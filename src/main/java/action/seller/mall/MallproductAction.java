package action.seller.mall;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.seller.mall.MallproductService;
import vo.ActionForward;
import vo.Product;
import vo.Users;

public class MallproductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		int MallID = Integer.parseInt(request.getParameter("id"));
//		HttpSession session =  request.getSession();
//		session.getAttribute("");
		
		MallproductService mallproductservice = new MallproductService();
		ArrayList<Product> productList= mallproductservice.mallproductGet(MallID);; 
		
		int Check = 0;
		
//		ActionForward forwardGet = new ActionForward(".controller", false);
//		request.setAttribute("forward", ".jsp");
		
//		request.setAttribute("", val);
//		session.setAttribute("", val);
		ActionForward forward = null;
		return forward;
	}

}
