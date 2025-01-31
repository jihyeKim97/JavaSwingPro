package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;
import template.Application.controller.Data.Login_data;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.DB.Reservation_DB;
import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.DB_Connect;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Reservation_data;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;

public class Reservation_step1 extends JFrame {

	JLabel in_movietitle, label_1, in_movietime, lblNewLabel_1, step1, step2, won, sum_price_pay, txtprice;
	RoundedButtonR roundedButtonD;
	RoundedButtonG btn_payment;
	Panel header, infoContent;
	JPanel infoDontent, seat_number, seat_detail, option, seat, contentPane, seatContent, content, info;
	JComboBox car_type, option_type;
	JLabel lblNewLabel;
	JLabel label_2;
	JPanel panel;
	JLabel label_3;
	JLabel lblNewLabel_2;
	JButton btnNewButton;
	JRadioButton rdbtnNewRadioButton;
	JToggleButton tglbtnNewToggleButton;
	JLabel label;

	Reservation_step1 reserStfrm;
	Main mainfrm;
	DB_Connect connect;
	Movie_Data Movie;
	Login_data Ld;
	Reservation_DB RDB;
	Reservation_data RD;

	ArrayList<Movie_Data> MovieList = new ArrayList<>();
	ArrayList<String> ButtonName = new ArrayList<>();
	ArrayList<Object> SName = new ArrayList<>();
	ArrayList<String> SeatNum = new ArrayList<>();

	public static final int MOVIE_PRICE = 30000;
	String Car = "";
	String selectOption;
	String optionName = "선택안함";
	String[] selectP;
	String[] selectPrice;
	int CarType = 0;
	int optionPrice = 0;


