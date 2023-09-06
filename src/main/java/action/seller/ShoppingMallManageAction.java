package action.seller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.ShoppingMallManageService;
import vo.ActionForward;
import vo.sellermall;

public class ShoppingMallManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int seller_id = (int)session.getAttribute("Seller_id");
		
		ShoppingMallManageService shoppingMallManageService = new ShoppingMallManageService();
		ArrayList<sellermall> sellermalls =  shoppingMallManageService.getShoppingMallList(seller_id);
		
		if(sellermalls != null) {
			System.out.println("셀러 몰"+sellermalls);
			request.setAttribute("sellermalls", sellermalls);
		}
		request.setAttribute("forward", "/ShoppingMallManage.jsp");
		ActionForward forward = new ActionForward("/template.jsp", false);
		return forward;
	}

}
