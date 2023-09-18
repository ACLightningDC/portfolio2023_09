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
import action.mainPage.ProductPageGetAction;
import action.mainPage.ShopPageGetAction;
import action.seller.mall.orderManageSalesView;
import action.seller.order.orderManageDeliveryAction;
import action.seller.order.orderManageDeliveryregistrationAction;
import action.user.AddressFormAction;
import action.user.LoginCheck.OTPResultAction;
import action.user.address.AddressAddAction;
import action.user.address.AddressDeleteAction;
import action.user.address.AddressUpdateAction;
import action.user.security.user_securityCancelAction;
import action.user.security.user_securitySettingAction;
import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.User")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerServlet() {
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
		
		if(command.equals("/shoppingPayAfter.User")) {
			request.setAttribute("forward", "buyUser/shoppingCart/shoppingPayAfter.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		else if(command.equals("/myImformationUpdateForm.User")) {
			request.setAttribute("forward", "userMain/userImformation/myImformationUpdateForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/BuyForm.User")) {
			request.setAttribute("forward", "/buyUser/buy/BuyForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountBuisness.User")) {
			request.setAttribute("forward", "/userMain/account/signup/accountBuisness.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountUsers.User")) {
			request.setAttribute("forward", "/userMain/account/signup/accountUsers.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/findIdForm.User")) {
			request.setAttribute("forward", "/userMain/account/FindForgot/findIdForm.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/findIdComplete.User")) {
			request.setAttribute("forward", "/userMain/account/FindForgot/findIdComplete.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/PasswordFindFrom.User")) {
			request.setAttribute("forward", "/userMain/account/FindForgot/PasswordFindFrom.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/PasswordFindComplete.User")) {
			request.setAttribute("forward", "/userMain/account/FindForgot/PasswordFindComplete.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/accountB_noCheck.User")) {
			forward = new ActionForward("userMain/account/signup/check/JoinComRegCheck.jsp", false);
		}
		else if(command.equals("/accountEmailCheck.User")) {
			forward = new ActionForward("userMain/account/signup/check/JoinEmailCheck.jsp", false);
		}
		else if(command.equals("/accountUseridCheck.User")) {
			forward = new ActionForward("userMain/account/signup/check/joinIdCheck.jsp", false);
		}
		else if(command.equals("/user_securitySetting.User")) {
			action = new user_securitySettingAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/user_securityCancel.User")) {
			action = new user_securityCancelAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/otpCheck.User")) {
			forward = new ActionForward("/userMain/login/loginCheck/otpCheck.jsp", false);
		}
		else if(command.equals("/OTPResult.User")) {
			action = new OTPResultAction();
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