	public Reservation_step1(Main mainfrm, Movie_Data movie, Login_data Ld) {
		this.reserStfrm = this;
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
		sDate.format(new Date());
		SeatNum = RDB.selectedSeat(movie.getMoviesid());

		Reservation_DB RDB = new Reservation_DB();
		ButtonName = RDB.ButtonName();
		Movie_DB MDB = new Movie_DB();
		MovieList = MDB.getMovieData();
		int Num = MDB.getMovieIDFromImage(movie.getImagefilename());
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

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		setTitle("Vehicle Outdoor Cinema");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		content.setBounds(0, 55, 484, 700);
		contentPane.add(content);
		content.setLayout(null);

		info = new JPanel();
		info.setBackground(new Color(255, 255, 255));
		info.setBounds(0, 10, 484, 104);
		content.add(info);
		info.setLayout(null);

		infoDontent = new JPanel();
		infoDontent.setBackground(new Color(255, 255, 255));
		infoDontent.setBounds(10, 10, 464, 86);
		info.add(infoDontent);
		infoDontent.setLayout(null);

		step1 = new JLabel("Step1. 영화 정보");
		step1.setBackground(new Color(220, 220, 220));
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		step1.setBounds(0, 1, 464, 37);
		infoDontent.add(step1);
		car_type = new JComboBox();
		car_type.setBackground(new Color(255, 255, 255));
		car_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		car_type.setModel(new DefaultComboBoxModel(new String[] { "세단, 경차", "SUV" }));
		car_type.setBounds(251, 40, 201, 42);
		infoDontent.add(car_type);
		Car = car_type.getSelectedItem().toString();
		if (Car.equals("SUV"))
			CarType = 2;
		else
			CarType = 1;

		infoContent = new Panel();
		infoContent.setBackground(new Color(255, 255, 255));
		infoContent.setBounds(10, 40, 235, 42);
		infoDontent.add(infoContent);
		infoContent.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_1 = new JLabel("영화제목 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(lblNewLabel_1);

		in_movietitle = new JLabel(MovieList.get(PK).getTitle());
		in_movietitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietitle.setBackground(new Color(192, 192, 192));
		in_movietitle.setHorizontalAlignment(SwingConstants.LEFT);
		infoContent.add(in_movietitle);

		label_1 = new JLabel("상영시간 : ");
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		label_1.setBackground(new Color(192, 192, 192));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(label_1);

		in_movietime = new JLabel(time + ":00");
		in_movietime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietime.setBackground(new Color(192, 192, 192));
		in_movietime.setHorizontalAlignment(SwingConstants.LEFT);
		infoContent.add(in_movietime);

		seat = new JPanel();
		seat.setBackground(new Color(255, 255, 255));
		seat.setBounds(0, 124, 484, 363);
		content.add(seat);
		seat.setLayout(null);

		seatContent = new JPanel();
		seatContent.setBackground(new Color(255, 255, 255));
		seatContent.setBounds(10, 10, 464, 343);
		seat.add(seatContent);
		seatContent.setLayout(null);

		step2 = new JLabel("Step2. 좌석 선택");
		step2.setBackground(new Color(255, 255, 255));
		step2.setBounds(0, 0, 464, 37);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		seatContent.add(step2);

		seat_detail = new JPanel();
		seat_detail.setBackground(new Color(240, 240, 240));
		seat_detail.setBounds(10, 71, 442, 272);
		seatContent.add(seat_detail);
		seat_detail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		label_2 = new JLabel("");
		seat_detail.add(label_2);

		seat_number = new JPanel();
		seat_number.setBackground(new Color(240, 240, 240));
		seat_number.setLayout(new GridLayout(6, 6, 6, 6));
		seat_detail.add(seat_number);

		panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBounds(10, 43, 442, 30);
		seatContent.add(panel);

		label_3 = new JLabel("SCREEN");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		panel.add(label_3);

		int select = 0;
		for (int i = 0; i < 36; i++) {
			int SS = 0;
			JToggleButton tglbtnNewToggleButton = new JToggleButton();
			tglbtnNewToggleButton.setToolTipText(ButtonName.get(i));
			for (int j = 0; j < SeatNum.size(); j++) {
				if (SeatNum.get(j).equals(tglbtnNewToggleButton.getToolTipText())) {
					SS = 1;
				break;	
				}
				else
					SS = 0;
			}
			if ( SS == 0) {
			ImageIcon ic = new ImageIcon(
					Reservation_step1.class.getResource("/template/Reference/icons/default_car.png"));
			Image icImg = ic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ic.setImage(icImg);
			tglbtnNewToggleButton.setIcon(ic);
			tglbtnNewToggleButton.repaint();
			tglbtnNewToggleButton.setBorderPainted(false);
			tglbtnNewToggleButton.setContentAreaFilled(false);
			tglbtnNewToggleButton.setFocusPainted(false);
			tglbtnNewToggleButton.setOpaque(false);
			seat_number.add(tglbtnNewToggleButton);

			tglbtnNewToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if (tglbtnNewToggleButton.isSelected()) {
							ImageIcon ic = new ImageIcon(
									Reservation_step1.class.getResource("/template/Reference/icons/select_car.png"));
							Image icImg = ic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
							ic.setImage(icImg);
							tglbtnNewToggleButton.setIcon(ic);
							tglbtnNewToggleButton.repaint();
							SName.add(tglbtnNewToggleButton.getToolTipText());
						} else {
							ImageIcon ic = new ImageIcon(
									Reservation_step1.class.getResource("/template/Reference/icons/default_car.png"));
							Image icImg = ic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
							ic.setImage(icImg);
							tglbtnNewToggleButton.setIcon(ic);
							tglbtnNewToggleButton.repaint();
							SName.remove(tglbtnNewToggleButton.getToolTipText());
						}
						}
			});
			} else {
				ImageIcon ic = new ImageIcon(
						Reservation_step1.class.getResource("/template/Reference/icons/selected_car.png"));
				Image icImg = ic.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ic.setImage(icImg);
				tglbtnNewToggleButton.setIcon(ic);
				tglbtnNewToggleButton.repaint();
				tglbtnNewToggleButton.setBorderPainted(false);
				tglbtnNewToggleButton.setContentAreaFilled(false);
				tglbtnNewToggleButton.setFocusPainted(false);
				tglbtnNewToggleButton.setOpaque(false);
				seat_number.add(tglbtnNewToggleButton);

				tglbtnNewToggleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "이미 선택된 자리입니다.");
					}
				});
			}
			if (tglbtnNewToggleButton.isSelected()) {
				select = 1;
			} else {
				select = 0;
			}
		}
		option = new JPanel();
		option.setBackground(new Color(255, 255, 255));
		option.setBounds(0, 497, 484, 110);
		content.add(option);
		option.setLayout(null);

		sum_price_pay = new JLabel("" + MOVIE_PRICE);
		sum_price_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		sum_price_pay.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		sum_price_pay.setBounds(113, 665, 109, 23);
		content.add(sum_price_pay);

		option_type = new JComboBox();
		option_type.setBounds(201, 57, 275, 37);   
		option.add(option_type);
		option_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		option_type.setModel(new DefaultComboBoxModel(
				new String[] { "선택안함", "팝콘  : 6000원", "오징어 : 3000원", "나쵸 : 5000원", "사이다 : 2000원", "콜라 : 2000원" }));
		option_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectOption = option_type.getSelectedItem().toString();
				if (selectOption.contains(":")) {
					selectP = selectOption.split(":");
					String ABC = selectP[1];
					selectPrice = ABC.split("원");
					String BCA = selectPrice[0];
					String APL = BCA.replace(" ", "");
					optionPrice = Integer.parseInt(APL);
					optionName = selectP[0];
					sum_price_pay.setText("" + (MOVIE_PRICE + optionPrice));

				} else {
					optionName = "선택안함";
					optionPrice = 0;
				}
			}
		});

		label = new JLabel("Step3. 추가 상품");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(12, 10, 166, 37);
		option.add(label);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon(Reservation_step1.class.getResource("/template/Reference/icons/option1.png")));
		lblNewLabel_2.setBounds(12, 55, 177, 43);
		option.add(lblNewLabel_2);

		btn_payment = new RoundedButtonG("결제 하기");
		btn_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int A = 0;
