package action.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Cart.ShoppingCartProductAddService;
import vo.ActionForward;
import vo.Users;

public class ShoppingCartProductAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		Users user =  (Users) session.getAttribute("userinfo");
		
		int users_id = user.getId();
		int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		
		ShoppingCartProductAddService shoppingCartProductAddService  = new ShoppingCartProductAddService(); 
		int Check = shoppingCartProductAddService.shoppingCartProductAdd(users_id , product_id);
		
		request.setAttribute("forward", "/shoppingCart.jsp");
		ActionForward forward = new ActionForward("/template.jsp", false);
		
		return forward;
	}

}
