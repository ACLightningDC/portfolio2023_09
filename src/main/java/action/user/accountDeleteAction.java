package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.AccountDeleteService;
import vo.ActionForward;
import vo.Users;

public class accountDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session =  request.getSession();
		Users users = (Users) session.getAttribute("userinfo");
		
		AccountDeleteService accountDeleteService = new AccountDeleteService();
		int Check = accountDeleteService.accountDelete(users.getId()); 
		
		if(Check>0) {
			
			session.removeAttribute("userinfo");
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('회원 탈퇴 축하드립니다.');");
			out.println("location.href='loginForm.shop'");
			out.println("</script>");
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		ActionForward forward = new ActionForward("loginForm.shop" ,true);
		return forward ;
	}

}
