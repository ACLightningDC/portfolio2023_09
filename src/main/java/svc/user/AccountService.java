package svc.user;

import static db.JdbcUtill.*;

import java.sql.Connection;

import dao.DAO;
import vo.Users;

public class AccountService {

	public int account(Users users) {
		Connection con = getConnection();
		
		DAO dao = DAO.getInstance();
				
		dao.setConnection(con);
		
		int Check = dao.accountjoin(users);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return Check;
	}

	public int address(int users_id ,String postcode, String address1, String address2) {
		Connection con = getConnection();

		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);
		
		int Check = dao.addressAdd(users_id , postcode, address1 , address2);
		
		if(Check > 0  ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return Check;
	}

	public int idGet(String userid, String password) {
		Connection con = getConnection();

		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);
		
		int user_id = dao.usersIdGet(userid , password);
		close(con);	
		return user_id;
	}

	public int CompanyRegistrationNumber(int user_id, String companyRegistrationNumber) {
		Connection con = getConnection();

		DAO dao = DAO.getInstance();
		
		dao.setConnection(con);
		
		int Check = dao.CompanyRegistrationNumber(user_id , companyRegistrationNumber);
		int CheckGrade = dao.sellerGrade(user_id);
		
		if(Check > 0 & CheckGrade> 0 ) {
			commit(con);
			Check = 1;
		}else {
			rollback(con);
		}
		close(con);
		return Check;
	}

}
