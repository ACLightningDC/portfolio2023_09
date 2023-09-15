package action.buy;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.buy.CartBuyService;
import vo.ActionForward;
import vo.ShoppingCart;

public class CartBuyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String[] Cartproduct = request.getParameterValues("remove");
		
		CartBuyService cartBuyService = new CartBuyService(); 
		ArrayList<ShoppingCart> BuyList = cartBuyService.cartBuy(Cartproduct);
		
		
		int sumPrice = 0;
		for(int i = 0 ; i < BuyList.size() ; i++) {
			sumPrice += BuyList.get(i).getPrice()*BuyList.get(i).getOrder_count();
		}
		
		request.setAttribute("buyList", BuyList);
		request.setAttribute("sumPrice", sumPrice);
		
		ActionForward forward = new ActionForward("BuyForm.User", false);
		
		return forward;
		
	}

}
