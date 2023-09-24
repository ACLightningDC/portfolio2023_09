package svc.inquiry;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;

//import vo.InquiryUser;

import vo.Inquiry; //리스트내역 추가

//public class InquiryUserService {
//
//	public ArrayList<InquiryUser> getinquiryUser(int users_id) {
//		
//		Connection con = getConnection();
//		DAO dao = DAO.getInstance();
//		dao.setConnection(con);
//		
//		ArrayList<InquiryUser> inquiryUserList = dao.getinquiryUser(users_id);
//
//		
//		close(con);
//		
//		return inquiryUserList;
//	}

public class InquiryUserService {
	
}
	public ArrayList<Inquiry> getInquiryList(int users_id, PageInfo pageInfo) {
	    Connection con = getConnection();
	    DAO dao = DAO.getInstance();
	    dao.setConnection(con);

	    // 페이지 번호와 페이지당 문의 수를 이용하여 startRow, endRow 계산
	    int startRow = (pageInfo.getPage() - 1) * pageInfo.getListCount() + 1;
	    int endRow = startRow + pageInfo.getListCount() - 1;

	    ArrayList<Inquiry> inquiryList = dao.getInquiryList(users_id, startRow, endRow);

	    close(con);
	    return inquiryList;
	
}
