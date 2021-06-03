package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;
import template.Application.controller.DB_Connect;
import template.Application.controller.Movie_DB;
import template.Application.controller.Movie_Data;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservation_step1 extends JFrame {

	JLabel in_movietitle,label_1,in_movietime,lblNewLabel_1,step1,lblNewLabel_2,step2,optionName,optionCount, won, sum_price_pay, txtprice,optionPrice,step3;
	RoundedButtonD btn_payment,btn_miu,btn_add,btn_delete,roundedButtonD;
	Panel header,img1, img2, img3, img4, img5,infoContent;
	JPanel infoDontent,seat_number,screen,option_add_line,seat_detail,option,optionContent,optionimgpanel,seat,contentPane,seatContent,option_add_panel,content,info;
	JComboBox car_type,option_type;
	JButton A_1, A_2, A_3, A_4, A_5, A_6, B_1, B_2, B_3, B_4, B_5, B_6, C_1, C_2, C_3, C_4, C_5, C_6, D_1, D_2, D_3,
			D_4, D_5, D_6, E_1, E_2, E_3, E_4, E_5, E_6, F_1, F_2, F_3, F_4, F_5, F_6;

	Main mainfrm;
	Reservation_step1 reserStfrm;
	DB_Connect connect;
	Movie_Data Movie;
	ArrayList<Movie_Data> MovieList = new ArrayList<>();

	public Reservation_step1(Main mainfrm, Movie_Data movie) {

		this.reserStfrm = this;
		Movie_DB MDB = new Movie_DB();
		MovieList = MDB.getMovieData();
		int Num = MDB.getMovieIDFromImage(movie.getImagefilename());
		int PK = 0;
		for (int i = 0; i < MovieList.size(); i++) {
			if (MovieList.get(i).getMoviesid() == Num)
				PK = i;
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		content = new JPanel();
		content.setBackground(new Color(211, 211, 211));
		content.setBounds(0, 55, 484, 856);
		contentPane.add(content);
		content.setLayout(null);

		info = new JPanel();
		info.setBackground(Color.LIGHT_GRAY);
		info.setBounds(0, 10, 484, 150);
		content.add(info);
		info.setLayout(null);

		infoDontent = new JPanel();
		infoDontent.setBackground(Color.LIGHT_GRAY);
		infoDontent.setBounds(10, 10, 464, 130);
		info.add(infoDontent);
		infoDontent.setLayout(null);

		step1 = new JLabel("Step1. 영화 정보");
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		step1.setBounds(0, 1, 464, 37);
		infoDontent.add(step1);
		car_type = new JComboBox();
		car_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		car_type.setModel(new DefaultComboBoxModel(new String[] { "세단, 경차", "SUV" }));
		car_type.setBounds(10, 90, 444, 37);
		infoDontent.add(car_type);

		infoContent = new Panel();
		infoContent.setBackground(new Color(211, 211, 211));
		infoContent.setBounds(10, 40, 444, 42);
		infoDontent.add(infoContent);
		infoContent.setLayout(null);

		lblNewLabel_1 = new JLabel("영화제목 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(0, 0, 80, 42);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(lblNewLabel_1); 

		in_movietitle = new JLabel(MovieList.get(PK).getTitle());
		in_movietitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietitle.setBackground(new Color(192, 192, 192));
		in_movietitle.setBounds(73, 0, 140, 42);
		in_movietitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(in_movietitle);

		label_1 = new JLabel("상영시간 : ");
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		label_1.setBackground(new Color(192, 192, 192));
		label_1.setBounds(228, 0, 80, 42);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(label_1);

		in_movietime = new JLabel("New label");
		in_movietime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietime.setBackground(new Color(192, 192, 192));
		in_movietime.setBounds(304, 0, 140, 42);
		in_movietime.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(in_movietime);

		seat = new JPanel();
		seat.setBackground(Color.LIGHT_GRAY);
		seat.setBounds(0, 170, 484, 363);
		content.add(seat);
		seat.setLayout(null);

		seatContent = new JPanel();
		seatContent.setBackground(Color.LIGHT_GRAY);
		seatContent.setBounds(10, 10, 464, 343);
		seat.add(seatContent);
		seatContent.setLayout(null);

		step2 = new JLabel("Step2. 좌석 선택");
		step2.setBounds(0, 0, 464, 37);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		seatContent.add(step2);

		seat_detail = new JPanel();
		seat_detail.setBounds(10, 36, 442, 297);
		seatContent.add(seat_detail);
		seat_detail.setLayout(null);

		screen = new JPanel();
		screen.setBackground(new Color(128, 128, 128));
		screen.setBounds(10, 0, 422, 30);
		seat_detail.add(screen);

		lblNewLabel_2 = new JLabel("SCREEN");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		screen.add(lblNewLabel_2);

		seat_number = new JPanel();
		seat_number.setBounds(10, 35, 422, 257);
		seat_detail.add(seat_number);
		seat_number.setLayout(new GridLayout(6, 6, 6, 6));

		A_1 = new JButton();
		seat_number.add(A_1);

		A_2 = new JButton();
		seat_number.add(A_2);

		A_3 = new JButton();
		seat_number.add(A_3);

		A_4 = new JButton();
		seat_number.add(A_4);

		A_5 = new JButton();
		seat_number.add(A_5);

		A_6 = new JButton();
		seat_number.add(A_6);

		B_1 = new JButton();
		seat_number.add(B_1);

		B_2 = new JButton();
		seat_number.add(B_2);

		B_3 = new JButton();
		seat_number.add(B_3);

		B_4 = new JButton();
		seat_number.add(B_4);

		B_5 = new JButton();
		seat_number.add(B_5);

		B_6 = new JButton();
		seat_number.add(B_6);

		C_1 = new JButton();
		seat_number.add(C_1);

		C_2 = new JButton();
		seat_number.add(C_2);

		C_3 = new JButton();
		seat_number.add(C_3);

		C_4 = new JButton();
		seat_number.add(C_4);

		C_5 = new JButton();
		seat_number.add(C_5);

		C_6 = new JButton();
		seat_number.add(C_6);

		D_1 = new JButton();
		seat_number.add(D_1);
		D_2 = new JButton();
		seat_number.add(D_2);

		D_3 = new JButton();
		seat_number.add(D_3);

		D_4 = new JButton();
		seat_number.add(D_4);

		D_5 = new JButton();
		seat_number.add(D_5);

		D_6 = new JButton();
		seat_number.add(D_6);

		E_1 = new JButton();
		seat_number.add(E_1);

		E_2 = new JButton();
		seat_number.add(E_2);

		E_3 = new JButton();
		seat_number.add(E_3);

		E_4 = new JButton();
		seat_number.add(E_4);

		E_5 = new JButton();
		seat_number.add(E_5);

		E_6 = new JButton();
		seat_number.add(E_6);

		F_1 = new JButton();
		seat_number.add(F_1);

		F_2 = new JButton();
		seat_number.add(F_2);

		F_3 = new JButton();
		seat_number.add(F_3);

		F_4 = new JButton();
		seat_number.add(F_4);

		F_5 = new JButton();
		seat_number.add(F_5);

		F_6 = new JButton();
		seat_number.add(F_6);

		option = new JPanel();
		option.setBackground(Color.LIGHT_GRAY);
		option.setBounds(0, 543, 484, 57);
		content.add(option);
		option.setLayout(null);

		optionContent = new JPanel();
		optionContent.setLayout(null);
		optionContent.setBackground(Color.LIGHT_GRAY);
		optionContent.setBounds(10, 10, 464, 37);
		option.add(optionContent);

		step3 = new JLabel("Step3. 추가 상품");
		step3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		step3.setBounds(0, 0, 166, 37);
		optionContent.add(step3);

		option_type = new JComboBox();
		option_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		option_type.setModel(new DefaultComboBoxModel(
				new String[] { "팝콘  : +6000원", "오징어 : +3000원", "나쵸 : +5000원", "사이다 : +2000원", "콜라 : +2000원" }));
		option_type.setBounds(324, 0, 140, 37);
		optionContent.add(option_type);

		optionimgpanel = new JPanel();
		optionimgpanel.setBounds(163, 0, 159, 37);
		optionContent.add(optionimgpanel);
		optionimgpanel.setLayout(new GridLayout(1, 0, 0, 0));

		img1 = new Panel();
		optionimgpanel.add(img1);

		img2 = new Panel();
		optionimgpanel.add(img2);

		img3 = new Panel();
		optionimgpanel.add(img3);

		img4 = new Panel();
		optionimgpanel.add(img4);

		img5 = new Panel();
		optionimgpanel.add(img5);

		btn_payment = new RoundedButtonD("결제 하기");
		btn_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation_step2 reserStep2 = new Reservation_step2(reserStfrm);
				Point fPt = reserStfrm.getLocationOnScreen();
				reserStep2.setLocation(fPt.x + reserStep2.getWidth() + 20, fPt.y);
				reserStep2.setVisible(true);

			}
		});
		btn_payment.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		btn_payment.setBounds(253, 812, 217, 34);
		content.add(btn_payment);

		won = new JLabel("원");
		won.setHorizontalAlignment(SwingConstants.CENTER);
		won.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		won.setBounds(222, 823, 19, 23);
		content.add(won);

		sum_price_pay = new JLabel("");
		sum_price_pay.setHorizontalAlignment(SwingConstants.CENTER);
		sum_price_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		sum_price_pay.setBounds(113, 823, 109, 23);
		content.add(sum_price_pay);

		txtprice = new JLabel("예상 결제 금액 : ");
		txtprice.setHorizontalAlignment(SwingConstants.CENTER);
		txtprice.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		txtprice.setBounds(0, 819, 127, 23);
		content.add(txtprice);

		option_add_panel = new JPanel();
		option_add_panel.setBackground(new Color(220, 220, 220));
		option_add_panel.setBounds(0, 600, 484, 202);
		content.add(option_add_panel);
		option_add_panel.setLayout(null);

		option_add_line = new JPanel();
		option_add_line.setLayout(null);
		option_add_line.setBackground(new Color(220, 220, 220));
		option_add_line.setBounds(0, 0, 484, 44);
		option_add_panel.add(option_add_line);

		optionName = new JLabel("팝콘");
		optionName.setHorizontalAlignment(SwingConstants.CENTER);
		optionName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		optionName.setBounds(17, 0, 102, 44);
		option_add_line.add(optionName);

		btn_add = new RoundedButtonD("+");
		btn_add.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 19));
		btn_add.setBounds(131, 8, 43, 26);
		option_add_line.add(btn_add);

		optionCount = new JLabel("2");
		optionCount.setHorizontalAlignment(SwingConstants.CENTER);
		optionCount.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		optionCount.setBounds(172, 0, 70, 44);
		option_add_line.add(optionCount);

		btn_miu = new RoundedButtonD("-");
		btn_miu.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 19));
		btn_miu.setBounds(242, 8, 43, 26);
		option_add_line.add(btn_miu);

		optionPrice = new JLabel("+10000원");
		optionPrice.setHorizontalAlignment(SwingConstants.CENTER);
		optionPrice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		optionPrice.setBounds(294, 0, 130, 44);
		option_add_line.add(optionPrice);

		btn_delete = new RoundedButtonD("X");
		btn_delete.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		btn_delete.setBounds(430, 8, 43, 26);
		option_add_line.add(btn_delete);

		header = new Panel();
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));

		roundedButtonD = new RoundedButtonD("PREV");
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);
	}
}
