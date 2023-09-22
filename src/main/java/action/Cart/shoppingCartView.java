package action.Cart;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Cart.ShoppingCartViewService;
import vo.ActionForward;
import vo.ShoppingCart;
import vo.Users;

public class shoppingCartView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Users user =  CheckLogin(request, response); 
		
		int users_id = user.getId();
		
		ShoppingCartViewService ShoppingCartViewService = new ShoppingCartViewService();
		ArrayList<ShoppingCart> ShoppingCartList =  ShoppingCartViewService.shoppingCartView(users_id);
		
		request.setAttribute("ShoppingCartList", ShoppingCartList);
		
		request.setAttribute("forward", "buyUser/shoppingCart/shoppingCart.jsp");
		ActionForward forward = new ActionForward("/template.jsp", false);
		return forward;
	}

}
