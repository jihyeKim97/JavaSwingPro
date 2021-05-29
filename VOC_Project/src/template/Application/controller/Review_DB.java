package template.Application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.view.Notice;

public class Review_DB {

	static DB_Connect connect;
	static Review_Data review;
	static ArrayList<Review_Data> contents;
	
	public static ArrayList<Review_Data> getReviewData(int movieId){
		contents = new ArrayList<>();
		connect.beginConnection();
		// DB에서 정보 가져오기
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
