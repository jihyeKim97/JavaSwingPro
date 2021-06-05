package template.Application.controller.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Ad_Review_Data;

public class Ad_Review_DB {

	static ArrayList<Ad_Review_Data> ReviewArr = new ArrayList<>();

	static DB_Connect DB;
	Ad_Review_Data ad_Review;

	public static ArrayList<Ad_Review_Data> GetReview(int ReviewiD) {
		DB.beginConnection();
		if (DB.conn != null) {
			String sql = "SELECT * FROM review where REVIEW_id = " + ReviewiD;
			try {
				Statement stmt = DB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {

					String content = rs.getString("content");

					ReviewArr.add(new Ad_Review_Data(content));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DB.endConnection();
		return ReviewArr;
	}

	public boolean changeReview(int noticeid, String content) {
		DB.beginConnection();
		if (DB.conn != null) {
			String sql = "UPDATE REVIEW SET CONTENT = ? WHERE REVIEW_ID = " + noticeid;
			try {
				PreparedStatement pstmt = DB.conn.prepareStatement(sql);
				pstmt.setString(1, content);

				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("db 리뷰 수정");
					return true;
				} else {
					System.out.println("db 리뷰 수정 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DB.endConnection();
		return false;
	}

}
