package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Cart.ShoppingBuyDeliveryShowAction;
import action.Cart.ShoppingresultUpdate;
import action.seller.mall.ShopUpdateAction;
import action.seller.mall.orderManageSalesView;
import action.seller.order.orderManageDeliveryAction;
import action.seller.order.orderManageDeliveryregistrationAction;
import action.user.AddressFormAction;
import action.user.address.AddressAddAction;
import action.user.address.AddressDeleteAction;
import action.user.address.AddressUpdateAction;
import svc.seller.order.orderCheckForm;
import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.Seller")
public class SellerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerControllerServlet() {
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
		
		System.out.println("address 커맨드 변수 "+command);

		
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/ShoppingMallManage.Seller")) {
			request.setAttribute("forward", "/sellerUser/shoppingMall/Mallmanage/ShoppingMallManage.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		if(command.equals("/MallManageForm.Seller")) {
			request.setAttribute("forward", "sellerUser/shoppingMall/Mallmanage/MallManageForm.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		else if(command.equals("/productDetail.Seller")) {
			request.setAttribute("forward", "buyUser/product/productDetail.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/ShoppingMallManager.Seller")) {
			request.setAttribute("forward", "sellerUser/shoppingMall/Mallmanage/ShoppingMallIndexMake.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		 /*
		  * 주소 추가
		  */
		else if(command.equals("/orderManageDelivery.Seller")) {
			action = new orderManageDeliveryAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/orderManageDeliveryregistration.Seller")) {
			action = new orderManageDeliveryregistrationAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if(command.equals("/ShoppingBuyDeliveryShow.Seller")) {
			action = new ShoppingBuyDeliveryShowAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/ShoppingresultUpdate.Seller")) {
			action = new ShoppingresultUpdate();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/orderManageSales.Seller")) {
			action = new orderManageSalesView();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/shopCreateForm.Seller")) {
			request.setAttribute("forward", "/sellerUser/shoppingMall/Mallmanage/CreateShopForm.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		else if(command.equals("/ShopUpdate.Seller")) {
			action = new ShopUpdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/productAdd.Seller")) {
			request.setAttribute("forward", "/sellerUser/shoppingMall/productManage/productAdd.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		else if(command.equals("/productManage.Seller")) {
			request.setAttribute("forward", "/sellerUser/shoppingMall/productManage/productManage.jsp");
			forward = new ActionForward("template.jsp", false);
		} 
		else if(command.equals("/orderCheck.Seller")) {
			action = new orderCheckForm();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} 

		 
		 	System.out.println(forward.getPath());
		if(forward !=null) {
			if(forward.isRedirect()) {

				response.sendRedirect(forward.getPath());
				return;
			}else {

				request.getRequestDispatcher(forward.getPath()).forward(request, response);
				return;
			}
		}
	}

}
