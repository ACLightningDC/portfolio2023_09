package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.UsersupdateService;
import vo.ActionForward;
import vo.Users;

public class usersupdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userid =request.getParameter("userid");
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		String birthday =request.getParameter("birthday");
		
		HttpSession session = request.getSession();
		Users users =  (Users) session.getAttribute("userinfo");
		
		int id = users.getId();
		
		UsersupdateService usersupdateService = new UsersupdateService();
		int Check = usersupdateService.userupdate(id , userid , name ,phone, birthday);
		
		if(Check > 0) {
			users.setUserid(userid);
			users.setName(name);
			users.setPhone(phone);
			users.setBirthday(birthday);
			
			session.setAttribute("userinfo", users);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('잘못된 입력입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		ActionForward actionForward = new ActionForward("myImformationForm.shop", true); 
		return actionForward;
	}

}
