package svc.inquiry;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

public class InquiryService {
	
	public int Makeinquiry(int users_id, int seller_Mall_id, int product_id, String inquiry_name, String inquiry_contents ,int order_id) {
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		int Check = dao.makeinquiry(users_id ,seller_Mall_id ,product_id,inquiry_name ,inquiry_contents , order_id);

		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return Check;
	}
}
