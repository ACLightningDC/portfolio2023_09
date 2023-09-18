package action.user;

import java.io.PrintWriter;

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
		String password = 	SHA256.encodeSHA256(request.getParameter("password"));
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
			
			session.setAttribute("userinfo", user);
			
			if(user.getGrade().equals("S")) {
				int Seller_id = loginService.getSeller_id(user.getId());
				session.setAttribute("Seller_id", Seller_id);
			}
			
			forward = new ActionForward("/homePage.shop" ,false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		//로그인 체크용
		if(false) {
	        String ipAddress=request.getRemoteAddr();

			OTPLoginCheck OTPloginCheck = new OTPLoginCheck();
			OTP otp = OTPloginCheck.CreateKey(id , ipAddress);
			
			request.setAttribute("encodedKey", otp.getEncodedKey());
			request.setAttribute("url", otp.getUrl());
			
			forward = new ActionForward("otpCheck.User" ,false);
			
		}

		
		

		return forward;
	}

}
