package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import action.Board.BoardDeleteProAction;
import action.Board.BoardDetailAction;
import action.Board.BoardListAction;
import action.Board.BoardModifyFormAction;
import action.Board.BoardModifyProAction;
import action.Board.BoardReplyFormAction;
import action.Board.BoardReplyProAction;
import action.Board.BoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardControllerServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	public BoardControllerServlet() { //따라적음
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	} 
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-utf-8"); //따라 적음
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("bo 커맨드 변수" + command); //따라 적음
		
		Action action = null;
		ActionForward forward = null;
		

		if(command.equals("/boardWriteForm.bo")){
			forward=new ActionForward();
			forward.setPath("/board/qna_board_write.jsp");
			
		}else if(command.equals("/boardWritePro.bo")){ //쓰기
			action  = new BoardWriteProAction();
			try {
				forward = action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardList.bo")){ //내역
			action = new BoardListAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardDetail.bo")){
			action = new BoardDetailAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyForm.bo")){
			action = new BoardReplyFormAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyPro.bo")){
			action = new BoardReplyProAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardModifyForm.bo")){
			action = new BoardModifyFormAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/boardModifyPro.bo")){
			action = new BoardModifyProAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/boardDeleteForm.bo")){
			String nowPage = request.getParameter("page");
			
			request.setAttribute("page", nowPage);
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			
			request.setAttribute("board_num",board_num);
			
			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}
		else if(command.equals("/boardDeletePro.bo")){
			action = new BoardDeleteProAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println(forward.getPath());
		
		if(forward != null){
			
			if(forward.isRedirect()){
				
				response.sendRedirect(forward.getPath());
				return;
				
			}else{
				
			request.getRequestDispatcher(forward.getPath()).forward(request, response);
			return;
			}
			
		}
		
	}
	
}

