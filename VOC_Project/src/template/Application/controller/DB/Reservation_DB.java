package template.Application.controller.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import template.Application.controller.Data.Reservation_data;

public class Reservation_DB {

	static ArrayList<String> Name;
	static DB_Connect connect;
	static Reservation_DB RD;
	static ArrayList<Reservation_data> uiList = new ArrayList<>();

	public static ArrayList<String> ButtonName() {
		Name = new ArrayList<>();
		for (int i = 0; i < 36; i++) {
			if (i < 6)
				Name.add("A" + (i + 1));
			else if (i < 12)
				Name.add("B" + (i - 5));
			else if (i < 18)
				Name.add("C" + (i - 11));
			else if (i < 24)
				Name.add("D" + (i - 17));
			else if (i < 30)
				Name.add("E" + (i - 23));
			else
				Name.add("D" + (i - 29));
		}
		return Name;
	}

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

	public static boolean saveResevationData(int A, String shecduledate, String seatNumber, int carType,
			int paymentPrice, String optionName, int optionPrice, int memberID, int movieID) {
		connect.beginConnection();
		// DB에서 정보 가져오기
		String sql = "INSERT INTO VOCPRO.RESERVATION (RESERVATION_ID,RESERVATION_NUMBER,RESERVATION_DATE,SEAT_NUMBER,CAR_TYPE,PAYMENT_PRICE,PAYMENT_DATE,OPTION_NAME,OPTION_PRICE,MEMBER_ID,MOVIE_ID)"
				+ "VALUES (RESERVATION_SEQ.nextval, " + A + ", '" + shecduledate + "', '" + seatNumber + "', " + carType
				+ ", " + paymentPrice + ", SYSDATE, '" + optionName + "', " + optionPrice + ", " + memberID + " , "
				+ movieID + ")";
		if (connect.conn != null) {
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("예약 성공");
					return true;
				} else {
					System.out.println("예약 실패");
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("오류");
		}
		connect.endConnection();
		return false;
	}

	public static ArrayList<String> selectedSeat(int movieid){
		ArrayList<String> selectedSeat = new ArrayList<>(); 
		connect.beginConnection();
		String sql = "select * from reservation where movie_id = " + movieid;
		try {
			Statement stmt = connect.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String movieseat = rs.getString("seat_number");
				selectedSeat.add(movieseat);
			}
			return selectedSeat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connect.endConnection();
		return selectedSeat;
	}
	
	public static Date StringtoDate(String date) {
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
