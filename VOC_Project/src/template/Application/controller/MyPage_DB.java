package template.Application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import template.Application.view.MyPage;
import template.Application.view.Notice;

public class MyPage_DB {

	static ArrayList<MyPage_Data> MyArr;
	static DB_Connect connect;
	MyPage Mypage;
	MyPage_Data MypageDT;
	static String ism = "";
	static String gen = "";

	public static ArrayList<MyPage_Data> SelectMemberID(int memberID) {
		ArrayList<MyPage_Data> MyArr = new ArrayList<>();
		DB_Connect connect = null;
		MyPage Mypage;
		MyPage_Data MypageDT;

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id = ?";
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
	
	public static void main(String[] args) {
		SelectMemberID(34);
		for (int i = 0; i < MyArr.size(); i++) {
			System.out.println(MyArr.get(i));
		}
		
	}
}
