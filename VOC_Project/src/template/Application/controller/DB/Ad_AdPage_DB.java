package template.Application.controller.DB;

import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.Data.Reservation_data;
import template.Application.controller.Data.Review_Data;

public class Ad_AdPage_DB {

	static DB_Connect connect;

	/* 관리자 - 회원 : 전체 회원 관리 */
	public static ArrayList<Login_data> selectAllMembers() {
		connect.beginConnection();
		if (connect.conn != null) {
			ArrayList<Login_data> uiList = new ArrayList<>();
			String sql = "select * from member ORDER BY MEMBER_ID desc";
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("BIRTHDAY");

					Login_data ui = new Login_data(rs.getInt("MEMBER_ID"), rs.getString("ID"), rs.getString("PASSWORD"),
							rs.getString("NAME"), rs.getInt("GENDER"), rs.getString("PHONE_NUMBER"),
							rs.getInt("IS_MEMBER"), rs.getString("BIRTHDAY"));

					uiList.add(ui);
				}
				System.out.println("회원 정보 조회 갯수 : => " + uiList.size() + "명");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return null;
	}

	/* 관리자 - 회원 : 회원 정보 수정 관리 */
	public static boolean UpdateAdminMemberInfo(int memberID, String name, String phn) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE MEMBER SET PHONE_NUMBER = ? ,  NAME = ?  WHERE MEMBER_ID = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, phn);
				pstmt.setString(2, name);
				pstmt.setInt(3, memberID);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 회원 : 탈퇴 회원 관리 */
	public static boolean updateMembertoNone(int memberID) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE MEMBER SET IS_MEMBER = 2  WHERE MEMBER_ID  = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setInt(1, memberID);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println(memberID + "회원 탈퇴 완료");
					return true;
				} else {
					System.out.println("회원 탈퇴 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 영화 : 영화 정보 전체 관리 */
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

	/* 관리자 - 영화 : 영화 정보 추가 관리 */
	public static boolean addNewMovie(String title, String genre, String director, int agegroup, String story,
			String gee, String opendate, String production, String imagefilename) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO movies (movies_id, title, genre, director, age_group, story, gee, open_date, production, image_file_name) "
					+ "values " + "(MOVIE_SEQ.nextval," + "'" + title + "', '" + genre + "', '" + director + "', "
					+ agegroup + ", '" + story + "', '" + gee + "', '" + opendate + "', '" + production + "', ' "
					+ imagefilename + "')";

			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);

				int r = pstmt.executeUpdate();
				if (r == 1) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 영화 : 영화 정보 수정 관리 */
	public static boolean UpdateMovieInfo(String title, String genre, String director, int agegroup, String story,
			String gee, String opendate, String production, String imagefilename, int movieid) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "update movies SET title = '" + title + "', genre = '" + genre + "', director = '" + director
					+ "', age_group = " + agegroup + ", story = '" + story + "', gee = '" + gee + "', open_date = '"
					+ opendate + "', production = '" + production + "'  ,image_file_name = '" + imagefilename
					+ "' where movies_id = " + movieid;

			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 영화 : 영화 정보 삭제 관리 */
	public static void deleteMovie(int movieID) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "delete movies where movies_id = " + movieID;
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
	}

	/* 관리자 - 공지사항 : 공지사항 정보 전체 관리 */
	public static ArrayList<Notice_data> selectAllNotice() {
		connect.beginConnection();
		if (connect.conn != null) {
			ArrayList<Notice_data> uiList = new ArrayList<>();
			String sql = "select * from NOTICE ORDER BY NOTICE_ID desc";
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("BIRTHDAY");
					Notice_data ui = new Notice_data(rs.getInt("NOTICE_ID"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getInt("VEIWCOUNT"), rs.getInt("MEMBER_ID"));
					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공! 공지사항갯수 => " + uiList.size());
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!!@");
		}
		connect.endConnection();
		return null;
	}

	/* 관리자 - 공지사항 : 공지사항 정보 추가 관리 */
	public static boolean addNotice(String title, String content) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO notice (notice_id,title,content,viewcount,member_id) VALUES (NOTICE_SEQ.nextval,"
					+ "'" + title + "', '" + content + "', 0 , " + 24 + ")";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 공지사항 : 공지사항 정보 수정 관리 */
	public static boolean updateNotice(int noticeID, String title, String content) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE NOTICE SET content = ?, title = ? WHERE notice_id = " + noticeID;
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, content);
				pstmt.setString(2, title);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("공지사항 수정 성공");
					return true;
				} else
					System.out.println("공지사항 수정 실패");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	/* 관리자 - 공지사항 : 공지사항 정보 삭제 관리 */
	public static void deleteNotice(int noticeID) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "delete notice where notice_id = " + noticeID;
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1)
					System.out.println("삭제");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
	}
	

	/* 관리자 - 예약 : 전체 조회 관리 */
	public static ArrayList<Reservation_data> AllReservation() {
		ArrayList<Reservation_data> uiList = new ArrayList<>();
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from RESERVATION ";
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int reservationid = rs.getInt("reservation_id");
					int reservaitonnumber = rs.getInt("reservation_id");
					Date reservationdate = rs.getDate("reservation_date");
					String seatnumber = rs.getString("seat_number");
					int cartype = rs.getInt("car_type");
					int paymentPrice = rs.getInt("payment_price");
					Date paymentdate = rs.getDate("payment_date");
					String optionname = rs.getString("option_name");
					int optionprice = rs.getInt("option_price");
					int memberid = rs.getInt("member_id");
					int MovieId = rs.getInt("MOVIE_ID");

					uiList.add(new Reservation_data(reservationid, reservaitonnumber, reservationdate, seatnumber,
							cartype, paymentPrice, paymentdate, optionname, optionprice, memberid, MovieId));
				}
				System.out.println("DBMgr: 연동 성공=> 예약 개수:" + uiList.size() + "개");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!~~~");
		}
		connect.endConnection();
		return null;
	}


	/* 관리자 - 리뷰 : 리뷰 정보 전체 관리 */
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
					contents.add(new Review_Data(reviewid, content, starscore, reviewdate, reservationid, movieid));
				}
				return contents;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return contents;

	}

	/* 관리자 - 리뷰 : 리뷰 정보 수정 관리 */
	public static boolean UpdateReview(int noticeid, String content) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE REVIEW SET CONTENT = ? WHERE REVIEW_ID = " + noticeid;
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, content);

				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("db 리뷰 수정");
					return true;
				} else {
					System.out.println("db 리뷰 수정 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

}
