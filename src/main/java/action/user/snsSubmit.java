package action.user;

import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.LoginService;
import svc.user.SnsSubmitService;
import vo.ActionForward;
import vo.Users;

public class snsSubmit implements Action {
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		String snsId = request.getParameter("snsId");
		String snsEmail = request.getParameter("snsEmail");
		
//		HttpSession session =  request.getSession();
//		session.getAttribute("");
		
		SnsSubmitService snsSubmitservice = new SnsSubmitService();
		int Check = snsSubmitservice.snsSubmit(users_id , snsId ,snsEmail); 
		String Message = "sns 등록에 실패했습니다.";
		ActionForward forward = null;
		
		if(Check > 0 ) {
			Check = snsSubmitservice.usersupdatesnsSubmit(users_id);
			if(Check > 0) {
				forward = new ActionForward("myImformationForm.shop", false);
				HttpSession session =  request.getSession();
				user.setSnsLogin_id("01");
				session.setAttribute("userinfo", user);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();	
				
				out.println("<script>");
				out.println("alert('"+Message+".');");
				out.println("history.back()");
				out.println("</script>");
			}
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			
			out.println("<script>");
			out.println("alert('"+Message+".');");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
