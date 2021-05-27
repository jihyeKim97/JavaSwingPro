package template.Application.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.view.Notice;

public class Notice_DB {
	static ArrayList<Notice_data> NoticeArr = new ArrayList<>();
		
//		public static void main(String[] args) {
//			takeNoticetitle();
//			for (int i = 0; i < NoticeArr.size(); i++) {
//				System.out.println(NoticeArr.get(i));
//			}
//			
//		}
		
	DB_Connect connect;
	Notice NM;
	Notice_data Notice;

	public static ArrayList<Notice_data> takeNoticetitle() {
		DB_Connect connect = null;
		Notice NM;
		Notice_data Notice;
		
		connect.beginConnection();
		// DB에서 정보 가져오기
		if (connect.conn != null) {
			String sql = "SELECT * FROM notice";
			try {
				Statement st = connect.conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("notice_id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					int viewcount = rs.getInt("viewcount");
					
					NoticeArr.add(new Notice_data(id, title, content, viewcount));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		connect.endConnection();
		return NoticeArr;
	}
	
	public boolean changeViewCount(String title, int Count) {
		
		DB_Connect connect = null;
		Notice NM;
		Notice_data Notice;
		
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE NOTICE SET viewcount = ? WHERE title = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setInt(1, Count);
				pstmt.setString(2, title);
				int rs = pstmt.executeUpdate();
				if( rs == 1 ) {
					System.out.println("조회수 증가 성공");
					return true;
				} else 
					System.out.println("조회수 증가 실패");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		connect.endConnection();
		return false;
	}
}
	