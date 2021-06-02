package template.Application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import template.Application.view.MyPage;

public class Mypage_DB {

	static DB_Connect connect;
	static MyPage Mypage;
	static Mypage_Member_data MypageDT;
	static Mypage_Reservation_data Myoage_reDT;
	static Mypage_Review_data Myoage_viDT;
	static ArrayList<Mypage_Member_data> MyArr = new ArrayList<>();
	static ArrayList<Mypage_Reservation_data> ReArr = new ArrayList<>();
	static ArrayList<Mypage_Review_data> ViArr = new ArrayList<>();

	public static ArrayList<Mypage_Member_data> SelectMemberID(int memberID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from member where member_id =  " + memberID;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					int member_id = rs.getInt("member_id");
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String phone_number = rs.getString("phone_number");
					int is_member = rs.getInt("is_member");
					String birthday = rs.getString("birthday");

					System.out.println(member_id + " " + id + " " + password + " " + name + " " + gender + " "
							+ phone_number + " " + birthday + " " + is_member);
					MyArr.add(new Mypage_Member_data(member_id, id, password, name, gender, phone_number, is_member,
							birthday));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return MyArr;
	}

	public static boolean UpdateMemberInfo(int memberID, String name, String phoneNum, String newPassword) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "update member set name = ? , phone_number = ? , password =  ? where member_id = ? ";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, phoneNum);
				pstmt.setString(3, newPassword);
				pstmt.setInt(4, memberID);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("회원 정보 갱신 성공");
					System.out.println(memberID + " " + newPassword + " " + name + " " + phoneNum + " ");
					return true;
				} else
					System.out.println("회원 정보 갱신 실패");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	public static ArrayList<Mypage_Reservation_data> SelectReservationID(int memberID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from reservation where member_id =  " + memberID;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					int reservation_id = rs.getInt("reservation_id");
					int reservation_number = rs.getInt("reservation_number");
					Date reservation_date = rs.getDate("reservation_date");
					String seat_number = rs.getString("seat_number");
					int car_type = rs.getInt("car_type");
					int payment_price = rs.getInt("payment_price");
					Date payment_date = rs.getDate("payment_date");
					String option_name = rs.getString("option_name");
					int option_price = rs.getInt("option_price");
					int member_id = rs.getInt("member_id");
					int movie_id = rs.getInt("movie_id");

					ReArr.add(new Mypage_Reservation_data(reservation_id, reservation_number, reservation_date,
							seat_number, car_type, payment_price, payment_date, option_name, option_price, member_id,
							movie_id));
				}
				return ReArr;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return ReArr;
	}

	public static String AlterMovieIDName(int moviesID) {
		String title = "";

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from movies where movies_id = " + moviesID;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int movies_id = rs.getInt("movies_id");
					title = rs.getString("title");
					return title;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return title;
	}

	public static ArrayList<Mypage_Review_data> SelectReviewID(int reservationID) {

		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "select * from review where reservation_id =  " + reservationID;
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					int review_id = rs.getInt("review_id");
					String content = rs.getString("content");
					int starScore = rs.getInt("star_score");
					Date review_date = rs.getDate("review_date");
					int reservation_id = rs.getInt("reservation_id");
					int movie_id = rs.getInt("movies_id");

					ViArr.add(new Mypage_Review_data(review_id, content, starScore, review_date, reservation_id,
							movie_id));
				}
				return ViArr;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return ViArr;
	}

	public static boolean InsertReviewID(String content, int star_score, int reservationID, int movies_id) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO REVIEW (REVIEW_ID,CONTENT,STAR_SCORE,REVIEW_DATE,RESERVATION_ID,MOVIES_ID) "
					+ "VALUES " + "(REVIEW_SEQ.nextval, ?,?,to_date(SYSDATE+1),?,? )";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, content);
				pstmt.setInt(2, star_score);
				pstmt.setInt(3, reservationID);
				pstmt.setInt(4, movies_id);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("리뷰 추가 완료");
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}

	public static void main(String[] args) {
//		ArrayList<Mypage_Review_data> i = SelectReviewD(1);
//		System.out.println(SelectReviewD(1).get(0).getMoviesID() );
//		System.out.println(i);
//		InsertReviewID();
//		InsertReviewID("좋아열", 5, SelectReservationID(34).get(0).getReservation_id(),
//				SelectReviewID(SelectReservationID(34).get(0).getReservation_id()).get(0).getMoviesID());
//		InsertReviewID(Myoage_viDT);
	}
}
