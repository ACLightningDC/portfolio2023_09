package action.user.address;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.address.AddressDeleteService;
import vo.ActionForward;

public class AddressDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		AddressDeleteService addressDeleteService = new AddressDeleteService();
		int Check = addressDeleteService.addressDelete(id);
		
		if(Check > 0  ) {
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('잘못된 주소 입니다.');");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		ActionForward forward = new ActionForward("AddressForm.shop", false);
		return forward;
	}

}
