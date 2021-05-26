package template.Application.controller;

import java.util.Date;

public class Login_data {

	private int member_id;
	private String id;
	private String password;
	private String name;
	private int gender;
	private int phone_number;
	private int is_member;
	private Date birthday;

	public Login_data() {
	}

	public Login_data(String name, int phone_number) {
		super();
		this.name = name;
		this.phone_number = phone_number;
	}

	public Login_data(String id, String name, int phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
	}

	public Login_data(String id, String password, String name, int phone_number) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone_number = phone_number;
	}

	public Login_data(int member_id, String id, String password, String name, int gender, int phone_number,
			int is_member, Date birthday) {
		super();
		this.member_id = member_id;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phone_number = phone_number;
		this.is_member = is_member;
		this.birthday = birthday;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passward) {
		this.password = passward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public int getIs_member() {
		return is_member;
	}

	public void setIs_member(int is_member) {
		this.is_member = is_member;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "data [member_id=" + member_id + ", id=" + id + ", password=" + password + ", name=" + name + ", gender="
				+ gender + ", phone_number=" + phone_number + ", is_member=" + is_member + ", birthday=" + birthday
				+ "]";
	}

}
