package svc.seller.product;

import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ProductManageService {

	public static ArrayList<Product> getProductList(int sellerMallid) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<Product> products = dao.getProductList(sellerMallid);
		
		return products;
	}
	
}
