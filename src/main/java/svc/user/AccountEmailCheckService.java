package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class AccountEmailCheckService {

	public int accountIdCheck(String email) {
Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		String emailCheck = dao.accountEmailCheck(email);
		System.out.println(emailCheck);
		int Check = 0 ;
		if(emailCheck!=null) {
			Check = 1;
		}
		close(con);
		
		return Check;
	}
	
}
