package action.Cart;

import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.CartRemoveService;
import svc.Cart.ShoppingresultUpdateService;
import vo.ActionForward;
import vo.Users;

public class ShoppingresultUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CheckLogin(request, response); 
		int check = 0;
		ActionForward forward= null;
		
		String [] id = request.getParameterValues("order_id");
		String result = request.getParameter("result");
		int address_id = Integer.parseInt(request.getParameter("address_id"));
		
		ShoppingresultUpdateService shoppingresultUpdateService = new ShoppingresultUpdateService();
			check = shoppingresultUpdateService.createDelivery(address_id);
			if(check > 0) {
				int delivery_id = shoppingresultUpdateService.getDelivery_id(address_id);
				check = shoppingresultUpdateService.resultUpdate(id, result ,delivery_id); 			
			}
			
		
			if(check > 0 ) {
				forward = new ActionForward("resultShopping.shop", false);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();	
				out.println("<script>");
				out.println("alert('실패함 .');");
				out.println("history.back()");
				out.println("</script>");
			}
			
		return forward;
	}

}
