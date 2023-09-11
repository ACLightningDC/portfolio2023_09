package svc.Cart;

import static db.JdbcUtill.*;

import java.sql.Connection;

import dao.DAO;
import vo.Address;

public class CartCountUpdateService {

	public int CartCountUpdate(int id, int orderCount) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check= dao.CartCountUpdate(id , orderCount);
		
		
		if(Check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return Check;
	}

}
