package svc.user.address;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class AddressDeleteService {

	public int addressDelete(int id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = dao.addressDelete(id);

		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return Check;
	}

}
