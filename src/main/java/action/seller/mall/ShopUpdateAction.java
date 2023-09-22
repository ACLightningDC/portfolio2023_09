package action.seller.mall;

import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.seller.mall.ShopUpdateService;
import vo.ActionForward;
import vo.Users;

public class ShopUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		CheckLogin(request, response); 
		
		HttpSession session =  request.getSession();
		int sellerMallid = (int) session.getAttribute("sellerMallid");
		String name = request.getParameter("name");
		
		int Check =0;
		ShopUpdateService shopUpdateService = new ShopUpdateService();
		Check = shopUpdateService.shopUpdate(sellerMallid ,name);
		
		String Message = "쇼핑몰 이름 변경에 실패했습니다.";
		ActionForward forward = ActionForwardForUpdateController(response, Check, Message, new ActionForward("MallManageForm.Seller", true));
		
		
		return forward;
	}

}
