package action.user;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import action.Action;
import svc.user.AddressFindService;
import svc.user.FindIdService;
import vo.ActionForward;
import vo.Address;
import vo.Users;

public class myImformationFormAddressFind implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		Users users = (Users) session.getAttribute("userinfo");
				
		AddressFindService addressFindService= new AddressFindService();
		
		ArrayList<Address> addressS = AddressFindService.findAddress(users.getId());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(userid == null) {
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			request.setAttribute("userid", userid);
			
			forward = new ActionForward("findIdComplete.User", false); 
		}
		
		ActionForward forward = new ActionForward("findIdComplete.User", false); 
		return forward;
	}

}
