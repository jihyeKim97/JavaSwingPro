package template.Application.controller.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import template.Application.controller.Data.Notice_data;
import template.Application.view.Notice;

public class Notice_DB {
	static ArrayList<Notice_data> NoticeArr = new ArrayList<>();
	static DB_Connect connect;
	static Notice NM;
	static Notice_data Notice;
	
	public void addNotice(String title, String content) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO notice(notice_id,title,content,viewcount,member_id) VALUES (MEMBER_SEQ.nextval,"
					+ "'" + title + "', '" + content + "', 0, " + 24 + ")";
			System.out.println(sql);
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);

				int r = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		connect.endConnection();
	}
	

	public static ArrayList<Notice_data> takeNoticetitle() {
		ArrayList<Notice_data> NoticeArr = new ArrayList<>();
		connect.beginConnection();
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
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "UPDATE NOTICE SET viewcount = ? WHERE title = ?";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				pstmt.setInt(1, Count);
				pstmt.setString(2, title);
				int rs = pstmt.executeUpdate();
				if (rs == 1) {
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

	public ArrayList<Notice_data> selectAllNotice() {
		connect.beginConnection();
		if (connect.conn != null) {
			ArrayList<Notice_data> uiList = new ArrayList<>();
			String sql = "select * from NOTICE ORDER BY NOTICE_ID desc";
			try {
				Statement stmt = connect.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String userDoB = rs.getString("BIRTHDAY");
					Notice_data ui = new Notice_data(rs.getInt("NOTICE_ID"), rs.getString("TITLE"),
							rs.getString("CONTENT"), rs.getInt("VEIWCOUNT"), rs.getInt("MEMBER_ID"));
					uiList.add(ui);
				}
				System.out.println("DBMgr: 연동 성공! 공지사항갯수 => " + uiList.size());
				return uiList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!!@");
		}
		connect.endConnection();
		return null;
	}
	
	public void deleteNotice(Notice_data selNotice) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "delete notice where  = notice_id" + selNotice.getNoticeid();
		try {
			PreparedStatement pstmt = connect.conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		}
		connect.endConnection();
	}
	
}
