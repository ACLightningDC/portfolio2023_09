package action.seller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.buy.CartBuyService;
import vo.ActionForward;
import vo.ShoppingCart;

public class orderManageDeliveryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String[] Cartproduct = request.getParameterValues("remove");
		
		CartBuyService cartBuyService = new CartBuyService(); 
		ArrayList<ShoppingCart> BuyList = cartBuyService.cartBuy(Cartproduct);
		
		request.setAttribute("buyList", BuyList);
		
		request.setAttribute("forward", "/MallManage/orderManage/orderManageDelivery.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
