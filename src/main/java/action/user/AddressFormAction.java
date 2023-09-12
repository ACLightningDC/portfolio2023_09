package action.user;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.user.AddressFormService;
import vo.ActionForward;
import vo.Address;
import vo.Users;

public class AddressFormAction implements Action {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("userinfo");
		int user_id = user.getId();
		
		AddressFormService addressFormService = new AddressFormService();
		ArrayList<Address> address = addressFormService.UserAddressGet(user_id);
		
		System.out.println(address);
		
		request.setAttribute("address", address);
		
		
		request.setAttribute("forward", "/AccountRelated/AddressAdd/AddressManage.jsp");
		forward = new ActionForward("template.jsp", false);
		return forward;
	}

}
