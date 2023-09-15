package svc.Cart;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;
import static util.svc.SvcUtil.daoSetConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.ShoppingCart;
import vo.util.svc.ConAndDAO;

public class ShoppingBuyDeliveryShowService {

	public ArrayList<ShoppingCart> shoppingBuyDeliveryShow(int users_id) {
		ConAndDAO conAndDao= daoSetConnection();
		
		
		ArrayList<ShoppingCart> ShoppingCart = conAndDao.getDao().shoppingResultView(users_id);
		
		close(conAndDao.getCon());
		return ShoppingCart;
	}

}
