package template.Application.controller.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.SignUp_data;

public class SIgnUp_DB {
	static final int LOGIN_SUCCESS = 1;
	static final int LOGIN_FAIL_PW_MISMATCH = 2;
	static final int LOGIN_FAIL_NOT_FOUND = 3;
	static final int LOGIN_ERROR = 4;
	static SignUp_data su;
	static DB_Connect connect;

	public boolean insertNewMember(SignUp_data ui) {
		connect.beginConnection();
		if (connect.conn != null && ui != null) {
			String sql = "INSERT INTO member(member_id,id,password,name,gender,phone_number,is_member, birthday) "
					+ "VALUES "
					+ "(MEMBER_SEQ.nextval"
					+ "','" + ui.getId() + "', '" + ui.getPassword() + "', '" + ui.getName() + "', '" + ui.getGender()
					+ "', '" + ui.getPhone_number() + "', '" + "0" + "', '" + ui.getBirthday() + "')";
			System.out.println(sql);
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				String memName = ui.getName();
				String phn = ui.getPhone_number();
				String bod = ui.getBirthday();
				String pw = ui.getPassword();
				if (r == 1 && memName != null && phn != null && bod != null && pw != null) {
					System.out.println("DBMgr: 회원 가입 성공! " + ui);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	public ArrayList<SignUp_data> selectAllMembers() {
		connect.beginConnection();
		if (connect.conn != null) {
			ArrayList<SignUp_data> uiList = new ArrayList<>();
			String sql = "select * from member ORDER BY id desc";
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("");
					SignUp_data ui = new SignUp_data(rs.getInt("MEMBER_ID"), rs.getString("ID"),
							rs.getString("PASSWORD"), rs.getString("NAME"), rs.getInt("GENDER"),
							rs.getString("PHONE_NUMBER"), rs.getInt("IS_MEMBER"), rs.getString("BIRTHDAY"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: 회원 조회 명수 => " + uiList.size());
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return null;
	}

	public SignUp_data selectOneMemberById(int dbui) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member" + " where id = " + dbui;
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					SignUp_data ui = new SignUp_data(rs.getInt("MEMBER_ID"), rs.getString("ID"),
							rs.getString("PASSWORD"), rs.getString("NAME"), rs.getInt("GENDER"),
							rs.getString("PHONE_NUMBER"), rs.getInt("IS_MEMBER"), rs.getString("BIRTHDAY"));
					return ui;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return null;
	}

	public SignUp_data selectOneMemberByUserId(String usid) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member" + " where Id = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(2, usid);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					SignUp_data ui = new SignUp_data(rs.getInt("MEMBER_ID"), rs.getString("ID"),
							rs.getString("PASSWORD"), rs.getString("NAME"), rs.getInt("GENDER"),
							rs.getString("PHONE_NUMBER"), rs.getInt("IS_MEMBER"), rs.getString("BIRTHDAY"));
					return ui;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return null;
	}

	public int nullCheck(String userName, String userPw, String userPhoneNum, String userDoB) {
		if (userName == null || userPhoneNum == null || userPw == null || userName.isEmpty() || userPw.isEmpty()
				|| userPhoneNum.isEmpty()) {
			System.out.println("빈칸이 존재 합니다");
			return LOGIN_ERROR;
		} else {
			System.out.println("빈칸이 다 채워졌습니다.");
			insertNewMember(su);
		}
		return LOGIN_ERROR;
	}
}
