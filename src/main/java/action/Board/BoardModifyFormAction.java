package action.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Board.BoardDetailService;
import vo.ActionForward;
import vo.Board.BoardBean;

public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
		 	
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			
			BoardDetailService boardDetailService = new BoardDetailService();	
		   	BoardBean article = boardDetailService.getArticle(board_num);
		   	
		   	request.setAttribute("article", article);
		   	
	   		forward.setPath("/board/qna_board_modify.jsp");
	   		
	   		return forward;
	   		
	 }
	 
}