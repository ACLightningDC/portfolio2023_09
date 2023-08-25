package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.PasswordFindService;
import util.SHA256;
import vo.ActionForward;

public class PasswordFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
ActionForward forward = null;
		
		String userid =request.getParameter("userid");
		String email =request.getParameter("email");
		
		String randomPasswordEncode = SHA256.encodeSHA256(SHA256.getRandomPassword(8));
		
		PasswordFindService passwordFindService = new PasswordFindService();
		int Check = passwordFindService.PasswordFind(randomPasswordEncode ,userid, email);
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(!(Check > 0)) {
			out.println("<script>");
			out.println("alert('잘못된 입력이거나 없는 계정 입니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			//메일전송 합니다.
			request.setAttribute("userid", userid);
			request.setAttribute("email", email);
			
			
			
			forward = new ActionForward("PasswordFindComplete.shop", false); 
		}
		
		return forward;
	}

}
