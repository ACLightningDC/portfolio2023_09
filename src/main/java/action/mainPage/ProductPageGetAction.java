package action.mainPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mainPage.ProductPageGetService;
import vo.ActionForward;
import vo.Product;

public class ProductPageGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ProductPageGetService productPageGetService = new ProductPageGetService();
		ArrayList<Product> products =  productPageGetService.productPageGetList();
		
		request.setAttribute("products", products);
		
		request.setAttribute("forward", "productPage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);	
		return forward;
	}

}
