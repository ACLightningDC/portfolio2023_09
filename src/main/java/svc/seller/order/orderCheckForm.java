package svc.seller.order;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.Delivery;

public class orderCheckForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CheckLogin(request, response); 

		
		int delivery_id = Integer.parseInt(request.getParameter("delivery_id")); 
				
		
		orderCheckFormService orderCheckFormService = new orderCheckFormService();
		Delivery del = orderCheckFormService.orderCheckForm(delivery_id); 
//		Val val= service.method; 
		
		
//		ActionForward forwardGet = new ActionForward(".controller", false);
//		request.setAttribute("forward", ".jsp");
		String Message = "실패했습니다.";
		
		request.setAttribute("del", del);
		
		request.setAttribute("forward", "/MallManage/orderManage/orderCheck.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
