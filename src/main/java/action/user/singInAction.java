package action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.LoginService;
import vo.ActionForward;
import vo.Users;

public class singInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		System.out.println("singInAction 실행");

		SignInService signInService =  new SignInService();
		
		Users users = new Users();
		
		users.setUserid(null);
		users.setPassword(null);
		users.setName(null);
		users.setPhone(null);
		users.setEmail(null);
		users.setBirthday(null);
		users.setGrade(null);
		
		
		String userid = request.getParameter("name");
		String password = request.getParameter("name");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String gender = request.getParameter("gender");
		
		return null;
	}

}
