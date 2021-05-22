package template.Application.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DB_Connect {

	static Connection conn;
	private static final String account = "VOCPRO";
	private static final String pw = "1234";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static boolean beginConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, account, pw);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
				ism = "회원";
			} else {
				ism = "관리자";
			}
			
			if (gender == 1) {
				gen = "여";
			} else {
				gen = "남";
			}
			System.out.println(member_id + " " + id + " " + password + " " + name + " " + gen + " " + phone_number + " "
					+ birthday + " " + ism);
		}
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();

	}

	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) throws SQLException {

		beginConnection();
		select();
		endConnection();
	}

}
