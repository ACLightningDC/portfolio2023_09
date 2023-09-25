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
		
		session.removeAttribute("userinfo"); //users DTO 객체
		session.removeAttribute("Seller_id");// seller Id
		session.removeAttribute("sellerMallid");// seller Mallid Id
		forward = new ActionForward("loginForm.shop", true);
		return forward;
	}

}
