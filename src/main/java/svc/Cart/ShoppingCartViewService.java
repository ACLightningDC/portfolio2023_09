package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Order_list;
import vo.ShoppingCart;

public class ShoppingCartViewService {

	public ArrayList<ShoppingCart> shoppingCartView(int users_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		
		ArrayList<ShoppingCart> ShoppingCart = dao.shoppingCartView(users_id);
		close(con);
		return ShoppingCart;
	}

}
