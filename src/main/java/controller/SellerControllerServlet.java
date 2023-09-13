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
import action.user.AddressFormAction;
import action.user.address.AddressAddAction;
import action.user.address.AddressDeleteAction;
import action.user.address.AddressUpdateAction;
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
		
		 /*
		  * 주소 추가
		  */
		if(command.equals("/AddressForm.shop")) {
			action = new AddressFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AddressAddForm.shop")) {
			request.setAttribute("forward", "/AccountRelated/AddressAdd/AddressAddFrom.jsp");
			forward = new ActionForward("template.jsp", false);
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
