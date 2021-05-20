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
			System.out.println("ojdbc.jar error");
		} catch (SQLException e) {
			System.out.println("no.one");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("on.two");
		}
		return false;
	}

	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("DB try error");
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
