package template.Application.controller.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {

	public static Connection conn;
	private static final String account = "VOCPRO";
	private static final String pw = "1234";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConn() {
		if( conn != null ) return conn;
		else {
			boolean c = beginConnection();
			return c ? conn : null;
		}
	}

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
		endConnection();
	}




}
