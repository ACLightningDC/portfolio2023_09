package action.mainPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mainPage.ProductPageGetService;
import vo.ActionForward;
import vo.Pagination;
import vo.Product;

public class ProductPageGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1; //현재 페이지 (기본값: 1)
		
		//int proudcut_cnt = 0; //제품 개수
		
		//URL 파라미터에서 페이지 번호를 읽어옴
		//String page_temp  = request.getParameter("page");
		
		String pageParam = request.getParameter("page");
		if(pageParam != null && !pageParam.isEmpty()){	
			try {
				page = Integer.parseInt(pageParam) ;
				if (page <=0) {
					//페이지 번호가 1보다 작거나 같으면 기본값 1로 설정
					page = 1;
				}
			}catch (NumberFormatException e) {
				//페이지 번호가 잘못된 경우, 기본값인 1을 사용
				e.printStackTrace();
			}	
		}
		System.out.println("page" +page);

		//
		ProductPageGetService productPageGetService = new ProductPageGetService();
		ArrayList<Product> products =  productPageGetService.productPageGetList(page);
		
		//proudcut_cnt = products.size(); //현재 페이지의 제품 개수
		int productCount = products.size(); //현재 페이지의 제품 개수
		
		 /**
		  * 계산 
		  */
		//Pagination 객체를 생성, 정보를 설정
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, rangeSize , productCount);
		
		System.out.println(pagination);
//		page_VO.setPage(page);
//		page_VO.setListCnt(proudcut_cnt);
		
		request.setAttribute("page", pagination);
		request.setAttribute("products", products);
		
		request.setAttribute("forward", "productPage.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);	
		return forward;
	}

	//페이지당 아이템 수를 상수로 정의
	private static final int rangeSize  = 15;
}
