package template.Application.controller.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Ad_Notice_data;
import template.Application.controller.Data.Notice_data;

public class Ad_Notice_DB {
	static ArrayList<Ad_Notice_data> NoticeArr = new ArrayList<>();

	static DB_Connect DB;
	Ad_Notice_data ad_Notice;
	

	public static ArrayList<Ad_Notice_data> GetNotice(int NoticeiD) {
		DB.beginConnection();
		if (DB.conn != null) {
			String sql = "SELECT * FROM notice where notice_id = " + NoticeiD;
			try {
				Statement stmt = DB.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String title = rs.getString("title");
					String content = rs.getString("content");

					NoticeArr.add(new Ad_Notice_data(title, content));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DB.endConnection();
		return NoticeArr;
	}

	public boolean changeNotice(int noticeid, String title, String content) {
		if (DB.conn != null) {
			String sql = "UPDATE NOTICE SET TITLE = ? ,CONTENT = ? WHERE NOTICE_ID = " + noticeid;
			try {
				PreparedStatement pstmt = DB.conn.prepareStatement(sql);
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
		DB.endConnection();
		return false;
	}

	public boolean insertNewNotice(Notice_data ui) {
		DB.beginConnection();
		if (DB.conn != null && ui != null) {
			String sql = "INSERT INTO notice(notice_id,title,content,viewcount,member_id) VALUES (MEMBER_SEQ.nextval,"
					+ "'" + ui.getTitle() + "', '" + ui.getContent() + "', '" + "0" + "', '" + 24 + "')";
			System.out.println(sql);
			try {
				PreparedStatement pstmt = DB.conn.prepareStatement(sql);

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("DBMgr: 공지사항 등록 성공! " + ui);
					return true;
				} else {
					System.out.println("DBMgr: 공지사항 등록 실패! " + ui);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		DB.endConnection();
		return false;
	}

}
