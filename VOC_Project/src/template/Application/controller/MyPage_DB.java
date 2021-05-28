package template.Application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import template.Application.view.MyPage;
import template.Application.view.Notice;

public class MyPage_DB {

	static DB_Connect connect;
	static ArrayList<MyPage_Data> MyArr = new ArrayList<>();
	static MyPage Mypage;
	static MyPage_Data MypageDT;

	public static ArrayList<MyPage_Data> SelectMemberID(int memberID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id =  " + memberID;
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

					System.out.println(member_id + " " + id + " " + password + " " + name + " " + gender + " "
							+ phone_number + " " + birthday + " " + is_member);
					MyArr.add(
							new MyPage_Data(member_id, id, password, name, gender, phone_number, is_member, birthday));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return MyArr;
	}
	

	public boolean UpdateMemberInfo(int memberID, String name, String phoneNum, String password,String newPassword) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "update member set name = '" + name + "' and phone_number = '" + phoneNum + "' and password = '"
					+ newPassword + "'  where member_id =  " + memberID;
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("조회수 증가 성공");
					return true;
				} else
					System.out.println("조회수 증가 실패");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	public static void main(String[] args) {

		ArrayList<MyPage_Data> i = SelectMemberID(34);
		System.out.println(i);
	}
}
