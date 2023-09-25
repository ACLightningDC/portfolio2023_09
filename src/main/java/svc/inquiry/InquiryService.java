package svc.inquiry;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;

import dao.DAO;

//리스트 내역 추가--------
import java.util.List;
import vo.Inquiry;
import vo.PageInfo;
//---------------------


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
	
// 리스트 내역 추가 ------------------------------------------------
	public List<Inquiry> getInquiryList(int users_id, PageInfo pageInfo){
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		List<Inquiry> inquiryList = dao.getInquiryList(users_id, pageInfo);
		
		close(con);
		
		return inquiryList;
	}
//--------------------------------------------------------------	
}

