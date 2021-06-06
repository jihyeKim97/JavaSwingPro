package template.Application.controller.DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Review_Data;
import template.Application.view.member.Notice;

public class Review_DB {

	static DB_Connect connect;
	static Review_Data review;
	
	public static void deleteReview(int reviewid) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "delete review where review_id = " + reviewid;
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("리뷰가 삭제되었습니다.");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("리뷰 삭제에 실패했습니다.");
			}
			
		}
			connect.endConnection();
	}
	
	
	
	public static ArrayList<Review_Data> AllReviewData() {
		ArrayList<Review_Data> contents = new ArrayList<>();
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "SELECT * FROM review";
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int reviewid = rs.getInt("review_id");
					String content = rs.getString("content");
					int starscore = rs.getInt("star_score");
					Date reviewdate = rs.getDate("review_date");
					int reservationid = rs.getInt("reservation_id");
					int movieid = rs.getInt("movies_id");
					contents.add(new Review_Data(reviewid,content,starscore,reviewdate,reservationid,movieid));
				}
				return contents;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return contents;
		
		
	}
	

	public static ArrayList<Review_Data> getReviewData(int movieId) {
		ArrayList<Review_Data> contents = new ArrayList<>();
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "SELECT * FROM review WHERE movies_id = " + movieId;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					String content = rs.getString("content");
					contents.add(new Review_Data(content));
				}
				return contents;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return contents;
	}

}
