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

public class DB_Connect2 {

	Login_data ld;
	static Connection conn;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_PW_MISMATCH = 2;
	public static final int LOGIN_FAIL_NOT_FOUND = 3;
	public static final int LOGIN_ERROR = 4;
	public static final int FIND_ERROR = 1;
	public static final int FIND_SUCCESS = 2;
	public static final int FIND_NULL = 3;
	public static final int PHN_MISMATCH = 4;

	public DB_Connect2() {
		this.conn = OracleDBUtil.getConn();
	}
	
	public boolean insertNewMember(int member_id,String id,String password,String name,int gender,
									String phone_number,int is_member, String birthday) {
		if (this.conn != null) {
			String sql 
					= "INSERT INTO member(member_id,id,password,name,gender,phone_number,is_member, birthday) VALUES (" + "VOCPRO_SEQ.nextval,getId,?, ?, ?, ?, ?, '0',? )";
			System.out.println(sql); 
			try {
//
				PreparedStatement pstmt = conn.prepareStatement(sql); // 사전문장준비
// ?서식자의 순서, 개수, 타입 set...
				
				int r = pstmt.executeUpdate(); // 전송
// 데이터 변화(DML insert, update, delete)
// 변화 없이 단순 데이터 조회는 stmt.executeQuery() select
				if (r == 1) {
					System.out.println("DBMgr: 회원 가입 성공! " + id);
				} else {
					System.out.println("DBMgr: 회원 가입 실패! " + id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return false;
	}

	public static void select() throws SQLException {
		Statement st = conn.createStatement();
		String sql = "select * from member";
		ResultSet rs = st.executeQuery(sql);
		String ism = "";
		String gen = "";

		while (rs.next()) {
			int member_id = rs.getInt("member_id");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			int gender = rs.getInt("gender");
			int phone_number = rs.getInt("phone_number");
			int is_member = rs.getInt("is_member");
			Date birthday = rs.getDate("birthday");

			if (is_member == 0) {
				ism = "ȸ��";
			} else {
				ism = "������";
			}

			if (gender == 1) {
				gen = "��";
			} else {
				gen = "��";
			}
			System.out.println(member_id 
								+ " " + id 
								+ " " + password 
								+ " " + name 
								+ " " + gen 
								+ " " + phone_number 
								+ " " + birthday 
								+ " " + ism
								);
		}
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();

	}

	public boolean changeBypass(String mbpassword, String mbid, int phone_number, String name) {
		if (this.conn != null) {
			String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE ID = ? AND PHONE_NUMBER = ? AND NAME = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbpassword);
				pstmt.setString(2, mbid);
				pstmt.setInt(3, phone_number);
				pstmt.setString(4, name);
				int rs = pstmt.executeUpdate();
				if( rs == 1) {
					System.out.println("db ��й�ȣ ���� ����");
					return true;
				} else {
					System.out.println("db ��й�ȣ ���� ����");
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
					Login_data mb = new Login_data(rs.getInt("member_id"),
													rs.getString("id"),
													rs.getString("password"),
													rs.getString("name"),
													rs.getInt("gender"),
													rs.getInt("phone_number"),
													rs.getInt("is_member"),
													rs.getString("birthday"));
					return mb;
				} else {
					System.out.println(mbLogin + " �α��θ��� ȸ�� ���ڵ� ��ȸ DB ����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}

	public Login_data selectOneMemberByName(String mbname) {
		if (this.conn != null) {

			String sql = "select * from member where name = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbname);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Login_data mb = new Login_data(rs.getInt("member_id"),
													rs.getString("id"),
													rs.getString("password"),
													rs.getString("name"),
													rs.getInt("gender"),
													rs.getInt("phone_number"),
													rs.getInt("is_member"),
													rs.getString("birthday"));
					return mb;
				} else {
					System.out.println(mbname + " �α��θ��� ȸ�� ���ڵ� ��ȸ DB ����!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}


	public int loginProcess(String login, String pw) {
		if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
			System.out.println("�α��� ������ ���� �Է� ����!!");
			return LOGIN_ERROR;
		}
		if (this.conn != null) {
			Login_data mb = selectOneMemberByLogin(login);
			if (mb != null) {
				String mbPw = mb.getPassword();
				if (mbPw != null && !mbPw.isEmpty()) {
					if (mbPw.equals(pw)) {
						System.out.println("�α��� ���� ����!!");
						return LOGIN_SUCCESS;
					} else {
						System.out.println("��ȣ ����ġ!!");
						return LOGIN_FAIL_PW_MISMATCH;
					}
				} else {
					System.out.println("�α��� ������ ���� PW ����!!");
					return LOGIN_ERROR;
				}
			} else {
				System.out.println("�߸��� �α��� �̸��̰ų� ���� ȸ��!");
				return LOGIN_FAIL_NOT_FOUND;
			}
		} else {
			System.out.println("DB ��� ����!!");
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
				int mbPhn = mb.getPhone_number();
				int Phn = Integer.parseInt(phone_number);
				if (mbPhn != 0) {
					if (mbPhn == Phn) {
						String mblogin = mb.getId();
						JOptionPane.showMessageDialog(null, mblogin + "�Դϴ�.");
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
			System.out.println("DB ��� ����!!");
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
		if (name == null || login == null || phone_number == null || name.isEmpty() || login.isEmpty() || phone_number.isEmpty()) {
			return FIND_NULL;
		}
		if (this.conn != null) {
			Login_data mb = selectOneMemberByLogin(login);
			if (mb != null) {
				int mbPhn = mb.getPhone_number();
				int Phn = Integer.parseInt(phone_number);
				if (mbPhn == Phn && mbPhn != 0) {
					String mbname = mb.getName();
					if (mbname != null && !mbname.isEmpty()) {
						if (mbname.equals(name)) {
							String setpassword = setPassword(8);
							boolean mb1 = changeBypass(setpassword, login, Phn, name);
							JOptionPane.showMessageDialog(null, setpassword + "�Դϴ�.");
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
			System.out.println("DB ��� ����!!");
		}
		return FIND_ERROR;
	}

	public static void main(String[] args) throws SQLException {
		DB_Connect2 mbMgr = new DB_Connect2();

		OracleDBUtil.endConnection();

	}

	public boolean insertNewMember(Login_data newlndt) {
		// TODO Auto-generated method stub
		return false;
	}
}