//				SeatNum = RDB.selectedSeat(movie.getMoviesid());
//				for (int j = 0; j < SeatNum.size(); j++) {
//					if (SeatNum.get(j).equals((SName.get(0)))) {
//						A = 1;
//						break;
//					}
//				}
//
//				if (A == 0) {
					if (SName.size() == 1) {
						RD = new Reservation_data((String) SName.get(0), CarType, MOVIE_PRICE, new Date(), optionName,
								optionPrice);
						Reservation_step2 reserStep2 = new Reservation_step2(reserStfrm, movie, Ld, RD);
						Point fPt = reserStfrm.getLocationOnScreen();
						reserStep2.setLocation(fPt.x, fPt.y);
						reserStep2.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "좌석을 하나만 선택해 주세요");
					}
//				} else {
//					JOptionPane.showMessageDialog(null, "이미 선택된 자리입니다.");
//				}
			}
		});
		btn_payment.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		btn_payment.setBounds(253, 656, 217, 34);
		content.add(btn_payment);

		won = new JLabel("원");
		won.setHorizontalAlignment(SwingConstants.CENTER);
		won.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		won.setBounds(222, 667, 19, 23);
		content.add(won);

		txtprice = new JLabel("예상 결제 금액 : ");
		txtprice.setHorizontalAlignment(SwingConstants.CENTER);
		txtprice.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		txtprice.setBounds(0, 663, 127, 23);
		content.add(txtprice);

		header = new Panel();
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);
		header.setLayout(null);
		header.setBackground(new Color(211, 211, 211));

		roundedButtonD = new RoundedButtonR("PREV");
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);
	}
}
