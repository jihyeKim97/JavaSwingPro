package template.Application.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Reservation_step2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_step2 frame = new Reservation_step2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reservation_step2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel content = new JPanel();
		content.setBackground(new Color(220, 220, 220));
		content.setBounds(0, 55, 484, 564);
		contentPane.add(content);
		content.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 10, 484, 261);
		content.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 464, 241);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 235, 205));
		panel_2.setBounds(0, 10, 141, 221);
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(153, 10, 311, 221);
		panel_1.add(panel_3);

		JLabel label = new JLabel("영화제목 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label.setBounds(0, 2, 100, 31);
		panel_3.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_1.setBounds(100, 2, 211, 31);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("영화 상영 날짜 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_2.setBounds(0, 33, 100, 31);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_3.setBounds(100, 33, 211, 31);
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("영화 상영 시간 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_4.setBounds(0, 64, 100, 31);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_5.setBounds(100, 64, 211, 31);
		panel_3.add(label_5);

		JLabel label_6 = new JLabel("좌석 번호 : ");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_6.setBounds(0, 95, 100, 31);
		panel_3.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_7.setBounds(100, 95, 211, 31);
		panel_3.add(label_7);

		JLabel label_8 = new JLabel("옵션 선택 : ");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_8.setBounds(0, 126, 100, 31);
		panel_3.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_9.setBounds(100, 126, 211, 31);
		panel_3.add(label_9);

		JLabel label_10 = new JLabel("옵션 금액 : ");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_10.setBounds(0, 157, 100, 31);
		panel_3.add(label_10);

		JLabel label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_11.setBounds(100, 157, 211, 31);
		panel_3.add(label_11);

		JLabel label_12 = new JLabel("총 결제 금액 : ");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_12.setBounds(0, 188, 100, 31);
		panel_3.add(label_12);

		JLabel label_13 = new JLabel("");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_13.setBounds(100, 188, 211, 31);
		panel_3.add(label_13);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 281, 484, 186);
		content.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 10, 464, 167);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel label_14 = new JLabel("카드 번호");
		label_14.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_14.setBounds(30, 7, 100, 30);
		panel_5.add(label_14);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(40, 37, 390, 30);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 15, 0));

		textField_3 = new JTextField();
		textField_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		panel_6.add(textField_3);
		textField_3.setColumns(10);

		passwordField_2 = new JPasswordField();
		panel_6.add(passwordField_2);

		passwordField_1 = new JPasswordField();
		panel_6.add(passwordField_1);

		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		panel_6.add(textField);
		textField.setColumns(10);

		JLabel label_15 = new JLabel("유효 기간");
		label_15.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_15.setBounds(30, 77, 100, 32);
		panel_5.add(label_15);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(40, 109, 86, 30);
		panel_5.add(textField_4);

		JLabel label_16 = new JLabel("비밀번호");
		label_16.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		label_16.setBounds(330, 77, 100, 32);
		panel_5.add(label_16);

		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lblCvc.setBounds(189, 77, 46, 32);
		panel_5.add(lblCvc);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(199, 109, 89, 30);
		panel_5.add(textField_6);

		passwordField = new JPasswordField();
		passwordField.setBounds(340, 109, 89, 30);
		panel_5.add(passwordField);

		RoundedButtonD btnNewButton = new RoundedButtonD("결제");
		btnNewButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 519, 464, 35);
		content.add(btnNewButton);

		Panel header = new Panel();
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));

		RoundedButtonD roundedButtonD = new RoundedButtonD("HOME");
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);
	}
}
