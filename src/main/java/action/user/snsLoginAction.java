package action.user;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.LoginService;
import svc.user.SnsLoginService;
import vo.ActionForward;
import vo.Users;
import vo.user_security.User_security;

public class snsLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String snsId = request.getParameter("snsId");
		String snsEmail = request.getParameter("snsEmail");
		HttpSession session =  request.getSession();
		
		SnsLoginService snsLoginService = new SnsLoginService();
		int users_id = snsLoginService.snsLoginService(snsId , snsEmail);
		
		LoginService loginService =  new LoginService();
		Users user =  loginService.getLoginInfo(users_id);
		
		session.setAttribute("userinfo", user);
		
		if(user.getGrade().equals("S")) {
			int Seller_id = loginService.getSeller_id(user.getId());
			session.setAttribute("Seller_id", Seller_id);
		}
		
		ActionForward forwardGet = new ActionForward("/homePage.shop" ,false);

//		HttpSession session =  request.getSession();
//		session.getAttribute("");
		
//		Service service = new Serrvice();
//		int Check = service.method; 
//		Val val= service.method; 
		
		int Check = 1;
		
//		ActionForward forwardGet = new ActionForward(".controller", false);
//		request.setAttribute("forward", ".jsp");
		String Message = "카카오 로그인 실패했습니다.";
		ActionForward forward = ActionForwardForUpdateController(response, Check, Message, forwardGet);
		
//		request.setAttribute("", val);
//		session.setAttribute("", val);
		
		return forward;
	}

}
