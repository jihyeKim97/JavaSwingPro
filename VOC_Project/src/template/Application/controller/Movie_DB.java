package template.Application.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Movie_DB {

	static DB_Connect connect;
	static Movie_Data Movie;
	static ArrayList<Movie_Data> MovieList = new ArrayList<>();
	static ArrayList<Integer> movieidlist = new ArrayList<>();
	
	public static void main(String[] args) {
	
	
		try {
			MovieList= notTodayMovie(21, 05, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < MovieList.size(); i++) {
			System.out.println(MovieList.get(i));
		}
	}
	
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
	
	public static ArrayList<Integer> getMovie(int year, int month, int day) {
		connect.beginConnection();
		// DB에서 정보 가져오기
		int MovieId = 0;
		if (connect.conn != null) {
			String sql = "SELECT * FROM movies WHERE schedule_date = '" + year + month + day + "'";
			System.out.println(sql);
		try {
			Statement st = connect.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int movieid = rs.getInt("movies_id");
				movieidlist.add(movieid);
		}
			return movieidlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		connect.endConnection();
		return movieidlist;
	
	}
	
	public static ArrayList<Movie_Data> notTodayMovie(int year, int month, int day) throws ParseException{
		
		String years = String.valueOf(year);
		String months = String.valueOf(month);
		String days = String.valueOf(day);
		
		String strDate = years+ "-" + months + "-" + days; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date;
		try {
			date = sdf.parse(strDate);
		connect.beginConnection();
		// DB에서 정보 가져오기
		if (connect.conn != null) {
			String sql = "select * from Movies";
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
				

				Movie_Data MD = new Movie_Data(moviesid, title, genre, director, agegroup, story, averagecsore, gee,
						openDate, production, imageFileName, scheduleDate, Scheduletime, runningTime);
				
		
				if ( !MD.getScheduledate().equals(date)) {
					MovieList.add(MD);
				}else
					;
			}
			connect.endConnection();
				}

				return MovieList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("오류");
		
		return MovieList;
	}

	


}


