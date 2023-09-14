package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.ShoppingCart;

public class ShoppingBuyDeliveryShowService {

	public ArrayList<ShoppingCart> shoppingBuyDeliveryShow(int users_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		
		ArrayList<ShoppingCart> ShoppingCart = dao.shoppingResultView(users_id);
		
		close(con);
		return ShoppingCart;
	}

}
