package template.Application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("HI~~~~^^");
				return true;
			} catch (SQLException e) {
				System.out.println("DB catch error");
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		beginConnection(); 
		endConnection(); 
	}

}
