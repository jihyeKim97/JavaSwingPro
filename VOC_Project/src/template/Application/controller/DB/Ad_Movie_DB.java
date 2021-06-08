package template.Application.controller.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import template.Application.controller.Data.Movie_Data;

public class Ad_Movie_DB {

	static DB_Connect DB;
	static Movie_Data MD;

	public boolean addNewMovie(String title, String genre, String director, int agegroup, String story, String gee,
			String opendate, String production, String imagefilename) {
		if (DB.conn != null) {
			String sql = "INSERT INTO movies(title, genre, director, age_group, story, gee, open_date, production, image_file_name) values (MOVIE_SEQ.nextval,"
					+ "'" + title + "', '" + genre + "', '" + director + "', " + agegroup + ", '" + story + "', '" + gee + "', '"
					+ opendate + "', '" + production + "', ' " + imagefilename + "')";
			try {
				PreparedStatement pstmt = DB.conn.prepareStatement(sql);

				int r = pstmt.executeUpdate();
				if(r == 1) {
					return true;
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		DB.endConnection();
		return false;
	}
		
}
