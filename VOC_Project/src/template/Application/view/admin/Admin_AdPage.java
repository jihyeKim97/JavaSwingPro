package template.Application.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import template.Application.controller.DB.Ad_AdPage_DB;
import template.Application.controller.DB.Ad_Review_DB;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.DB.Notice_DB;
import template.Application.controller.DB.Reservation_DB;
import template.Application.controller.DB.Review_DB;
import template.Application.controller.DB.SIgnUp_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Mypage_Reservation_data;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.Data.Reservation_data;
import template.Application.controller.Data.Review_Data;
import template.Application.controller.Data.SignUp_data;
import template.Application.controller.btn.RoundedButtonR;
import template.Application.view.member.Login;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;
public class Admin_AdPage extends JFrame {

	 JPanel contentPane;
	 JTable ad_tb_MemberTable;
	 JTable ad_tb_ReviewTable;
	 JTable ad_tb_RaservationTable;
	 JTable ad_tb_MovieTable;
	 JTable ad_tb_NoticeTable;
	
	 ArrayList<Login_data> mList;
	 ArrayList<Movie_Data> movieList;
	 ArrayList<Review_Data> rList;
	 ArrayList<Notice_data> nList;
	 ArrayList<Reservation_data> resList;
	 Notice_DB NDB;
	 Movie_DB MDB;
	 Review_DB RDB;
	 Reservation_DB reservaiton;
	 Ad_AdPage_DB addb;
	 Admin_AdPage frm;
	 static Login Lg;
	 static Login_data Ld;
	 Review_Data review = new Review_Data();
	 Ad_Review_DB ARDB;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_AdPage frame = new Admin_AdPage(Lg, Ld);
//					Admin_AdPage frame = new Admin_AdPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin_AdPage(Login Lg, Login_data Ld) {
//	public Admin_AdPage() {
		this.frm = this;
		setTitle("Vehicle Outdoor Cinema [ admin page ] ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		tabbedPane.setBounds(12, 43, 1144, 674);
		contentPane.add(tabbedPane);
		
		JPanel ad_pn_Member = new JPanel(); // pnLeft는 음식메뉴관리탭?
		ad_pn_Member.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				frm.showMemberTableUIFromDB();
			}
		});
		tabbedPane.addTab("회원관리", ad_pn_Member);		
		tabbedPane.setIconAt(0, new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\sport_football.png"));
		ad_pn_Member.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_pn_Member.add(toolBar, BorderLayout.NORTH);
		
		JButton ad_btn_AdDeleteUser = new JButton("\uD68C\uC6D0 \uC0AD\uC81C");
		ad_btn_AdDeleteUser.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_btn_AdDeleteUser.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\wrench_orange.png"));
		ad_btn_AdDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Ad_AdPage_DB addb = new Ad_AdPage_DB();
	            int n = ad_tb_MemberTable.getSelectedRow();
	            Login_data A = mList.get(n);
	            DefaultTableModel tm = (DefaultTableModel)ad_tb_MemberTable.getModel();
	            if (n>=0 && n <ad_tb_MemberTable.getRowCount()) {
	               tm.removeRow(n);
	               Login_data ln = new Login_data();
	               int memberId= ln.getMember_id();
	               int ismember= ln.getIs_member();
	               addb.updateMembertoNone(ismember,A.getMember_id());
	               System.out.println("회원 탈퇴처리");
	            }
			}
		});	
		
		toolBar.add(ad_btn_AdDeleteUser);
		
		JScrollPane scrollPane = new JScrollPane();
		ad_pn_Member.add(scrollPane, BorderLayout.CENTER);
		
		ad_tb_MemberTable = new JTable();
		scrollPane.setViewportView(ad_tb_MemberTable);
		ad_tb_MemberTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_MemberTable.getSelectedRow();
				int selMemberId = (int) ad_tb_MemberTable.getValueAt(selRow, 0);
				String selMemberName = (String) ad_tb_MemberTable.getValueAt(selRow, 3);
				Login_data selMember = mList.get(selRow);
				System.out.println(">> 선택된 회원: " + selMember);
			}
		});
		
		ad_tb_MemberTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		ad_tb_MemberTable.setModel(new DefaultTableModel(
//				new Object[][] {
//					{ "1", "asdfa", "1234", "바나나",1,"01012345678","940151"},
//					{ "2", "aabcd123", "1234", "초코",2,"01012345678","920105"},
//					{ "3", "qwerasdf", "1234", "딸기",1,"01012345678","900815"},
//					{"4", "uiopjkl", "1234", "수박",2,"01012345678","950618"},
//
//				},
//		new String[] {
//				"고유ID", "사용자 ID ", "비밀번호", "이름", "성별","전화번호","생년월일"
//		}
//	));
		scrollPane.setViewportView(ad_tb_MemberTable);

		
		JPanel ad_pn_review = new JPanel();
		ad_pn_review.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				frm.showReviewTableUIFromDB();
			}
		});
		tabbedPane.addTab("리뷰관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\group.png"), ad_pn_review, null);
		tabbedPane.setEnabledAt(1, true);
		ad_pn_review.setLayout(null);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(0, 0, 1050, 23);
		ad_pn_review.add(toolBar_1);
		
		JButton ad_btn_AdDeleteReview = new JButton("리뷰 삭제");
		ad_btn_AdDeleteReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = ad_tb_ReviewTable.getSelectedRow();
	            Login_data A = mList.get(n);
	            DefaultTableModel tm = (DefaultTableModel)ad_tb_ReviewTable.getModel();
	            if (n>=0 && n <ad_tb_ReviewTable.getRowCount()) {
	               tm.removeRow(n);
	               int reviewId= review.getReviewid();
	               ARDB.changePK(reviewId);
	               ARDB.deleteReview(reviewId);
	               System.out.println("리뷰가 삭제되었습니다.");
	            }
			}
		});
		toolBar_1.add(ad_btn_AdDeleteReview);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 23, 1050, 294);
		ad_pn_review.add(scrollPane_1);
		
		ad_tb_ReviewTable = new JTable();
		scrollPane_1.setViewportView(ad_tb_ReviewTable);
		ad_tb_ReviewTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_ReviewTable.getSelectedRow();
				int selReviewId = (int) ad_tb_ReviewTable.getValueAt(selRow, 0);
				String selReviewContent = (String) ad_tb_ReviewTable.getValueAt(selRow, 1);
				Review_Data selReview = rList.get(selRow);
				System.out.println(">> 선택된 리뷰: " + selReviewContent);
			}
		});
		
		ad_tb_ReviewTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		ad_tb_ReviewTable.setModel(new DefaultTableModel(
//				new Object[][] {
//					{"1", "너무 재밌었어요", 5, "", "12",1,176,10},
//					{"2", "그냥 그래요", 3.2, "13",2,015,17},
//					{"3", "별로에요", 1.5, "14",1,103,22},
//					{"4", "감동적이였어요", 4, "16",2,123,04},
//
//				},
//		new String[] {
//				"리뷰인덱스", "리뷰 내용", "별점", "리뷰작성날짜", "예약인덱스", "영화인덱스"
//		}
//	));
		scrollPane_1.setViewportView(ad_tb_ReviewTable);
		
//		tableMembers = new JTable();
//		scrollPane_1.setViewportView(tableMembers);
		
		JPanel ad_pn_reservation = new JPanel();
		ad_pn_reservation.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				frm.showReservationTableUIFromDB();
			}
		});
		tabbedPane.addTab("예매관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\contrast.png"), ad_pn_reservation, null);
		tabbedPane.setEnabledAt(2, true);
		ad_pn_reservation.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 1038, 318);
		ad_pn_reservation.add(scrollPane_3);
		
		ad_tb_RaservationTable = new JTable();
		scrollPane_3.setViewportView(ad_tb_RaservationTable);
		ad_tb_RaservationTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_RaservationTable.getSelectedRow();
				int selResId = (int) ad_tb_RaservationTable.getValueAt(selRow, 0);
				int selResNum = (int) ad_tb_RaservationTable.getValueAt(selRow, 1);
				Reservation_data selRes = resList.get(selRow);
				System.out.println(">> 선택된 예약: " + selResNum);
			}
		});
		
		ad_tb_RaservationTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
