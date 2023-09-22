package action.user.Payment;

import java.awt.Menu;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import action.Action;
import vo.ActionForward;
import vo.Pay;

public class PaymentAction implements Action {

	/* 필드 : 결제위해 추가---------------------------------------------------------------------*/
	//RestTemplate를 이용하여 두컴퓨터 시스템(영남-토스)이 인터넷을 통해 정보를 안전하게 교환할 수 있다.
	//Spring 에서 지원하는 객체로 간편하게 Rest 방식 API 를 호출 할 수 있는 Spring 내장 클래스
	//Rest 방식 API?  두컴퓨터 시스템(영남-토스)이 인터넷을 통해 정보를 안전하게 교환하기 위해 사용하는 인터페이스
	private final RestTemplate restTemplate = new RestTemplate();
	
	//이용하면 JSON 를 JAVA 객체로 변환할 수 있고, 반대로 JAVA 객체를 JSON 객체로 serialiraze 할수 있다
	private final ObjectMapper ObjectMapper = new ObjectMapper();
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String u_id = (String) session.getAttribute("u_id");
		String u_email = (String) session.getAttribute("u_email");
		ArrayList<Menu> menuList= (ArrayList<Menu>) session.getAttribute("menuList");//주문
		
		//순서6 . 결제 인증 ------------------------
		/* 결제 승인 API 를 호출해서 마지막 단계를 완료
		 * 먼저 . API 인증을 위해 아래와 같이 인증 헤더값을 만들기
		 * Http Basic 인증 방식은 클라이언트에서 Base64로 인코딩된 사용자 ID, 비밀번호 쌍을 인증 정보 값으로 사용
		 * 사용자 ID의 비밀번호 쌍은 : 으로 구분함
		 * Base 64 로 인코딩한 정보는 쉽게 디코딩이 가능 해서 Basic 인증은 반드시 HTTPS/TLS와 함께 사용해야 함
		 * 토스 페이먼츠 API는 시크릿 키를 사용자 ID 로 사용하고, 비밀번호는 사용하지 않습니다.
		 * (=> 실제 결제 안됨)
		 */
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(("test_sk_GePWvyJnrKbvMlQ7ajLVgLzN97Eo" + ":" + "").getBytes("UTF-8")));
		
		//데이터를 Json 형식으로 게시하기 위해 APPLICATION_JSON 미디어 유형을 사용하여 요청에 추가함
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//순서7 '영남서버'dptj '토스 페이먼츠'에 REstTemplate를 사용하여 JSON 데이터를 담아 POST방식으로 요청함
		/*
		 * 결제창(API)에서 결제 요청이 성공하면 결제성공 페이지(successUrl)로 허용한다.
		 * 이때의 요청
		 * https://{ORIGIN}/success?paymentKey={PAYMENT_KEY}&orderId={ORDER_ID}&amount={AMOUNT}
		 * 
		 */
		String paymentKey = request.getParameter("paymentKey");
		String orderId = request.getParameter("orderId");//주문번호(서비스에서 정한 주문고유번호)
		String amount = request.getParameter("amount");//결제 가격
		
		Map<String , String> payloadMap = new HashMap<>();
		payloadMap.put("orderId", orderId);
		payloadMap.put("amount", amount);
		
		/*	ObjectMapper 클래스 이용하여
		 *  Java객체를 Json으로 직렬화하기 위해 writeValue() 이용
		 */
		
		HttpEntity<String> requests =  new HttpEntity<>(ObjectMapper.writeValueAsString(payloadMap),headers);
		
		//RestTemplate 사용하여 POST 방식으로 요청
		ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity("https://js.tosspayments.com/v1/payments"+paymentKey, requests, JsonNode.class);
		
		if(responseEntity.getStatusCode() != HttpStatus.OK) {
			JsonNode failNode = responseEntity.getBody();
			System.out.println("[PaymentAction] 최종결제 실패 = " + failNode);
			
			out.println("<script>");
			out.println("alert('결제를 실패했습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			JsonNode successNode = responseEntity.getBody();
			System.out.println("[PaymentAction] 최종결제 성공 = " + successNode);
			
			//내가 필요에 의해 작성한 코드
			//결제 성공하면 order_table 가장 마지막 주문한(latestOrder)의 order_status 를 'py' 로 최
			
			//pay_table에 결제성공한 정보를 insert함
			Pay pay = new Pay();//
			pay.setOrderId(successNode.get("orderId").asText());
			pay.setmId(successNode.get("orderId").asText());
			pay.setPaymentKey(paymentKey);
			pay.setOrder_num(order_num);
			
			String easyPay = null;
			try {
				easyPay = successNode.get("easyPay").asText();
				if(easyPay !=null)pay.setEasyPay(successNode.get("easyPay").get("provider").asText()); 
			}catch (Exception e) {
				
			}
			String card = null;
			try {
				card = successNode.get("card").asText();
				if(easyPay !=null)pay.setPay_bank(successNode.get("card").get("company").asText());/* 결제 은행*/ 
			}catch (Exception e) {
				
			}
			
			pay.setId(u_id);
			pay.setEmail(u_email);
			
			int totalamount = successNode.get("totalAmount").asInt();
			
			pay.setPay_status(successNode.get("status").asText());
			pay.setPay_date(successNode.get("approvedAt").asText());
			
			pay.setTotalAmount()
			
			System.out.println("pay= " + pay);
			
			PaymentService paymentService = new PaymentAction();
			boolean isInsertPaySuccess = paymentService.insertPay(pay);
			
			if(!isInsertPaySuccess) {
				
			}else {
				session.removeAttribute(cartList)
				
				session.setAttribute("u_id", paymentService);
				session.setAttribute("u_id", paymentService);
				session.setAttribute("u_id", paymentService);
				
				out.println
			}
		}
		
		return null;
	}

}
