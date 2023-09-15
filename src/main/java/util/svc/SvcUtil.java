package util.svc;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;
import vo.util.svc.ConAndDAO;

public class SvcUtil {
	public static void commitOrCloseSvc (int Check ,Connection con) {
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);		
	}
	public static void commitOrCloseSvc (Connection con) {
		
		close(con);		
	}
	public static ConAndDAO daoSetConnection () {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ConAndDAO conAndDAO = new ConAndDAO();
		conAndDAO.setCon(con);
		conAndDAO.setDao(dao);
		
		return conAndDAO ;
	}
}
