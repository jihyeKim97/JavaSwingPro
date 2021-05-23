package template.Application.controller;



public class DB_UserInfo {

	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 0;
	public static final int IS_MEMBER = 0;
	public static final int IS_NOT_MEMBER = 1;
	
	private int id;
	private String userId;
	private String userPw;
	private	String userName;
	private int gender;
	private	String userDoB;
	private String userPhoneNum;
	private int isMember;
	


	public DB_UserInfo(int id, String userId, String userPw, String userName, int gender, String userDoB,
		 String userPhoneNum, int isMember) {
		super();
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userDoB = userDoB;
		this.userPhoneNum = userPhoneNum;
		this.isMember = isMember;
	}



	public DB_UserInfo () {}

	

	public DB_UserInfo(int id, String userId, String userPw, String userName, int gender, String userDoB,
			String userPhoneNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userDoB = userDoB;
		this.userPhoneNum = userPhoneNum;
	}


	public DB_UserInfo(String userId, String userPw, String userName, int gender, String userDoB,
			String userPhoneNum) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userDoB = userDoB;
		this.userPhoneNum = userPhoneNum;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getUserDoB() {
		return userDoB;
	}


	public void setUserDoB(String userDoB) {
		this.userDoB = userDoB;
	}



	public String getUserPhoneNum() {
		return userPhoneNum;
	}


	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}


	public int getIsMember() {
		return isMember;
	}



	public void setIsMember(int isMember) {
		this.isMember = isMember;
	}



	@Override
	public String toString() {
		return "DB_UserInfo [id=" + id + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", gender=" + gender + ", userDoB=" + userDoB + ", userPhoneNum="
				+ userPhoneNum + "]";
	}


	
	
	
}




