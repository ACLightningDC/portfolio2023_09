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
		System.out.println("셀러 몰 아이디"+sellerMallid);
		int Seller_id = (int)session.getAttribute("Seller_id");
		System.out.println("셀러 아이디"+Seller_id);
		
		session.setAttribute("sellerMallid", sellerMallid);
		
		
		 request.setAttribute("forward", "MallManage/MallManageForm.jsp");
		ActionForward actionForward = new ActionForward("template.jsp", false);
		return actionForward;
	}

}