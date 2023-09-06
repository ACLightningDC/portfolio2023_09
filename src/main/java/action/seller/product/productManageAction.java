package action.seller.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.product.ProductManageService;
import vo.ActionForward;
import vo.Product;

public class productManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int sellerMallid = (int)session.getAttribute("sellerMallid");
		
		ProductManageService productManageService = new ProductManageService();
		ArrayList<Product> products =  ProductManageService.getProductList(sellerMallid);
		
		request.setAttribute("products", products);
		
		request.setAttribute("forward", "/MallManage/productManage/productManage.jsp");
		ActionForward forward = new ActionForward("/template.jsp", false);
		return forward;
	}

}
