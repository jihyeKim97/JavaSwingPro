package template.Application.controller;

public class SignUp_data {

	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 0;
	public static final int MEMBER = 0;
	public static final int NOT_MEMBER = 1;

	int member_id;
	String id;
	String password;
	String name;
	int gender;
	String phone_number;
	int is_member;
	String birthday;

	public SignUp_data(int member_id, String id, String password, String name, int gender, String phone_number,
			int is_member, String birthday) {
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

	public SignUp_data(String id, String password, String name, int gender, String phone_number, String birthday) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phone_number = phone_number;
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

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getIs_member() {
		return is_member;
	}

	public void setIs_member(int is_member) {
		this.is_member = is_member;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "SignUp_data [member_id=" + member_id + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", phone_number=" + phone_number + ", is_member=" + is_member + ", birthday="
				+ birthday + "]";
	}

}
