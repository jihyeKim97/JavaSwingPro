package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.net.www.content.image.jpeg;
import template.Application.controller.RoundedButtonD;
import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.RoundedButtonY;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class MyPage extends JFrame {

	private JPanel contentPane;
	private final Panel header_panel = new Panel();
	private RoundedButtonD btn_home;
	private Panel content_panel;
	private Panel div_panel;
	private Panel title_panel;
	private JLabel lb_title;
	private JButton btnMember;
	private JButton btnReservation;
	private JButton btnReview;
	private Panel tab_panel;
	private final Panel re_panel = new Panel();
	private Panel mem_panel;
	private Panel res_panel;
	private Panel mem_detail;
	private Panel re_detail;
	private Panel res_detail;
	private RoundedButtonD btn_edit;
	private Panel txt_panel;
	private JLabel lb_name;
	private JLabel lb_ld;
	private JLabel lb_phone;
	private JLabel lb_bir;
	private JLabel lb_cp;
	private JLabel lb_np;
	private JLabel lb_cnp;
	private Panel txtF_panel;
	private JLabel lb_gen;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MyPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		header_panel.setBackground(new Color(169, 169, 169));
		header_panel.setBounds(0, 0, 484, 55);
		contentPane.add(header_panel);
		header_panel.setLayout(null);

		RoundedButtonD btn_logout = new RoundedButtonD("LOGOUT");
		btn_logout.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_logout.setBounds(12, 10, 100, 35);
		header_panel.add(btn_logout);

		btn_home = new RoundedButtonD("HOME");
		btn_home.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_home.setBounds(320, 10, 100, 35);
		header_panel.add(btn_home);

		RoundedButtonD btn_myPage = new RoundedButtonD("HOME");
		btn_myPage.setText("=");
		btn_myPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_myPage.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_myPage.setBounds(430, 10, 41, 35);
		header_panel.add(btn_myPage);

		content_panel = new Panel();
		content_panel.setBackground(new Color(255, 255, 255));
		content_panel.setBounds(0, 55, 484, 705);
		contentPane.add(content_panel);
		content_panel.setLayout(null);

		div_panel = new Panel();
		div_panel.setBackground(new Color(255, 255, 255));
		div_panel.setBounds(10, 0, 464, 705);
		content_panel.add(div_panel);
		div_panel.setLayout(null);

		title_panel = new Panel();
		title_panel.setBackground(new Color(255, 255, 255));
		title_panel.setBounds(10, 16, 444, 55);
		div_panel.add(title_panel);
		title_panel.setLayout(new BorderLayout(0, 0));

		lb_title = new JLabel("Member");
		lb_title.setBackground(new Color(255, 255, 255));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("SansSerif", Font.BOLD, 35));
		title_panel.add(lb_title, BorderLayout.CENTER);

		tab_panel = new Panel();
		tab_panel.setBackground(Color.LIGHT_GRAY);
//		tab_panel.setBackground(SystemColor.controlShadow);
		tab_panel.setBounds(10, 77, 444, 45);
		div_panel.add(tab_panel);
		tab_panel.setLayout(new GridLayout(0, 3, 0, 0));

		btnMember = new JButton("Member");
		btnMember.setBackground(Color.LIGHT_GRAY);
		btnMember.setFont(new Font("SansSerif", Font.BOLD, 15));
//		btnMember.setBorderPainted(false);
//		btnMember.setContentAreaFilled(false);
//		btnMember.setFocusPainted(false);
		tab_panel.add(btnMember);
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(true);
				re_panel.setVisible(false);
				res_panel.setVisible(false);
				mem_detail.setVisible(true);
				re_detail.setVisible(false);
				res_detail.setVisible(false);
				lb_title.setText("Member");
			}
		});
		
		btnReservation = new JButton("Reservation");
		btnReservation.setBackground(Color.LIGHT_GRAY);
		btnReservation.setFont(new Font("SansSerif", Font.BOLD, 15));
//		btnReservation.setBorderPainted(false);
//		btnReservation.setContentAreaFilled(false);
//		btnReservation.setFocusPainted(false);
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
				re_panel.setVisible(false);
				res_panel.setVisible(true);
				mem_detail.setVisible(false);
				re_detail.setVisible(false);
				res_detail.setVisible(true);
				lb_title.setText("Reservation");
			}
		});
		tab_panel.add(btnReservation);

		btnReview = new JButton("Review");
		btnReview.setBackground(Color.LIGHT_GRAY);
		btnReview.setFont(new Font("SansSerif", Font.BOLD, 15));
//		btnReview.setBorderPainted(false);
//		btnReview.setContentAreaFilled(false);
//		btnReview.setFocusPainted(false);
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
				re_panel.setVisible(true);
				res_panel.setVisible(false);
				mem_detail.setVisible(false);
				re_detail.setVisible(true);
				res_detail.setVisible(false);
				lb_title.setText("Review");
			}
		});
		mem_panel = new Panel();
		mem_panel.setBackground(new Color(255, 228, 196));
		mem_panel.setBounds(10, 120, 444, 570);
//		div_panel.add(mem_panel);
		mem_panel.setLayout(null);

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

	}
}
