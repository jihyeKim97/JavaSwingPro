package template.Application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import template.Application.view.MyPage;
import template.Application.view.Notice;

public class MyPage_DB {

	static ArrayList<MyPage_Data> MyArr = new ArrayList<>();
	static DB_Connect connect;
	MyPage Mypage;
	MyPage_Data MypageDT;
	static String ism = "";
	static String gen = "";

//	public static void select() throws SQLException {
//		Statement st = connect.conn.createStatement();
//		String sql = "select * from member";
//		ResultSet rs = st.executeQuery(sql);
//
//		while (rs.next()) {
//			int member_id = rs.getInt("member_id");
//			String id = rs.getString("id");
//			String password = rs.getString("password");
//			String name = rs.getString("name");
//			int gender = rs.getInt("gender");
//			String phone_number = rs.getString("phone_number");
//			int is_member = rs.getInt("is_member");
//			String birthday = rs.getString("birthday");
//
//			if (is_member == 0) {
//				ism = "회원";
//			} else {
//				ism = "관리자";
//			}
//
//			if (gender == 1) {
//				gen = "여";
//			} else {
//				gen = "남";
//			}
//			System.out.println(member_id + " " + id + " " + password + " " + name + " " + gen + " " + phone_number + " "
//					+ birthday + " " + ism);
//		}
//		if (rs != null)
//			rs.close();
//		if (st != null)
//			st.close();
//		if (connect.conn != null)
//			connect.conn.close();
//
//	}
	
	public static ArrayList<MyPage_Data> SelectMemberID(int memberID) {
		DB_Connect connect = null;
		MyPage Mypage;
		MyPage_Data MypageDT;

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setInt(1, memberID);
				ResultSet rs = pstmt.executeQuery(sql);
				if (rs.next()) {
					int member_id = rs.getInt("member_id");
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String phone_number = rs.getString("phone_number");
					int is_member = rs.getInt("is_member");
					String birthday = rs.getString("birthday");

					System.out.println(member_id + " " + id + " " + password + " " + name + " " + gen + " "
							+ phone_number + " " + birthday + " " + ism);
					MyArr.add(
							new MyPage_Data(member_id, id, password, name, gender, phone_number, is_member, birthday));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(MyArr.size());
		connect.endConnection();
		return MyArr;
	}

	public static void main(String[] args) throws SQLException {
		SelectMemberID(34);

	}
}
