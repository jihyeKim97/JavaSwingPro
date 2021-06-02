package template.Application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ad_Film_DB {
	static DB_Connect DB;
	static Connection conn;
	
	
	
	public Ad_Film_DB() {
		this.conn = DB.getConn();
	}
	
	public Ad_Film_Data selectMovie(String mvposter) {
		if (this.conn != null) {

			String sql = "select * from movies where image_file_name = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mvposter);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					Ad_Film_Data mv = new Ad_Film_Data(rs.getString("title"), rs.getString("genre"),rs.getString("director"), rs.getInt("age_group"),
							rs.getString("story"), rs.getInt("average_score"), rs.getString("gee"),rs.getDate("open_date"),
							rs.getString("production"),rs.getDate("schedule_date"),rs.getInt("schedule_time"),rs.getString("running_time"));
					return mv;
				} else {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러");
		}
		return null;
	}
}
