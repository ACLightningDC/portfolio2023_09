package util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Users;

public class LoginCheck {
	public static void CheckLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		return ;
		
	}
}
