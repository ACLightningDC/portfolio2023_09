package action.user.address;

import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		System.out.println("입력 id"+id);
		
		AddressBasicSelectService addressBasicSelectService = new AddressBasicSelectService();
		int Check = addressBasicSelectService.addressBasicSelect(users_id , id);
		
		if(Check > 0  ) {
			HttpSession session = request.getSession();
			user.setAddress_id(id);
			session.setAttribute("userinfo", user);
			 forward = new ActionForward("AddressForm.address", false);

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
