package action.seller;

import static util.action.ActionUtil.*;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		ActionForward forwardGet = new ActionForward("ShoppingMallManage.shop", false); 
		String Message = "쇼핑몰 생성에 실패했습니다.";

		ActionForward forward = ActionForwardForUpdateController(response, Check, Message, forwardGet);
		
		return forward;
	}

}
