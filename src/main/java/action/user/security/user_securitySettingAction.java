package action.user.security;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.Users;

public class user_securitySettingAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		String ipAddress =request.getRemoteAddr();
		
		user_securitySettingService user_securitySettingservice = new user_securitySettingSerrvice();
		int Check = user_securitySettingservice.user_securitySetting(users_id , ipAddress); 
		
		int Check = 0;
		
//		ActionForward forwardGet = new ActionForward(".controller", false);
//		request.setAttribute("forward", ".jsp");
		String Message = "실패했습니다.";
		ActionForward forward = ActionForwardForUpdateController(response, Check, Message, forwardGet);
		ActionForward forward = ActionForwardForUpdate(request, response,  Check, Message, Contextjsp );
		
//		request.setAttribute("", val);
//		session.setAttribute("", val);
		
		return forward;
	}

}
