package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.user.PasswordFindAction;
import action.user.findIdAction;
import action.user.loginAction;
import action.user.logoutAction;
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

		
		System.out.println("FrontController 실행 1");
		
		Action action = null;
		ActionForward forward = null;
		
		/**
		 * 로그인 로그아웃
		 */
		
		 if(command.equals("/login.shop")){
			action = new loginAction();
			System.out.println("FrontController 실행 login");

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/logout.shop")) {
			action = new logoutAction();
			System.out.println("FrontController 실행 logout");
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		/**
		 * 아이디 찾기  
		 */
		else if(command.equals("/LoginRelated/findIdForm.shop")) {
			request.setAttribute("forward", "/LoginRelated/findIdForm.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		else if(command.equals("/LoginRelated/findIdAction.shop")){
			action = new findIdAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/LoginRelated/findIdComplete.shop")) {
			request.setAttribute("forward", "/LoginRelated/findIdComplete.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		 
		/**
		 * 비밀번호 찾기  
		 */		 
		else if(command.equals("/LoginRelated/PasswordFindFrom.shop")) {
			request.setAttribute("forward", "/LoginRelated/PasswordFind/PasswordFindFrom.jsp");
			forward = new ActionForward("/template.jsp", false);
		}
		else if(command.equals("/LoginRelated/PasswordFind/PasswordFindAction.shop")){
			action = new PasswordFindAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/LoginRelated/PasswordFind/PasswordFindComplete.shop")) {
			request.setAttribute("forward", "/LoginRelated/PasswordFind/PasswordFindComplete.jsp");
			forward = new ActionForward("/template.jsp", false);
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
