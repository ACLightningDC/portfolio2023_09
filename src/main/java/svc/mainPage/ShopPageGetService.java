package svc.mainPage;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;
import vo.sellermall;

public class ShopPageGetService {

	public ArrayList<sellermall> getShoppingAllMallList() {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<sellermall> sellermalls = dao.getAllsellermallList();
		
		close(con);

		
		return sellermalls;
	}

}
