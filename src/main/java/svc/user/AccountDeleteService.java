package svc.user;

import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class AccountDeleteService {

	public int accountDelete(int id) {
		
Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.accountDelete(id);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return Check;
	}

}
