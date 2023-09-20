package svc.seller.mallPage;

import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;
import vo.Users;

public class IndexMakeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Users user = CheckLogin(request, response);
		HttpSession session = request.getSession();
		int sellerMallid = (int) session.getAttribute("sellerMallid");
		
		String PageType = request.getParameter("pageType");
		String name = request.getParameter("name");
		
		IndexMakeService indexMake = IndexMakeService();  
		
		if(request.getParameter("categori")!=null) {
			String CategoriCheck = indexMake.getCategori();
			
			if() {
				String categori = request.getParameter("categori");
			}
		}else {
			
		}
		
		
		return forward;
		
	}

}
