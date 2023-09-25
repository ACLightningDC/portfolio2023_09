package action.inquiry;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.inquiry.InquiryUserService;
import vo.ActionForward;
import vo.Inquiry;
//리스트내역 추가-----
import vo.PageInfo;
//------------------
import vo.Users;

public class InquiryUserAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Users user = CheckLogin(request,response);
		
		int users_id = user.getId();
		
		InquiryUserService inquiryUserService = new InquiryUserService();
		//ArrayList<InquiryUser> inquiryUserList = inquiryUserService.getinquiryUser(users_id);
		
		//리스트 내역으로 추가 --------------------------------
        // 현재 페이지와 페이지당 문의 수 설정
        int page = 1;
        int listCount = 10; // 페이지당 문의 수

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        PageInfo pageInfo = new PageInfo(page, listCount);

        // 페이지네이션을 고려하여 문의 리스트 가져오기
        ArrayList<Inquiry> inquiryUserList = inquiryUserService.getinquiryUser(users_id, pageInfo);

        // 조회 결과 및 페이지 정보를 request에 저장하여 JSP 페이지로 전달
        System.out.println(inquiryUserList);
        request.setAttribute("inquiryUserList", inquiryUserList);
        request.setAttribute("pageInfo", pageInfo);

        // 이동할 JSP 페이지 경로를 설정
        request.setAttribute("forward", "/inquiry/inquiryUser.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
        
        return forward;
		
		//return null;
	}

}
