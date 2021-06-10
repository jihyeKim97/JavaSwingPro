package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.DB.Mypage_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.Data.Movie_Data;
import template.Application.controller.Data.Mypage_Reservation_data;
import template.Application.controller.Data.Mypage_Review_data;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Mypage_writePage extends JFrame {

	JPanel contentPane;
	JTextField review_tf;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel;
	JPanel panel_1;
	JComboBox star_combo;
	String value;
	RoundedButtonG btn_success;

	MyPage frm;
	Mypage_DB MDB;
	MyPage Mypage;

	int sco = 0;
	int i = 0;

	public Mypage_writePage(MyPage frm, Login_data Ld, int PK, JPanel reser_box, int c) {
		Mypage_Review_data ViArr = MDB
				.SelectReviewID(MDB.SelectReservationID(Ld.getMember_id()).get(c).getReservation_id(), PK);
		this.frm = frm;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 352);
		setResizable(false);
		setTitle("Vehicle Outdoor Cinema");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 400, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(25, 156, 350, 37);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("한줄 리뷰를 작성해 주세요!");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 38, 402, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		star_combo = new JComboBox();
		star_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(star_combo)) {
					JComboBox cb = (JComboBox) e.getSource();
					value = (String) cb.getSelectedItem();
					for (int i = 0; i < value.length(); i++) {
						char df = value.charAt(i);
						if (df >= 49 && df <= 53) {
							sco = (int) df - 48;
						}
					}
				}
			}
		});

		btn_success = new RoundedButtonG("완료!");
		btn_success.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "리뷰 등록이 완료 되었습니다");
			}
		});

		review_tf = new JTextField();
		review_tf.setBounds(25, 103, 350, 43);

		panel.add(review_tf);
		review_tf.setColumns(10);

		lblNewLabel_2 = new JLabel("당신의 별점은?");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 137, 37);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		ArrayList<Mypage_Reservation_data> ReArr = MDB.SelectReservationID(Ld.getMember_id());
		if (ViArr.getReviewID() != 0) {
			for (i = 0; i < ReArr.size(); i++) {
				if (ViArr.getMoviesID() == ReArr.get(i).getMovie_id()) {
					System.out.println("ReArr.get(i).getMovie_id() ====>"
							+ ReArr.get(Integer.parseInt(reser_box.getToolTipText())).getMovie_id());
					review_tf.setText(ViArr.getContent());
					lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
					String star = "";
					int score = 0;
					switch (ViArr.getStar_score()) {
					case 1:
						star = "★☆☆☆☆";
						score = 1;
						break;
					case 2:
						star = "★★☆☆☆";
						score = 2;
						break;
					case 3:
						star = "★★★☆☆";
						score = 3;
						break;
					case 4:
						star = "★★★★☆";
						score = 4;
						break;
					case 5:
						star = "★★★★★";
						score = 5;
						break;
					}
					lblNewLabel_1.setText(star + "  " + score + " 점");
					lblNewLabel_1.setBounds(149, 0, 201, 37);
					panel_1.add(lblNewLabel_1);
					btn_success.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String review = review_tf.getText();
							boolean isResult = MDB.UpdateReviewContent(ViArr.getReviewID(), review);
							if (isResult) {
								System.out.println("수정완료");
								dispose();
							}
						}
					});
				}
			}
		} else {
			star_combo.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
			star_combo.setBounds(149, 0, 201, 37);
			String[] comboF = { "★☆☆☆☆ : 1점", "★★☆☆☆ : 2점", "★★★☆☆ : 3점", "★★★★☆ : 4점", "★★★★★ : 5점" };
			star_combo.setModel(new DefaultComboBoxModel(comboF));
			panel_1.add(star_combo);

			btn_success.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String review = review_tf.getText();
					boolean isResult = MDB.InsertReviewID(review, sco,
							ReArr.get(Integer.parseInt(reser_box.getToolTipText())).getReservation_id(),
							ReArr.get(Integer.parseInt(reser_box.getToolTipText())).getMovie_id());
					if (isResult) {
						dispose();
					}
				}
			});
		}

		btn_success.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btn_success.setBounds(25, 255, 350, 43);
		panel.add(btn_success);

	}
}
