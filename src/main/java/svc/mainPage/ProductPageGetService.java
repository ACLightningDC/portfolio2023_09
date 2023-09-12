package svc.mainPage;

import static db.JdbcUtill.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ProductPageGetService {

	public ArrayList<Product> productPageGetList(int page) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<Product> products = dao.getAllProductList(page);
		
		close(con);

		
		return products;
	}
	
}
