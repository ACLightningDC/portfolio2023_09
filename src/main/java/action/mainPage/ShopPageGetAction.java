package action.mainPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mainPage.ProductPageGetService;
import svc.mainPage.ShopPageGetService;
import svc.seller.ShoppingMallManageService;
import vo.ActionForward;
import vo.PageInfo;
import vo.Product;
import vo.sellermall;

public class ShopPageGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = 1; //현재 페이지를 표시 (기본값: 1)
		
		int limit = 9; //한 페이지당 15개
		
		//int proudcut_cnt = 0; //제품 개수
		
		//사용자가 선택한 페이지가 있을 경우 해당 페이지 정보를 저장
		String page_temp  = request.getParameter("page");
		if(page_temp != null){	
			page = Integer.parseInt(page_temp);
		}

		
		ShopPageGetService shopPageGetService = new ShopPageGetService();
		ArrayList<sellermall> sellermalls =  shopPageGetService.getShoppingAllMallList(page, limit);
		System.out.println(sellermalls);
		int cnt = shopPageGetService.shopPageGet();
		//현재 페이지의 제품 개수
		int listCount = cnt;
		
		//총페이지수 - 0.95를 더해서 올림
		int maxPage = (int)((double)listCount / limit + 0.95);
		
		//현재 페이지를 보여줄 시작 페이지수(1, 16, 31..)
		int startPage = (((int) ((double)page / 10 + 0.9)) -1) * 10 + 1;
		System.out.println(startPage);
		//현재 페이지에 보여줄 마지막 페이지수(15, 30, 45..)
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		
		System.out.println(pageInfo);
			
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("sellermalls", sellermalls);
				
		request.setAttribute("forward", "mainPage/shopPage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		return forward;
		
	}

}
