package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JdbcUtill;

public class DAO {
	private Connection con =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	private DAO() {}
	
	private static DAO dao;
	
	public static DAO getInstance() {
		if(dao == null) {
			dao = new DAO();
		}
		
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}

	public int loginCheck(String id, String password) {
		
		int loginCheck = 0;
		
		String sql = " select id from users where userid = ? and password = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			//0 prepareStatment 의 setString -> ? 1 부터 함 
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			System.out.println(loginCheck);

			if(rs.next()) {
				rs.getInt(loginCheck);
			}
			System.out.println(loginCheck);
		}catch(Exception e) {
			System.out.println("loginCheck 에러: " +e);
		}finally {
			JdbcUtill.close(rs);
			JdbcUtill.close(pstmt);
		}
			
		return loginCheck;
	}
	
}
