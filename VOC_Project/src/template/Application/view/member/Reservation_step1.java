package template.Application.view.member;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;
import template.Application.controller.Data.Login_data;
import template.Application.controller.DB.Main_Movie_DB;
import template.Application.controller.DB.Reservation_DB;
import template.Application.controller.DB.DB_Connect;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Reservation_data;
import template.Application.controller.btn.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class Reservation_step1 extends JFrame {

	JLabel in_movietitle, label_1, in_movietime, lblNewLabel_1, step1, lblNewLabel_2, step2, won, sum_price_pay,
			txtprice;
	RoundedButtonD btn_payment, roundedButtonD;
	Panel header, img1, img2, img3, img4, img5, infoContent;
	JPanel infoDontent, seat_number, screen, seat_detail, option, optionimgpanel, seat, contentPane, seatContent,
			content, info;
	JComboBox car_type, option_type;
	JButton A_2, A_3, A_4, A_5, A_6, B_1, B_2, B_3, B_4, B_5, B_6, C_1, C_2, C_3, C_4, C_5, C_6, D_1, D_2, D_3, D_4,
			D_5, D_6, E_1, E_2, E_3, E_4, E_5, E_6, F_1, F_2, F_3, F_4, F_5, F_6;

	public static final int MOVIE_PRICE = 30000; 
	Main mainfrm;
	Reservation_step1 reserStfrm;
	DB_Connect connect;
	Movie_Data Movie;
	ArrayList<Movie_Data> MovieList = new ArrayList<>();
	private JLabel label;
	Login_data Ld;
	private JLabel lblNewLabel;
	ArrayList<String> ButtonName = new ArrayList<>();
	private JRadioButton rdbtnNewRadioButton;
	String Car = "";
	int CarType = 0;
	private JToggleButton tglbtnNewToggleButton_1;
	private JToggleButton tglbtnNewToggleButton_2;
	ArrayList<Object> SName = new ArrayList<>();
	String selectOption;
	String optionName = "";
	String[] selectP;
	String[] selectPrice;
	int optionPrice = 0;
	Reservation_data RD;

	public Reservation_step1(Main mainfrm, Movie_Data movie, Login_data Ld) {
		this.reserStfrm = this;
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
		sDate.format(new Date());
		
		Reservation_DB RDB = new Reservation_DB();
		ButtonName = RDB.ButtonName();
		Main_Movie_DB MDB = new Main_Movie_DB();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		content = new JPanel();
		content.setBackground(new Color(240, 240, 240));
		content.setBounds(0, 55, 484, 700);
		contentPane.add(content);
		content.setLayout(null);

		info = new JPanel();
		info.setBackground(new Color(220, 220, 220));
		info.setBounds(0, 10, 484, 104);
		content.add(info);
		info.setLayout(null);

		infoDontent = new JPanel();
		infoDontent.setBackground(new Color(220, 220, 220));
		infoDontent.setBounds(10, 10, 464, 86);
		info.add(infoDontent);
		infoDontent.setLayout(null);

		step1 = new JLabel("Step1. 영화 정보");
		step1.setBackground(new Color(220, 220, 220));
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		step1.setBounds(0, 1, 464, 37);
		infoDontent.add(step1);
		car_type = new JComboBox();
		car_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		car_type.setModel(new DefaultComboBoxModel(new String[] { "세단, 경차", "SUV" }));
		car_type.setBounds(335, 40, 117, 42);
		infoDontent.add(car_type);
		Car = car_type.getSelectedItem().toString();
		if ( Car.equals("SUV"))
			CarType = 2;
		else
			CarType = 1;

		infoContent = new Panel();
		infoContent.setBackground(new Color(220, 220, 220));
		infoContent.setBounds(10, 40, 319, 42);
		infoDontent.add(infoContent);
		infoContent.setLayout(new GridLayout(0, 4, 0, 0));

		lblNewLabel_1 = new JLabel("영화제목 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(lblNewLabel_1);

		in_movietitle = new JLabel(MovieList.get(PK).getTitle());
		in_movietitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietitle.setBackground(new Color(192, 192, 192));
		in_movietitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(in_movietitle);

		label_1 = new JLabel("상영시간 : ");
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		label_1.setBackground(new Color(192, 192, 192));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(label_1);

		in_movietime = new JLabel(time + ":00");
		in_movietime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		in_movietime.setBackground(new Color(192, 192, 192));
		in_movietime.setHorizontalAlignment(SwingConstants.CENTER);
		infoContent.add(in_movietime);

		seat = new JPanel();
		seat.setBackground(new Color(220, 220, 220));
		seat.setBounds(0, 124, 484, 363);
		content.add(seat);
		seat.setLayout(null);

		seatContent = new JPanel();
		seatContent.setBackground(new Color(220, 220, 220));
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
			
		int select = 0;
		for (int i = 0; i < 36; i++) {
			JToggleButton tglbtnNewToggleButton = new JToggleButton(ButtonName.get(i));
			ImageIcon ic = new ImageIcon(
					Reservation_step1.class.getResource("/template/Reference/icons/default_car.png"));
			Image icImg = ic.getImage().getScaledInstance(55, 30, Image.SCALE_SMOOTH);
			ic.setImage(icImg);
			tglbtnNewToggleButton.setIcon(ic);
			tglbtnNewToggleButton.repaint();
			seat_number.add(tglbtnNewToggleButton);	
			
			tglbtnNewToggleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ( tglbtnNewToggleButton.isSelected()) {
						ImageIcon ic = new ImageIcon(Reservation_step1.class.getResource("/template/Reference/icons/select_car.png"));
						Image icImg = ic.getImage().getScaledInstance(55, 30, Image.SCALE_SMOOTH);
						ic.setImage(icImg);
						tglbtnNewToggleButton.setIcon(ic);
						tglbtnNewToggleButton.repaint();
						SName.add(tglbtnNewToggleButton.getText());
					}
					else {
						ImageIcon ic = new ImageIcon(Reservation_step1.class.getResource("/template/Reference/icons/default_car.png"));
						Image icImg = ic.getImage().getScaledInstance(55, 30, Image.SCALE_SMOOTH);
						ic.setImage(icImg);
						tglbtnNewToggleButton.setIcon(ic);
						tglbtnNewToggleButton.repaint();
						SName.remove(tglbtnNewToggleButton.getText());
					}
				}
				
			});
			if (tglbtnNewToggleButton.isSelected())
				select = 1;
			else
				select = 0;
		}

		option = new JPanel();
		option.setBackground(new Color(220, 220, 220));
		option.setBounds(0, 497, 484, 110);
		content.add(option);
		option.setLayout(null);
		
		sum_price_pay = new JLabel("" + MOVIE_PRICE);
		sum_price_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		sum_price_pay.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		sum_price_pay.setBounds(113, 662, 109, 23);
		content.add(sum_price_pay);

		option_type = new JComboBox();
		option_type.setBounds(201, 57, 275, 37);
		option.add(option_type);
		option_type.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		option_type.setModel(new DefaultComboBoxModel(new String[] {"선택안함", "팝콘  : 6000원", "오징어 : 3000원", "나쵸 : 5000원", "사이다 : 2000원", "콜라 : 2000원"}));
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
			
		}else {
			optionName = "선택안함";
			optionPrice = 0;
		}
			}
		});

		optionimgpanel = new JPanel();
		optionimgpanel.setBounds(15, 57, 174, 37);
		option.add(optionimgpanel);
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

		label = new JLabel("Step3. 추가 상품");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(12, 10, 166, 37);
		option.add(label);
		
		btn_payment = new RoundedButtonD("결제 하기");
		btn_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RD = new Reservation_data((String) SName.get(0), CarType, MOVIE_PRICE, new Date(), optionName, optionPrice);
				if ( SName.size() == 1) {
				Reservation_step2 reserStep2 = new Reservation_step2(reserStfrm, movie, Ld, RD);
				Point fPt = reserStfrm.getLocationOnScreen();
				reserStep2.setLocation(fPt.x , fPt.y);
				reserStep2.setVisible(true);
				dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "좌석을 하나만 선택해 주세요");
				}
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
