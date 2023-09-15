package svc.seller.mall;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import java.util.ArrayList;

import vo.ShoppingCart;
import vo.util.svc.ConAndDAO;

public class OrderManageSalesViewService {

	public ArrayList<ShoppingCart> orderManageSalesView(int sellerMallid) {
		
		ConAndDAO conAndDao= daoSetConnection();
		
		ArrayList<ShoppingCart> ShoppingCart = conAndDao.getDao().orderManageSalesView(sellerMallid);
		
		commitOrCloseSvc(conAndDao.getCon());
		
		return ShoppingCart;
	}

}
