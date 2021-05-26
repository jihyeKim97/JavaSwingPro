package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import template.Application.view.Mypage_writePage;

public class MyPage extends JFrame {

	JPanel contentPane;
	JTextField nameField;
	JTextField idField;
	JTextField pwField;
	JTextField genField;
	JTextField birField;
	JTextField currField;
	JTextField newpwField;
	JTextField newpwckField;
	Panel header;
	MyPage frm;
	RoundedButtonD btn_logout;
	RoundedButtonD wirte_review;
	Mypage_writePage wirteP;
	Point fPt;
	Main mafrm;
	
	int memberID = 25 ;

	public MyPage(Main mafrm) {
		this.frm = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		header = new Panel();
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);

		RoundedButtonD btn_main = new RoundedButtonD("HOME");
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_main.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_main.setBounds(12, 10, 100, 35);
		header.add(btn_main);

		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(0, 55, 484, 705);
		contentPane.add(content);
		content.setLayout(null);

		Panel detail = new Panel();
		detail.setBackground(Color.WHITE);
		detail.setBounds(10, 0, 464, 705);
		content.add(detail);
		detail.setLayout(null);

		Panel title = new Panel();
		title.setBackground(Color.WHITE);
		title.setBounds(10, 10, 444, 55);
		detail.add(title);
		title.setLayout(new BorderLayout(0, 0));

		JLabel lbTitle = new JLabel("Member Info");
		lbTitle.setFont(new Font("Corbel Light", Font.PLAIN, 40));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(lbTitle, BorderLayout.CENTER);

		JPanel mem_panel = new JPanel();
		mem_panel.setBackground(new Color(220, 220, 220));
		mem_panel.setBounds(10, 110, 444, 585);
		detail.add(mem_panel);
		mem_panel.setLayout(null);

		JPanel res_panel = new JPanel();
		res_panel.setBackground(new Color(211, 211, 211));
		res_panel.setBounds(10, 110, 444, 585);
		detail.add(res_panel);
		res_panel.setLayout(null);

		JPanel resdetail_panel = new JPanel();
		resdetail_panel.setBackground(Color.WHITE);
		resdetail_panel.setBounds(10, 10, 424, 565);
		res_panel.add(resdetail_panel);
		resdetail_panel.setLayout(null);

		Panel reser_box = new Panel();
		reser_box.setBackground(new Color(245, 245, 245));
		reser_box.setBounds(10, 10, 404, 150);
		resdetail_panel.add(reser_box);
		reser_box.setLayout(null);

		Panel poster = new Panel();
		poster.setBackground(new Color(255, 228, 196));
		poster.setBounds(10, 31, 87, 109);
		reser_box.add(poster);

		JLabel txt_reser_num = new JLabel("number : ");
		txt_reser_num.setFont(new Font("Candara Light", Font.PLAIN, 10));
		txt_reser_num.setBounds(10, 10, 102, 15);
		reser_box.add(txt_reser_num);

		JLabel resernum_sett = new JLabel("");
		resernum_sett.setFont(new Font("Candara Light", Font.PLAIN, 10));
		resernum_sett.setBounds(110, 10, 282, 15);
		reser_box.add(resernum_sett);

		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setFont(new Font("Candara Light", Font.PLAIN, 10));
		lblTitle.setBounds(103, 31, 32, 15);
		reser_box.add(lblTitle);

		JLabel title_sett = new JLabel("");
		title_sett.setFont(new Font("Candara Light", Font.PLAIN, 10));
		title_sett.setBounds(132, 31, 260, 15);
		reser_box.add(title_sett);

		JLabel lblTime = new JLabel("Time : ");
		lblTime.setFont(new Font("Candara Light", Font.PLAIN, 10));
		lblTime.setBounds(103, 56, 36, 15);
		reser_box.add(lblTime);

		JLabel time_sett = new JLabel("");
		time_sett.setFont(new Font("Candara Light", Font.PLAIN, 10));
		time_sett.setBounds(136, 56, 256, 15);
		reser_box.add(time_sett);

		JLabel lblSeat = new JLabel("Seat : ");
		lblSeat.setFont(new Font("Candara Light", Font.PLAIN, 10));
		lblSeat.setBounds(103, 81, 36, 15);
		reser_box.add(lblSeat);

		JLabel seat_sett = new JLabel("");
		seat_sett.setFont(new Font("Candara Light", Font.PLAIN, 10));
		seat_sett.setBounds(133, 81, 259, 15);
		reser_box.add(seat_sett);

