package action.seller.mall;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.seller.mall.ShopDeleteService;
import vo.ActionForward;
import static util.LoginCheck.CheckLogin;

public class ShopDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CheckLogin(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ShopDeleteService shopDeleteService = new ShopDeleteService();
		int Check = shopDeleteService.shopDelete(id);
		
		if(Check > 0  ) {
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('잘못된 삭제 입니다.');");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		ActionForward forward = new ActionForward("ShoppingMallManage.shop", false);
		return forward;
	}

}
