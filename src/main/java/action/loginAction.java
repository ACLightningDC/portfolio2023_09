package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;

public class loginAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		//로그인 서비스 객체 생성
		LoginService loginService =  new LoginService();
		//로그인 전송 데이터 변수에 받음
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		String checkbox = request.getParameter("checkbox");
		//로그인 확인값 숫자로 체크
		int loginCheck = loginService.getLogin(id, password);
		System.out.println("action loginCheck 실행 " + loginCheck);
		HttpSession session =  request.getSession();
		
		if(loginCheck>0) {
			session.setAttribute("users_id", loginCheck);
		}else {

		}
		
		Cookie cookie = new Cookie("user_id" , id);
		
		if(checkbox !=null) {
			response.addCookie(cookie);
		}else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		
		
		forward = new ActionForward("/mainpage/homePage.jsp" ,false);

		return forward;
	}

}
