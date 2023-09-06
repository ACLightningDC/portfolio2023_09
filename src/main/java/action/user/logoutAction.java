package action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class logoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session= request.getSession();
		
		session.removeAttribute("userinfo");
		session.removeAttribute("Seller_id");
		session.removeAttribute("sellerMallid");
		 request.setAttribute("forward", "loginForm.jsp");
		forward = new ActionForward("template.jsp", true);
		return forward;
	}

}
