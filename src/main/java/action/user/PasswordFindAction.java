package action.user;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.PasswordFindService;
import util.SHA256;
import vo.ActionForward;

public class PasswordFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
ActionForward forward = null;
		
		String userid =request.getParameter("userid");
		String email =request.getParameter("email");
		
		String randomPassword = SHA256.getRandomPassword(8);
		String randomPasswordEncode = SHA256.encodeSHA256(randomPassword);
		
		PasswordFindService passwordFindService = new PasswordFindService();
		int Check = passwordFindService.PasswordFind(randomPasswordEncode ,userid, email);
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(Check > 0) {

		
			//메일전송 합니다.
			String sender = "0523mytop@gmail.com"; //보내는사람
			String receiver = email; //받는사람 : 1명
			String subject = userid + "님의 임시비밀번호 입니다."; //제목
			String content = userid + "님의 임시비밀번호는" + randomPassword +"입니다."; //내용
			content += "<a href='#'>로그인 하러 가기</a>"; //내용
			
			String host = "smtp.gmail.com";
			
			final String username = "0523mytop";
			final String password = "alwtmskuwirbkyil";
			
			final int port=587;
			
			try {
				Properties properties=  System.getProperties();
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.port", port);
				
				Session session= Session.getDefaultInstance(properties, //SMTP 서버 정보
						new Authenticator() { //사용자인증정보객체: Authenticator추상클래스 생성자()정의와 생성을 동시에 
							//재정의 해야 할 메서드
							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username, password);//사용자인증접보 객체 리턴 
							} //사용자 인증정보
						}//생성자 끝
					);
				
				Message message = new MimeMessage(session);			
				Address sender_address = new InternetAddress(sender);
				Address receiver_address = new InternetAddress(receiver);
				message.setHeader("content-type","text/html;charset=utf-8");
				message.setFrom(sender_address);//보내는 메일주소 셋팅
				message.addRecipient(Message.RecipientType.TO, receiver_address);
				message.setSubject(subject);
				message.setContent(content, "text/html;charset=utf-8");
				message.setSentDate(new java.util.Date());
				
				Transport.send(message);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			request.setAttribute("userid", userid);
			request.setAttribute("email", email);
			forward = new ActionForward("PasswordFindComplete.User", false); 
		}else {
			out.println("<script>");
			out.println("alert('잘못된 입력이거나 없는 계정 입니다.');");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
