package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class PasswordFindService {

	public int PasswordFind(String randomPasswordEncode, String userid, String email) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.PassowordFind(randomPasswordEncode , userid ,email);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return Check;
	}

}
