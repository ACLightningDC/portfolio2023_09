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
import action.seller.mall.orderManageSalesView;
import action.seller.order.orderManageDeliveryAction;
import action.seller.order.orderManageDeliveryregistrationAction;
import action.user.AddressFormAction;
import action.user.address.AddressAddAction;
import action.user.address.AddressDeleteAction;
import action.user.address.AddressUpdateAction;
import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.Common")
public class commonControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commonControllerServlet() {
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
		
		if(command.equals("/productDetail.Common")) {
			request.setAttribute("forward", "buyUser/product/productDetail.jsp");
			forward = new ActionForward("template.jsp", false);
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
