package template.Application.controller.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Reservation_DB {

	static ArrayList<String> Name;
	static DB_Connect connect;
	static Reservation_DB RD;

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
