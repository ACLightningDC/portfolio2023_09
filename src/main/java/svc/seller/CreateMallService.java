package svc.seller;

import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Address;

public class CreateMallService {



	public int getSeller_id(int users_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Seller_id = dao.getSeller_id(users_id);

		
		return Seller_id;
	}

	public int createMall(int seller_id, String name) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = dao.createMall(seller_id , name);

		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		return Check;
	}

}
