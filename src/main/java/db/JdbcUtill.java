package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtill {
	
	public static Connection getConnection() {
		Connection con =null;
		
		try {
			Context initCtx = new InitialContext();
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/portfolio");
			con = ds.getConnection();
			
			con.setAutoCommit(false);
		} catch (NamingException | SQLException e) {
			System.out.println("JdbcUtill 클래스의 getConnection 오류"+e);
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
			try {
				con.commit();
				System.out.println("commit success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("commit success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
