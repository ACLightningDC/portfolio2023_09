package svc;

import static db.JdbcUtill.getConnection;

import java.sql.Connection;

import dao.DAO;
import vo.ActionForward;

public class LoginService {
	
	public int getLogin(String id , String password) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int loginCheck = dao.loginCheck(id , password);
		

		
		
		return loginCheck;
	}
	
	
	
}
