package template.Application.controller.DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import template.Application.controller.Data.Movie_Data;

public class Movie_DB {

	static DB_Connect connect;
	static Movie_Data Movie;
	static ArrayList<Movie_Data> MovieList = new ArrayList<>();
	static ArrayList<Integer> movieidlist = new ArrayList<>();

	public static ArrayList<Movie_Data> getMovieData() {
		ArrayList<Movie_Data> MovieList = new ArrayList<>();
		connect.beginConnection();
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
		int MovieId = 0;
		if (connect.conn != null) {
			String sql = "SELECT movies_id FROM movies WHERE image_file_name = '" + ImageFile + "'";
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
		int MovieId = 0;
		if (connect.conn != null) {
			String sql = "SELECT * FROM movies WHERE movies_id = '" + id + "'";
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

	public static Movie_Data getMovieInformationFromMovieId(int id) {
		connect.beginConnection();
		Movie_Data MD = new Movie_Data();
		if (connect.conn != null) {
			String sql = "SELECT * FROM movies WHERE movies_id = " + id;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int movieid = rs.getInt("movies_id");
					String movietitle = rs.getString("title");
					String imgfilename = rs.getString("image_file_name");

					MD = new Movie_Data(movieid, movietitle, imgfilename);
				}
				return MD;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB접속 오류");
			}

		}
		connect.endConnection();
		return MD;

	}

	public static ArrayList<Integer> getMovie(int year, int month, int day) {
		connect.beginConnection();
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

	public static ArrayList<Movie_Data> notTodayMovie(int month, int day) throws SQLException {
		ArrayList<Movie_Data> MovieList = new ArrayList<>();
		String years = "2021";
		String months = "";
		if (month == 5)
			months = "05";
		else if (month == 6)
			months = "06";
		String days = String.valueOf(day);
		String Dday = years + months + days;

		Date date = null;
		date = transformDate(Dday);

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from Movies";
			Statement st = connect.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int moviesid = rs.getInt("movies_id");
				String imageFileName = rs.getString("image_file_name");
				Date scheduleDate = rs.getDate("schedule_date");

				Movie_Data MD = new Movie_Data(moviesid, imageFileName, scheduleDate);
				if (!MD.getScheduledate().equals(date)) {
					MovieList.add(MD);
				}
			}

			return MovieList;
		}
		connect.endConnection();
		return MovieList;

	}

	public static ArrayList<Movie_Data> TodayMovie(int month, int day) throws SQLException {
		ArrayList<Movie_Data> MovieList = new ArrayList<>();
		String years = "2021";
		String months = "";
		if (month == 5)
			months = "05";
		else if (month == 6)
			months = "06";
		String days = String.valueOf(day);
		String Dday = years + months + days;

		Date date = null;
		date = transformDate(Dday);

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from Movies";
			Statement st = connect.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int moviesid = rs.getInt("movies_id");
				String imageFileName = rs.getString("image_file_name");
				Date scheduleDate = rs.getDate("schedule_date");

				Movie_Data MD = new Movie_Data(moviesid, imageFileName, scheduleDate);
				if (MD.getScheduledate().equals(date))
					MovieList.add(MD);

			}

			return MovieList;
		}
		connect.endConnection();
		return MovieList;

	}

	public static Date transformDate(String date) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date tempDate = null;
		try {
			tempDate = beforeFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String transDate = afterFormat.format(tempDate);
		Date d = Date.valueOf(transDate);
		return d;
	}
}