//		ad_tb_RaservationTable.setModel(new DefaultTableModel(
//				new Object[][] {
//					{1021,123456,"2021-06-01 4시","A3",1,55000,"2021-05-31","","",111,41},
//					{0651,19897654,"2021-06-02 20시","H6",1,65000,"2021-05-29","팝콘,콜라",18000,456,71},
//					{6541,8520,"2021-06-07 10시","B1",2,39000,"2021-06-01","나초",5000,111,41},
//					{6785,01365,"2021-06-03 22시","F8",1,78000,"2021-05-30","오징어,팝콘,콜라,나초",35000,891,30},
//
//				},
//		new String[] {
//				"예약인덱스", "예약번호", "예약날짜시간", "좌석번호", "차량타입", "결제금액","결제일시","옵션이름","옵션가격",
//				"회원인덱스","영화인덱스"
//		}
//	));
		scrollPane_3.setViewportView(ad_tb_RaservationTable);
		
		JPanel ad_pn_movie = new JPanel();
		ad_pn_movie.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				frm.showMovieTableUIFromDB();
			}
		});
		tabbedPane.addTab("영화관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\transmit_go.png"), ad_pn_movie, null);
		tabbedPane.setEnabledAt(3, true);
		ad_pn_movie.setLayout(null);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setBounds(0, 0, 1038, 23);
		ad_pn_movie.add(toolBar_2);
		
		JButton ad_btn_LookUpMovie = new JButton("\uC601\uD654\uBAA9\uB85D \uC870\uD68C");
		toolBar_2.add(ad_btn_LookUpMovie);
		ad_btn_LookUpMovie.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_MovieTable.getSelectedRow();
				//int selmovId = (int) ad_tb_MovieTable.getValueAt(selRow, 0);
				String selmovtitle = (String) ad_tb_MovieTable.getValueAt(selRow, 1);
				Movie_Data selm = movieList.get(selRow);
				System.out.println(">> 선택된 영화: " + selmovtitle);
			}
		});
		
		JButton ad_btn_AddMovie = new JButton("\uC601\uD654 \uCD94\uAC00");
		toolBar_2.add(ad_btn_AddMovie);
		
		JButton ad_btn_DeleteMovie = new JButton("\uC601\uD654 \uC0AD\uC81C");
		toolBar_2.add(ad_btn_DeleteMovie);
		
		JButton btnNewButton_7 = new JButton("\uC0C1\uC601\uC911?");
		toolBar_2.add(btnNewButton_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 23, 1038, 295);
		ad_pn_movie.add(scrollPane_2);
		
		ad_tb_MovieTable = new JTable();
		scrollPane_2.setViewportView(ad_tb_MovieTable);
		
		ad_tb_MovieTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_MovieTable.getSelectedRow();
				int selMovieId = (int) ad_tb_MovieTable.getValueAt(selRow, 0);
				String selMovieName = (String) ad_tb_MovieTable.getValueAt(selRow, 1);
				Movie_Data selmovie = movieList.get(selRow);
				System.out.println(">> 선택된 영화: " + selmovie);
				
			}
		});
		
		ad_tb_MovieTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		ad_tb_MovieTable.setModel(new DefaultTableModel(
//				new Object[][] {
//					{41,"승리호","SF","조성희",12,"2092년, 지구는 병들고 우주 위성궤도에 인류의 새로운 보금자리인 UTS가 만들어졌다. 돈 되는 일이라면, 뭐든 하는 조종사 태호 과거, 우주 해적단을 이끌었던 장선장 갱단 두목이었지만 이제는 기관사가 된 타이거 박 평생 이루고 싶은 꿈을 가진 작살잡이 로봇 업동이 이들은 우주쓰레기를 주워 돈을 버는 청소선 ‘승리호’의 선원들이다.어느날, 사고 우주정을 수거한 ‘승리호’는 그 안에 숨어있던 대량살상무기로 알려진 인간형 로봇 ‘도로시’를 발견한다. 돈이 절실한 선원들은 ‘도로시’를 거액의 돈과 맞바꾸기 위한 위험한 거래를 계획하는데…",
//						4.2,"송중기,김태리,진선규","'21/02/05','RR/MM/DD')","비단길","./template/Reference/images/승리호.jpg","to_date('21/06/01','RR/MM/DD')",1,"140분",null
//					}
//				},
//		new String[] {
//				
//				"영화인덱스", "영화제목", "장르", "감독", "연령등급", "줄거리","영화평균별점","등장인물","개봉일자","제작사","이미지 파일경로",
//				"상영 날짜","상영 시간","러닝타임"
//		}
//	));
	
		scrollPane_2.setViewportView(ad_tb_MovieTable);
//		tableOrders = new JTable();
//		scrollPane_2.setViewportView(tableOrders);
		
		JPanel ad_pn_notice = new JPanel();
		ad_pn_notice.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				frm.showNoticeTableUIFromDB();
			}
		});
		tabbedPane.addTab("공지사항", null, ad_pn_notice, null);
		tabbedPane.setEnabledAt(4, true);
		ad_pn_notice.setLayout(null);
		
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setBounds(0, 5, 1038, 23);
		ad_pn_notice.add(toolBar_3);
		
		JButton ad_btn_AdAddNotice = new JButton("\uACF5\uC9C0\uC0AC\uD56D \uCD94\uAC00");
		toolBar_3.add(ad_btn_AdAddNotice);
		
		JButton ad_btn_AdDeleteNotice = new JButton("\uACF5\uC9C0\uC0AC\uD56D \uC0AD\uC81C");
		toolBar_3.add(ad_btn_AdDeleteNotice);
		ad_btn_AdDeleteNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
