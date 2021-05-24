package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Panel;
import java.awt.Color;

import template.Application.controller.DB_Connect;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField pwField;
	private JTextField genField;
	private JTextField birField;
	private JTextField currField;
	private JTextField newpwField;
	private JTextField newpwckField;

	public MyPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel header = new Panel();
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);

		RoundedButtonD roundedButtonD = new RoundedButtonD("LOGOUT");
		roundedButtonD.setFont(new Font("Candara Light", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);

		RoundedButtonD roundedButtonD_1 = new RoundedButtonD("HOME");
		roundedButtonD_1.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		roundedButtonD_1.setBounds(320, 10, 100, 35);
		header.add(roundedButtonD_1);

		RoundedButtonD roundedButtonD_2 = new RoundedButtonD("HOME");
		roundedButtonD_2.setText("=");
		roundedButtonD_2.setFont(new Font("Corbel Light", Font.PLAIN, 20));
		roundedButtonD_2.setBounds(430, 10, 41, 35);
		header.add(roundedButtonD_2);

		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(0, 55, 484, 705);
		contentPane.add(content);
		content.setLayout(null);

		Panel detail = new Panel();
		detail.setBackground(Color.WHITE);
		detail.setBounds(10, 10, 464, 685);
		content.add(detail);
		detail.setLayout(null);

		Panel title = new Panel();
		title.setBackground(Color.WHITE);
		title.setBounds(10, 0, 444, 55);
		detail.add(title);
		title.setLayout(new BorderLayout(0, 0));

		JLabel lbTitle = new JLabel("Member Info");
		lbTitle.setFont(new Font("Corbel Light", Font.PLAIN, 40));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(lbTitle, BorderLayout.CENTER);

		JPanel mem_panel = new JPanel();
		mem_panel.setBackground(new Color(220, 220, 220));
		mem_panel.setBounds(10, 90, 444, 585);
		detail.add(mem_panel);
		mem_panel.setLayout(null);

		JPanel res_panel = new JPanel();
		res_panel.setBackground(new Color(211, 211, 211));
		res_panel.setBounds(10, 90, 444, 585);
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

		RoundedButtonD wirte_review = new RoundedButtonD("Go to write a review");
		wirte_review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mypage_writePage WinReport = new Mypage_writePage(); 
				WinReport.setVisible(true);
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

		Button btn_meminfo = new Button("member info");
		btn_meminfo.setFont(new Font("Candara Light", Font.PLAIN, 13));
		btn_meminfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(true);
				res_panel.setVisible(false);
				lbTitle.setText("Member Info");
			}
		});
		btn_meminfo.setBounds(10, 61, 100, 30);
		detail.add(btn_meminfo);

		Button btn_reser = new Button("reservtion");
		btn_reser.setFont(new Font("Candara Light", Font.PLAIN, 13));
		btn_reser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
				res_panel.setVisible(true);
				lbTitle.setText("Reservtion");
			}
		});
		btn_reser.setBounds(110, 61, 100, 30);
		detail.add(btn_reser);

		Panel memdetail_panel = new Panel();
		memdetail_panel.setLayout(null);
		memdetail_panel.setBackground(Color.WHITE);
		memdetail_panel.setBounds(10, 10, 424, 565);
		mem_panel.add(memdetail_panel);

		RoundedButtonD btn_edit = new RoundedButtonD("Edit");
		btn_edit.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_edit.setBounds(162, 515, 100, 35);
		memdetail_panel.add(btn_edit);

		Panel lbPanel = new Panel();
		lbPanel.setBounds(0, 0, 162, 462);
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
		fieldPanel.setBounds(168, 0, 256, 462);
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

<<<<<<< HEAD
		mem_detail = new Panel();
		mem_detail.setBackground(new Color(255, 255, 255));
		mem_detail.setBounds(10, 10, 424, 550);
		mem_panel.add(mem_detail);
		mem_detail.setLayout(null);
		mem_panel.setVisible(false);
		btn_edit = new RoundedButtonD("Edit");
		btn_edit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_edit.setBounds(162, 505, 100, 35);
		mem_detail.add(btn_edit);

		txt_panel = new Panel();
		txt_panel.setBounds(0, 0, 162, 462);
		mem_detail.add(txt_panel);
		txt_panel.setLayout(new GridLayout(0, 1, 0, 0));

		lb_name = new JLabel("Name");
		lb_name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_name);

		lb_ld = new JLabel("ID");
		lb_ld.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_ld.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_ld);

		lb_phone = new JLabel("Phone");
		lb_phone.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_phone.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_phone);

		lb_gen = new JLabel("Gender");
		lb_gen.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_gen.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_gen);

		lb_bir = new JLabel("BirthDay");
		lb_bir.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_bir.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_bir);

		lb_cp = new JLabel("Current PW");
		lb_cp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_cp.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_cp);

		lb_np = new JLabel("New PW");
		lb_np.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_np.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_np);

		lb_cnp = new JLabel("Confirm New PW");
		lb_cnp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_cnp.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_cnp);

		txtF_panel = new Panel();
		txtF_panel.setBounds(168, 0, 256, 462);
		mem_detail.add(txtF_panel);
		txtF_panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 10, 246, 40);
		txtF_panel.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 65, 246, 40);
		txtF_panel.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(0, 123, 246, 40);
		txtF_panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(0, 183, 246, 40);
		txtF_panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(0, 242, 246, 40);
		txtF_panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(0, 302, 246, 40);
		txtF_panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(0, 358, 246, 40);
		txtF_panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(0, 412, 246, 40);
		txtF_panel.add(textField_7);

		tab_panel.add(btnReview);
		re_panel.setBackground(new Color(135, 206, 235));
		re_panel.setBounds(10, 120, 444, 570);
		div_panel.add(re_panel);
		re_panel.setLayout(null);

		re_detail = new Panel();
		re_detail.setBackground(new Color(255, 255, 255));
		re_detail.setBounds(10, 10, 424, 550);
		re_panel.add(re_detail);
		re_detail.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 404, 530);
		re_detail.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
//		for (int i = 0; i < 12; i++) {
//			JPanel JP = new JPanel();
//			JP.setBounds(10, 10 * (i + 1) + ( 120 * i), 370, 120);
//			JP.setBackground(new Color(0,0,255));
//			
//			panel.add(JP);
//		}
//	

		for (int i = 0; i < 50; i++) { // 리뷰 개수
			String text = "리뷰";
			JLabel Review = new JLabel(text);
			Review.setSize(new Dimension(370, 120));
			panel.add(Review);
		}	
		
		res_panel = new Panel();
		res_panel.setBackground(new Color(255, 192, 203));
		res_panel.setBounds(10, 120, 444, 570);
		
		div_panel.add(res_panel);
		res_panel.setLayout(null);

		res_detail = new Panel();
		res_detail.setBackground(new Color(255, 255, 255));
		res_detail.setBounds(10, 10, 424, 550);
		res_panel.add(res_detail);
		res_detail.setLayout(null);
=======
	}
>>>>>>> 2b71e7bf42462320e29acf7933189604ed7bd39c

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage frame = new MyPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
