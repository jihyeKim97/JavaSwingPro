package template.Application.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.DB.Reservation_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Reservation_data;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class Reservation_step2 extends JFrame {

	JPanel contentPane;
	JTextField card_number4;
	JTextField card_number1;
	JTextField card_date;
	JTextField card_cvc;
	JPasswordField card_pw;
	JPasswordField card_number3;
	JPasswordField card_number2;
	JPanel pay_success;
	RoundedButtonR roundedButtonD;
	Panel header;
	JLabel label_17;
	JPanel panel_8;
	RoundedButtonG btn_pay;
	Reservation_step1 reserStfrm;
	Reservation_DB RDB;
	Movie_DB movie;
	Login_data Ld;
	ArrayList<Movie_Data> MovieList = new ArrayList<>();

	public Reservation_step2(Reservation_step1 reserStfrm, Movie_Data movie, Login_data Ld, Reservation_data RD) {
		Movie_DB MDB = new Movie_DB();
		MovieList = MDB.getMovieData();
		int Num = MDB.getMovieIDFromImage(movie.getImagefilename());
		int PK = 0;
		for (int i = 0; i < MovieList.size(); i++) {
			if (MovieList.get(i).getMoviesid() == Num)
				PK = i;
		}

		int itime = 17 + (2 * MovieList.get(PK).getScheduletime());
		String time = "";
		if (itime > 24) {
			time = "" + (itime - 24);
		} else {
			time = "" + itime;
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 658);
		contentPane = new JPanel();
		setTitle("Vehicle Outdoor Cinema");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pay_ing = new JPanel();
		pay_ing.setBackground(new Color(255, 255, 255));
		pay_ing.setBounds(0, 55, 484, 564);
		contentPane.add(pay_ing);
		pay_ing.setLayout(null);

		JPanel movieInfo = new JPanel();
		movieInfo.setBackground(new Color(255, 255, 255));
		movieInfo.setLayout(null);
		movieInfo.setBounds(0, 10, 484, 261);
		pay_ing.add(movieInfo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 464, 241);
		movieInfo.add(panel_1);

		JPanel poset_div = new JPanel();
		poset_div.setBackground(new Color(255, 235, 205));
		poset_div.setBounds(0, 10, 141, 221);
		panel_1.add(poset_div);
		poset_div.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		poset_div.add(lblNewLabel, BorderLayout.CENTER);
		ImageIcon ic = new ImageIcon(Reservation_step2.class.getResource(movie.getImagefilename()));
		Image icImg = ic.getImage().getScaledInstance(141, 221, Image.SCALE_SMOOTH);
		ic.setImage(icImg);
		lblNewLabel.setIcon(ic);

		JPanel movietxt_div = new JPanel();
		movietxt_div.setBackground(new Color(255, 255, 255));
		movietxt_div.setLayout(null);
		movietxt_div.setBounds(153, 10, 311, 221);
		panel_1.add(movietxt_div);

		JLabel label = new JLabel("영화제목 : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label.setBounds(0, 2, 100, 31);
		movietxt_div.add(label);

		JLabel movietitle = new JLabel(MovieList.get(PK).getTitle());
		movietitle.setHorizontalAlignment(SwingConstants.CENTER);
		movietitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		movietitle.setBounds(100, 2, 211, 31);
		movietxt_div.add(movietitle);

		JLabel label_2 = new JLabel("영화 상영 날짜 : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_2.setBounds(0, 33, 100, 31);
		movietxt_div.add(label_2);

		JLabel moviedate = new JLabel("" + MovieList.get(PK).getScheduledate());
		moviedate.setHorizontalAlignment(SwingConstants.CENTER);
		moviedate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		moviedate.setBounds(100, 33, 211, 31);
		movietxt_div.add(moviedate);

		JLabel label_4 = new JLabel("영화 상영 시간 : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_4.setBounds(0, 64, 100, 31);
		movietxt_div.add(label_4);

		JLabel movietime = new JLabel(time + ":00");
		movietime.setHorizontalAlignment(SwingConstants.CENTER);
		movietime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		movietime.setBounds(100, 64, 211, 31);
		movietxt_div.add(movietime);

		JLabel label_6 = new JLabel("좌석 번호 : ");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_6.setBounds(0, 95, 100, 31);
		movietxt_div.add(label_6);

		JLabel seatnum = new JLabel(RD.getSeatNumber());
		seatnum.setHorizontalAlignment(SwingConstants.CENTER);
		seatnum.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		seatnum.setBounds(100, 95, 211, 31);
		movietxt_div.add(seatnum);

		JLabel label_8 = new JLabel("옵션 선택 : ");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_8.setBounds(0, 126, 100, 31);
		movietxt_div.add(label_8);

		JLabel optionname = new JLabel(RD.getOptionName());
		optionname.setHorizontalAlignment(SwingConstants.CENTER);
		optionname.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		optionname.setBounds(100, 126, 211, 31);
		movietxt_div.add(optionname);

		JLabel label_10 = new JLabel("옵션 금액 : ");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_10.setBounds(0, 157, 100, 31);
		movietxt_div.add(label_10);

		JLabel optionprice = new JLabel(RD.getOptionPrice() + "원");
		optionprice.setHorizontalAlignment(SwingConstants.CENTER);
		optionprice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		optionprice.setBounds(100, 157, 211, 31);
		movietxt_div.add(optionprice);

		JLabel label_12 = new JLabel("총 결제 금액 : ");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_12.setBounds(0, 188, 100, 31);
		movietxt_div.add(label_12);

		JLabel totalprice = new JLabel((RD.getPaymentPrice() + RD.getOptionPrice()) + "원");
		totalprice.setHorizontalAlignment(SwingConstants.CENTER);
		totalprice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		totalprice.setBounds(100, 188, 211, 31);
		movietxt_div.add(totalprice);

		JPanel cardInfo = new JPanel();
		cardInfo.setBackground(new Color(255, 255, 255));
		cardInfo.setBounds(0, 281, 484, 186);
		pay_ing.add(cardInfo);
		cardInfo.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 10, 484, 167);
		cardInfo.add(panel_5);
		panel_5.setLayout(null);

		JLabel label_14 = new JLabel("카드 번호");
		label_14.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_14.setBounds(30, 7, 100, 30);
		panel_5.add(label_14);

		JPanel card_numbering = new JPanel();
		card_numbering.setBounds(53, 37, 390, 30);
		panel_5.add(card_numbering);
		card_numbering.setLayout(new GridLayout(0, 4, 15, 0));

		card_number1 = new JTextField();
		card_number1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		card_numbering.add(card_number1);
		card_number1.setColumns(10);

		card_number2 = new JPasswordField();
		card_numbering.add(card_number2);

		card_number3 = new JPasswordField();
		card_numbering.add(card_number3);

		card_number4 = new JTextField();
		card_number4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		card_numbering.add(card_number4);
		card_number4.setColumns(10);

		JLabel label_15 = new JLabel("유효 기간");
		label_15.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_15.setBounds(41, 77, 100, 32);
		panel_5.add(label_15);

		card_date = new JTextField();
		card_date.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		card_date.setColumns(10);
		card_date.setBounds(51, 109, 86, 30);
		panel_5.add(card_date);

		JLabel label_16 = new JLabel("비밀번호");
		label_16.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_16.setBounds(343, 77, 100, 32);
		panel_5.add(label_16);

		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lblCvc.setBounds(195, 77, 46, 32);
		panel_5.add(lblCvc);

		card_cvc = new JTextField();
		card_cvc.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		card_cvc.setColumns(10);
		card_cvc.setBounds(205, 109, 89, 30);
		panel_5.add(card_cvc);

		card_pw = new JPasswordField();
		card_pw.setBounds(353, 109, 89, 30);
		panel_5.add(card_pw);

		btn_pay = new RoundedButtonG("결제");
		btn_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardF1 = new String(card_number1.getText());
				String cardF2 = new String(card_number2.getPassword());
				String cardF3 = new String(card_number3.getPassword());
				String cardF4 = new String(card_number4.getText());
				String cardFC = new String(card_cvc.getText());
				String cardFD = new String(card_date.getText());
				String cardFP = new String(card_pw.getPassword());
				String a = "";
				int A = 0;
				for (int i = 0; i < 9; i++) {
					a += "" + (int) (Math.random() * 10);
				}
				System.out.println(a);
				A = Integer.parseInt(a);
				if (!cardF1.isEmpty() && !cardF2.isEmpty() && !cardF3.isEmpty() && !cardF4.isEmpty()
						&& !cardFC.isEmpty() && !cardFD.isEmpty() && !cardFP.isEmpty()) {
					RDB.saveResevationData(A, "" + movie.getScheduledate(), RD.getSeatNumber(), RD.getCarType(),
							RD.getPaymentPrice(), RD.getOptionName(), RD.getOptionPrice(), Ld.getMember_id(),
							movie.getMoviesid());
					System.out.println();
					pay_success.setVisible(true);
					pay_ing.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "빈칸이 존재 합니다");
					pay_success.setVisible(false);
				}
			}
		});
		btn_pay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_pay.setBounds(12, 504, 464, 50);
		pay_ing.add(btn_pay);

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

		pay_success = new JPanel();
		pay_success.setLayout(null);
		pay_success.setBackground(new Color(255, 255, 255));
		pay_success.setBounds(0, 55, 484, 564);
		contentPane.add(pay_success);

		label_17 = new JLabel("결제가 완료되었습니다!");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		label_17.setBounds(10, 4, 462, 61);
		pay_success.add(label_17);
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));

		panel_8.setLayout(null);
		panel_8.setBounds(0, 69, 484, 261);
		pay_success.add(panel_8);
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));

		panel_9.setLayout(null);
		panel_9.setBounds(10, 10, 464, 241);
		panel_8.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 235, 205));
		panel_10.setBounds(0, 10, 141, 221);
		panel_10.setLayout(new BorderLayout());
		JLabel JL = new JLabel();
		panel_9.add(panel_10);
		ImageIcon ic1 = new ImageIcon(Main.class.getResource(movie.getImagefilename()));
		Image icImg1 = ic1.getImage().getScaledInstance(141, 221, Image.SCALE_SMOOTH);
		ic1.setImage(icImg1);
		JL.setIcon(ic1);
		JL.repaint();
		panel_10.add(JL, BorderLayout.CENTER);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setLayout(null);
		panel_11.setBounds(153, 10, 311, 221);
		panel_9.add(panel_11);

		JLabel label_18 = new JLabel("영화제목 : ");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_18.setBounds(0, 2, 100, 31);
		panel_11.add(label_18);

		JLabel label_19 = new JLabel(MovieList.get(PK).getTitle());
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_19.setBounds(100, 2, 211, 31);
		panel_11.add(label_19);

		JLabel label_20 = new JLabel("영화 상영 날짜 : ");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_20.setBounds(0, 33, 100, 31);
		panel_11.add(label_20);

		JLabel label_21 = new JLabel("" + movie.getScheduledate());
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_21.setBounds(100, 33, 211, 31);
		panel_11.add(label_21);

		JLabel label_22 = new JLabel("영화 상영 시간 : ");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_22.setBounds(0, 64, 100, 31);
		panel_11.add(label_22);

		JLabel label_23 = new JLabel(time + ":00");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_23.setBounds(100, 64, 211, 31);
		panel_11.add(label_23);

		JLabel label_24 = new JLabel("좌석 번호 : ");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		label_24.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_24.setBounds(0, 95, 100, 31);
		panel_11.add(label_24);

		JLabel label_25 = new JLabel(RD.getSeatNumber());
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_25.setBounds(100, 95, 211, 31);
		panel_11.add(label_25);

		JLabel label_26 = new JLabel("옵션 선택 : ");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_26.setBounds(0, 126, 100, 31);
		panel_11.add(label_26);

		JLabel label_27 = new JLabel(RD.getOptionName());
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_27.setBounds(100, 126, 211, 31);
		panel_11.add(label_27);

		JLabel label_28 = new JLabel("옵션 금액 : ");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_28.setBounds(0, 157, 100, 31);
		panel_11.add(label_28);

		JLabel label_29 = new JLabel("" + RD.getOptionPrice());
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_29.setBounds(100, 157, 211, 31);
		panel_11.add(label_29);

		JLabel label_30 = new JLabel("총 결제 금액 : ");
		label_30.setHorizontalAlignment(SwingConstants.RIGHT);
		label_30.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_30.setBounds(0, 188, 100, 31);
		panel_11.add(label_30);

		JLabel label_31 = new JLabel("" + (RD.getOptionPrice() + RD.getPaymentPrice()));
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_31.setBounds(100, 188, 211, 31);
		panel_11.add(label_31);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(70, 114, 42));
		panel_12.setLayout(null);
		panel_12.setBounds(0, 344, 484, 220);
		pay_success.add(panel_12);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(70, 114, 42));
		panel_13.setLayout(null);
		panel_13.setBounds(10, 10, 464, 200);
		panel_12.add(panel_13);

		JLabel label_32 = new JLabel("영화 관람 시 유의사항");
		label_32.setForeground(new Color(255, 255, 255));
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_32.setBounds(0, 5, 464, 30);
		panel_13.add(label_32);

		JLabel label_33 = new JLabel("극장 입구에서 차량의 미등까지 모두 소등합니다.");
		label_33.setForeground(new Color(255, 255, 255));
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_33.setBounds(0, 42, 464, 20);
		panel_13.add(label_33);

		JLabel label_34 = new JLabel("창문을 열고 감상하실 때에는 다른 손님에게 피해가 가지 않도록 음향 볼륨을 낮춰 주세요.");
		label_34.setForeground(new Color(255, 255, 255));
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_34.setBounds(0, 63, 464, 20);
		panel_13.add(label_34);

		JLabel label_35 = new JLabel("정산 티켓을 운전석 와이퍼에 꼭끼워주세요.");
		label_35.setForeground(new Color(255, 255, 255));
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_35.setBounds(0, 85, 464, 20);
		panel_13.add(label_35);

		JLabel label_36 = new JLabel("다른 손님에게 방해가 되지 않도록 소음이나 눈에 거슬리는 행동은 삼가해 주세요.");
		label_36.setForeground(new Color(255, 255, 255));
		label_36.setHorizontalAlignment(SwingConstants.CENTER);
		label_36.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_36.setBounds(0, 106, 464, 20);
		panel_13.add(label_36);

		JLabel label_37 = new JLabel("타고오신 차량에 이상이 있을 경우에 극장 직원에게 도움을 요청 하십시오.");
		label_37.setForeground(new Color(255, 255, 255));
		label_37.setHorizontalAlignment(SwingConstants.CENTER);
		label_37.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_37.setBounds(0, 126, 464, 20);
		panel_13.add(label_37);

		JLabel label_38 = new JLabel("영화상영 도중 라이트를 켜지 말아 주세요.");
		label_38.setForeground(new Color(255, 255, 255));
		label_38.setHorizontalAlignment(SwingConstants.CENTER);
		label_38.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_38.setBounds(0, 148, 464, 20);
		panel_13.add(label_38);

		JLabel label_39 = new JLabel("주파수를 미리 맟추시고 소리가 잘 들리는지 미리 테스트 해보십시오.");
		label_39.setForeground(new Color(255, 255, 255));
		label_39.setHorizontalAlignment(SwingConstants.CENTER);
		label_39.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		label_39.setBounds(0, 170, 464, 20);
		panel_13.add(label_39);
	}
}
