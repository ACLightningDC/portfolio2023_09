package action.Cart;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Cart.ShoppingCartProductAddService;
import vo.ActionForward;
import vo.Order_list;
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
		ArrayList<Order_list> order_List = shoppingCartProductAddService.GetCartOrder_Check(users_id , product_id );
		int id = 0;
		int GetOrderCount = 0;
		String GetResult = null;
		for(int i = 0 ; i < order_List.size(); i++) {
			String tempResult = order_List.get(i).getResult();
			if(tempResult.equals("N")) {
				id = order_List.get(i).getId();
				GetOrderCount = order_List.get(i).getOrder_count();
				GetResult = order_List.get(i).getResult();
			}
		}
		System.out.println("GetResult = "+ GetResult);
		System.out.println("GetOrderCount = "+ GetOrderCount);
		if(GetOrderCount > 0 && GetResult.equals("N")) {
			order_count += GetOrderCount;
			Check = shoppingCartProductAddService.shoppingCartProductUpdate(id ,order_count);

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
