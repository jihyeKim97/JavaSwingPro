package template.Application.controller.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				Name.add("F" + (i - 29));
		}
		return Name;
	}

	// 예약정보 저장하기
	public static boolean saveResevationData(int A, String shecduledate, String seatNumber, int carType,
			int paymentPrice, String optionName, int optionPrice, int memberID, int movieID) {
		connect.beginConnection();
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

	// 영화 예매된 자리 찾아오기
	public static ArrayList<String> selectedSeat(int movieid) {
		ArrayList<String> selectedSeat = new ArrayList<>();
		connect.beginConnection();
		String sql = "select * from reservation where movie_id = " + movieid;
		try {
			Statement stmt = connect.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
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
	

}
