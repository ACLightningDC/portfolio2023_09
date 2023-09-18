package util.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.Users;

public class ActionUtil {
	public static Users CheckLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session =  request.getSession();
		Users user =  (Users)session.getAttribute("userinfo");
		
		if(user == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('로그인 후 사용 부탁드립니다.');");
			out.println("location.href='loginForm.shop'");
			out.println("</script>");
		}
		
		return user;
		
	}
	
	public static ActionForward ActionForwardForUpdateController(HttpServletResponse response ,int Check , String Message ,ActionForward forwardGet) throws Exception {
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
			forward = forwardGet;
		}
		
		return forward;
	}
	
	public static ActionForward ActionForwardForUpdate(HttpServletRequest request, HttpServletResponse response ,int Check , String Message , String contextJsp) throws Exception {
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
			request.setAttribute("forward", contextJsp);
			forward = new ActionForward("/template.jsp", false);
		}
		
		return forward;
	}
	
	
}
