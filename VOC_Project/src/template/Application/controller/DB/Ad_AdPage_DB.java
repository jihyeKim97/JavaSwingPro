package template.Application.controller.DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.Data.Reservation_data;
import template.Application.controller.Data.Review_Data;

public class Ad_AdPage_DB {
	static DB_Connect connect;
	static Connection conn;

	public Ad_AdPage_DB() {
		this.conn = connect.getConn();
	}

//	
//	   public  ArrayList<Notice_data> showAllNotice() {
//		      if( connect.conn != null ) {
//		         ArrayList<Notice_data> uiList = new ArrayList<>();
//		         String sql = "select * from NOTICE ORDER BY NOTICE_ID desc";
//		         try {
//		            Statement stmt =  connect.conn.createStatement();
//		            ResultSet rs = stmt.executeQuery(sql);
//		            while( rs.next() ) {   
//		               int mbid= rs.getInt("MEMBER_ID");
//
//		               Notice_data ui 
//		            = new Notice_data(
//		                     rs.getInt("NOTICE_ID"), 
//		                     rs.getString("TITLE"),
//		                     rs.getString("CONTENT"),
//		                     rs.getInt("VIEWCOUNT"),
//		                     rs.getInt("MEMBER_ID"));
//		               
//		            uiList.add(ui);
//		            }
//		            System.out.println("DBMgr: 연동 성공! 공지사항갯수 => " + uiList.size());
//		            return uiList;
//		         } catch (SQLException e) {
//		            e.printStackTrace();
//		         }         
//		      } else {
//		         System.out.println("DB error!!!@");
//		      }
//		      
//		      return null;
//		   }
		
//	   public boolean deleteNotice(int is_member, int member_id) {
//			connect.beginConnection();
//			if (this.conn != null) {
//				String sql = "update member set is_member = '2'  where member_id = ? ";
//				try {
//					PreparedStatement pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, is_member);
//					int rs = pstmt.executeUpdate();
//					if (rs == 1) {
//						System.out.println("공지사항 삭제 성공" );
//						return true;
//					} else
//						System.out.println("공지사항 삭제 실패!");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			connect.endConnection();
//			return false;
//		}

	
	public static boolean deleteNotice(int NOTICE_ID, String TITLE, String CONTENT, int VIEWCOUNT, int MEMBER_ID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "update notice set NOTICE_ID = 'null' , TITLE = 'null' , CONTENT =  'null', VIEWCOUNT = 'null', MEMBER_ID = 'null' where member_id = ? ";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setInt(1, NOTICE_ID);
				pstmt.setString(2, TITLE);
				pstmt.setString(3, CONTENT);
				pstmt.setInt(4, VIEWCOUNT);
				pstmt.setInt(5, MEMBER_ID);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("공지사항 null로 갱신 성공");
					System.out.println(NOTICE_ID + " " + TITLE + " " + CONTENT + " " + VIEWCOUNT +
							" " + MEMBER_ID + " ");
					return true;
				} else
					System.out.println("공지사항 null로 갱신 실패");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}
	
	
	public boolean updateMembertoNone(int MEMBER_ID) {
		connect.beginConnection();
		if (this.conn != null) {
			String sql = "update member set IS_MEMBER = '2'  where MEMBER_ID = ? ";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, MEMBER_ID);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("멤버 탈퇴 성공" + MEMBER_ID + "");
					return true;
				} else {
					System.out.println("멤버 탈퇴 실패!");
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

//

	public ArrayList<Login_data> selectAllMembers() {
		if (this.conn != null) {
			ArrayList<Login_data> uiList = new ArrayList<>();
			String sql = "select * from member ORDER BY MEMBER_ID desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("BIRTHDAY");

					Login_data ui = new Login_data(rs.getInt("MEMBER_ID"), rs.getString("ID"), rs.getString("PASSWORD"),
							rs.getString("NAME"), rs.getInt("GENDER"), rs.getString("PHONE_NUMBER"),
							rs.getInt("IS_MEMBER"), rs.getString("BIRTHDAY"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동성공 총 회원수: => " + uiList.size() + "명");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!!@");
		}

		return null;
	}

	public ArrayList<Movie_Data> showAllMovie() {
		if (this.conn != null) {
			ArrayList<Movie_Data> uiList = new ArrayList<>();
			String sql = "select * from MOVIES ORDER BY MOVIES_ID desc";
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String mvRuntime = rs.getString("RUNNING_TIME");

					Movie_Data ui 
				= new Movie_Data(
							rs.getInt("MOVIES_ID"), 
							rs.getString("TITLE"),
							rs.getString("GENRE"),
							rs.getString("DIRECTOR"),
							rs.getInt("AGE_GROUP"),
							rs.getString("STORY"),
							rs.getInt("AVERAGE_SCORE"),
							rs.getString("GEE"),
							rs.getDate("OPEN_DATE"),
							rs.getString("PRODUCTION"),
							rs.getString("IMAGE_FILE_NAME"),
							rs.getDate("SCHEDULE_DATE"),
							rs.getInt("SCHEDULE_TIME"),
							rs.getString("RUNNING_TIME"));

				uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공=> 영화 개수:" + uiList.size() + "개");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!~~~");
		}

		return null;
	}

	public ArrayList<Review_Data> showAllReview() {
		if (this.conn != null) {
			ArrayList<Review_Data> uiList = new ArrayList<>();
			String sql = "select * from REVIEW ORDER BY REVIEW_ID desc";
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int rvMovieid = rs.getInt("RESERVATION_ID");

					Review_Data ui = new Review_Data(rs.getInt("REVIEW_ID"), rs.getString("CONTENT"),
							rs.getInt("STAR_SCORE"), rs.getDate("REVIEW_DATE"), rs.getInt("RESERVATION_ID"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공=> 리뷰 개수:" + uiList.size() + "개");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!~~~");
		}

		return null;
	}

	public ArrayList<Reservation_data> showAllReservation() {
		if (this.conn != null) {
			ArrayList<Reservation_data> uiList = new ArrayList<>();
			String sql = "select * from RESERVATION ORDER BY RESERVATION_ID desc";
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int rsMovieId = rs.getInt("MOVIE_ID");

					Reservation_data ui = new Reservation_data(rs.getInt("RESERVATION_ID"),
							rs.getInt("RESERVATION_NUMBER"), rs.getDate("RESERVATION_DATE"),
							rs.getString("SEAT_NUMBER"), rs.getInt("CAR_TYPE"), rs.getInt("PAYMENT_PRICE"),
							rs.getDate("PAYMENT_DATE"), rs.getString("OPTION_NAME"), rs.getInt("OPTION_PRICE"),
							rs.getInt("MEMBER_ID"), rs.getInt("MOVIE_ID"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공=> 예약 개수:" + uiList.size() + "개");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!~~~");
		}

		return null;
	}

	public ArrayList<Notice_data> showAllNotice() {
		if (this.conn != null) {
			ArrayList<Notice_data> uiList = new ArrayList<>();
			String sql = "select * from NOTICE ORDER BY NOTICE_ID desc";
			try {
				Statement stmt = this.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int noticeMemberId = rs.getInt("MEMBER_ID");

					Notice_data ui = new Notice_data(rs.getInt("NOTICE_ID"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getInt("VIEWCOUNT"), rs.getInt("MEMBER_ID"));

					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공=> 공지사항 개수:" + uiList.size() + "개");
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!~~~");
		}

		return null;
	}

	public static void main(String[] args) throws SQLException {
		// sAdminPage_DB mbMgr = new AdminPage_DB();

		connect.endConnection();
	}

}
