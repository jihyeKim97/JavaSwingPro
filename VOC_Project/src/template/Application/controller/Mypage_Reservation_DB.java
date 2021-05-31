package template.Application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import template.Application.view.MyPage;

public class Mypage_Reservation_DB {

	static DB_Connect connect;
	static MyPage Mypage;
	static Mypage_Reservation_data Myoage_reDT;
	static ArrayList<Mypage_Reservation_data> ReArr = new ArrayList<>();

	public static ArrayList<Mypage_Reservation_data> SelectReservationID(int memberID) {
		connect.beginConnection();
		ResultSet rs;
		Statement st;
		if (connect.conn != null) {
			String sql = "select * from reservation where member_id =  " + memberID;
			try {
				st = connect.conn.createStatement();
				rs = st.executeQuery(sql);
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

	public static void main(String[] args) {
		ArrayList<Mypage_Reservation_data> i = SelectReservationID(34);
		System.out.println(i);
//		System.out.println(AlterMovieIDName(27));

	}
}
