package template.Application.view.member;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import template.Application.controller.DB.Main_Movie_DB;

import template.Application.controller.DB.Movie_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.btn.RoundedButtonD;
import template.Application.controller.btn.RoundedButtonG;
import template.Application.controller.btn.RoundedButtonR;
import template.Application.controller.btn.RoundedButtonY;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;

public class Main extends JFrame {

	JPanel contentPane;
	final Panel header_panel = new Panel();
	Panel mainPanel;
	Panel main_panel;
	Panel title_panel;
	final Panel cpn_panel = new Panel();
	Panel mem_panel;
	Panel mem_detail;
	Panel screening_panel;
	RoundedButtonD btn_edit;
	Panel txt_panel;
	Panel txtF_panel;
	JTextField textField_1;
	JTextField textField;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JLabel lblNewLabel;
	Panel released_panel;
	RoundedButtonR btn_notice;
	JLabel lb_title1;
	JLabel lb_title2;
	Panel screen_guid_line;
	Panel panel_10;
	Main reserfrm;
	ArrayList<Movie_Data> toDayMovieList;
	ArrayList<Movie_Data> notToDayMovieList;
	Movie_Data movie;
	JLabel lb_month;
	JLabel lb_date;
	JLabel label_2;
	Main main;
	static Login Lg;
	static Login_data Ld;
	private JPanel panel;
	private JLabel label;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(Lg, Ld);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main(Login Lg, Login_data Ld) {
		this.main = this;

		Main_Movie_DB MDB = new Main_Movie_DB();

		this.reserfrm = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		header_panel.setBackground(new Color(211, 211, 211));
		header_panel.setBounds(0, 0, 484, 55);
		contentPane.add(header_panel);
		header_panel.setLayout(null);

		RoundedButtonG btn_my = new RoundedButtonG("MYPAGE");
		btn_my.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn_my.setBounds(372, 10, 100, 35);
		btn_my.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage mypage = new MyPage(reserfrm);
				Point fPt = reserfrm.getLocationOnScreen();
				mypage.setLocation(fPt.x + reserfrm.getWidth() + 20, fPt.y);
				mypage.setVisible(true);
			}
		});

		header_panel.add(btn_my);

		mainPanel = new Panel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 55, 484, 705);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		main_panel = new Panel();
		main_panel.setBackground(new Color(255, 255, 255));
		main_panel.setBounds(10, 0, 464, 705);
		mainPanel.add(main_panel);
		main_panel.setLayout(null);
		title_panel = new Panel();
		title_panel.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		title_panel.setBackground(new Color(255, 255, 255));
		title_panel.setBounds(10, 16, 444, 50);
		main_panel.add(title_panel);

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
//		int year = 2020;
//		int month = 6;
//		int day = 2;
		title_panel.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(83, 0, 267, 50);
		title_panel.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("2020");
		lblNewLabel.setBounds(0, 0, 128, 50);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Ebrima", Font.PLAIN, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { btn_my, contentPane, header_panel, mainPanel, main_panel,
						title_panel, lblNewLabel, cpn_panel, screening_panel, lb_title1, screen_guid_line }));

		label = new JLabel("/");
		label.setBounds(100, 0, 47, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ebrima", Font.PLAIN, 38));
		panel.add(label);

		lb_month = new JLabel("" + month);
		lb_month.setBounds(135, 0, 47, 50);
		panel.add(lb_month);
		lb_month.setHorizontalAlignment(SwingConstants.CENTER);
		lb_month.setFont(new Font("Ebrima", Font.PLAIN, 38));

		label_2 = new JLabel("/");
		label_2.setBounds(171, 0, 47, 50);
		panel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Ebrima", Font.PLAIN, 38));

		lb_date = new JLabel("" + day);
		lb_date.setBounds(212, 0, 55, 50);
		panel.add(lb_date);
		lb_date.setHorizontalAlignment(SwingConstants.CENTER);
		lb_date.setFont(new Font("Ebrima", Font.PLAIN, 38));

		try {
			toDayMovieList = MDB.TodayMovie(month, day);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			notToDayMovieList = MDB.notTodayMovie(month, day);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		mem_panel = new Panel();
		mem_panel.setBackground(new Color(255, 228, 196));
		mem_panel.setBounds(10, 120, 444, 570);
		mem_panel.setLayout(null);

		mem_detail = new Panel();
		mem_detail.setBackground(new Color(255, 255, 255));
		mem_detail.setBounds(10, 10, 424, 550);
		mem_panel.add(mem_detail);
		mem_detail.setLayout(null);
		mem_panel.setVisible(false);
		btn_edit = new RoundedButtonD("Edit");
		btn_edit.setFont(new Font("Candara Light", Font.PLAIN, 20));
		btn_edit.setBounds(162, 505, 100, 35);
		mem_detail.add(btn_edit);

		txt_panel = new Panel();
		txt_panel.setBounds(0, 0, 162, 462);
		mem_detail.add(txt_panel);
		txt_panel.setLayout(new GridLayout(0, 1, 0, 0));

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
		cpn_panel.setBackground(Color.WHITE);
		cpn_panel.setBounds(10, 77, 444, 613);
		main_panel.add(cpn_panel);
		cpn_panel.setLayout(null);

		screening_panel = new Panel();
		screening_panel.setBackground(new Color(255, 255, 255));
		screening_panel.setBounds(10, 10, 424, 210);
		cpn_panel.add(screening_panel);
		screening_panel.setLayout(null);

		lb_title1 = new JLabel("상영중인 영화");
		lb_title1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_title1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title1.setBounds(0, 0, 424, 39);
		screening_panel.add(lb_title1);

		screen_guid_line = new Panel();
		screen_guid_line.setBounds(0, 39, 424, 171);
		screening_panel.add(screen_guid_line);
		screen_guid_line.setLayout(null);

		for (int i = 0; i < 4; i++) {

			JPanel MoviePoster = new JPanel();
			MoviePoster.setLayout(new BorderLayout());
			MoviePoster.setBounds(10 * (i + 1) + 94 * i, 10, 94, 121);
			JLabel Poster = new JLabel();
			MoviePoster.add(Poster, BorderLayout.CENTER);
			Movie_Data movie = toDayMovieList.get(i);
			screen_guid_line.add(MoviePoster);
			Poster.setIcon(new ImageIcon("." + toDayMovieList.get(i).getImagefilename()));
			Poster.repaint();
			Poster.setBackground(new Color(0, 0, 150));
			MoviePoster.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Movie_Informaiton MI = new Movie_Informaiton(reserfrm, movie);
					Point fPt = reserfrm.getLocationOnScreen();
					MI.setLocation(fPt.x + reserfrm.getWidth() + 20, fPt.y);
					MI.setVisible(true);

				}
			});
			RoundedButtonY btn_poster_1 = new RoundedButtonY("click");
			btn_poster_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			btn_poster_1.setBounds(10 * (i + 1) + 94 * i, 141, 94, 30);
			screen_guid_line.add(btn_poster_1);
			btn_poster_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Reservation_step1 reser1 = new Reservation_step1(reserfrm, movie, Ld);
					Point fPt = reserfrm.getLocationOnScreen();
					reser1.setLocation(fPt.x + reserfrm.getWidth() + 20, fPt.y);
					reser1.setVisible(true);
				}
			});
		}

		released_panel = new Panel();
		released_panel.setLayout(null);
		released_panel.setBackground(Color.WHITE);
		released_panel.setBounds(10, 226, 424, 309);
		cpn_panel.add(released_panel);

		lb_title2 = new JLabel("개봉예정 영화");
		lb_title2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb_title2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title2.setBounds(0, 0, 424, 44);
		released_panel.add(lb_title2);

		panel_10 = new Panel();
		panel_10.setBounds(0, 43, 423, 265);
		released_panel.add(panel_10);
		panel_10.setLayout(null);

		for (int i = 0; i < 8; i++) {
			JPanel MoviePoster = new JPanel();
			MoviePoster.setLayout(new BorderLayout());
			JLabel Poster = new JLabel();
			MoviePoster.add(Poster, BorderLayout.CENTER);
			Movie_Data movie = notToDayMovieList.get(i);
			panel_10.add(MoviePoster);
			if (i < 4) {
				MoviePoster.setBounds(10 * (i + 1) + 94 * i, 0, 94, 125);
			} else {
				MoviePoster.setBounds(10 * (i - 3) + 94 * (i - 4), 135, 94, 125);
			}
			Poster.setIcon(new ImageIcon("." + notToDayMovieList.get(i).getImagefilename()));
			Poster.setBackground(new Color(0, 0, 150));
			Poster.repaint();
			MoviePoster.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Movie_Informaiton MI = new Movie_Informaiton(reserfrm, movie);
					Point fPt = reserfrm.getLocationOnScreen();
					MI.setLocation(fPt.x + reserfrm.getWidth() + 20, fPt.y);
					MI.setVisible(true);

				}
			});
		}

		btn_notice = new RoundedButtonR("notice");
		btn_notice.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn_notice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notice noti = new Notice(reserfrm);
				Point fPt = reserfrm.getLocationOnScreen();
				noti.setLocation(fPt.x + reserfrm.getWidth() + 20, fPt.y);
				noti.setVisible(true);
			}
		});
		btn_notice.setBounds(10, 543, 424, 60);
		cpn_panel.add(btn_notice);
		cpn_panel.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { lb_title1, screening_panel, screen_guid_line }));

	}
}
