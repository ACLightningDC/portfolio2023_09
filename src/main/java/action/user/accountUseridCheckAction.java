package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.AccountEmailCheckService;
import svc.user.AccountUseridCheckService;
import vo.ActionForward;

public class accountUseridCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		
		AccountUseridCheckService accountUseridCheckService = new AccountUseridCheckService();
		int check = accountUseridCheckService.AccountUseridCheck(userid);
		ActionForward forward = null;
		request.setAttribute("checkUserid", check+1);
		System.out.println(check);
		
			forward = new ActionForward("AccountRelated/Check/joinIdCheck.jsp",false);

		
		return forward;
	}
}
