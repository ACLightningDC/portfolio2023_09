package action.template;

import static util.action.ActionUtil.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;
import vo.Users;

public class actionTemplate implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
//		request.getParameter("");
//		HttpSession session =  request.getSession();
//		session.getAttribute("");
		
//		Service service = new Serrvice();
//		int Check = service.method; 
//		Val val= service.method; 
		
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
