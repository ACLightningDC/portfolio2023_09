package action.user;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.user.LoginCheck.OTPLoginCheck;
import svc.LoginService;
import util.SHA256;
import vo.ActionForward;
import vo.Users;
import vo.login.OTP;
import vo.user_security.User_security;

public class loginAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		//아이디 저장 처리
		System.out.println("loginAction 실행");
		
		//로그인 서비스 객체 생성
		LoginService loginService =  new LoginService();
		//로그인 전송 데이터 변수에 받음
		String id = request.getParameter("userid");
		String encodeNoPassword = request.getParameter("password");
		String password = 	SHA256.encodeSHA256(encodeNoPassword);
		String checkbox = request.getParameter("checkbox");
		if(checkbox !=null) {
			Cookie cookie = new Cookie("user_id" , id);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("user_id" , null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		//로그인 확인값 숫자로 체크
		
		int loginCheck = loginService.getLogin(id, password);

		System.out.println("로그인 체크값"+loginCheck);
		System.out.println("action loginCheck 실행 " + loginCheck);
		

			if(loginCheck>0) {
				HttpSession session =  request.getSession();
				Users user =  loginService.getLoginInfo(loginCheck);
				ArrayList<User_security> user_securityList = loginService.getUser_security(user.getId());

				if(user_securityList.size() > 0) {
			        String ipAddress=request.getRemoteAddr();
			        String model = request.getParameter("model");
			        System.out.println(ipAddress +"," +model );
			        for(int i = 0 ;i<user_securityList.size() ;i++) {
			        	User_security user_security = user_securityList.get(i);
			        	System.out.println(user_security);
			        	int secu_id =0;
			        	if(user_security.getSecurity_check()==1) {
							request.setAttribute("Check", 1);
			        	}
			        	if(user_security.getUsers_id()==user.getId() && user_security.getIpaddress().equals(ipAddress)
			        			&& user_security.getModel().equals(model) ) {
			        		secu_id = user_security.getId();
							request.setAttribute("Check2",secu_id );
			        	}
			        }
			        
			        OTPLoginCheck OTPloginCheck = new OTPLoginCheck();
			        OTP otp = OTPloginCheck.CreateKey(id , ipAddress);
					
			        request.setAttribute("ipAddress", ipAddress);
			        request.setAttribute("model", model);
			        request.setAttribute("loginCheck", loginCheck);
					request.setAttribute("encodedKey", otp.getEncodedKey());
					request.setAttribute("url", otp.getUrl());
					
					forward = new ActionForward("otpCheck.User" ,false);
				}else {
					
					session.setAttribute("userinfo", user);
					
					if(user.getGrade().equals("S")) {
						int Seller_id = loginService.getSeller_id(user.getId());
						session.setAttribute("Seller_id", Seller_id);
					}
					
					forward = new ActionForward("/homePage.shop" ,false);
				}
				
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('잘못된 이름 이메일 입니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		
		
		//로그인 체크용
		

		
		

		return forward;
	}

}
