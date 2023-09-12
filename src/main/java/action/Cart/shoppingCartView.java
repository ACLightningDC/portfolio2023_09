package action.Cart;

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
		HttpSession session = request.getSession();
		Users user =  (Users) session.getAttribute("userinfo");
		
		int users_id = user.getId();
		
		ShoppingCartViewService ShoppingCartViewService = new ShoppingCartViewService();
		ArrayList<ShoppingCart> ShoppingCartList =  ShoppingCartViewService.shoppingCartView(users_id);
		
		
		
		request.setAttribute("ShoppingCartList", ShoppingCartList);
		
		request.setAttribute("forward", "/shoppingCart.jsp");
		ActionForward forward = new ActionForward("/template.jsp", false);
		return forward;
	}

}
