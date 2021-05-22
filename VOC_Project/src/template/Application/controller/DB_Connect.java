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
			System.out.println("DB connect success" + new Date());
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar Database driver loading failure");
		} catch (SQLException e) {
			System.out.println("Database connection failure");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unkonwn error");
		}
		return false;
	}

	public static void select() throws SQLException {
		Statement st = conn.createStatement();
		String sql = "select * from member";
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			int member_id = rs.getInt("member_id");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			int gender = rs.getInt("gender");
			int phone_number = rs.getInt("phone_number");
			int is_member = rs.getInt("is_member");
			Date birthday = rs.getDate("birthday");

			System.out.println(member_id);
			System.out.println(id);
			System.out.println(password);
			System.out.println(name);
			System.out.println(gender);
			System.out.println(phone_number);
			System.out.println(is_member);
			System.out.println(birthday);
			System.out.println("-----------------");
		}
		if (rs != null)rs.close();
		if (st != null)st.close();
		if (conn != null)conn.close();

	}

	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("end Connection.");
				return true;
			} catch (SQLException e) {
				System.out.println("DB catch error");
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