		wirte_review = new RoundedButtonD("Go to write a review");
		wirte_review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wirteP = new Mypage_writePage(frm);
				fPt = frm.getLocationOnScreen();
				wirteP.setLocation(fPt.x + frm.getWidth() + 20, fPt.y);
				wirteP.setVisible(true);
			}
		});
		wirte_review.setBounds(103, 106, 291, 34);
		reser_box.add(wirte_review);

		JPanel none_resdetail_panel = new JPanel();
		none_resdetail_panel.setBackground(Color.WHITE);
		none_resdetail_panel.setBounds(10, 10, 424, 565);
		res_panel.add(none_resdetail_panel);
		none_resdetail_panel.setLayout(null);

		JLabel nonereservatiompanel = new JLabel("There are currently no reservations");
		nonereservatiompanel.setForeground(new Color(165, 42, 42));
		nonereservatiompanel.setFont(new Font("Candara Light", Font.PLAIN, 20));
		nonereservatiompanel.setHorizontalAlignment(SwingConstants.CENTER);
		nonereservatiompanel.setBounds(51, 10, 324, 15);
		none_resdetail_panel.add(nonereservatiompanel);

		RoundedButtonD btn_meminfo = new RoundedButtonD("member info");
		btn_meminfo.setBackground(new Color(128, 128, 128));
		btn_meminfo.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_meminfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(true);
				res_panel.setVisible(false);
				lbTitle.setText("Member Info");
			}
		});
		btn_meminfo.setBounds(13, 80, 130, 35);
		detail.add(btn_meminfo);

		RoundedButtonD btn_reser = new RoundedButtonD("reservtion");
		btn_reser.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_reser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
				res_panel.setVisible(true);
				lbTitle.setText("Reservtion");
			}
		});
		btn_reser.setBounds(146, 80, 105, 35);
		detail.add(btn_reser);

		Panel memdetail_panel = new Panel();
		memdetail_panel.setLayout(null);
		memdetail_panel.setBackground(Color.WHITE);
		memdetail_panel.setBounds(10, 10, 424, 565);
		mem_panel.add(memdetail_panel);

		RoundedButtonD btn_edit = new RoundedButtonD("Edit");
		btn_edit.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_edit.setBounds(12, 515, 400, 40);
		memdetail_panel.add(btn_edit);

		Panel lbPanel = new Panel();
		lbPanel.setBounds(0, 0, 162, 463);
		memdetail_panel.add(lbPanel);
		lbPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label);

		JLabel label_1 = new JLabel("ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_1);

		JLabel label_2 = new JLabel("Phone");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_2);

		JLabel label_3 = new JLabel("Gender");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_3);

		JLabel label_4 = new JLabel("BirthDay");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_4);

		JLabel label_5 = new JLabel("Current PW");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_5);

		JLabel label_6 = new JLabel("New PW");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_6);

		JLabel label_7 = new JLabel("Confirm New PW");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Candara Light", Font.PLAIN, 20));
		lbPanel.add(label_7);

		Panel fieldPanel = new Panel();
		fieldPanel.setLayout(null);
		fieldPanel.setBounds(168, 0, 256, 463);
		memdetail_panel.add(fieldPanel);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(0, 10, 246, 40);
		fieldPanel.add(nameField);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(0, 65, 246, 40);
		fieldPanel.add(idField);

		pwField = new JTextField();
		pwField.setColumns(10);
		pwField.setBounds(0, 123, 246, 40);
		fieldPanel.add(pwField);

		genField = new JTextField();
		genField.setColumns(10);
		genField.setBounds(0, 183, 246, 40);
		fieldPanel.add(genField);

		birField = new JTextField();
		birField.setColumns(10);
		birField.setBounds(0, 242, 246, 40);
		fieldPanel.add(birField);

		currField = new JTextField();
		currField.setColumns(10);
		currField.setBounds(0, 302, 246, 40);
		fieldPanel.add(currField);

		newpwField = new JTextField();
		newpwField.setColumns(10);
		newpwField.setBounds(0, 358, 246, 40);
		fieldPanel.add(newpwField);

		newpwckField = new JTextField();
		newpwckField.setColumns(10);
		newpwckField.setBounds(0, 412, 246, 40);
		fieldPanel.add(newpwckField);

		btn_logout = new RoundedButtonD("LOGOUT");
		btn_logout.setBounds(350, 80, 100, 35);
		detail.add(btn_logout);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
//					System.out.println("안닫기 누름");
					System.exit(0);
				}
				Login loginpage = new Login();
				loginpage.setVisible(true);
			}
		});
		btn_logout.setFont(new Font("Candara Light", Font.PLAIN, 20));

	}
}
