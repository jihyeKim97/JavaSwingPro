package template.Application.controller.DB;

import java.sql.Date;
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
	
	
	public static ArrayList<Reservation_DB> saveResevationData(Date reservationDate, String seatNumber,
									int carType, int paymentPrice, Date paymentDate, String optionName, int optionPrice, int memberID,int movieID) {
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
			String sql = "INSERT INTO reservaiton  value(RESERVATION_SEQ.nextval, "+ A +", '" + reservationDate + "', '" 
							+ seatNumber + "'," + carType + ", " + paymentPrice + ",'" + paymentDate + "', '" + optionName + "', " 
							+ optionPrice + "," + memberID +"," + movieID + ")";
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
				
				}

				return null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("오류");
		}
		connect.endConnection();
		return null;
	}
	
}
