package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.AccountService;
import vo.ActionForward;
import vo.Users;

public class accountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String birthday= request.getParameter("birthday");
		String email= request.getParameter("email");
		String gender = request.getParameter("gender");
		
		String postcode = request.getParameter("postcode");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		System.out.println("스트링 출력"+request.getParameter("b_no"));
		String b_noS = request.getParameter("b_no");
		 String CompanyRegistrationNumber = null;
		if(b_noS != null) {			
			CompanyRegistrationNumber = b_noS;
		}
		
		System.out.println("CompanyRegistrationNumber = " + CompanyRegistrationNumber);
		
		Users users =  new Users();
		
		users.setUserid(userid);
		users.setPassword(password);
		users.setName(name);
		users.setPhone(phone);
		users.setBirthday(birthday);
		users.setEmail(email);
		users.setGender(gender);
		
		AccountService accountService = new AccountService();
		
		int resultCheck = accountService.account(users);
		
		int user_id = accountService.idGet(userid , users.getPassword() );
		
		int resultAddressCheck = accountService.address(user_id ,postcode , address1, address2);
		
		if(CompanyRegistrationNumber != null) {
			int resulCompanyRegistrationNumber = accountService.CompanyRegistrationNumber(user_id , CompanyRegistrationNumber);
		}
		
		
		
		if(resultCheck < 0 && resultAddressCheck < 0 ) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('잘못된 이름 이메일 입니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
			forward = new ActionForward("loginForm.shop", false); 
		}
		
		return forward;
	}

}
