package action.Cart;


import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.CartCountUpdateService;
import vo.ActionForward;

public class CartCountUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckLogin(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		int orderCount = Integer.parseInt(request.getParameter("orderCount"));
		
		CartCountUpdateService cartCountUpdateService = new CartCountUpdateService();
		int Check = cartCountUpdateService.CartCountUpdate(id , orderCount);
		
		ActionForward forward = ActionForwardForUpdateController(response, Check, "개수 업데이트에 실패함", new ActionForward("shoppingCart.shop", true));
		
		return forward;
	}

}
