package action.seller.mall;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class MakeMallSession implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		
		ActionForward forward = null;
		
		request.setAttribute("forward", "/sellerUser/shoppingMall/mallPage/MallMain.jsp");
		forward = new ActionForward("/sellerUser/shoppingMall/mallPage/MallTemplate.jsp", false);
		
		return forward;
	}

}
