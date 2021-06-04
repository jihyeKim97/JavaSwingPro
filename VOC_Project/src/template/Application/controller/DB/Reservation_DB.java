package template.Application.controller.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Movie_Data;

public class Reservation_DB {
	


	static ArrayList<String> Name;
	static DB_Connect connect;
	Reservation_DB RD;
	
	public static ArrayList<String> ButtonName(){
		Name = new ArrayList<>();
			for (int i = 0; i < 36; i++) {
				if ( i< 6)
					Name.add("A"+(i+1));
				else if ( i < 12)
					Name.add("B"+(i-5));
				else if ( i < 18)
					Name.add("C"+(i-11));
				else if ( i < 24)
					Name.add("D"+(i-17));
				else if ( i < 30)
					Name.add("E"+(i-23));
				else
					Name.add("D"+(i-29));
			}
		return Name;
	}
	
	
	public static boolean saveResevationData(java.util.Date date, String seatNumber,
									int carType, int paymentPrice, java.util.Date date2, String optionName, int optionPrice, int memberID,int movieID) {
		String a = "";
		int A = 0;
		connect.beginConnection();
		for (int i = 0; i < 9; i++) {
			a += "" + (int)(Math.random()*10);
		}
		System.out.println(a);
		A = Integer.parseInt(a);
		// DB에서 정보 가져오기
		if (connect.conn != null) {
			String sql = "INSERT INTO VOCPRO.RESERVATION (RESERVATION_ID,RESERVATION_NUMBER,RESERVATION_DATE,SEAT_NUMBER,CAR_TYPE,PAYMENT_PRICE,PAYMENT_DATE,OPTION_NAME,OPTION_PRICE,MEMBER_ID,MOVIE_ID)"+ 
					"values (RESERVATION_SEQ.nextval, " + A + ", " + date + ", '" + seatNumber + "', " + carType + ", " + date2 + ", '"
					 + optionName + "', " + optionPrice + ", " + memberID + " , 61)";
//					""
//					+ "INSERT INTO reservaiton  value(RESERVATION_SEQ.nextval, "+ A +", '" + date + "', '" 
//							+ seatNumber + "'," + carType + ", " + paymentPrice + ",'" + date2 + "', '" + optionName + "', " 
//							+ optionPrice + "," + memberID +"," + movieID + ")";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("예약 성공");
					return true;
				}else {
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
	
}
