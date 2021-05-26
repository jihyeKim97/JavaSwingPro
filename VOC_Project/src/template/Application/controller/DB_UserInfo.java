package template.Application.controller;


import java.sql.SQLException;
import java.sql.Statement;

public class DB_UserInfo {

	DB_Connect conn;
	
	public DB_UserInfo() {

	}
	
	
	public static final int GENDER_FEMALE = 1;
	public static final int GENDER_MALE = 0;
	public static final int MEMBER= 0;
	public static final int NOT_MEMBER = 1;
	
	public int id;
	private String userId;
	private String userPw;
	private	String userName;
	private int gender;
	private String userPhoneNum;
	private int isMember;
	private	String userDoB;
	
	

	
		
	public DB_UserInfo(int id, String userId, String userPw, String userName, int gender, String userPhoneNum,
			int isMember, String userDoB) {
		super();
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userPhoneNum = userPhoneNum;
		this.isMember = isMember;
		this.userDoB = userDoB;
	}
	
	


	public DB_UserInfo(String userId, String userPw, String userName, int gender, String userPhoneNum, int isMember,
			String userDoB) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userPhoneNum = userPhoneNum;
		this.isMember = isMember;
		this.userDoB = userDoB;
	}




	



	public DB_UserInfo(String userId, String userPw, String userName, int gender, String userPhoneNum, String userDoB) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.userPhoneNum = userPhoneNum;
		this.userDoB = userDoB;
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


	public String getUserDoB() {
		return userDoB;
	}


	public void setUserDoB(String userDoB) {
		this.userDoB = userDoB;
	}




	public boolean insertNewMember(DB_UserInfo ui) {
			conn = null;
			conn.beginConnection();
			if (conn.conn == null && ui != null) {
			//	INSERT INTO member(Member_id,id,password,name,gender,phone_number,is_member, birthday) VALUES 
			//	(VOCPRO_SEQ.nextval,'jiwon','1234','지원',1,'123123123','0','912154');

				String sql // 순서, 개수, 타입.. 띄어쓰기
						= "INSERT INTO member(member_id,id,password,name,gender,phone_number,is_member, birthday) VALUES (" + 
				"VOCPRO_SEQ.nextval," 
								+ ui.getUserId() + ", "
								+ ui.getUserPw() + ", " + ui.getUserName() + ", " + ui.getGender() +
								", "+ ui.getUserPhoneNum() + ", " + "0"+ ", " + ui.getUserDoB();
				System.out.println(sql);
				try {
					Statement stmt = conn.conn.createStatement();
					
					int r = stmt.executeUpdate(sql);
	// 데이터 변화(DML insert, update, delete)
	// 변화 없이 단순 데이터 조회는 stmt.executeQuery() select
					if (r == 1) {
						System.out.println("DBMgr: 회원 가입 성공! " + ui);
					} else {
						System.out.println("DBMgr: 회원 가입 실패! " + ui);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("DB error!!");
			}
			conn.endConnection();
			return false;
	}
	}