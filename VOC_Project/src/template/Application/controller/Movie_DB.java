package template.Application.controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Movie_DB {

	static DB_Connect connect;
	static Movie_Data Movie;
	static ArrayList<Movie_Data> MovieList = new ArrayList<>();
	
//	public static void main(String[] args) {
	
//		int i = 0;
//		 i  = getMovieIDFromImage("./template/Reference/images/컨저링.jpg");
//		 System.out.println(i);
//		MovieList = getMovieData();
//		System.out.println(MovieList.get(0));
//		System.out.println(MovieList.get(1));
//		System.out.println(MovieList.get(2));
//		System.out.println(MovieList.get(3));
//
//	}
	
	public static ArrayList<Movie_Data> getMovieData(){
		connect.beginConnection();
		// DB에서 정보 가져오기
		if (connect.conn != null) {
			String sql = "select * from Movies";
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int moviesid = rs.getInt("movies_id");
					String title = rs.getString("title");
					String genre = rs.getString("genre");
					String director = rs.getString("director");
					int agegroup = rs.getInt("age_group");
					String story = rs.getString("story");
					int averagecsore = rs.getInt("average_score");
					String gee = rs.getString("gee");
					Date openDate = rs.getDate("open_date");
					String production = rs.getString("production");
					String imageFileName = rs.getString("image_file_name");
					Date scheduleDate = rs.getDate("schedule_date");
					int Scheduletime = rs.getInt("schedule_time");
					String runningTime = rs.getString("running_time");
					

					MovieList.add(new Movie_Data(moviesid, title, genre, director, agegroup, story, averagecsore, gee,
							openDate, production, imageFileName, scheduleDate, Scheduletime, runningTime));
				}

				return MovieList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("오류");
		}
		connect.endConnection();
		return MovieList;
	}
	
	public static int getMovieIDFromImage(String ImageFile) {
		connect.beginConnection();
		// DB에서 정보 가져오기
		int MovieId = 0;
		if (connect.conn != null) {
			String sql = "SELECT movies_id FROM movies WHERE image_file_name = '" + ImageFile + "'";
			System.out.println(sql);
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
				int movieid = rs.getInt("movies_id");
				
				
				MovieId = movieid;
				}
				return MovieId;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB접속 오류");
			}
			System.out.println("오류");

		}
		connect.endConnection();
		return MovieId;
		
	}
	
	public static int getMovieInformationFromImage(int id) {
		connect.beginConnection();
		// DB에서 정보 가져오기
		int MovieId = 0;
		if (connect.conn != null) {
			String sql = "SELECT * FROM movies WHERE movies_id = '" + id + "'";
			System.out.println(sql);
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
				int movieid = rs.getInt("movies_id");
				
				
				MovieId = movieid;
				}
				return MovieId;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB접속 오류");
			}


		}
		connect.endConnection();
		return MovieId;
		
	}
		
	
	
}


