package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.AccountEmailCheckService;
import vo.ActionForward;

public class accountEmailCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		
		AccountEmailCheckService accountIdCheckService = new AccountEmailCheckService();
		int check = accountIdCheckService.accountIdCheck(email);
		ActionForward forward = null;
		request.setAttribute("checkEmail", check+1);

			forward = new ActionForward("accountEmailCheck.User",false);
		
		return forward;
	}

}
