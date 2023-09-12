package svc.user.address;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class AddressAddService {

	public int AddressAdd(String postcode, String address1, String address2, int user_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = dao.addressAdd(user_id,postcode ,address1 ,address2 );

		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return Check;
	}

}
