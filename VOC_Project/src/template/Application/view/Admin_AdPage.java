package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import template.Application.controller.SIgnUp_DB;
import template.Application.controller.SignUp_data;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
public class Admin_AdPage extends JFrame {

	 JPanel contentPane;
	 JTable ad_tb_MemberTable;
	 JTable ad_tb_ReviewTable;
	 JTable ad_tb_RaservationTable;
	 JTable ad_tb_MovieTable;
	 JTable ad_tb_NoticeTable;
	
	 ArrayList<SignUp_data> mList;
	 Admin_AdPage frm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_AdPage frame = new Admin_AdPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_AdPage() {
		this.frm = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 37, 654, 347);
		contentPane.add(tabbedPane);
		
		JPanel ad_pn_Member = new JPanel(); // pnLeft는 음식메뉴관리탭?
		tabbedPane.addTab("회원관리", ad_pn_Member);		
		tabbedPane.setBackgroundAt(0, Color.ORANGE);
		tabbedPane.setIconAt(0, new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\sport_football.png"));
		ad_pn_Member.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		ad_pn_Member.add(toolBar, BorderLayout.NORTH);
		
		JButton ad_btn_AdLookUpUser = new JButton("\uD68C\uC6D0 \uC870\uD68C");

		ad_btn_AdLookUpUser.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\find.png"));
		toolBar.add(ad_btn_AdLookUpUser);
		
		JButton ad_btn_AdDeleteUser = new JButton("\uD68C\uC6D0 \uC0AD\uC81C");
		ad_btn_AdDeleteUser.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\wrench_orange.png"));
		toolBar.add(ad_btn_AdDeleteUser);
		
		JScrollPane scrollPane = new JScrollPane();
		ad_pn_Member.add(scrollPane, BorderLayout.CENTER);
		
		ad_tb_MemberTable = new JTable();
		scrollPane.setViewportView(ad_tb_MemberTable);
		ad_tb_MemberTable.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				int selRow = ad_tb_MemberTable.getSelectedRow();
				int selMemberId = (int) ad_tb_MemberTable.getValueAt(selRow, 1);
				String selMemberName = (String) ad_tb_MemberTable.getValueAt(selRow, 3);
				SignUp_data selMember = mList.get(selRow);
				System.out.println(">> 선택된 회원: " + selMember);
			}
		});
		
		ad_tb_MemberTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ad_tb_MemberTable.setModel(new DefaultTableModel(
				new Object[][] {
					{" ", "1", "asdfa", "1234", "바나나",1,"940151","01012345678"},
					{" ", "2", "aabcd123", "1234", "초코",2,"920105","01012345678"},
					{" ", "3", "qwerasdf", "1234", "딸기",1,"900815","01012345678"},
					{" ", "4", "uiopjkl", "1234", "수박",2,"950618","01012345678"},

				},
		new String[] {
				"선택", "고유ID", "사용자 ID ", "비밀번호", "이름", "성별","생년월일","전화번호"
		}
	));
		scrollPane.setViewportView(ad_tb_MemberTable);

		
		JPanel ad_pn_review = new JPanel();
		tabbedPane.addTab("리뷰관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\group.png"), ad_pn_review, null);
		ad_pn_review.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_1 = new JToolBar();
		ad_pn_review.add(toolBar_1, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8 \uC870\uD68C");
		toolBar_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uCD94\uAC00");
		toolBar_1.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		ad_pn_review.add(scrollPane_1, BorderLayout.CENTER);
		
		ad_tb_ReviewTable = new JTable();
		scrollPane_1.setViewportView(ad_tb_ReviewTable);
		
//		tableMembers = new JTable();
//		scrollPane_1.setViewportView(tableMembers);
		
		JPanel ad_pn_reservation = new JPanel();
		tabbedPane.addTab("예매관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\contrast.png"), ad_pn_reservation, null);
		ad_pn_reservation.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 651, 353);
		ad_pn_reservation.add(scrollPane_3);
		
		ad_tb_RaservationTable = new JTable();
		scrollPane_3.setViewportView(ad_tb_RaservationTable);
		
		JPanel ad_pn_movie = new JPanel();
		tabbedPane.addTab("영화관리", new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\transmit_go.png"), ad_pn_movie, null);
		ad_pn_movie.setLayout(null);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setBounds(0, 0, 651, 23);
		ad_pn_movie.add(toolBar_2);
		
		JButton ad_btn_LookUpMovie = new JButton("\uC601\uD654\uBAA9\uB85D \uC870\uD68C");
		toolBar_2.add(ad_btn_LookUpMovie);
		
		JButton ad_btn_AddMovie = new JButton("\uC601\uD654 \uCD94\uAC00");
		toolBar_2.add(ad_btn_AddMovie);
		
		JButton ad_btn_DeleteMovie = new JButton("\uC601\uD654 \uC0AD\uC81C");
		toolBar_2.add(ad_btn_DeleteMovie);
		
		JButton btnNewButton_7 = new JButton("\uC0C1\uC601\uC911?");
		toolBar_2.add(btnNewButton_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 23, 651, 328);
		ad_pn_movie.add(scrollPane_2);
		
		ad_tb_MovieTable = new JTable();
		scrollPane_2.setViewportView(ad_tb_MovieTable);
		
//		tableOrders = new JTable();
//		scrollPane_2.setViewportView(tableOrders);
		
		JPanel ad_pn_notice = new JPanel();
		tabbedPane.addTab("공지사항", null, ad_pn_notice, null);
		ad_pn_notice.setLayout(null);
		
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setBounds(0, 5, 639, 23);
		ad_pn_notice.add(toolBar_3);
		
		JButton btnNewButton_2 = new JButton("\uACF5\uC9C0\uC0AC\uD56D \uCD94\uAC00");
		toolBar_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uACF5\uC9C0\uC0AC\uD56D \uC0AD\uC81C");
		toolBar_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uACF5\uC9C0\uC0AC\uD56D \uC870\uD68C");
		toolBar_3.add(btnNewButton_4);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 25, 651, 326);
		ad_pn_notice.add(scrollPane_4);
		
		ad_tb_NoticeTable = new JTable();
		scrollPane_4.setViewportView(ad_tb_NoticeTable);
		
		JButton btnNewButton_5 = new JButton("LogOut");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_5.setBounds(563, 4, 91, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Home");
		btnNewButton_6.setBounds(12, 4, 97, 23);
		contentPane.add(btnNewButton_6);
		

	
	}
	
	public void showMemberTableUIFromDB() {
		final String columnNames[] = {
				"선택","고유번호","아이디","비밀번호","이름",
				"성별","생년월일","전화번호"
		}; // 8개
	
	SIgnUp_DB mgr = new SIgnUp_DB();
	mList = mgr.selectAllMembers();
		if(mList == null || mList.isEmpty()) return;
		final int nDBSize = mList.size(); // 레코드 개수 ==> 테이블의 행수
		Object data[][] = new Object[nDBSize][columnNames.length];
		
		for (int i = 0; i < nDBSize; i++) {
			SignUp_data mbl= mList.get(i);
			// 행열 번호로 테이블 데이터셀 채우기
			data[i][1] = mbl.getId();  
			data[i][2] = mbl.getPassword();
			data[i][3] = mbl.getName();
			data[i][4] = mbl.getGender()== SignUp_data.GENDER_FEMALE? "여성":"남성";
			data[i][5] = mbl.getBirthday();
			data[i][6] = mbl.getPhone_number();

		DefaultTableModel dtm = 
				new DefaultTableModel(data, columnNames);
		// 기본테이블 모델 = 데이터(행/열) 2차원배열, 열이름헤더 1차원배열
		this.ad_tb_MemberTable.setModel(dtm);		

		}
	}
}
