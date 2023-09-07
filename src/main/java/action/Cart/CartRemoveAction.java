package action.Cart;

import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Cart.CartRemoveService;
import vo.ActionForward;

public class CartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		String[] remove = request.getParameterValues("remove");
		if(remove == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('체크가 없습니다 .');");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		CartRemoveService cartRemoveService = new CartRemoveService();
		
			int check = cartRemoveService.CartRemove(remove); 			
		
			if(check > 0 ) {
				forward = new ActionForward("/shoppingCart.shop", false);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();	
				out.println("<script>");
				out.println("alert('장바구니 삭제에 실패함 .');");
				out.println("history.back()");
				out.println("</script>");
			}
			
		return forward;
	}

}
