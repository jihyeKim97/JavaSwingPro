package template.Application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.view.MyPage;

public class MyPage_DB {
		
	static DB_Connect connect;
	MyPage Mypage;
	MyPage_Data MypageDT;

	public static void mySelectMemberID () {
		DB_Connect connect = null;
		MyPage Mypage;
		MyPage_Data MypageDT;
		String ism = "";
		String gen = "";
		
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "SELECT * FROM member where member_id = ? ";
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int member_id = rs.getInt("member_id");
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String phone_number = rs.getString("phone_number");
					int is_member = rs.getInt("is_member");
					String birthday = rs.getString("birthday");
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
				if (connect != null)
					connect.endConnection();

				}catch (Exception e) {
					e.printStackTrace();
				}
		}

	}
		
	public static void main(String[] args) {
		
	}
	
}
