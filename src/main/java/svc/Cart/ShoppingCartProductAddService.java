package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ShoppingCartProductAddService {

	public int shoppingCartProductAdd(int users_id, int product_id, int order_count) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int check = dao.shoppingCartProductAdd(users_id , product_id ,order_count);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return check;
		
	}

	public int GetCartOrder_count(int users_id, int product_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int order_count = dao.GetCartOrder_count(users_id , product_id);
		close(con);
		return order_count;
	}

	public int shoppingCartProductUpdate(int users_id, int product_id, int order_count) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int check = dao.shoppingCartProductUpdate(users_id , product_id ,order_count);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return check;
	}
	
}
