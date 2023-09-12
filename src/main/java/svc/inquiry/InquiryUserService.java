package svc.inquiry;

import static db.JdbcUtill.close;
import static db.JdbcUtill.commit;
import static db.JdbcUtill.getConnection;
import static db.JdbcUtill.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import vo.InquiryUser;

public class InquiryUserService {

	public ArrayList<InquiryUser> getinquiryUser(int users_id) {
		
		Connection con = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<InquiryUser> inquiryUserList = dao.getinquiryUser(users_id);

		
		close(con);
		
		return inquiryUserList;
	}

}
