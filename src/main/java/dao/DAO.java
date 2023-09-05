package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static db.JdbcUtill.*;
import vo.Users;

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
			System.out.println("id 값"+id);

			pstmt.setString(2, password);
			System.out.println("password 값"+password);

			rs = pstmt.executeQuery();
			System.out.println(loginCheck);

			if(rs.next()) {
				loginCheck = rs.getInt("id");
				System.out.println("sql 값 인출"+rs.getInt("id"));
			}
			System.out.println(loginCheck);
		}catch(Exception e) {
			System.out.println("loginCheck 에러: " +e);
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return loginCheck;
	}

	public Users getUsersInfo(int id) {
		Users userInfo = null;
		String sql = " select * from users where id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				userInfo = new Users();
				userInfo.setId(id);
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setName(rs.getString("name"));
				userInfo.setDate(rs.getString("date"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPhone(rs.getString("Phone"));
				userInfo.setBirthday(rs.getString("birthday"));
				userInfo.setGrade(rs.getString("grade"));
			}
		}catch(Exception e){
			System.out.println("[DAO] getUsersInfo 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return userInfo;
	}

	public String findId(String name, String email) {
		String userid = null;
		String sql = " select userid from users where name =? and email = ?";
		try {
			
			System.out.println(name +" "+email);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				userid = rs.getString("userid");
			}
			
			System.out.println(userid);
		}catch(Exception e){
			System.out.println("[DAO] findId 에러" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return userid;
	}

	public int PassowordFind(String randomPasswordEncode, String userid, String email) {
		int check = 0;
		String sql =" update users set password=? where userid=? and email=?";
		try {
								
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, randomPasswordEncode);
			pstmt.setString(2, userid);
			pstmt.setString(3, email);
			
			check= pstmt.executeUpdate();

				System.out.println(userid);
			}catch(Exception e){
				System.out.println("[DAO] PassowordFind 에러" + e );
			}finally {
				close(pstmt);
			}
		return check;
	}
	
}
