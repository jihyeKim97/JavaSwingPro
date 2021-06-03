package template.Application.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Login_DB {
	static DB_Connect DB;
	static Connection conn;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_PW_MISMATCH = 2;
	public static final int LOGIN_FAIL_NOT_FOUND = 3;
	public static final int LOGIN_ERROR = 4;
	public static final int FIND_ERROR = 1;
	public static final int FIND_SUCCESS = 2;
	public static final int FIND_NULL = 3;
	public static final int PHN_MISMATCH = 4;

	public Login_DB() {
		this.conn = DB.getConn();
	}

	public ArrayList<Login_data> selectAllMembers() {
		if (this.conn != null) {
			ArrayList<Login_data> uiList = new ArrayList<>();
			String sql = "select * from member ORDER BY MEMBER_ID desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("BIRTHDAY");

					Login_data ui = new Login_data(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
							rs.getInt("GENDER"), rs.getString("PHONE_NUMBER"), rs.getString("BIRTHDAY"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: ���� 議고�� 紐��� => " + uiList.size());
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!!@");
		}

		return null;
	}

	/*-------------------------------------------------------------------------------------*/
	static DB_Connect connect;
	static Login_data loginDT;
	static ArrayList<Login_data> LogArr = new ArrayList<>();

	public static ArrayList<Login_data> SelectMemberID(int memberID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id =  " + memberID;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					int member_id = rs.getInt("member_id");
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String phone_number = rs.getString("phone_number");
					int is_member = rs.getInt("is_member");
					String birthday = rs.getString("birthday");

					System.out.println(member_id + " " + id + " " + password + " " + name + " " + gender + " "
							+ phone_number + " " + birthday + " " + is_member);
					LogArr.add(
							new Login_data(member_id, id, password, name, gender, phone_number, is_member, birthday));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return LogArr;
	}

	/*-------------------------------------------------------------------------------------*/

	public Login_data movepage(int a) {
		if (this.conn != null) {

			String sql = "select is_member from member where member_id = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, a);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Login_data mb = new Login_data(rs.getInt("member_id"), rs.getString("id"), rs.getString("password"),
							rs.getString("name"), rs.getInt("gender"), rs.getString("phone_number"),
							rs.getInt("is_member"), rs.getString("birthday"));
					return mb;
				} else {

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러");
		}
		return null;
	}

	public boolean changeBypass(String mbpassword, String mbid, String phn, String name) {
		if (this.conn != null) {
			String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE ID = ? AND PHONE_NUMBER = ? AND NAME = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbpassword);
				pstmt.setString(2, mbid);
				pstmt.setString(3, phn);
				pstmt.setString(4, name);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("db 임시비밀번호 발급 성공");
					return true;
				} else {
					System.out.println("db 임시비밀번호 발급 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Login_data selectOneMemberByLogin(String mbLogin) {
		if (this.conn != null) {

			String sql = "select * from member where id = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbLogin);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Login_data mb = new Login_data(rs.getInt("member_id"), rs.getString("id"), rs.getString("password"),
							rs.getString("name"), rs.getInt("gender"), rs.getString("phone_number"),
							rs.getInt("is_member"), rs.getString("birthday"));
					return mb;
				} else {

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}

	// 아이디찾는함수
	public Login_data selectOneMemberByName(String mbname) {
		if (this.conn != null) {

			String sql = "select * from member where name = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbname);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Login_data mb = new Login_data(rs.getInt("member_id"), rs.getString("id"), rs.getString("password"),
							rs.getString("name"), rs.getInt("gender"), rs.getString("phone_number"),
							rs.getInt("is_member"), rs.getString("birthday"));
					return mb;
				} else {

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러");
		}
		return null;
	}

	public int loginProcess(String login, String pw) {
		if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
			System.out.println("로그인 인증에 대한 입력에러");
			return LOGIN_ERROR;
		}
		if (this.conn != null) {
			Login_data mb = selectOneMemberByLogin(login);
			if (mb != null) {
				String mbPw = mb.getPassword();
				if (mbPw != null && !mbPw.isEmpty()) {
					if (mbPw.equals(pw)) {
						System.out.println("로그인 인증 성공!");
						return LOGIN_SUCCESS;
					} else {
						System.out.println("암호 불일치");
						return LOGIN_FAIL_PW_MISMATCH;
					}
				} else {
					System.out.println("로그인 인증에 대한 PW 에러!");
					return LOGIN_ERROR;
				}
			} else {
				System.out.println("잘못된 로그인 이름이거나 없는 회원");
				return LOGIN_FAIL_NOT_FOUND;
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return LOGIN_ERROR;
	}

	public int findid(String name, String phone_number) {
		if (name == null || phone_number == null || name.isEmpty() || phone_number.isEmpty()) {
			return FIND_NULL;
		}
		if (this.conn != null) {
			Login_data mb = selectOneMemberByName(name);
			if (mb != null) {
				String mbPhn = mb.getPhone_number();
				String Phn = phone_number;
				if (mbPhn != null) {
					if (mbPhn == Phn) {
						String mblogin = mb.getId();
						JOptionPane.showMessageDialog(null, mblogin + "입니다.");
						return FIND_SUCCESS;
					} else {
						return PHN_MISMATCH;
					}
				} else {
					return FIND_NULL;
				}
			} else {
				return FIND_ERROR;
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return FIND_ERROR;
	}

	public static String setPassword(int length) {
		int num = 0;
		char[] pwset = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
				'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&' };

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			num = (int) (pwset.length * Math.random());
			sb.append(pwset[num]);
		}
		return sb.toString();
	}

	public int findpw(String name, String login, String phone_number) {
		if (name == null || login == null || phone_number == null || name.isEmpty() || login.isEmpty()
				|| phone_number.isEmpty()) {
			return FIND_NULL;
		}
		if (this.conn != null) {
			Login_data mb = selectOneMemberByLogin(login);
			if (mb != null) {
				String mbPhn = mb.getPhone_number();
				String Phn = phone_number;
				if (mbPhn == Phn && mbPhn != null) {
					String mbname = mb.getName();
					if (mbname != null && !mbname.isEmpty()) {
						if (mbname.equals(name)) {
							String setpassword = setPassword(8);
							boolean mb1 = changeBypass(setpassword, login, Phn, name);
							JOptionPane.showMessageDialog(null, setpassword + "입니다.");
							return FIND_SUCCESS;
						}
					} else {
						return PHN_MISMATCH;
					}
				} else {
					return FIND_NULL;
				}
			} else {
				return FIND_ERROR;
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return FIND_ERROR;
	}

	public static void main(String[] args) throws SQLException {
		Login_DB mbMgr = new Login_DB();
//		ArrayList<Login_data> i = SelectMemberID(34);
//		System.out.println(i);
//		
		DB.endConnection();

	}

}
