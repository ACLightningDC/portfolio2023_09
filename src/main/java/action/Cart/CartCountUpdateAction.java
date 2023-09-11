package action.Cart;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.CartCountUpdateService;
import vo.ActionForward;

public class CartCountUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("orderCount"));
		int id = Integer.parseInt(request.getParameter("id"));
		int orderCount = Integer.parseInt(request.getParameter("orderCount"));
		
		CartCountUpdateService cartCountUpdateService = new CartCountUpdateService();
		int Check = cartCountUpdateService.CartCountUpdate(id , orderCount);
		
		forward = new ActionForward("shoppingCart.shop", true);
		return forward;
	}

}
