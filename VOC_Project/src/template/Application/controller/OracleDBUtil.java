package template.Application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

// ���� DB ����/���� ��ƿ Ŭ����
public class OracleDBUtil {

	public static Connection conn = null; // DBMS ������ �����ϴ� ��� ���ذ�ü
	private static final String account = "VOCPRO"; // ��Ű����/������
	private static final String pw = "1234";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// IP �ּ�, port ��Ʈ 1521, SID ���񽺾��̵� xe
	// XE ���� ���� ����Ŭ ���� (127.0.0.1 �ּ� �����Ŀ� �ִ� ���� - �������ּ�)
	// = "jdbc:oracle:thin:@localhost:1521:orcl"; // ORCL ���

	// ���ä���� ��Ȱ�밡���ϰ� �Լ� conn getter
	public static Connection getConn() {
		if (conn != null)
			return conn;
		else {
			boolean c = beginConnection();
			return c ? conn : null;
		}
	}

	// DB�� �����ϱ� (�����ϱ� - ���ä�� �¾�)
	private static boolean beginConnection() {
//	public static boolean beginConnection() {
		try {
			// 1. ����Ŭ JDBC ������(����̹�) Ŭ���� '����' �ε�
			// Class.forName("oracle.jdbc.driver.racleDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. ����Ŭ DBMS ������ ��ſ����� ���� (���� ����)
//		Connection conn = 
			conn = DriverManager.getConnection(url, account, pw);
			System.out.println("DB ���� ����! " + new Date());
			// + new java.util.Date());
			// 3. �������� �����̸� null�� �ƴ� ���ᰴü�� ���ϵ�
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar�� ����ŬDB ����̹� �ε� ����!");
		} catch (SQLException e) {
			System.out.println("��� ���� ����!!! ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("java �Ϲ� ����!!!");
//			e.printStackTrace();
		}
		return false;
	}

	// DB���� ���������ϱ�
	public static boolean endConnection() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("DB ���� ����!!");
				return true;
			} catch (SQLException e) {
				System.out.println("DB ���� ����!!");
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Connection con = OracleDBUtil.getConn();
		OracleDBUtil.endConnection();
	}

}
