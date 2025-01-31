package template.Application.view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Color;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Movie_DB;
import template.Application.controller.DB.Mypage_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Mypage_Member_data;
import template.Application.controller.Data.Mypage_Reservation_data;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MyPage extends JFrame {
	JPanel contentPane;
	JLabel lbTitle;
	JTextField nameField;
	JLabel idField;
	JTextField phone;
	JLabel genField;
	JLabel birField;
	JTextField currField;
	JTextField newpwField;
	JTextField newpwckField;
	Panel header;

	JLabel in_reservationNum;
	JLabel txtmovietitle;
	JLabel in_movieTitle;
	JLabel txtreservationdate;
	JLabel in_resercationDate;
	JLabel txttotalprice;
	JLabel in_totalPrice;
	JLabel lblReservation;
	Panel memdetail_panel;
	Panel lbPanel;
	RoundedButtonR btn_logout;
	RoundedButtonG wirte_review;
	RoundedButtonG btn_meminfo;
	RoundedButtonG btn_reser;
	RoundedButtonG btn_edit;
	RoundedButtonR btn_main;
	JPanel panel;
	JLabel txtreservationum;
	JPanel content;
	JPanel mem_panel;
	JPanel res_panel;
	JPanel resdetail_panel;
	Panel fieldPanel;
	Panel reser_box;
	Panel detail;

	Point fPt;
	Main mafrm;
	Mypage_writePage wirteP;

	MyPage frm;
	Mypage_Member_data MyPage;
	JLabel errortxt;
	Mypage_DB MDB;
	JLabel none_reservation;
	Movie_Data MDT;
	Movie_DB MD;
	int A = 0;
	int i = 0;
	public static ArrayList<Mypage_Reservation_data> ReArr;

	public MyPage(Main mafrm, Login_data Ld) {
		this.frm = this;
		Mypage_Member_data MyArr = MDB.SelectMember(Ld.getMember_id());

//		ArrayList<Mypage_Reservation_data> MoveArr = MDB.Selectid(Ld.getMember_id());
//		for (int i = 0; i < MoveArr.size(); i++) {
//			System.out.println(MoveArr.get(i).getMovie_id());
//		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		setTitle("Vehicle Outdoor Cinema");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		header = new Panel();
		header.setLayout(null);
		header.setBackground(new Color(211, 211, 211));
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);

		btn_main = new RoundedButtonR("HOME");
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_main.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		btn_main.setBounds(12, 10, 100, 35);
		header.add(btn_main);

		content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(0, 55, 484, 705);
		contentPane.add(content);
		content.setLayout(null);

		detail = new Panel();
		detail.setBackground(Color.WHITE);
		detail.setBounds(10, 0, 464, 705);
		content.add(detail);
		detail.setLayout(null);

		mem_panel = new JPanel();
		mem_panel.setBackground(new Color(70, 114, 42));
		mem_panel.setBounds(10, 40, 444, 655);
		mem_panel.setLayout(null);
		detail.add(mem_panel);

		res_panel = new JPanel();
		res_panel.setBackground(new Color(70, 114, 42));
		res_panel.setBounds(10, 40, 444, 655);
		detail.add(res_panel);
		res_panel.setLayout(null);

		resdetail_panel = new JPanel();
		resdetail_panel.setBackground(Color.WHITE);
		resdetail_panel.setBounds(10, 10, 424, 635);
		res_panel.add(resdetail_panel);
		resdetail_panel.setLayout(null);

		none_reservation = new JLabel();
		none_reservation.setForeground(Color.RED);
		none_reservation.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		none_reservation.setBounds(10, 80, 402, 15);
		resdetail_panel.add(none_reservation);

		btn_meminfo = new RoundedButtonG("member info");
		btn_meminfo.setText("Member Info");
		btn_meminfo.setBackground(new Color(128, 128, 128));
		btn_meminfo.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btn_meminfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(true);
				res_panel.setVisible(false);
				lbTitle.setText("Member Info");
			}
		});
		btn_meminfo.setBounds(18, 10, 130, 35);
		detail.add(btn_meminfo);

		btn_reser = new RoundedButtonG("reservtion");
		btn_reser.setText("Reservation");
		btn_reser.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btn_reser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem_panel.setVisible(false);
				res_panel.setVisible(true);
				lbTitle.setText("Reservtion");
				ArrayList<Mypage_Reservation_data> ReArr = MDB.SelectReservationID(Ld.getMember_id());
				if (!ReArr.isEmpty()) {
					for (i = 0; i < ReArr.size(); i++) {
						MDT = MD.getMovieInformationFromMovieId(ReArr.get(i).getMovie_id());
						System.out.println(MDT);
						none_reservation.setVisible(false);
						JPanel reser_box = new JPanel();
						reser_box.setToolTipText("" + i);
						reser_box.setBackground(new Color(242, 242, 242));
						reser_box.setBounds(10, 80 + (174 * i) + (10 * i), 404, 174);
						resdetail_panel.add(reser_box);
						reser_box.setLayout(null);
						Panel poster = new Panel();
						poster.setBackground(Color.white);
						poster.setBounds(10, 10, 117, 155);
						poster.setLayout(new BorderLayout());
						JLabel JL = new JLabel();
						poster.add(JL, BorderLayout.CENTER);
						reser_box.add(poster);
						ImageIcon ic = new ImageIcon(Reservation_step2.class.getResource(MDT.getImagefilename()));
						Image icImg = ic.getImage().getScaledInstance(117, 155, Image.SCALE_SMOOTH);
						ic.setImage(icImg);
						JL.setIcon(ic);
						JL.repaint();
						RoundedButtonG wirte_review = new RoundedButtonG("Go to write a review");
						wirte_review.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
						wirte_review.setText("한줄평 작성하기");
						int A = i;
						int PK = ReArr.get(A).getMovie_id();
						wirte_review.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("선택한 영화 인덱스  : " + PK);
								wirteP = new Mypage_writePage(frm, Ld, PK, reser_box, A);
								fPt = frm.getLocationOnScreen();
								wirteP.setLocation(fPt.x + frm.getWidth() + 20, fPt.y);
								wirteP.setVisible(true);
							}
						});

						wirte_review.setBounds(133, 131, 259, 34);
						reser_box.add(wirte_review);

						JPanel panel = new JPanel();
						panel.setBounds(133, 10, 259, 113);
						panel.setBackground(new Color(242, 242, 242));
						reser_box.add(panel);
						panel.setLayout(null);

						JLabel txtreservationum = new JLabel("예약번호 :  ");
						txtreservationum.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						txtreservationum.setBounds(0, 0, 68, 28);
						txtreservationum.setHorizontalAlignment(SwingConstants.RIGHT);
						panel.add(txtreservationum);
						JLabel in_reservationNum = new JLabel("");
						in_reservationNum.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						in_reservationNum.setHorizontalAlignment(SwingConstants.LEFT);
						in_reservationNum.setText("" + ReArr.get(i).getReservation_number());
						in_reservationNum.setBounds(75, 0, 183, 28);
						panel.add(in_reservationNum);

						JLabel txtmovietitle = new JLabel("영화제목 :  ");
						txtmovietitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						txtmovietitle.setBounds(0, 28, 68, 28);
						txtmovietitle.setHorizontalAlignment(SwingConstants.RIGHT);
						panel.add(txtmovietitle);

						JLabel in_movieTitle = new JLabel("");
						in_movieTitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						in_movieTitle.setHorizontalAlignment(SwingConstants.LEFT);
						in_movieTitle.setText(Mypage_DB.AlterMovieIDName(ReArr.get(i).getMovie_id()));
						in_movieTitle.setBounds(75, 28, 183, 28);
						panel.add(in_movieTitle);

						JLabel txtreservationdate = new JLabel("예약일시 :  ");
						txtreservationdate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						txtreservationdate.setBounds(0, 56, 68, 28);
						txtreservationdate.setHorizontalAlignment(SwingConstants.RIGHT);
						panel.add(txtreservationdate);

						JLabel in_resercationDate = new JLabel("");
						in_resercationDate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						in_resercationDate.setHorizontalAlignment(SwingConstants.LEFT);
						in_resercationDate.setText("" + ReArr.get(i).getReservation_date());
						in_resercationDate.setBounds(75, 56, 183, 28);
						panel.add(in_resercationDate);

						JLabel txttotalprice = new JLabel("결제 금액 :  ");
						txttotalprice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						txttotalprice.setBounds(0, 84, 68, 28);
						txttotalprice.setHorizontalAlignment(SwingConstants.RIGHT);
						panel.add(txttotalprice);

						JLabel in_totalPrice = new JLabel("");
						in_totalPrice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
						in_totalPrice.setText("" + (ReArr.get(i).getPayment_price() + ReArr.get(i).getOption_price()));
						in_totalPrice.setHorizontalAlignment(SwingConstants.LEFT);
						in_totalPrice.setBounds(75, 84, 183, 28);
						panel.add(in_totalPrice);

						JLabel lblReservation = new JLabel("Reservation");
						lblReservation.setHorizontalAlignment(SwingConstants.CENTER);
						lblReservation.setFont(new Font("Candara Light", Font.BOLD, 36));
						lblReservation.setBounds(14, 19, 400, 55);
						resdetail_panel.add(lblReservation);
					}
				} else {
					none_reservation.setText("현재 회원님의 예매 내역이 없습니다.");
					none_reservation.setHorizontalAlignment(SwingConstants.CENTER);
					resdetail_panel.setVisible(true);
				}

			}
		});
		btn_reser.setBounds(151, 10, 105, 35);
		detail.add(btn_reser);

		memdetail_panel = new Panel();
		memdetail_panel.setLayout(null);
		memdetail_panel.setBackground(Color.WHITE);
		memdetail_panel.setBounds(10, 10, 424, 635);
		mem_panel.add(memdetail_panel);

		btn_edit = new RoundedButtonG("Edit");
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!nameField.getText().isEmpty() && !phone.getText().isEmpty() && !currField.getText().isEmpty()
						&& !newpwField.getText().isEmpty() && !newpwckField.getText().isEmpty()) {
					if (currField.getText().equals(MyArr.getPassword())
							&& newpwField.getText().equals(newpwckField.getText())) {
						errortxt.setForeground(Color.blue);
						errortxt.setText("성공!");
						MDB.UpdateMemberInfo(Ld.getMember_id(), nameField.getText(), phone.getText(),
								newpwField.getText());
						System.out.println("업데이트 성공");
					} else {
						if (!currField.getText().equals(MyArr.getPassword())) {
							errortxt.setText("현재 비밀번호가 불일치 합니다");
							System.out.println("비밀번호 불일치");
						} else if (!newpwField.getText().equals(newpwckField.getText())) {
							errortxt.setText("새 비밀번호끼리 불일치 합니다");
							System.out.println("비밀번호 필드끼리 불일치");
						}
					}
					System.out.println("빈칸 없음");
				} else {
					errortxt.setText("빈칸이 존재 합니다");
					System.out.println("빈칸있음");
				}
			}
		});
		btn_edit.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		btn_edit.setBounds(12, 565, 400, 60);
		memdetail_panel.add(btn_edit);

		lbPanel = new Panel();
		lbPanel.setBounds(0, 119, 162, 373);
		memdetail_panel.add(lbPanel);
		lbPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label = new JLabel("이름 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label);

		JLabel label_1 = new JLabel("아이디 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_1);

		JLabel label_2 = new JLabel("전화번호 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_2);

		JLabel label_3 = new JLabel("성별 : ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_3);

		JLabel label_4 = new JLabel("생년월일 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_4);

		JLabel label_5 = new JLabel("현재 비밀번호 : ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_5);

		JLabel label_6 = new JLabel("새 비밀번호 : ");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_6);

		JLabel label_7 = new JLabel("새 비밀번호 확인 : ");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lbPanel.add(label_7);

		fieldPanel = new Panel();
		fieldPanel.setLayout(null);
		fieldPanel.setBounds(168, 119, 256, 373);
		memdetail_panel.add(fieldPanel);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setColumns(10);
		nameField.setBounds(0, 5, 246, 40);
		nameField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		nameField.setText(MyArr.getName());
		fieldPanel.add(nameField);

		idField = new JLabel();
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setBounds(0, 52, 246, 40);
		idField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		idField.setText(MyArr.getId());
		fieldPanel.add(idField);

		phone = new JTextField();
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setColumns(10);
		phone.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		phone.setText(MyArr.getPhoneNumber());
		phone.setBounds(0, 98, 246, 40);
		fieldPanel.add(phone);

		genField = new JLabel();
		genField.setHorizontalAlignment(SwingConstants.CENTER);
		genField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		String gen = "";
		if (MyArr.getGender() == 0) {
			gen = "남자";
		} else {
			gen = "여자";
		}
		genField.setText(gen);
		genField.setBounds(0, 142, 246, 40);
		fieldPanel.add(genField);

		birField = new JLabel();
		birField.setHorizontalAlignment(SwingConstants.CENTER);
		birField.setText(MyArr.getBirthday());
		birField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		birField.setBounds(0, 186, 246, 40);
		fieldPanel.add(birField);

		currField = new JTextField();
		currField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		currField.setHorizontalAlignment(SwingConstants.CENTER);
		currField.setColumns(10);
		currField.setBounds(0, 235, 246, 40);
		fieldPanel.add(currField);

		newpwField = new JTextField();
		newpwField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		newpwField.setHorizontalAlignment(SwingConstants.CENTER);
		newpwField.setColumns(10);
		newpwField.setBounds(0, 279, 246, 40);
		fieldPanel.add(newpwField);

		newpwckField = new JTextField();
		newpwckField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		newpwckField.setHorizontalAlignment(SwingConstants.CENTER);
		newpwckField.setColumns(10);
		newpwckField.setBounds(0, 324, 246, 40);
		fieldPanel.add(newpwckField);

		lbTitle = new JLabel("Member Info");
		lbTitle.setBounds(12, 25, 400, 55);
		memdetail_panel.add(lbTitle);
		lbTitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

		errortxt = new JLabel("");
		errortxt.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 10));
		errortxt.setForeground(Color.RED);
		errortxt.setBounds(168, 498, 244, 24);
		memdetail_panel.add(errortxt);

		btn_logout = new RoundedButtonR("LOGOUT");
		btn_logout.setBounds(347, 10, 100, 35);
		detail.add(btn_logout);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Login loginpage = new Login();
					loginpage.setVisible(true);
					dispose();
					mafrm.dispose();
				}

			}
		});
		btn_logout.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));

	}
}
