package template.Application.controller;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class Movie_DB {

	static DB_Connect connect;
	static Movie_Data Movie;
	static ArrayList<Movie_Data> MovieList = new ArrayList<>();
	static ArrayList<Integer> movieidlist = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
				MovieList= TodayMovie(6, 2);
			} catch (SQLException e) {

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
	
	public static ArrayList<Movie_Data> notTodayMovie(int month, int day) throws SQLException{

		String years = "2021";
		String months ="";
		if ( month == 5)
			months = "05";
		else if ( month == 6 )
			months = "06";
		String days = String.valueOf(day);
		String Dday = years+months+days;
		
		Date date = null;
		date = transformDate(Dday);

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
				if ( !MD.getScheduledate().equals(date))
					MovieList.add(MD);
		
				}

				return MovieList;
	}
		connect.endConnection();
		return MovieList;
	
	}

	public static ArrayList<Movie_Data> TodayMovie(int month, int day) throws SQLException {

		String years = "2021";
		String months ="";
		if ( month == 5)
			months = "05";
		else if ( month == 6 )
			months = "06";
		String days = String.valueOf(day);
		String Dday = years+months+days;
		
		Date date = null;
		date = transformDate(Dday);

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
				if ( MD.getScheduledate().equals(date))
					MovieList.add(MD);
		
				}

				return MovieList;
	}
		connect.endConnection();
		return MovieList;
	
	}
	public static Date transformDate(String date)
    {
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
        
        // Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
        
        java.util.Date tempDate = null;
        
        try {
            // 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
            tempDate = beforeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
        String transDate = afterFormat.format(tempDate);
        
        // 반환된 String 값을 Date로 변경한다.
        Date d = Date.valueOf(transDate);
        
        return d;
    }
}






