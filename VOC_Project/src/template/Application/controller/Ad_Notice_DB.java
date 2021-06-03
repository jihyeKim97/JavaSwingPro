package template.Application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ad_Notice_DB {
	static ArrayList<Ad_Notice_data> NoticeArr = new ArrayList<>();
	
	static DB_Connect DB;
	static Connection conn;
	Ad_Notice_data ad_Notice;
	
	
	public Ad_Notice_DB() {
		this.conn = DB.getConn();
	}
	
	public static ArrayList<Ad_Notice_data> GetNotice() {
		if (conn != null) {
			String sql = "SELECT * FROM notice";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("notice_id");
					String title = rs.getString("title");
					String content = rs.getString("content");
	
					NoticeArr.add(new Ad_Notice_data(id,title,content));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return NoticeArr;
	}
	public boolean changeNotice(String title, String content) {
		if (this.conn != null) {
			String sql = "UPDATE NOTICE SET TITLE = ? SET CONTENT = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
			
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					System.out.println("db 공지사항 수정");
					return true;
				} else {
					System.out.println("db 공지사항 수정 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
}
