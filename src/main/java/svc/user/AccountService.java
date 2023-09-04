package svc.user;

import static db.JdbcUtill.*;

import java.sql.Connection;

import dao.DAO;
import vo.Users;

public class AccountService {

	public int account(Users users) {
Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.accountjoin(users);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return Check;
	}

}
