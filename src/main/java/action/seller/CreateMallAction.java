package action.seller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.CreateMallService;
import vo.ActionForward;
import vo.Users;

public class CreateMallAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		Users users = (Users)session.getAttribute("userinfo");
		
		int users_id = users.getId();
		
		CreateMallService createMallService = new CreateMallService();
		int seller_id = createMallService.getSeller_id(users_id);
		
		int Check = createMallService.createMall(seller_id , name);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		ActionForward forward = null;

		if(Check < 0  ) {
			out.println("<script>");
			out.println("alert('실패했습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
			forward = new ActionForward("homePage.shop", false); 
		}
		return forward;
	}

}
