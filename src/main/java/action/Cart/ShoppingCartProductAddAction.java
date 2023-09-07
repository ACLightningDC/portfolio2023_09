package action.Cart;

import java.io.PrintWriter;

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
		if(user == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('로그인 후 구매 장바구니 이용 부탁드립니다 .');");
			out.println("history.back()");
			out.println("</script>");
		}
		int order_count = Integer.parseInt(request.getParameter("order_count")); 
		
		int users_id = user.getId();
		int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		
		int Check  = 0;
		ShoppingCartProductAddService shoppingCartProductAddService  = new ShoppingCartProductAddService(); 
		int GetOrder_count = shoppingCartProductAddService.GetCartOrder_count(users_id , product_id );
		System.out.println("기존 주문 개수 " +  GetOrder_count);
		if(GetOrder_count > 0 ) {
			System.out.println(" ture 실행");
			order_count += GetOrder_count;
			Check = shoppingCartProductAddService.shoppingCartProductUpdate(users_id , product_id ,order_count);

		}else {
			System.out.println(" else 실행");

			Check = shoppingCartProductAddService.shoppingCartProductAdd(users_id , product_id ,order_count);
		}
		
			ActionForward forward = null;

		if(Check > 0 ) {
			forward = new ActionForward("/shoppingCart.shop", false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('장바구니 추가에 실패함 .');");
			out.println("history.back()");
			out.println("</script>");
		}
		

		
		return forward;
	}

}
