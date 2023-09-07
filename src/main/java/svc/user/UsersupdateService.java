package svc.user;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class UsersupdateService {

	public int userupdate(int id , String userid, String name, String phone, String birthday) {
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.userupdate(id , userid , name, phone, birthday);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return Check;
	}
	
}
