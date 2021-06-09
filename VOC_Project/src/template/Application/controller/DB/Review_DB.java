package template.Application.controller.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Review_Data;

public class Review_DB {

	static DB_Connect connect;
	static Review_Data review;

	// 무비ID로 영화 한개의 리뷰만 가져오기
	public static ArrayList<Review_Data> getReviewData(int movieId) {
		ArrayList<Review_Data> contents = new ArrayList<>();
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "SELECT * FROM review WHERE movies_id = " + movieId;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int reviewid = rs.getInt("review_id");
					String content = rs.getString("content");
					Date date = rs.getDate("review_date");

					contents.add(new Review_Data(reviewid, content, date));
				}
				return contents;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return contents;
	}

	// 영화ID로 리뷰ID만 가져오기
	public static ArrayList<Integer> getreviewID(int movieId) {
		ArrayList<Integer> user = new ArrayList<>();
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from reservation where movie_id =" + movieId;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int memberid = rs.getInt("member_id");

					user.add(memberid);
				}
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return user;
	}

	// 영화ID로 회원 멤버ID 가져오기
	public static String getid(int memberid) {
		String A = null;
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id =" + memberid;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					String ID = rs.getString("id");
					A = ID;
				}
				return A;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return A;

	}

}
