package action.mainPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mainPage.ShopPageGetService;
import svc.seller.ShoppingMallManageService;
import vo.ActionForward;
import vo.sellermall;

public class ShopPageGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ShopPageGetService shopPageGetService = new ShopPageGetService();
		ArrayList<sellermall> sellermalls =  shopPageGetService.getShoppingAllMallList();
		
		request.setAttribute("sellermalls", sellermalls);
		
		request.setAttribute("forward", "mainPage/shopPage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);	
		return forward;
	}

}
