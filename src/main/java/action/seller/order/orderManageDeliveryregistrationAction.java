package action.seller.order;

import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.seller.order.OrderManageDeliveryregistrationService;
import vo.ActionForward;
import vo.Delivery;
import vo.Users;

public class orderManageDeliveryregistrationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CheckLogin(request, response); 
		
		String[] Cartproduct = request.getParameterValues("order_list_id");
		System.out.println(Cartproduct);
		
		
		Delivery delivery = new Delivery();
		delivery.setDelivery_company(Integer.parseInt(request.getParameter("delivery_company")));
		delivery.setDelivery_num(Integer.parseInt(request.getParameter("delivery_num")));
		
		OrderManageDeliveryregistrationService OrderManageDeliveryregistrationService = new OrderManageDeliveryregistrationService(); 
		int Address_id = OrderManageDeliveryregistrationService.GetAddress_id(Integer.parseInt(Cartproduct[0]));
		int Check = OrderManageDeliveryregistrationService.OrderManageDeliveryregistration(Address_id , Cartproduct , delivery);
		
		ActionForward forward = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(Check <= 0  ) {
			out.println("<script>");
			out.println("alert('실패했습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward("BuyForm.User", false);
		}
		
		
		return forward;
	}

}
