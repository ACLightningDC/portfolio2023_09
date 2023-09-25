package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import action.user.AddressFormAction;
import action.user.address.AddressAddAction;
import action.user.address.AddressBasicSelectAction;
import action.user.address.AddressDeleteAction;
import action.user.address.AddressUpdateAction;
import action.user.address.Select_addressAction;
import vo.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.address")
public class AddressControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressControllerServlet() {
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
		if(command.equals("/AddressForm.address")) {
			action = new AddressFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AddressAddForm.address")) {
			request.setAttribute("forward", "/userMain/account/address/AddressAddFrom.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/AddressManage.address")) {
			request.setAttribute("forward", "/userMain/account/address/AddressManage.jsp");
			forward = new ActionForward("template.jsp", false);
		}
		else if(command.equals("/AddressAdd.shop")) {
			action = new AddressAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AddressUpdate.address")) {
			action = new AddressUpdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AddressDelete.address")) {
			action = new AddressDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/AddressBasicSelect.address")) {
			action = new AddressBasicSelectAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/select_address.address")) {
			action = new Select_addressAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/select_addressForPopup.address")) {
			action = new AddressFormAction();
			
			
			try {
				forward = action.execute(request, response);
				forward = new ActionForward("/userMain/account/address/AddressManage.jsp", false);
				
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
