package svc.mainPage;

import static db.JdbcUtill.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ProductPageGetService {

	public int productPageGetPageCount() {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int cnt = dao.getAllProductListCnt();
		
		close(con);

		
		return cnt;
	}


	public ArrayList<Product> productPageGetList(int page, int limit) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		System.out.println(page);
		int first = (page-1)* limit; 
		System.out.println(first);
		
		ArrayList<Product> products = dao.productPageGetList(first ,limit);
		
		close(con);

		
		return products;
	}
	
}
