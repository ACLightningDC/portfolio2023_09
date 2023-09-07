package svc;

import static db.JdbcUtill.close;
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
		
		close(con);
		return loginCheck;
	}
	
	public Users getLoginInfo(int id) {
		
		Connection con =getConnection();
		
		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);

		
		Users userInfo = dao.getUsersInfo(id);
		close(con);	
		return userInfo;
	}

	public int getSeller_id(int id) {
		Connection con =getConnection();
		
		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);

		
		int seller_id = dao.getSeller_id(id);
		close(con);
		return seller_id;
	}
	
}
