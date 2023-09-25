<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script> 
	<!-- iamport.payment.js --> 
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath}/resource/javascript/BuyForm.js"></script>
<script>

'클라이언트 키' : 브라우저에서 토스 페이먼츠 SDK를 연동할때 사용
	const tossPayments = TossPayments("test_ck_d46qopOB89zx54X1jmK3ZmM75y0v")
	
	function payment(){
	
	
		if(!efyPIPP){
			alert('')
			return false;
		}
		if(docuemnt.payForm.payPlan.value =="선택"){
			alert('')
			return false;
		}
	}
	
	//순서-3. 결제 정보 -------------------------------------------------------------
	
	const method="카드";
	
	const paymentData = {
			amount : ${saleTotalMoney}, //결제금액
			orderId: (Math.random() + "").substring(2),//주문 구분하는 ID : 6~64 문자열(무작위 값 생성하여 고유값 넣어줌);
			orderName : '${sessionScope.menuList}',//주문명
			customerName : '${sessionScope.u_name}',//주문자 이름
			
			successUrl : window.location.origin + "/war파일명/paymentAction.kiosk",//결제성공시 이동할 페이지
			
			failUrl : window.location.origin + "/war파일명/paymentOrderPayment.kiosk" //결제 실패시 이동할 페이지
	}
	
	tossPayments.requestPayment(method, paymentData);
	
	//메서드 실행에 실패
	/* 
	tossPayments.catch(function(error){
		if(error.code == "USER_CANCEL"){
			//결제 고객이 결제창을 닫았을 때 에러 처리
		}else if(error.code == 'INVALID_ORDER_ID'){
			
		}else if(error.code == 'INVALID_ORDER_NAME'){
			
		}else if(error.code == 'INVALID_CUSTOMER_NAME'){
			
		}else if(error.code == 'INVALID_ORDER_ID'){
			
		}
	});
	 */
}//payment() 함수 끝

//순서-5. 결제 요청이 성공하면 결제성공페이지(successUrl)로 이동한다.--------------------------------------------
	 /*
	 순서-5. 결제 요청이 성공하면 결제성공 페이지(successUrl)로 이동한다.

https://{ORIGIN}/success?paymentKey={PAYMENT_KEY}&orderId={ORDER_ID}&amount={AMOUNT}
결제 성공 페이지의 URL에는 paymentKey, orderId, amount 세 가지 쿼리 파라미터가 들어있다. 
- paymentKey : 결제의 키 값입니다. 최대 길이는 200자입니다. 결제를 식별하는 역할로, 중복되지 않는 고유한 값입니다. 
				결제 데이터 관리를 위해 반드시 저장해야 합니다. 결제 상태가 변해도 값이 유지됩니다. 
				결제 승인, 결제 조회, 결제 취소 API에 사용합니다.
- orderId :    주문 ID이다. 주문한 결제를 식별하는 역할로, 결제를 요청할 때 가맹점에서 만들어서 requestPayment()에 담아 보낸 값이다. 
                 결제 데이터 관리를 위해 반드시 저장해야 한다. 중복되지 않는 고유한 값을 발급해야 합니다. 결제 상태가 변해도 값이 유지된다.
- amount: 실제로 결제된 금액이다.

 결제 요청이 실패하면 결제창을 열 때 설정한 결제 실패 페이지(failUrl)로 이동한다. 
	 */
</script>
<script>
	window.onload = function(){
		//[방법-1] 니챧(0,9+1)
		today = new Date();
		console.log();
		today = today.toISOString().slice(0, 9+1);//"2023-09-22"만 가져옴
		
		//[방법 -2] substring(0,9+1)		
		var today = new Date().toISOString().substring(0, 9+1);//"2023-09-22"만 가져옴
		bir = document.getElementById("now_date");
		bir.value = today;
		
	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
</head>
<body>
			        <form method="post" action="ShoppingresultUpdate.Seller" id="buyIdResult" name="infoPayForm">
		<div class="container">
		<div class="row mt-5">
		      <div class="col-8 mx-auto">
		      <h5>${sessionScope.userinfo.name}님의 주문 입니다.</h5>
		        <h4 class="d-flex justify-content-between align-items-center mb-3">
		        	
		          <span class="text-primary">구매한 물건 종류</span>
		          <span class="badge bg-primary rounded-pill" id="select_count">${buyCount}</span>
		        </h4>
		        <ul class="list-group mb-3 ">
			        <c:if test="${not empty requestScope.buyList}">
						<c:forEach var="buy" items="${requestScope.buyList}" varStatus="status">
							<li class="list-group-item d-flex justify-content-between lh-sm">
						            	<img width="100px" alt="안나옴" src="${pageContext.request.contextPath}/images/${buy.img}">
						            	
							           <h6 class="my-0">${buy.name}</h6> 
							              <small class="text-body-secondary">종류: ${buy.kind}</small>
							              <small class="text-body-secondary"><br>가격 : ${buy.price}</small>
							              <small class="text-body-secondary"><br>주문 개수 : ${buy.order_count}</span></small>
					          </li>
					          <li class="list-group-item d-flex lh-sm text-break">
						          		<button class="btn btn-primary btn-sm" type="button" onclick="location.href='shoppingCartProductDetail.shop?product_id=${buy.product_id}'">상품 상세보기</button>
					          </li>
					          		<input type="hidden" name="order_id" value="${buy.id}">
						</c:forEach>
					</c:if>
		          <li class="list-group-item d-flex">
		            <span >총가격  &nbsp; </span>
		            <strong id="sum_price">${requestScope.sumPrice}</strong> &#8361
		          </li>
		        </ul>
		        
		        		<input type="hidden" name="result" value="P">
					<h4>주소</h4>
					 <c:if test="${not empty address}">
							<div >
								우편번호 : <span id="postcode">${address.postcode}</span>
								<br>주소 : <span id="address1">${address.address1}</span>						
								<br>상세주소 :<span id="address2">${address.address2}</span>			
							</div>
						<input type="hidden" name="address_id" value="${sessionScope.userinfo.address_id}">		
					 </c:if>
					 <c:if test="${empty address }">
					 	배송지 선택 바랍니다.
					 </c:if>
					<button class="btn btn-primary " type="button" onclick="select_address()">배송지 선택</button>
					<button class="btn btn-primary btn-lg col-12"  type="submit">테스트 결제</button>
				</form>
			
			<form id="payForm" name="payForm">
			<hr>
				<input type="hidden" name="email"  value="${sessionScope.userinfo.email}">
				<input type="hidden" name="user_name"  value="${sessionScope.userinfo.name}">
				<input type="hidden" name="tel"  value="${sessionScope.userinfo.phone}">
				<input type="text" name="order_id" value="${requestScope.buyList[0].id}">
				<br>
				${requestScope.buyList[0].name} ${not empty requestScope.buyList[1]? "외 물건 구매":"구매"}
				<input type="hidden" name="pay_name" value="${requestScope.buyList[0].name}">
				<input type="hidden" name="amount" value="${requestScope.sumPrice }">
				
			</form>
			<hr>
			<div>
				<h2>총 결제 금액 ${requestScope.sumPrice} &#8361</h2>
			</div>
			<hr>
				<button class="btn btn-primary btn-lg col-12" id="Payment" type="button">카카오 페이 결제</button>
									<button class="btn btn-primary btn-lg col-12"  type="submit">토스 페이번츠 결제</button>
				
		</div>
	</div>	
		
	




</body>
</html>