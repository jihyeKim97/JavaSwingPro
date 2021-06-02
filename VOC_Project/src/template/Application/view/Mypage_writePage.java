package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import template.Application.controller.Mypage_DB;
import template.Application.controller.Mypage_Review_data;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Mypage_writePage extends JFrame {

	JPanel contentPane;
	MyPage frm;
	JTextField review_tf;
	Mypage_DB MDB;
	Mypage_Review_data Myoage_viDT;
	MyPage Mypage;
	String value;
	char df;
	int memberID = 34;
	int sco = 0;

	public Mypage_writePage(MyPage frm) {
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 352);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 400, 323);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 156, 350, 37);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("한줄 리뷰를 작성해 주세요!");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 38, 402, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("당신의 별점은?");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 137, 37);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JComboBox star_combo = new JComboBox();
		star_combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(star_combo)) {
					JComboBox cb = (JComboBox) e.getSource();
					value = (String) cb.getSelectedItem();
					for (int i = 0; i < value.length(); i++) {
						df = value.charAt(i);
						if (df >= 49 && df <= 53) {
							sco = (int) df - 48;
						}
					}
				}
			}
		});

		star_combo.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		star_combo.setBounds(149, 0, 201, 37);
		String[] comboF = { "★☆☆☆☆ : 1점", "★★☆☆☆ : 2점", "★★★☆☆ : 3점", "★★★★☆ : 4점", "★★★★★ : 5점" };
		star_combo.setModel(new DefaultComboBoxModel(comboF));
		panel_1.add(star_combo);

		review_tf = new JTextField();
		review_tf.setBounds(25, 103, 350, 43);
		panel.add(review_tf);
		review_tf.setColumns(10);

		JButton btn_success = new JButton("완료!");
		btn_success.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String review = review_tf.getText();
				boolean isResult = MDB.InsertReviewID(review, sco,
						MDB.SelectReservationID(memberID).get(0).getReservation_id(),
						MDB.SelectReservationID(memberID).get(0).getMovie_id());
				if (isResult) {
					dispose();
				}
			}
		});
		btn_success.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btn_success.setBounds(25, 255, 350, 43);
		panel.add(btn_success);
	}
}
