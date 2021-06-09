package template.Application.controller.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SIgnUp_DB {
	static DB_Connect connect;

	// 회원 등록하기
	public boolean insertMember(String id, String pw, String name, int gender, String phone, String birth) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO MEMBER (MEMBER_ID,ID,PASSWORD,NAME,GENDER,PHONE_NUMBER,IS_MEMBER,BIRTHDAY) "
					+ "VALUES" + " (MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, 0, ? )";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setInt(4, gender);
				pstmt.setString(5, phone);
				pstmt.setString(6, birth);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("회원가입 성공");
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}
}
