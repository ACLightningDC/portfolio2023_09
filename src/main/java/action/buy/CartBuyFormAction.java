package action.buy;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.buy.CartBuyService;
import vo.ActionForward;
import vo.Address;
import vo.ShoppingCart;
import vo.Users;

public class CartBuyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Users user =  CheckLogin(request, response); 
		int address_id = user.getAddress_id();
		
		String[] Cartproduct = request.getParameterValues("remove");
		
		CartBuyService cartBuyService = new CartBuyService(); 
		ArrayList<ShoppingCart> BuyList = cartBuyService.cartBuy(Cartproduct);
		Address address=  cartBuyService.addressGet(address_id);
		
		int sumPrice = 0;
		for(int i = 0 ; i < BuyList.size() ; i++) {
			sumPrice += BuyList.get(i).getPrice()*BuyList.get(i).getOrder_count();
		}
		
		request.setAttribute("buyList", BuyList);
		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("buyCount", BuyList.size());
		request.setAttribute("address", address);
		
		
		ActionForward forward = new ActionForward("BuyForm.User", false);
		
		return forward;
		
	}

}
