package action.inquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.inquiry.InquiryService;

import static util.action.ActionUtil.*;

import java.io.PrintWriter;

import vo.ActionForward;
import vo.Users;

public class InquiryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("실행");
		Users user = CheckLogin(request,response);
		int users_id = user.getId();
		
		int seller_Mall_id = Integer.parseInt(request.getParameter("seller_Mall_id"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		System.out.println(request.getParameter("order_id"));
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		String Inquiry_name = request.getParameter("name");
		String Inquiry_contents = request.getParameter("contents");
		
		InquiryService inquiryService = new InquiryService(); 
		int Check = inquiryService.Makeinquiry(users_id , seller_Mall_id ,product_id, Inquiry_name , Inquiry_contents ,order_id );
		
		ActionForward forward = null;
		if(Check > 0 ) {
			forward = new ActionForward("inquiryUser.shop", false);
		}else {			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert(' 입력 실패함.');");
			out.println("location.href='loginForm.shop'");
			out.println("</script>");
		}
		
		return forward;
	}

}
