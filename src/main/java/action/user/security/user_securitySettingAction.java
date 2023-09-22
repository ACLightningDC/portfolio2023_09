package action.user.security;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ActionForward forward = null;
		String Message = "2단계 보안 설정에 실패했습니다.";
		forward = ActionForwardForUpdateController(response, Check, Message, new ActionForward("myImformationForm.shop",true));
		
		return forward;
	}

}
