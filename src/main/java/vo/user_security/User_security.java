package vo.user_security;

public class User_security {
	private int id;
	private int users_id;
	private String ipaddress;
	private String model;
	private int security_check;
	
	public int getSecurity_check() {
		return security_check;
	}
	public void setSecurity_check(int security_check) {
		this.security_check = security_check;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User_security [id=" + id + ", users_id=" + users_id + ", ipaddress=" + ipaddress + ", model=" + model
				+ "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
