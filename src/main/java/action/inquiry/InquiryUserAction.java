package action.inquiry;

import static util.LoginCheck.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.inquiry.InquiryUserService;
import vo.ActionForward;
import vo.InquiryUser;
import vo.Users;

public class InquiryUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Users user = CheckLogin(request,response);
		
		int users_id = user.getId();
		
		InquiryUserService inquiryUserService =new InquiryUserService();
		ArrayList<InquiryUser> inquiryUserList = inquiryUserService.getinquiryUser(users_id);
		
		
		return null;
	}

}
