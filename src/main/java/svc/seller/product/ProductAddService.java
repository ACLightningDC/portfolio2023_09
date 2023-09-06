package svc.seller.product;

import static db.JdbcUtill.*;

import java.sql.Connection;

import dao.DAO;
import vo.Product;

public class ProductAddService {

	public int addproduct(Product product) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int check = dao.ProductAdd(product);

		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return check;
	}
	
}
