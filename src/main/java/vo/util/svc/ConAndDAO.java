package vo.util.svc;

import java.sql.Connection;

import dao.DAO;

public class ConAndDAO {
	private DAO dao ;
	private Connection con ;
	
	public DAO getDao() {
		return dao;
	}
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
