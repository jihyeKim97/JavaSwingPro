package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;

import template.Application.controller.MyPage_DB;
import template.Application.controller.MyPage_Data;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class Admin_AdPage extends JFrame {

	JPanel contentPane;
	Panel header;
	Admin_AdPage frm;
	RoundedButtonD ad_btn_adNotice;
	Mypage_writePage wirteP;
	Point fPt;
	Main mafrm;
	MyPage_Data MyPage;
	MyPage_DB MDB;
	int memberID = 34;
	private JTable table;

	public Admin_AdPage(Main mafrm) {
		this.frm = this;
		ArrayList<MyPage_Data> MyArr = MDB.SelectMemberID(memberID);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		header = new Panel();
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));
		header.setBounds(0, 0, 536, 55);
		contentPane.add(header);

		RoundedButtonD btn_main = new RoundedButtonD("HOME");
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_main.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		btn_main.setBounds(12, 10, 100, 35);
		header.add(btn_main);
		
		RoundedButtonD ad_btn_adLogout = new RoundedButtonD("LOGOUT");
		ad_btn_adLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
						Login loginpage = new Login();
						loginpage.setVisible(true);
					}
				});

		ad_btn_adLogout.setBounds(424, 10, 100, 35);
		header.add(ad_btn_adLogout);

		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(0, 55, 662, 415);
		contentPane.add(content);
		content.setLayout(null);

		Panel detail = new Panel();
		detail.setBackground(Color.WHITE);
		detail.setBounds(10, 0, 519, 405);
		content.add(detail);
		detail.setLayout(null);

		JPanel mem_panel = new JPanel();
		mem_panel.setBackground(new Color(220, 220, 220));
		mem_panel.setBounds(0, 40, 519, 363);
		detail.add(mem_panel);
		mem_panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 10, 1, 1);
		mem_panel.add(table);

		RoundedButtonD ad_btn_adUser = new RoundedButtonD("회원관리");
		ad_btn_adUser.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		ad_btn_adUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
		
			}
		});
		ad_btn_adUser.setBounds(0, 10, 105, 35);
		detail.add(ad_btn_adUser);
		String gen = "";
		if (MyArr.get(0).getGender() == 0) {
			gen = "남자";
		} else {
			gen = "여자";
		}

		ad_btn_adNotice = new RoundedButtonD("공지사항");
		ad_btn_adNotice.setBounds(319, 10, 100, 35);
		detail.add(ad_btn_adNotice);
		
		ad_btn_adNotice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		
		RoundedButtonD ad_btn_adMovie = new RoundedButtonD("영화관리");
		ad_btn_adMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ad_btn_adMovie.setBounds(106, 9, 105, 35);
		detail.add(ad_btn_adMovie);
		
		RoundedButtonD ad_btn_adReservation = new RoundedButtonD("예약관리");
		ad_btn_adReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ad_btn_adReservation.setBounds(212, 9, 105, 35);
		detail.add(ad_btn_adReservation);

	}
}