//				int selRow = ad_tb_ReviewTable.getSelectedRow();
//				int n = ad_tb_ReviewTable.getSelectedRow();
//	            Login_data A = mList.get(n);
//	            DefaultTableModel tm = (DefaultTableModel)ad_tb_ReviewTable.getModel();
//	            if (n>=0 && n <ad_tb_ReviewTable.getRowCount()) {
//	               tm.removeRow(n);
//	               int reviewId= review.getReviewid();
//	               RDB.deleteReview(reviewId);
//	               System.out.println("리뷰가 삭제되었습니다.");
				int n = ad_tb_NoticeTable.getSelectedRow();
				DefaultTableModel tm = (DefaultTableModel)ad_tb_NoticeTable.getModel();
				if (n>=0 && n <ad_tb_NoticeTable.getRowCount()) {
					tm.removeRow(n);
					Notice_data nd = new Notice_data();
					int noticeId= nd.getNoticeid();
					String title= nd.getTitle();
					String content = nd.getContent();
					int veiwcount = nd.getViewcount();
					int memberid = nd.getMemberid();
					Ad_AdPage_DB.deleteNotice(noticeId,title,content,veiwcount,memberid);
				System.out.println("공지사항이 삭제 되었습니다.");	
			}
		}

		});	
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 25, 1038, 293);
		ad_pn_notice.add(scrollPane_4);
		
		ad_tb_NoticeTable = new JTable();
		scrollPane_4.setViewportView(ad_tb_NoticeTable);
		ad_tb_NoticeTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_NoticeTable.getSelectedRow();
				int selNoticeId = (int) ad_tb_NoticeTable.getValueAt(selRow, 0);
				String selNoticeContent = (String) ad_tb_NoticeTable.getValueAt(selRow, 1);
				Notice_data selNotice = nList.get(selRow);
				System.out.println(">> 선택된 공지사항: " + selNoticeContent);
			}
		});
		
		ad_tb_NoticeTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		ad_tb_NoticeTable.setModel(new DefaultTableModel(
//				new Object[][] {
//					{"코로나 관련 방역 안내 ", "코로나19 예방하기 위해 방역하였습니다.", 80, 291},
//					{"우천시 영화상영 관련 공지사항", "우천시에도 상영합니다. ", 63, 12},
//					{"코로나19로 인한 매점 음식판매 중단", "감염예방을 위해 매점에서 음식판매를 잠시 중단합니다.",23,111},
//
//				},
//		new String[] {
//				"공지인덱스", "제목", "내용", "조회수", "회원인덱스"
//		}
//	));
		scrollPane_4.setViewportView(ad_tb_NoticeTable);
		
		RoundedButtonR ad_btn_AdLogOut = new RoundedButtonR("로그아웃");
		ad_btn_AdLogOut.setText("LOGOUT");
		ad_btn_AdLogOut.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		ad_btn_AdLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Login loginpage = new Login();
					loginpage.setVisible(true);
					dispose();
					frm.dispose();
				}
			}
		});
		ad_btn_AdLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("로그아웃버튼 누름");
				ad_btn_AdLogOut.setOpaque(true);
				ad_btn_AdLogOut.setBackground(Color.LIGHT_GRAY);
