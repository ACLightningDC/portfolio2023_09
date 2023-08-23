package vo;

public class Users {
	public int id;
	public String userid;
	public String password;
	public String name;
	
	public String date;
	public String phone;
	public String email;
	public String birthday;
	public String grade;
	public String ipaddress;
	
	public Users(int id, String userid, String password, String name, String date, String phone, String email,
			String birthday, String grade, String ipaddress) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.date = date;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.grade = grade;
		this.ipaddress = ipaddress;
	}

	public Users() {}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	

	
	
}
