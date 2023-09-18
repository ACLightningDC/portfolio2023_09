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

	public int OrderManageDeliveryregistration(int address_id, String[] cartproduct, Delivery delivery) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		
		int Check = 0;
		
		
		Check = dao.OrderManageDeliveryregistration(address_id , delivery);
		int delivery_Id =dao.getdeliveryId(address_id , delivery);
		
		for(int i=0 ; i < cartproduct.length ; i++)
		{
			
			Check = dao.OrderManageDeliveryresultChange(delivery_Id , Integer.parseInt(cartproduct[i]));
			if(Check == 0)break;

		}
		
		commitOrCloseSvc(Check, con);
		
		return Check;
	}

	public int GetAddress_id(int order_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
			int address_id = dao.GetAddress_id(order_id);
		
		commitOrCloseSvc(con);
		
		return address_id;
	}
	
}
