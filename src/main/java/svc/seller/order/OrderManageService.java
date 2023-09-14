package svc.seller.order;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.ShoppingCart;

public class OrderManageService {

	public ArrayList<ShoppingCart> OrderManageShow(int sellerMallid) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<ShoppingCart> ShoppingCart = dao.OrderManageShow(sellerMallid);
		
		close(con);
		return ShoppingCart;
	}
	
}
