package action.seller.mall;

import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.seller.mall.ShopDeleteService;
import vo.ActionForward;

public class ShopDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CheckLogin(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ShopDeleteService shopDeleteService = new ShopDeleteService();
		int Check = shopDeleteService.shopDelete(id);
		
		ActionForward forward = ActionForwardForUpdateController(response, Check, "상품 삭제후 매장 삭제 부탁드립니다.", new ActionForward("ShoppingMallManage.shop", false));
		
		return forward;
	}

}
