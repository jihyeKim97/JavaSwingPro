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

	// 공지사항 추가하기
	public static boolean addNotice(String title, String content) {
		connect.beginConnection();
		if (connect.conn != null) {
			String sql = "INSERT INTO notice (notice_id,title,content,viewcount,member_id) VALUES (NOTICE_SEQ.nextval,"
					+ "'" + title + "', '" + content + "', 0 , " + 24 + ")";
			try {
				PreparedStatement pstmt = connect.conn.prepareStatement(sql);
				int r = pstmt.executeUpdate();
				if (r == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB error!!");
		}
		connect.endConnection();
		return false;
	}

	// 공지사항 제목 가져오기
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

	// 공지사항 조회수 변경하기
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

}
