package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.ShoppingCart;

public class ShoppingresultUpdateService {

	public int resultUpdate(String[] id, String order_result, int delivery_id) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		int Check = 0;
		for(int i =0; i < id.length;i++) {
			int id_parse = Integer.parseInt(id[i]);
			Check  = dao.shoppingresultUpdate(order_result, id_parse , delivery_id);
			if(Check == 0)break;
		}
		
		if(Check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return Check;
	}

	public int createDelivery(int address_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = 0;
		
			Check  = dao.createDelivery(address_id);
		
		if(Check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return Check;
	}

	public int getDelivery_id(int address_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Delivery_id = 0;
		
		Delivery_id  = dao.getDelivery_id(address_id);
		
		close(con);
		
		return Delivery_id;
	}

}
