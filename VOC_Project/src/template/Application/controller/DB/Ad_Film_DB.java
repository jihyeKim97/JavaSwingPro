package template.Application.controller.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import template.Application.controller.Data.Ad_Film_Data;
import template.Application.controller.Data.Ad_Notice_data;
import template.Application.controller.Data.Notice_data;

public class Ad_Film_DB {
	static ArrayList<Ad_Film_Data> FilmArr = new ArrayList<>();
	static DB_Connect DB;
	static Connection conn;
	Ad_Film_Data ad_film;

	public Ad_Film_DB() {
		this.conn = DB.getConn();
	}

	public static ArrayList<Ad_Film_Data> GetFilm(int movieid) {
		if (conn != null) {
			String sql = "SELECT * FROM movies where MOVIES_id = " + movieid;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String title = rs.getString("title");
					String genre = rs.getString("genre");
					String director = rs.getString("director");
					String age_group = rs.getString("age_group");
					String story = rs.getString("story");
					String average_score = rs.getString("average_score");
					String gee = rs.getString("gee");
					String open_date = rs.getString("open_date");
					String production = rs.getString("production");
					String schedule_date = rs.getString("schedule_date");
					String image_file_name = rs.getString("IMAGE_FILE_NAME");
					String running_time = rs.getString("running_time");
					
					FilmArr.add(new Ad_Film_Data(title, genre, director, age_group, story, average_score, gee, open_date, production, schedule_date,image_file_name,running_time));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return FilmArr;
	}
	
	
	public boolean changeFilm(int movieid,String title, String genre, String director, String age_group,
			String story, String average_score, String gee, String open_date, String production, String schedule_date,
			String image_file_name, String running_time) {
		if (this.conn != null) {
			String sql = "UPDATE MOVIES SET TITLE = ? ,GENRE = ?, DIRECTOR = ?, AGE_GROUP = ?, STORY = ?,"
					+ "AVERAGE_SCORE = ?, GEE = ?, OPEN_DATE = ?, PRODUCTION = ?, SCHEDULE_DATE = ?, "
					+ "IMAGE_FILE_NAME = ?, RUNNING_TIME = ? WHERE MOVIES_ID = "+movieid;
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, genre);
				pstmt.setString(3, director);
				pstmt.setString(4, age_group);
				pstmt.setString(5, story);
				pstmt.setString(6, average_score);
				pstmt.setString(7, gee);
				pstmt.setString(8, open_date);
				pstmt.setString(9, production);
				pstmt.setString(10, schedule_date);
				pstmt.setString(11, image_file_name);
				pstmt.setString(12, running_time);
			
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("db 영화 수정");
					return true;
				} else {
					System.out.println("db 영화 수정 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public  boolean  insertNewMovie(Ad_Film_Data ui) {
		
		if (this.conn != null && ui != null) {
			String sql 
					= "INSERT INTO movies(mo_id,title,content,viewcount,member_id) VALUES (MEMBER_SEQ.nextval,"
							+"'"+ ui.getTitle() + "', '"
							+ ui.getGenre() + "', '" + "0" + "', '" + 24 + "')";
			System.out.println(sql);
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("DBMgr: 공지사항 등록 성공! " + ui);
					return true;
				} else {
					System.out.println("DBMgr: 공지사항 등록 실패! " + ui);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		return false;
}

}
