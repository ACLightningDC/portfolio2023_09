package action.Cart;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.ShoppingBuyDeliveryShowService;
import svc.Cart.ShoppingCartViewService;
import vo.ActionForward;
import vo.ShoppingCart;
import vo.Users;

public class ShoppingBuyDeliveryShowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		ShoppingBuyDeliveryShowService shoppingBuyDeliveryShowService = new ShoppingBuyDeliveryShowService();
		ArrayList<ShoppingCart> ShoppingCartList =  shoppingBuyDeliveryShowService.shoppingBuyDeliveryShow(users_id );
		
		request.setAttribute("ShoppingCartList", ShoppingCartList);
		
		ActionForward forward = new ActionForward("shoppingPayAfter.User", false);
		
		return forward;
	}

}
