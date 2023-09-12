package svc.buy;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.ShoppingCart;

public class CartBuyService {

	public ArrayList<ShoppingCart> cartBuy(String[] cartproduct) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<ShoppingCart> BuyList = new ArrayList<>(); 
		
		int Check = 0;
		
		for(int i=0 ; i < cartproduct.length ; i++)
		{
			ShoppingCart buy = dao.cartBuy(Integer.parseInt(cartproduct[i]));
			BuyList.add(buy);
		}
		
		
		close(con);
		
		return BuyList;
	}

}
