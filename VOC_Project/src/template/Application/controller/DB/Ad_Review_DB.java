package template.Application.controller.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Ad_Review_Data;
import template.Application.controller.Data.Review_Data;

public class Ad_Review_DB {

	static ArrayList<Ad_Review_Data> ReviewArr = new ArrayList<>();

	static DB_Connect DB;
	Ad_Review_Data ad_Review;

	public static boolean changePK(int reviewid) {
		DB.beginConnection();
		if (DB.conn != null) {
			String sql = "UPDATE review SET reservation_id = null, movies_id = null WHERE review_id = " + reviewid;
			try {
				PreparedStatement pstmt = DB.conn.prepareStatement(sql);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("PK제거됨");
					return true;
				} else {
					System.out.println("제거 실패");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DB.endConnection();
		return false;
	}

	public static void deleteReview(int reviewid) {
		DB.beginConnection();
		if (DB.conn != null) {
			String sql = "delete review where review_id = " + reviewid;
			try {
				Statement stmt = DB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("리뷰가 삭제되었습니다.");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("리뷰 삭제에 실패했습니다.");
			}

		}
		DB.endConnection();
	}

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

	

}
