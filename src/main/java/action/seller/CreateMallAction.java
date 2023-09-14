package action.seller;

import static util.LoginCheck.CheckLogin;

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
		
		Users user =  CheckLogin(request, response); 

		int users_id = user.getId();
		
		String name = request.getParameter("name");
		
		
		
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
			
			forward = new ActionForward("ShoppingMallManage.shop", false); 
		}
		return forward;
	}

}
