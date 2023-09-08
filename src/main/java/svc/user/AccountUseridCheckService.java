package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;

import dao.DAO;

public class AccountUseridCheckService {

	public int AccountUseridCheck(String userid) {
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		String useridCheck = dao.AccountUseridCheck(userid);
		int Check = 0 ;
		if(useridCheck!=null) {
			Check = 1;
		}
		
		close(con);
		return Check;
	}

}
