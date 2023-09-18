package action.seller.mall;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.mall.OrderManageSalesViewService;
import vo.ActionForward;
import vo.ShoppingCart;

public class orderManageSalesView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
				CheckLogin(request, response); 
				
				HttpSession session =  request.getSession();
				int sellerMallid = (int) session.getAttribute("sellerMallid");
				
				OrderManageSalesViewService orderManageSalesViewservice = new OrderManageSalesViewService();
				ArrayList<ShoppingCart> ShoppingList = orderManageSalesViewservice.orderManageSalesView(sellerMallid); 
				
				int sum = 0;
				for(int i = 1 ; i<ShoppingList.size(); i++) {
					ShoppingCart order = ShoppingList.get(i);
					sum += order.getOrder_count() * order.getPrice();
				}
				
				
				
				String Message = "실패했습니다.";
				ActionForward forward = ActionForwardForUpdate(request, response, 1, Message, "/MallManage/orderManage/orderManageSales.jsp" );
				
				request.setAttribute("ShoppingCartList", ShoppingList);
				request.setAttribute("sum", sum);
				
				return forward;
	}

}
