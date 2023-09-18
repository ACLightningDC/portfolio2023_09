package action.user.LoginCheck;

import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.LoginCheck.OTPResultService;
import vo.ActionForward;

public class OTPResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String user_codeStr = request.getParameter("user_code");
        long user_code = Integer.parseInt(user_codeStr);
        String encodedKey = request.getParameter("encodedKey");
        long l = new Date().getTime();
        long ll =  l / 30000;
        
        
        OTPResultService OTPResultservice = new OTPResultService();
         
        boolean check_code = false;
        
        try {
            // 키, 코드, 시간으로 일회용 비밀번호가 맞는지 일치 여부 확인.
            check_code = OTPResultservice.check_code(encodedKey, user_code, ll);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
         
        System.out.println("check_code : " + check_code);
		
        ActionForward forward = null; 
        
        if(check_code) {
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
