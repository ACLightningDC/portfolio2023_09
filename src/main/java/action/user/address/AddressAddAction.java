package action.user.address;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.AddressFormService;
import svc.user.address.AddressAddService;
import vo.ActionForward;
import vo.Address;
import vo.Users;

public class AddressAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
ActionForward forward= null;
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userinfo");
		int user_id = user.getId();
		
		String postcode = request.getParameter("postcode");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		AddressAddService addressAddService = new AddressAddService();
		int Check = addressAddService.AddressAdd(postcode , address1, address2 , user_id);
		
		if(Check > 0  ) {
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('잘못된 주소 입니다.');");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		
		forward = new ActionForward("AddressForm.shop", false);
		return forward;
		
	}

}
