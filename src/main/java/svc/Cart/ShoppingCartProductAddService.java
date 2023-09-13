package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Order_list;

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

	public ArrayList<Order_list> GetCartOrder_Check(int users_id, int product_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<Order_list> order_List = dao.GetCartOrder_Check(users_id , product_id);
		close(con);
		return order_List;
	}

	public int shoppingCartProductUpdate(int id, int order_count) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int check = dao.shoppingCartProductUpdate(id ,order_count);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return check;
	}
	
}
