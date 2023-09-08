package svc.user.product;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ShoppingCartProductDetailService {

	public Product shoppingCartProductDetailView(int product_id) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		Product products = dao.getProduct(product_id);
		
		close(con);
		return products;
	}
	
}
