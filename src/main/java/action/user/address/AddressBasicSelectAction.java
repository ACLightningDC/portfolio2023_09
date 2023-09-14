package action.user.address;

import static util.LoginCheck.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.address.AddressBasicSelectService;
import vo.ActionForward;
import vo.Users;

public class AddressBasicSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		int id = Integer.parseInt(request.getParameter("id")); 
		
		AddressBasicSelectService addressBasicSelectService = new AddressBasicSelectService();
		int Check = addressBasicSelectService.addressBasicSelect(users_id , id);
		
		if(Check > 0  ) {
			 forward = new ActionForward("AddressForm.shop", false);

		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('잘못된 주소 입니다.');");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		return forward;
	}

}
