package action.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import action.Action;
import svc.LoginService;
import util.SHA256;
import vo.ActionForward;
import vo.Users;

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
		}else {
			
		}
		
		

		
		
		forward = new ActionForward("/homePage.shop" ,false);

		return forward;
	}

}
