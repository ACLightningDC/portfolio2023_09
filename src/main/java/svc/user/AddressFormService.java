package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Address;
import vo.Users;

public class AddressFormService {

	public ArrayList<Address> UserAddressGet(int user_id) {
		
		Connection con =getConnection();
		
		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);

		
		ArrayList<Address> address = dao.UserAddressGet(user_id);
		close(con);	
		return address;
	}



}
