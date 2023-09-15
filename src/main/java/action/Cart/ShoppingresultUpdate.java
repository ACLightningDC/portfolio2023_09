package action.Cart;

import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.CartRemoveService;
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
		
		
		ShoppingresultUpdateService shoppingresultUpdateService = new ShoppingresultUpdateService();
		
			check = shoppingresultUpdateService.resultUpdate(id, result); 			
		
			if(check > 0 ) {
				forward = new ActionForward("/shoppingCart.shop", false);
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
