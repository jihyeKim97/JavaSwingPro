package template.Application.view.admin;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import java.awt.Color;
	import java.awt.Dimension;

import template.Application.controller.DB.DB_Connect;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.DB.Review_DB;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Review_Data;
import template.Application.controller.btn.RoundedButtonD;
import template.Application.view.Main;

import javax.swing.JButton;
	import javax.swing.SwingConstants;
	import java.awt.GridLayout;
	import java.awt.Panel;
	import java.awt.event.ActionListener;
	import java.sql.Date;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.awt.event.ActionEvent;
	import javax.swing.UIManager;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

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
	import javax.swing.ImageIcon;
	import javax.swing.JTextArea;
	import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

	public class Admin_Movie_Info extends JFrame {

			
		private JPanel contentPane;
		private final Panel header_panel = new Panel();
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
		private JPanel pn_Poster;
		private JPanel panel_1;
		private JLabel lb_MovieTime;
		private JPanel panel_2;
		private JScrollPane scrollPane;
		private JPanel pn_MovieStoryTitle;
		private JLabel lblNewLabel_1;
		private JPanel pn_MovieFirstTime;
		private JPanel panel_4;
		private JPanel panel_7;
		private JLabel lb_Title;
		private JLabel lb_Directer;
		private JLabel lb_Genre;
		private JLabel lb_Rate;
		private JLabel lb_producte;
		private JLabel lb_Age;
		private JLabel lb_Character;
		private JLabel lb_Year;
		private JLabel lblNewLabel_3;
		private JLabel lb_Movietime;
		private JLabel lb_MovieTitle;
		private JLabel lb_MovieInfomaiton;
		private JPanel panel_9;
		private JScrollPane scrollPane_1;
		private JPanel pn_Review;

		DB_Connect connect;
		Movie_Data Movie;
		ArrayList<Movie_Data> MovieList = new ArrayList<>();
		Main refrm;
		Admin_Movie_Info frm;
		ArrayList<Review_Data> ReviewList = new ArrayList<>();
		Review_DB Review;
		private JTextField ad_txt_Title;
		private JTextField ad_txt_genre;
		private JTextField textField_10;
		private JTextField textField_11;
		private JTextField textField_12;
		private JTextField textField_13;
		private JTextField textField_14;
		private JTextField textField_15;
		private JTextField textField_16;

		
		public Admin_Movie_Info() {
//			this.conn = DB_Connect.getConn();
			this(null, null);
		}
		public Admin_Movie_Info(Main refrm, Movie_Data movie) {
			setResizable(false);
			this.frm = this;
			Movie_DB MDB= new Movie_DB();
			MovieList = MDB.getMovieData();
			int Num = MDB.getMovieIDFromImage(movie.getImagefilename());
			ReviewList = Review.getReviewData(Num);
			int PK = 0;
			for (int i = 0; i < MovieList.size(); i++) {
				if ( MovieList.get(i).getMoviesid() == Num )
					PK = i;
			}
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 500, 850);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			header_panel.setBackground(new Color(169, 169, 169));
			header_panel.setBounds(0, 0, 484, 55);
			contentPane.add(header_panel);
			header_panel.setLayout(null);
			
			RoundedButtonD roundedButtonD = new RoundedButtonD("HOME");
			roundedButtonD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			roundedButtonD.setFont(new Font("Candara Light", Font.PLAIN, 20));
			roundedButtonD.setBounds(12, 10, 100, 35);
			header_panel.add(roundedButtonD);

			content_panel = new Panel();
			content_panel.setBackground(new Color(255, 255, 255));
			content_panel.setBounds(0, 55, 484, 950);
			contentPane.add(content_panel);
			content_panel.setLayout(null);

			div_panel = new Panel();
			div_panel.setBackground(Color.BLACK);
			div_panel.setBounds(10, 0, 464, 260);
			content_panel.add(div_panel);
			div_panel.setLayout(null);

			pn_Poster = new JPanel();
			pn_Poster.setBounds(10, 10, 180, 240);
			div_panel.add(pn_Poster);
			pn_Poster.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("" + MovieList.get(PK).getImagefilename()));
			pn_Poster.add(lblNewLabel, BorderLayout.CENTER);

			panel_1 = new JPanel();
			panel_1.setBounds(204, 10, 250, 35);
			div_panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			lb_MovieTime = new JLabel("   NO       상영날자     상영시간");
			lb_MovieTime.setFont(new Font("굴림", Font.BOLD, 15));
			panel_1.add(lb_MovieTime, BorderLayout.CENTER);

			panel_2 = new JPanel();
			panel_2.setBounds(204, 102, 250, 148);
			div_panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));

			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane, BorderLayout.CENTER);

			pn_MovieStoryTitle = new JPanel();
			pn_MovieStoryTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
			scrollPane.setColumnHeaderView(pn_MovieStoryTitle);

			lblNewLabel_1 = new JLabel("줄거리");
			pn_MovieStoryTitle.add(lblNewLabel_1);
			
			JTextArea txtrAsd = new JTextArea();
			txtrAsd.setText(MovieList.get(PK).getStory());
			txtrAsd.setEditable(false);
			txtrAsd.setLineWrap(true);
			scrollPane.setViewportView(txtrAsd);

			pn_MovieFirstTime = new JPanel();
			pn_MovieFirstTime.setBounds(204, 57, 250, 35);
			div_panel.add(pn_MovieFirstTime);
			pn_MovieFirstTime.setLayout(null);

			lblNewLabel_3 = new JLabel("1");
			lblNewLabel_3.setBounds(23, 10, 20, 15);
			pn_MovieFirstTime.add(lblNewLabel_3);

			lb_Movietime = new JLabel("20:10");
			lb_Movietime.setBounds(184, 10, 40, 15);
			pn_MovieFirstTime.add(lb_Movietime);
			
			JComboBox ad_combo_scheduleDate = new JComboBox();
			ad_combo_scheduleDate.setBounds(69, 6, 78, 23);
			pn_MovieFirstTime.add(ad_combo_scheduleDate);
			
			JComboBox ad_combo_scheduleTime = new JComboBox();
			ad_combo_scheduleTime.setBounds(159, 6, 79, 23);
			pn_MovieFirstTime.add(ad_combo_scheduleTime);

			panel_4 = new JPanel();
			panel_4.setBounds(10, 266, 464, 360);
			content_panel.add(panel_4);
			panel_4.setLayout(null);

			panel_7 = new JPanel();
			panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_7.setBounds(0, 40, 464, 320);
			panel_4.add(panel_7);
			panel_7.setLayout(new GridLayout(9, 2, 0, 0));

			lb_Title = new JLabel("제목");
			lb_Title.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Title.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Title);
			
			ad_txt_Title = new JTextField();
			panel_7.add(ad_txt_Title);
			ad_txt_Title.setColumns(10);

			lb_Genre = new JLabel("장르");
			lb_Genre.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Genre.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Genre);
			
			ad_txt_genre = new JTextField();
			ad_txt_genre.setColumns(10);
			panel_7.add(ad_txt_genre);

			lb_Directer = new JLabel("감독");
			lb_Directer.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Directer.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Directer);
			
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			panel_7.add(textField_10);

			lb_Age = new JLabel("연령등급");
			lb_Age.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Age.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Age);
			
			textField_11 = new JTextField();
			panel_7.add(textField_11);
			textField_11.setColumns(10);

			lb_Rate = new JLabel("별점");
			lb_Rate.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Rate.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Rate);
			
			textField_12 = new JTextField();
			panel_7.add(textField_12);
			textField_12.setColumns(10);

			lb_Character = new JLabel("등장인물");
			lb_Character.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Character.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Character);
			
			textField_13 = new JTextField();
			panel_7.add(textField_13);
			textField_13.setColumns(10);

			lb_Year = new JLabel("개봉일");
			lb_Year.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Year.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Year);
			
			textField_14 = new JTextField();
			panel_7.add(textField_14);
			textField_14.setColumns(10);

			lb_producte = new JLabel("제작사");
			lb_producte.setHorizontalAlignment(SwingConstants.CENTER);
			lb_producte.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_producte);
			
			textField_15 = new JTextField();
			panel_7.add(textField_15);
			textField_15.setColumns(10);

			JLabel lb_Runningtime = new JLabel("영화 상영 시간");
			lb_Runningtime.setHorizontalAlignment(SwingConstants.CENTER);
			lb_Runningtime.setFont(new Font("Dialog", Font.PLAIN, 15));
			panel_7.add(lb_Runningtime);
			
			textField_16 = new JTextField();
			panel_7.add(textField_16);
			textField_16.setColumns(10);

			lb_MovieTitle = new JLabel("영화 정보");
			lb_MovieTitle.setFont(new Font("굴림", Font.BOLD, 20));
			lb_MovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lb_MovieTitle.setBounds(0, 0, 232, 40);
			panel_4.add(lb_MovieTitle);

			lb_MovieInfomaiton = new JLabel("내용");
			lb_MovieInfomaiton.setFont(new Font("굴림", Font.BOLD, 20));
			lb_MovieInfomaiton.setHorizontalAlignment(SwingConstants.CENTER);
			lb_MovieInfomaiton.setBounds(232, 0, 232, 40);
			panel_4.add(lb_MovieInfomaiton);

			panel_9 = new JPanel();
			panel_9.setBounds(10, 634, 464, 118);
			content_panel.add(panel_9);
			panel_9.setLayout(new BorderLayout(0, 0));

			scrollPane_1 = new JScrollPane();
			panel_9.add(scrollPane_1, BorderLayout.CENTER);

			pn_Review = new JPanel();
			scrollPane_1.setViewportView(pn_Review);
			pn_Review.setLayout(new GridLayout(0, 1, 0, 0));
			mem_panel = new Panel();
			mem_panel.setBackground(new Color(255, 228, 196));
			mem_panel.setBounds(10, 120, 444, 570);
//			div_panel.add(mem_panel);
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

			for (int i = 0; i < ReviewList.size(); i++) { // 리뷰 개수
				String text = ReviewList.get(i).getContent();
				JLabel Review = new JLabel(text);
				Review.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
				Review.setSize(new Dimension(400, 50));
				pn_Review.add(Review);
			}

		}
	}
