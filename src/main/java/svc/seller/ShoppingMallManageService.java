package svc.seller;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.sellermall;

public class ShoppingMallManageService {

	public ArrayList<sellermall> getShoppingMallList(int seller_id) {
		
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		ArrayList<sellermall> sellermalls = dao.findSellerMall(seller_id);
		
		close(con);

		return sellermalls;
		
	}
	
	
}
