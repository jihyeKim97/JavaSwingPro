package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.border.LineBorder;

public class Movie_Informaiton extends JFrame {

	private JPanel contentPane;
	private final Panel header_panel = new Panel();
	private RoundedButtonD btn_home;
	private Panel content_panel;
	private Panel div_panel;
	private Panel mem_panel;
	private Panel mem_detail;
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
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;
	private JPanel panel_6;
	private JPanel panel_4;
	private JPanel panel_7;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JPanel panel_8;
	private JLabel lblNewLabel_3;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel lblNewLabel_4;
	private JLabel label_21;
	private JPanel panel_9;
	private JScrollPane scrollPane_1;
	private JPanel panel_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movie_Informaiton frame = new Movie_Informaiton();
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
	public Movie_Informaiton() {
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
		content_panel.setBounds(0, 55, 484, 698);
		contentPane.add(content_panel);
		content_panel.setLayout(null);

		div_panel = new Panel();
		div_panel.setBackground(Color.BLACK);
		div_panel.setBounds(10, 0, 464, 260);
		content_panel.add(div_panel);
		div_panel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 180, 240);
		div_panel.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(204, 10, 250, 35);
		div_panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("   NO       상영날자     상영시간");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBounds(204, 150, 250, 100);
		div_panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		scrollPane.setColumnHeaderView(panel_3);
		
		lblNewLabel_1 = new JLabel("줄거리");
		panel_3.add(lblNewLabel_1);
		
		panel_5 = new JPanel();
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("영화 줄거리");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		panel_5.add(lblNewLabel_2, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		panel_6.setBounds(204, 57, 250, 35);
		div_panel.add(panel_6);
		panel_6.setLayout(null);
		
		lblNewLabel_3 = new JLabel("1");
		lblNewLabel_3.setBounds(23, 10, 20, 15);
		panel_6.add(lblNewLabel_3);
		
		label_16 = new JLabel("05/21");
		label_16.setBounds(95, 10, 40, 15);
		panel_6.add(label_16);
		
		label_19 = new JLabel("20:10");
		label_19.setBounds(184, 8, 40, 15);
		panel_6.add(label_19);
		
		panel_8 = new JPanel();
		panel_8.setBounds(204, 105, 250, 35);
		div_panel.add(panel_8);
		panel_8.setLayout(null);
		
		label_17 = new JLabel("2");
		label_17.setBounds(23, 10, 20, 15);
		panel_8.add(label_17);
		
		label_18 = new JLabel("05/21");
		label_18.setBounds(95, 10, 40, 15);
		panel_8.add(label_18);
		
		label_20 = new JLabel("23:30");
		label_20.setBounds(184, 8, 40, 15);
		panel_8.add(label_20);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 266, 464, 290);
		content_panel.add(panel_4);
		panel_4.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(0, 40, 464, 250);
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(8, 2, 0, 0));
		
		label = new JLabel("제목");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label);
		
		label_1 = new JLabel("New label");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_1);
		
		label_2 = new JLabel("감독");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_3);
		
		label_4 = new JLabel("장르");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_4);
		
		label_5 = new JLabel("New label");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_5);
		
		label_6 = new JLabel("별점");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_6);
		
		label_7 = new JLabel("New label");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_7);
		
		label_8 = new JLabel("제작사");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_8);
		
		label_9 = new JLabel("New label");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_9);
		
		label_10 = new JLabel("연령등급");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_10);
		
		label_11 = new JLabel("New label");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_11);
		
		label_12 = new JLabel("등장인물");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_12);
		
		label_13 = new JLabel("New label");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_13);
		
		label_14 = new JLabel("개봉연도");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_14);
		
		label_15 = new JLabel("New label");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_7.add(label_15);
		
		lblNewLabel_4 = new JLabel("영화 정보");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 232, 40);
		panel_4.add(lblNewLabel_4);
		
		label_21 = new JLabel("내용");
		label_21.setFont(new Font("굴림", Font.BOLD, 20));
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(232, 0, 232, 40);
		panel_4.add(label_21);
		
		panel_9 = new JPanel();
		panel_9.setBounds(10, 570, 464, 118);
		content_panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_9.add(scrollPane_1, BorderLayout.CENTER);
		
		panel_10 = new JPanel();
		scrollPane_1.setViewportView(panel_10);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
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
		
		for (int i = 0; i < 30; i++) { // 리뷰 개수
			String text = "리뷰";
			JLabel Review = new JLabel(text);
			Review.setSize(new Dimension(400, 50));
			panel_10.add(Review);
		}	

	}
}
