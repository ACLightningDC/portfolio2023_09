package svc.mainPage;

import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ProductPageGetService {

	public ArrayList<Product> productPageGetList() {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<Product> products = dao.getAllProductList();
		
		return products;
	}
	
}