//				Login ln = new Login(frm);
//				ln.setLocation(750.100);
//				ln.setVisible(true);
				dispose();
			}
		});
		
		
		ad_btn_AdLogOut.setVerticalAlignment(SwingConstants.TOP);
		ad_btn_AdLogOut.setBounds(1045, 10, 111, 35);
		contentPane.add(ad_btn_AdLogOut);
		

	
	}
	

//	public void deleteMemberTableUIFromDB() {
//		AdminPage_DB ad = new AdminPage_DB();
//		ad.deleteOneMember();
//	}
	
	public void showMemberTableUIFromDB() {
		final String columnNames[] = {
				"고유 번호","아이디","비밀번호","이름",
				"성별","전화번호","생년월일"
		}; // 7
	
		Login_DB mgr = new Login_DB();
		mList = mgr.selectAllMembers();
		if(mList == null || mList.isEmpty()) return;
		final int nDBSize = mList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Login_data mbl= mList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = mbl.getMember_id();  
			data[i][1] = mbl.getId();  
			data[i][2] = mbl.getPassword();
			data[i][3] = mbl.getName();
			data[i][4] = mbl.getGender()== SignUp_data.GENDER_FEMALE? "여성":"남성";
			data[i][5] = mbl.getPhone_number();
			data[i][6] = mbl.getBirthday();

		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.ad_tb_MemberTable.setModel(dtm);		

		}
	}
	
	
	public void showReservationTableUIFromDB() {
		final String columnNames[] = {
				"예약인덱스", "예약번호", "예약날짜시간", "좌석번호", "차량타입", "결제금액","결제일시","옵션이름","옵션가격",
				"회원인덱스","영화인덱스"
				
		}; // 8개
	
		resList = reservaiton.AllReservation();
		if(resList == null || resList.isEmpty()) return;
		final int nDBSize = resList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Reservation_data mbl= resList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = mbl.getReservationID();  
			data[i][1] = mbl.getReservationNumber();
			data[i][2] = mbl.getReservationDate();
			data[i][3] = mbl.getSeatNumber();
			data[i][4] = mbl.getCarType();
			data[i][5] = mbl.getPaymentPrice();
			data[i][6] = mbl.getPaymentDate();
			data[i][7] = mbl.getOptionName();
			data[i][8] = mbl.getOptionPrice();
			data[i][9] = mbl.getMemberID();
			data[i][10] = mbl.getMovieID();
			

		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.ad_tb_RaservationTable.setModel(dtm);		
		}
		}


	public void showReviewTableUIFromDB() {
		final String columnNames[] = {
				"리뷰인덱스", "리뷰 내용", "별점", "리뷰작성날짜", "예약인덱스", "영화인덱스"
				
		}; // 8개
	
		rList = RDB.AllReviewData();
		if(rList == null || rList.isEmpty()) return;
		final int nDBSize = rList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Review_Data mbl= rList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = mbl.getReviewid();  
			data[i][1] = mbl.getContent();
			data[i][2] = mbl.getStar_score();
			data[i][3] = mbl.getReviewdate();
			data[i][4] = mbl.getReservationid();
			data[i][5] = mbl.getMoviesid();

		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.ad_tb_ReviewTable.setModel(dtm);		
		}
		}

	public void showMovieTableUIFromDB() {
		final String columnNames[] = {
				"영화인덱스", "영화제목", "장르", "감독", "연령등급", "줄거리","영화평균별점","등장인물","개봉일자","제작사","이미지 파일경로",
				"상영 날짜","상영 시간","러닝타임"
		}; // 14개
	
		movieList = MDB.getMovieData();
		if(movieList == null || movieList.isEmpty()) return;
		final int nDBSize = movieList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length+1];
		
		for (int i = 0; i < nDBSize; i++) {
			Movie_Data mbl= movieList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = mbl.getMoviesid();  
			data[i][1] = mbl.getTitle();
			data[i][2] = mbl.getGenre();
			data[i][3] = mbl.getDirector();
			data[i][4] = mbl.getAgegroup();
			data[i][5] = mbl.getStory();
			data[i][6] = mbl.getAverageScore();
			data[i][7] = mbl.getGee();
			data[i][8] = mbl.getOpendate();
			data[i][9] = mbl.getProduction();
			data[i][10] = mbl.getImagefilename();
			data[i][11] = mbl.getScheduledate();
			data[i][12] = mbl.getScheduletime();
			data[i][13] = mbl.getRunningtime();


		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.ad_tb_MovieTable.setModel(dtm);		

		}
	}
	
	public void showNoticeTableUIFromDB() {
		final String columnNames[] = {
				"공지인덱스", "제목", "내용", "조회수", "회원인덱스"
		}; // 8개
	

		nList = NDB.takeNoticetitle();
		if(nList == null || nList.isEmpty()) return;
		final int nDBSize = nList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			Notice_data mbl= (Notice_data) nList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][0] = mbl.getNoticeid();  
			data[i][1] = mbl.getTitle();
			data[i][2] = mbl.getContent();
			data[i][3] = mbl.getViewcount();
			data[i][4] = mbl.getMemberid();
			
			DefaultTableModel dtm = 
					new DefaultTableModel(data, columnNames);
			// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
			this.ad_tb_NoticeTable.setModel(dtm);		

		

		}
	}
}
