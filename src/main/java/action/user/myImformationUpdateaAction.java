package action.user;

import static util.action.ActionUtil.ActionForwardForUpdateController;
import static util.action.ActionUtil.CheckLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.MyImformationUpdateaService;
import util.SHA256;
import vo.ActionForward;
import vo.Users;

public class myImformationUpdateaAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		Users user =  CheckLogin(request, response); 
		int id = user.getId();
		int Check = 0;
		
		Users inputuser = new Users();
		
		String passowrd = request.getParameter("password");
		
		
		inputuser.setId(id);
		inputuser.setUserid(request.getParameter("userid")); 
		inputuser.setPassword(passowrd); 
		inputuser.setName(request.getParameter("name")); 
		inputuser.setEmail(request.getParameter("email")); 
		inputuser.setPhone(request.getParameter("phone")); 
		
		System.out.println(inputuser);
		
		MyImformationUpdateaService myImformationUpdateaservice = new MyImformationUpdateaService();
		Check = myImformationUpdateaservice.myImformationUpdate(inputuser); 
		
		String Message = "사용자 정보 변경에 실패했습니다.";
		ActionForward forward = ActionForwardForUpdateController(response, Check, Message, new ActionForward("myImformationUpdateForm.User" , false));
		
		request.setAttribute("updateMessage", "사용자 변경에 성공했습니다.");
		
		return forward;
	}

}
