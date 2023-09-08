package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Cart.CartRemoveAction;
import action.Cart.ShoppingCartProductAddAction;
import action.Cart.shoppingCartView;
import action.mainPage.ProductPageGetAction;
import action.mainPage.ShopPageGetAction;
import action.seller.CreateMallAction;
import action.seller.ShoppingMallManageAction;
import action.seller.ShoppingMallManageActionOne;
import action.seller.product.productAddAction;
import action.seller.product.productManageAction;
import action.user.PasswordFindAction;
import action.user.accountAction;
import action.user.accountDeleteAction;
import action.user.accountEmailCheckAction;
import action.user.accountUseridCheckAction;
import action.user.findIdAction;
import action.user.loginAction;
import action.user.logoutAction;
import action.user.myImformationFormAddressFind;
import action.user.usersupdateAction;
import action.user.product.ShoppingCartProductDetailAction;
import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.shop")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command= requestURI.substring(contextPath.length());
		
		System.out.println("커맨드 변수 "+command);

		
		
		Action action = null;
		ActionForward forward = null;
		/**
		 * 헤더 이동
		 */
		if(command.equals("/productPage.shop")){
			action = new ProductPageGetAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/shopPage.shop")){
			action = new ShopPageGetAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		/**
		 * 몰 페이지
		 */
		if(command.equals("/Mallpage.shop")){
			action = new ShopPageGetAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		/**
		 * 로그인 로그아웃
		 */
		
		 if(command.equals("/login.shop")){
			action = new loginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		 if(command.equals("/homePage.shop")){
			 request.setAttribute("forward", "homePage.jsp");
			forward = new ActionForward("template.jsp", false);
			 
		 }
		 if(command.equals("/loginForm.shop")){
			 request.setAttribute("forward", "loginForm.jsp");
			 forward = new ActionForward("template.jsp", false);
			 
		 }
		else if(command.equals("/logout.shop")) {
			action = new logoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 회원가입
		 */
		else if(command.equals("/account.shop")) {
			request.setAttribute("forward", "/accountSelect.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountBuisness.shop")) {
			request.setAttribute("forward", "/AccountRelated/accountBuisness.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountUsers.shop")) {
			request.setAttribute("forward", "/AccountRelated/accountUsers.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountAction.shop")) {
			action = new accountAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/accountEmailCheck.shop")) {
			forward = new ActionForward("AccountRelated/Check/JoinEmailCheck.jsp", false);
		}
		else if( command.equals("/accountEmailCheckAction.shop")) {
			action = new accountEmailCheckAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/accountUseridCheck.shop")) {
			forward = new ActionForward("AccountRelated/Check/joinIdCheck.jsp", false);
		}
		else if( command.equals("/accountUseridCheckAction.shop")) {
			action = new accountUseridCheckAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		 /**
		  * 회원 수정
		  */
		 
		else if(command.equals("/myImformationDelete.shop")) {
			action = new accountDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/usersupdateAction.shop")) {
			action = new usersupdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		else if(command.equals("/myImformationUpdateForm.shop")) {
			request.setAttribute("forward", "/myImformation/myImformationUpdateForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/myImformationForm.shop")) {
			request.setAttribute("forward", "/myImformationForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/AddressAdd.shop")) {
			request.setAttribute("forward", "/myImformation/AddressAdd.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		
		 /**
		  * 쇼핑 카트 
		  */
		else if(command.equals("/shoppingCart.shop")) {
			action = new shoppingCartView();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/shoppingCartProductAdd.shop")) {
			action = new ShoppingCartProductAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/CartRemove.shop")) {
			action = new CartRemoveAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/CartBuyForm.shop")) {
//			action = new CartBuyFormAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		 /**
		  * 제품 상세
		  */
		else if(command.equals("/shoppingCartProductDetail.shop")) {
			action = new ShoppingCartProductDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 아이디 찾기  
		 */
		else if(command.equals("/findIdForm.shop")) {
			request.setAttribute("forward", "LoginRelated/findIdForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/findIdAction.shop")){
			action = new findIdAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/findIdComplete.shop")) {
			request.setAttribute("forward", "/LoginRelated/findIdComplete.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		 
		/**
		 * 비밀번호 찾기  
		 */		 
		else if(command.equals("/PasswordFindFrom.shop")) {
			request.setAttribute("forward", "LoginRelated/PasswordFind/PasswordFindFrom.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/PasswordFindAction.shop")){
			action = new PasswordFindAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/PasswordFindComplete.shop")) {
			request.setAttribute("forward", "/LoginRelated/PasswordFind/PasswordFindComplete.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		 /**
		  * 홈쇼핑 생성
		  */
		else if(command.equals("/ShoppingMallManage.shop")) {
			action = new ShoppingMallManageAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/shopCreateForm.shop")) {
			request.setAttribute("forward", "/MallManage/CreateShopForm.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		else if(command.equals("/CreateMall.shop")){
			action = new CreateMallAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 /**
		  * 홈쇼핑 관리
		  */
		else if(command.equals("/ShoppingMallManageOne.shop")) {
			action = new ShoppingMallManageActionOne();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/ShopUpdate.shop")) {
			request.setAttribute("forward", "/MallManage/ShopManage/ShopUpdateForm.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		 /**
		  * 제품 관리
		  */
		else if(command.equals("/productAdd.shop")) {
			request.setAttribute("forward", "/MallManage/productManage/productAdd.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		else if(command.equals("/productManage.shop")) {
			action = new productManageAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} 
		else if(command.equals("/productAddAction.shop")) {
			action = new productAddAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		 /**
		  * 문의사항 관리
		  */
		else if(command.equals("/inquiryManage.shop")) {
			request.setAttribute("forward", "/MallManage/inquiryManage/inquiryManage.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		 /**
		  * 배송관리
		  */
		else if(command.equals("/orderManage.shop.shop")) {
			request.setAttribute("forward", "/MallManage/orderManage/orderManage.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		 
		 	System.out.println(forward.getPath());
		if(forward !=null) {
			System.out.println("FrontController Forward 실행");
			if(forward.isRedirect()) {
				System.out.println("FrontController 실행 리다이렉트");

				response.sendRedirect(forward.getPath());
				return;
			}else {
				System.out.println("FrontController 실행 디스패쳐");

				request.getRequestDispatcher(forward.getPath()).forward(request, response);
				return;
			}
		}
	}

}
