package action.user;

import static db.JdbcUtill.*;

import java.sql.Connection;

import dao.DAO;

public class FindIdService {
	
	


	public String findId(String name, String email) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		String userid = dao.findId(name , email);
		
		
		
		return userid;
	}
			
	
	
}
