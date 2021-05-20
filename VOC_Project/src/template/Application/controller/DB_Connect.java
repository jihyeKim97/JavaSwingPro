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
			System.out.println("DB 접속 성공! " + new Date());
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar의 오라클DB 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("통신 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("java 일반 예외");
		}
		return false;
	}

	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("DB 종료 성공");
				return true;
			} catch (SQLException e) {
				System.out.println("DB 종료 실패");
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		beginConnection(); // 접속
		endConnection(); // 해제
	}

}
