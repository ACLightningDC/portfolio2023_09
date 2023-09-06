package svc.Cart;

import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;

public class ShoppingCartProductAddService {

	public int shoppingCartProductAdd(int users_id, int product_id) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int check = dao.shoppingCartProductAdd(users_id , product_id);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return check;
		
	}
	
}
