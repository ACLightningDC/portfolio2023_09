package action.user.address;

import static util.action.ActionUtil.CheckLogin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.user.AddressFormService;
import vo.ActionForward;
import vo.Address;
import vo.Users;

public class Select_addressAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;
		
		Users user =  CheckLogin(request, response); 
		int users_id = user.getId();
		
		
		AddressFormService addressFormService = new AddressFormService();
		ArrayList<Address> address = addressFormService.UserAddressGet(users_id);
		
		System.out.println(address);
		
		request.setAttribute("address", address);
		
		
		forward = new ActionForward("AddressForm.address", false);
		return forward;
	}

}
