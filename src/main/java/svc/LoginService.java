package svc;

import static db.JdbcUtill.getConnection;

import java.sql.Connection;

import dao.DAO;
import vo.Users;

public class LoginService {
	
	public int getLogin(String id , String password) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int loginCheck = dao.loginCheck(id , password);
		
		System.out.println("login service logincheck" + loginCheck);
		
		
		return loginCheck;
	}
	
	public Users getLoginInfo(String id) {
		
		Connection con =getConnection();
		
		DAO dao = DAO.getInstance();
		
		Users userInfo = dao.getUsersInfo(id);
				
		return userInfo;
	}
	
}
