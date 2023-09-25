package action.user.security;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.security.user_securitySettingService;
import vo.ActionForward;
import vo.Users;

public class user_securitySettingAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		String ipAddress =request.getRemoteAddr();
		String model = request.getParameter("model");
		
		user_securitySettingService user_securitySettingservice = new user_securitySettingService();
		int Check = user_securitySettingservice.user_securitySetting(users_id , ipAddress , model); 
		
		String Message = "2단계 보안 설정에 실패했습니다.";
		
		ActionForward forward = null;
		if(Check == 0  ) {
			System.out.println("실행됨? ");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			
			out.println("<script>");
			out.println("alert('"+Message+".');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			user.setUserSecurity_id("1");
			HttpSession session =  request.getSession();
			session.setAttribute("userinfo", user);
			
			forward = new ActionForward("myImformationForm.shop" , false);
		}
		
		return forward;
	}

}
