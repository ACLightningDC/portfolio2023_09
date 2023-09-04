package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class findIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String name =request.getParameter("name");
		String email =request.getParameter("email");
		
		System.out.println(name + " "+email);
		
		FindIdService findIdService = new FindIdService();
		
		String userid = findIdService.findId(name , email);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(userid == null) {
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			request.setAttribute("userid", userid);
			
			forward = new ActionForward("findIdComplete.shop", false); 
		}
		
		return forward;
	}

}
