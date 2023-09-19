package action.user.LoginCheck;

import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.LoginService;
import svc.user.LoginCheck.OTPResultService;
import vo.ActionForward;
import vo.Users;
import vo.login.OTP;
import vo.user_security.User_security;

public class OTPResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean check_code = false;
		int Check = 0;
		if(request.getParameter("Check")!=null){
			Check = Integer.parseInt(request.getParameter("Check"));
		}
		if(Check == 1) {
			check_code = true;

		}else {
			String user_codeStr = request.getParameter("user_code");
			long user_code = Integer.parseInt(user_codeStr);
			String encodedKey = request.getParameter("encodedKey");
			long l = new Date().getTime();
			long ll =  l / 30000;
			
			
			OTPResultService OTPResultservice = new OTPResultService();
			
			
			try {
				// 키, 코드, 시간으로 일회용 비밀번호가 맞는지 일치 여부 확인.
				check_code = OTPResultservice.check_code(encodedKey, user_code, ll);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			System.out.println("check_code : " + check_code);
			
		}
		ActionForward forward = null; 
		if(check_code) {
			LoginService loginService =  new LoginService();
			int loginCheck = Integer.parseInt(request.getParameter("loginCheck"));
			HttpSession session =  request.getSession();
			Users user =  loginService.getLoginInfo(loginCheck);
			
			session.setAttribute("userinfo", user);
			
			if(user.getGrade().equals("S")) {
				int Seller_id = loginService.getSeller_id(user.getId());
				session.setAttribute("Seller_id", Seller_id);
			}
			
			forward = new ActionForward("/homePage.shop" ,false);
			
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('잘못된 번호 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
        
		return forward;
	}

}
