package vo;

public class Users {
	public int id;
	public String userid;
	public String password;
	public String joinDate;
	public String email;
	public String phone;
	public String birthday;
	public char degree;
	
	public Users() {}
	
	public Users(int id, String userid, String password, String joinDate, String email, String phone, String birthday,
			char degree) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.joinDate = joinDate;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.degree = degree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public char getDegree() {
		return degree;
	}

	public void setDegree(char degree) {
		this.degree = degree;
	}
	
	
}
