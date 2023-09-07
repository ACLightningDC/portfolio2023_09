package action.user.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.product.ShoppingCartProductDetailService;
import vo.ActionForward;
import vo.Product;

public class ShoppingCartProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int product_id = Integer.parseInt(request.getParameter("product_id")); 
		ShoppingCartProductDetailService shoppingCartProductDetailService = new ShoppingCartProductDetailService();
		Product product = shoppingCartProductDetailService.shoppingCartProductDetailView(product_id);
		
		request.setAttribute("products", product);
		
		request.setAttribute("forward", "product/productDetail.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		return forward;
	}

}
