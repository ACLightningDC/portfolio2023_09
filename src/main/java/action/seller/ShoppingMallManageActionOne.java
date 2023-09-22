package action.seller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.ShoppingMallManageOneService;
import vo.ActionForward;
import vo.Product;

public class ShoppingMallManageActionOne implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int sellerMallid = Integer.parseInt(request.getParameter("sellerMallid")) ;
		int Seller_id = (int)session.getAttribute("Seller_id");
		
		session.setAttribute("sellerMallid", sellerMallid);
		
		
		ActionForward actionForward = new ActionForward("MallManageForm.Seller", false);
		return actionForward;
	}

}
