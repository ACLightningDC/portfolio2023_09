package svc.seller.order;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import static util.svc.SvcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.Delivery;
import vo.ShoppingCart;

public class OrderManageDeliveryregistrationService {

	public int OrderManageDeliveryregistration(String[] cartproduct, Delivery delivery) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		
		int Check = 0;
		
		for(int i=0 ; i < cartproduct.length ; i++)
		{
			Check = dao.OrderManageDeliveryresultChange(Integer.parseInt(cartproduct[i]));
			if(Check == 0)break;

			Check = dao.OrderManageDeliveryregistration(Integer.parseInt(cartproduct[i]) , delivery);
			if(Check == 0)break;
		}
		
		commitOrCloseSvc(Check, con);
		
		return Check;
	}
	
}
