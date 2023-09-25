package action.user.security;

import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.security.user_securityCancelService;
import svc.user.security.user_securitySettingService;
import vo.ActionForward;
import vo.Users;

public class user_securityCancelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		user_securityCancelService user_securityCancelService = new user_securityCancelService();
		int Check = user_securityCancelService.user_securityCancel(users_id); 
		
		ActionForward forward = null;
		String Message = "2단계 보안 삭제에 실패했습니다.";
		
		if(Check == 0  ) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			
			out.println("<script>");
			out.println("alert('"+Message+".');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			user.setUserSecurity_id("0");
			HttpSession session =  request.getSession();
			session.setAttribute("userinfo", user);
			
			forward = new ActionForward("myImformationForm.shop" , true);
		}
		
		System.out.println(forward);
		return forward;
	}

}
