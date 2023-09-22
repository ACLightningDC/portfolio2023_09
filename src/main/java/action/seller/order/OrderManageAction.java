package action.seller.order;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Cart.ShoppingBuyDeliveryShowService;
import svc.seller.order.OrderManageService;
import vo.ActionForward;
import vo.ShoppingCart;
import vo.Users;

public class OrderManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckLogin(request, response); 
		
		HttpSession session = request.getSession();
		int sellerMallid = (int) session.getAttribute("sellerMallid");
		
		OrderManageService orderManageService = new OrderManageService();
		ArrayList<ShoppingCart> ShoppingCartList =  orderManageService.OrderManageShow(sellerMallid);
		
		
		
		request.setAttribute("ShoppingCartList", ShoppingCartList);
		
		request.setAttribute("forward", "/MallManage/orderManage/orderManage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
