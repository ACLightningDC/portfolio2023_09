package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Address;

public class AddressFindService {

	public static ArrayList<Address> findAddress(int id) {
		
Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		ArrayList<Address> addressS = dao.findAddress(id);
		
		close(con);
		return addressS;
	}
	
}
