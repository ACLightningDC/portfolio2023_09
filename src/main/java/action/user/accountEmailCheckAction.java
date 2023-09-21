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
import svc.user.AccountEmailCheckService;
import util.SHA256;
import vo.ActionForward;

public class accountEmailCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String randomPassword = SHA256.getRandomPassword(8);
		
		
		AccountEmailCheckService accountIdCheckService = new AccountEmailCheckService();
		int check = accountIdCheckService.accountIdCheck(email);
		ActionForward forward = null;
		if(check == 1) {
			
			String sender = "0523mytop@gmail.com"; //보내는사람
			String receiver = email; //받는사람 : 1명
			String subject = email + "쇼핑몰 이메일 인증입니다."; //제목
			String content = email + "님의 이메일 인증 번호는" + randomPassword +"입니다."; //내용
			
			request.setAttribute("randomPassword", randomPassword);
			
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
		}
	
		
		
		request.setAttribute("checkEmail", check+1);

			forward = new ActionForward("accountEmailCheck.User",false);
		
		return forward;
	}

}
