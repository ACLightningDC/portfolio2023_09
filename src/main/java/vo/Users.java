package vo;

import util.SHA256;

public class Users {
	//식별자 입력 불필요
	public int id;
	
	//입력 불필요 
	public String date;
	public String grade;
	
	//입력 필요 not null
	public String userid;
	public String password;
	public String name;
	public String gender;
	
	//입력 필요 null 가능 
	public String email;
	public String birthday;

	public Users() {} 
	
	public Users(int id, String date, String grade, String userid, String password, String name, String gender,
			String phone, String email, String birthday) {
		super();
		this.id = id;
		this.date = date;
		this.grade = grade;
		this.userid = userid;
		this.password = SHA256.encodeSHA256(password);
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}
	public String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
		this.password = SHA256.encodeSHA256(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
