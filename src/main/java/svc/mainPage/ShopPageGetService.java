package svc.mainPage;

import static db.JdbcUtill.close;
import static db.JdbcUtill.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Product;
import vo.sellermall;

public class ShopPageGetService {

	public ArrayList<sellermall> getShoppingAllMallList(int page, int limit) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		page = (page-1)* limit; 

		ArrayList<sellermall> sellermalls = dao.getAllsellermallList(page, limit);
		
		close(con);

		System.out.println(sellermalls);
		return sellermalls;
	}

	public int shopPageGet() {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int cnt = dao.shopPageGet();
		
		close(con);

		
		return cnt;
	}

}
