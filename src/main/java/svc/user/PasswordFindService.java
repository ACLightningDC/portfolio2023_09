package svc.user;

import static db.JdbcUtill.getConnection;

import java.sql.Connection;

import dao.DAO;

public class PasswordFindService {

	public int PasswordFind(String randomPasswordEncode, String userid, String email) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.PassowordFind(randomPasswordEncode , userid ,email);
		
		return Check;
	}

}
