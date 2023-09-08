package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.stream.Stream;

import dao.DAO;

public class CartRemoveService {

	public int CartRemove(String[] remove) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int[] removeInt = Stream.of(remove).mapToInt(Integer::parseInt).toArray();
		
		int check = 0;
		
		for(int i = 0 ; removeInt.length > i ;i++) {
			
			check = dao.CartRemove(removeInt[i]);
			if(check == 0) {
				break;
			}
		}

		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return check;
		
	}

}
