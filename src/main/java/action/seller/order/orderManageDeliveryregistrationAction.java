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
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		String[] Cartproduct = request.getParameterValues("order_list_id");
		System.out.println(Cartproduct);
		
		
		Delivery delivery = new Delivery();
		delivery.setDelivery_company(Integer.parseInt(request.getParameter("delivery_company")));
		delivery.setDelivery_num(Integer.parseInt(request.getParameter("delivery_num")));
		
		OrderManageDeliveryregistrationService OrderManageDeliveryregistrationService = new OrderManageDeliveryregistrationService(); 
		int Check = OrderManageDeliveryregistrationService.OrderManageDeliveryregistration(Cartproduct , delivery);
		
		ActionForward forward = null;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(Check < 0  ) {
			out.println("<script>");
			out.println("alert('실패했습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
		}
		
		
		request.setAttribute("forward", "/buy/BuyForm.jsp");
		forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
