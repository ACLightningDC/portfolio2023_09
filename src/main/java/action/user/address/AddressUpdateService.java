package action.user.address;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class AddressUpdateService {

	public int AddressUpdate(String postcode, String address1, String address2, int user_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = dao.addressUpdate(user_id,postcode ,address1 ,address2 );

		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return Check;
	}
	
}
