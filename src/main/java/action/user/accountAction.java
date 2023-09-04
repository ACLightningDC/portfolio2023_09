package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.AccountService;
import vo.ActionForward;
import vo.Users;

public class accountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String birthday= request.getParameter("birthday");
		String email= request.getParameter("email");
		String gender = request.getParameter("gender");
		
		Users users =  new Users();
		
		users.setUserid(userid);
		users.setPassword(password);
		users.setName(name);
		users.setPhone(phone);
		users.setBirthday(birthday);
		users.setEmail(email);
		users.setGender(gender);
		
		AccountService accountService = new AccountService();
		
		int resultCheck = accountService.account(users);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		
		if(resultCheck < 0 ) {
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
			forward = new ActionForward("loginForm.shop", false); 
		}
		
		return forward;
	}

}
