package action.mainPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mainPage.ShopPageGetService;
import svc.seller.ShoppingMallManageService;
import vo.ActionForward;
import vo.Pagination;
import vo.sellermall;

public class ShopPageGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1; //현재 페이지 (기본값: 1)
		
		//URL 파라미터에서 페이지 번호를 읽어옴
		String pageParam = request.getParameter("page");
		if(pageParam != null && !pageParam.isEmpty()) {
			try {
				page = Integer.parseInt(pageParam);
				if(page <=0) {
					//페이지 번호가 1보다 작거나 같으면 기본값 1로 설정
					page = 1;
				}
			}catch (NumberFormatException e) {
				//페이지 번호가 잘못된 경우, 기본값인 1을 사용
				e.printStackTrace();
			}
		}
		ShopPageGetService shopPageGetService = new ShopPageGetService();
		ArrayList<sellermall> sellermalls =  shopPageGetService.getShoppingAllMallList();
		
		int sellermallCount = sellermalls.size();
		
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, PAGE_SIZE, sellermallCount);
		
		request.setAttribute("page",  pagination);
		
		
		request.setAttribute("sellermalls", sellermalls);
		
		request.setAttribute("forward", "shopPage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);	
		return forward;
	}

	//페이지당 아이템 수를 상수로 정의
	private static final int PAGE_SIZE = 15;
}
