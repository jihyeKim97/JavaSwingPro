package template.Application.controller;

import java.util.ArrayList;

public class Mypage_Member_data {
	int memberID;
	String id;
	String password;
	String name;
	int gender;
	String phoneNumber;
	int is_Member;
	String birthday;
	public Mypage_Member_data() {}

 // 회원 정보 수정 시
	public Mypage_Member_data(String password, String name, String phoneNumber) {
		super();
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
// 회원 모든 정보 불러올 시
	public Mypage_Member_data(int memberID, String id, String password, String name, int gender, String phoneNumber,
			int is_Member, String birthday) {
		super();
		this.memberID = memberID;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.is_Member = is_Member;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "MyPage_Data [memberID=" + memberID + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", is_Member=" + is_Member + ", birthday="
				+ birthday + "]";
	}

	public int getMemberID() {
		return memberID;
	}
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getIs_Member() {
		return is_Member;
	}

	public void setIs_Member(int is_Member) {
		this.is_Member = is_Member;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
