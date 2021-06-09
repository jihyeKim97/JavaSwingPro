package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.RoundedButtonD;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Ad_AdPage_DB;
import template.Application.controller.DB.DB_Connect;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.DB.Review_DB;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Review_Data;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class Movie_Informaiton extends JFrame {

	JPanel contentPane;
	Panel content_panel;
	Panel div_panel;
	Panel mem_panel;
	Panel mem_detail;
	RoundedButtonD btn_edit;
	Panel txt_panel;
	JLabel lb_name;
	JLabel lb_ld;
	JLabel lb_phone;
	JLabel lb_bir;
	JLabel lb_cp;
	JLabel lb_np;
	JLabel lb_cnp;
	Panel txtF_panel;
	JLabel lb_gen;
	JTextField textField_1;
	JTextField textField;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JPanel pn_Poster;
	JPanel panel_1;
	JPanel panel_2;
	JScrollPane scrollPane;
	JPanel panel_7;
	JLabel lb_Title;
	JLabel lb_MVTitle;
	JLabel lb_Directer;
	JLabel lb_MVDirecter;
	JLabel lb_Genre;
	JLabel lb_MVGenre;
	JLabel lb_Rate;
	JLabel lb_MVRate;
	JLabel lb_producte;
	JLabel lb_MVProducte;
	JLabel lb_Age;
	JLabel lb_MVAge;
	JLabel lb_Character;
	JLabel lb_MVCharacter;
	JLabel lb_Year;
	JLabel lb_MVYear;
	JLabel lb_MovieDate;
	JLabel lb_Movietime;
	JLabel lb_MovieInfomaiton;
	JPanel panel_9;
	JLabel lblNewLabel_3;
	JLabel label_2;
	JPanel panel;
	JPanel panel_3;
	JPanel panel_4;
	JLabel lblNewLabel_2;
	JLabel label;
	JLabel label_1;
	JLabel label_3;
	JLabel label_4;
	JPanel panel_5;
	JPanel panel_6;

	Main refrm;
	Movie_Informaiton frm;

	ArrayList<Review_Data> ReviewList = new ArrayList<>();
	ArrayList<Review_Data> RV = new ArrayList<>();
	ArrayList<Movie_Data> MovieList = new ArrayList<>();
	ArrayList<Integer> intArr = new ArrayList<>();
	ArrayList<String> strArr = new ArrayList<>();

	Movie_Data Movie;
	DB_Connect connect;
	Login_DB LDB;
	Ad_AdPage_DB AADB = new Ad_AdPage_DB();
	Review_DB Review = new Review_DB();
	Movie_DB MDB = new Movie_DB();
	int Score = 0;

	public Movie_Informaiton(Main refrm, Movie_Data movie) {
		setResizable(false);
		this.frm = this;
		Movie_DB MDB = new Movie_DB();
		MovieList = MDB.getMovieData();
		intArr = Review.getreviewID(movie.getMoviesid());
		for (int i = 0; i < intArr.size(); i++) {
			System.out.println(intArr.get(i));
		}
		int Num = MDB.getMovieIDFromImage(movie.getImagefilename());
		ReviewList = Review.getReviewData(Num);
		int PK = 0;
		for (int i = 0; i < MovieList.size(); i++) {
			if (MovieList.get(i).getMoviesid() == Num)
				PK = i;
		}
		String dummyDate = "" + MovieList.get(PK).getScheduledate();
		String[] date = dummyDate.split("-");

		int itime = 17 + (2 * MovieList.get(PK).getScheduletime());
		String time = "";
		if (itime > 24) {
			time = "" + (itime - 24);
		} else {
			time = "" + itime;
		}
		Score = Review.starscore(movie.getMoviesid());
		RV = Review.getReviewData(movie.getMoviesid());
		if (RV.size() > 0) {
			double A = (double) Score / (double) RV.size();
			System.out.println("평균" + A);
			MDB.changeScore(A, movie.getMoviesid());
			MovieList.get(PK).setAverageScore(A);
		}
		setTitle("Vehicle Outdoor Cinema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 752);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		content_panel = new Panel();
		content_panel.setBackground(new Color(255, 255, 255));
		content_panel.setBounds(0, 55, 494, 665);
		contentPane.add(content_panel);
		content_panel.setLayout(null);

		div_panel = new Panel();
		div_panel.setBackground(new Color(70, 114, 42));
		div_panel.setBounds(0, 0, 494, 420);
		content_panel.add(div_panel);
		div_panel.setLayout(null);

		pn_Poster = new JPanel();
		pn_Poster.setBounds(10, 10, 187, 232);
		div_panel.add(pn_Poster);
		pn_Poster.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel();
		ImageIcon ic = new ImageIcon(Main.class.getResource(MovieList.get(PK).getImagefilename()));
		Image icImg = ic.getImage().getScaledInstance(187, 232, Image.SCALE_SMOOTH);
		ic.setImage(icImg);
		lblNewLabel.setIcon(ic);
		lblNewLabel.repaint();
		pn_Poster.add(lblNewLabel, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 114, 42));
		panel_1.setBounds(204, 10, 278, 35);
		div_panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		lblNewLabel_3 = new JLabel("상영날짜 : ");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		lb_MovieDate = new JLabel(date[1] + "/" + date[2]);
		lb_MovieDate.setForeground(new Color(255, 255, 255));
		lb_MovieDate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		panel_1.add(lb_MovieDate);

		label_2 = new JLabel("상영시간 : ");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);

		lb_Movietime = new JLabel(time + ":00");
		lb_Movietime.setForeground(new Color(255, 255, 255));
		lb_Movietime.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		panel_1.add(lb_Movietime);

		panel_7 = new JPanel();
		panel_7.setBounds(205, 50, 277, 192);
		div_panel.add(panel_7);
		panel_7.setBackground(Color.WHITE);
		panel_7.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 97, 192);
		panel.setBackground(new Color(70, 114, 42));
		panel_7.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		lb_Title = new JLabel("제목 : ");
		lb_Title.setForeground(new Color(255, 255, 255));
		panel.add(lb_Title);
		lb_Title.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Title.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_Genre = new JLabel("장르 : ");
		lb_Genre.setForeground(new Color(255, 255, 255));
		panel.add(lb_Genre);
		lb_Genre.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Genre.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_Directer = new JLabel("감독 : ");
		lb_Directer.setForeground(new Color(255, 255, 255));
		panel.add(lb_Directer);
		lb_Directer.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Directer.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_Age = new JLabel("연령등급 : ");
		lb_Age.setForeground(new Color(255, 255, 255));
		panel.add(lb_Age);
		lb_Age.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Age.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_Character = new JLabel("등장인물 : ");
		lb_Character.setForeground(new Color(255, 255, 255));
		panel.add(lb_Character);
		lb_Character.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Character.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_Year = new JLabel("개봉일 : ");
		lb_Year.setForeground(new Color(255, 255, 255));
		panel.add(lb_Year);
		lb_Year.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Year.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_producte = new JLabel("제작사 : ");
		lb_producte.setForeground(new Color(255, 255, 255));
		panel.add(lb_producte);
		lb_producte.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_producte.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		JLabel lb_Runningtime = new JLabel("영화 상영 시간 : ");
		lb_Runningtime.setForeground(new Color(255, 255, 255));
		panel.add(lb_Runningtime);
		lb_Runningtime.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Runningtime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		panel_3 = new JPanel();
		panel_3.setBounds(96, 0, 181, 192);
		panel_3.setBackground(new Color(70, 114, 42));
		panel_7.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		lb_MVTitle = new JLabel(MovieList.get(PK).getTitle());
		lb_MVTitle.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVTitle);
		lb_MVTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVTitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVGenre = new JLabel(MovieList.get(PK).getGenre());
		lb_MVGenre.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVGenre);
		lb_MVGenre.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVGenre.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVDirecter = new JLabel(MovieList.get(PK).getDirector());
		lb_MVDirecter.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVDirecter);
		lb_MVDirecter.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVDirecter.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVAge = new JLabel("" + MovieList.get(PK).getAgegroup());
		lb_MVAge.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVAge);
		lb_MVAge.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVAge.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVCharacter = new JLabel(MovieList.get(PK).getGee());
		lb_MVCharacter.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVCharacter);
		lb_MVCharacter.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVCharacter.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVYear = new JLabel("" + MovieList.get(PK).getOpendate());
		lb_MVYear.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVYear);
		lb_MVYear.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVYear.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MVProducte = new JLabel(MovieList.get(PK).getProduction());
		lb_MVProducte.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVProducte);
		lb_MVProducte.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVProducte.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		JLabel lb_MVRunningTime = new JLabel(MovieList.get(PK).getRunningtime());
		lb_MVRunningTime.setForeground(new Color(255, 255, 255));
		panel_3.add(lb_MVRunningTime);
		lb_MVRunningTime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lb_MVRunningTime.setHorizontalAlignment(SwingConstants.LEFT);

		panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBounds(10, 252, 473, 158);
		div_panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JTextArea txtrAsd = new JTextArea();
		txtrAsd.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtrAsd.setText(MovieList.get(PK).getStory());
		txtrAsd.setEditable(false);
		txtrAsd.setLineWrap(true);
		scrollPane.setViewportView(txtrAsd);

		panel_9 = new JPanel();
		panel_9.setBounds(12, 466, 472, 182);
		content_panel.add(panel_9);
		panel_9.setLayout(null);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(12, 426, 164, 30);
		content_panel.add(panel_5);
		panel_5.setLayout(null);

		lb_Rate = new JLabel("별점 : ");
		lb_Rate.setBackground(new Color(255, 255, 255));
		lb_Rate.setBounds(0, 0, 48, 30);
		panel_5.add(lb_Rate);
		lb_Rate.setForeground(new Color(0, 0, 0));
		lb_Rate.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Rate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		panel_4 = new JPanel();
		panel_4.setBounds(43, 0, 121, 30);
		panel_5.add(panel_4);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		double star = Math.round(MovieList.get(PK).getAverageScore());
		String S = "star0.PNG";
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		if (star >= 1)
			S = "star (1).png";
		lblNewLabel_2.setIcon(new ImageIcon(Movie_Informaiton.class.getResource("/template/Reference/icons/" + S)));
		S = "star0.PNG";
		panel_4.add(lblNewLabel_2);

		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		if (star >= 2)
			S = "star (1).png";
		label_1.setIcon(new ImageIcon(Movie_Informaiton.class.getResource("/template/Reference/icons/" + S)));
		S = "star0.PNG";
		panel_4.add(label_1);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if (star >= 3)
			S = "star (1).png";
		label.setIcon(new ImageIcon(Movie_Informaiton.class.getResource("/template/Reference/icons/" + S)));
		S = "star0.PNG";
		panel_4.add(label);

		label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		if (star >= 4)
			S = "star (1).png";
		label_3.setIcon(new ImageIcon(Movie_Informaiton.class.getResource("/template/Reference/icons/" + S)));
		S = "star0.PNG";
		panel_4.add(label_3);

		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		if (star >= 5)
			S = "star (1).png";
		label_4.setIcon(new ImageIcon(Movie_Informaiton.class.getResource("/template/Reference/icons/" + S)));
		S = "star0.PNG";
		panel_4.add(label_4);

		lb_MVRate = new JLabel("" + MovieList.get(PK).getAverageScore());
		lb_MVRate.setBounds(188, 426, 75, 30);
		content_panel.add(lb_MVRate);
		lb_MVRate.setForeground(new Color(0, 0, 0));
		lb_MVRate.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MVRate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		lb_MovieInfomaiton = new JLabel("내용");
		lb_MovieInfomaiton.setBounds(262, 321, 232, 40);
		contentPane.add(lb_MovieInfomaiton);
		lb_MovieInfomaiton.setFont(new Font("굴림", Font.BOLD, 20));
		lb_MovieInfomaiton.setHorizontalAlignment(SwingConstants.CENTER);

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(211, 211, 211));
		panel_6.setBounds(0, 0, 494, 55);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		RoundedButtonR roundedButtonD = new RoundedButtonR("HOME");
		roundedButtonD.setBounds(10, 10, 93, 35);
		panel_6.add(roundedButtonD);
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));

		for (int i = 0; i < ReviewList.size(); i++) { // 리뷰 개수
			Review = new Review_DB();
			strArr.add(Review.getid(intArr.get(i)));
			JPanel panel_8 = new JPanel();
			panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_8.setBounds(10, (10 * (i + 1)) + (50 * i), 452, 50);
			panel_9.add(panel_8);
			panel_8.setLayout(null);

			JLabel lb_reviewID = new JLabel(strArr.get(i));
			lb_reviewID.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lb_reviewID.setBounds(10, 5, 110, 15);
			panel_8.add(lb_reviewID);

			JLabel lb_reviewcontent = new JLabel(ReviewList.get(i).getContent());
			lb_reviewcontent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lb_reviewcontent.setBounds(10, 30, 430, 15);
			panel_8.add(lb_reviewcontent);

			JLabel lb_reviewdate = new JLabel("" + ReviewList.get(i).getReviewdate());
			lb_reviewdate.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_reviewdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lb_reviewdate.setBounds(330, 6, 110, 15);
			panel_8.add(lb_reviewdate);
		}

	}
}
