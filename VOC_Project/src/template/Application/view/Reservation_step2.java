package template.Application.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;

import template.Application.controller.RoundPanel;
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

public class Reservation_step2 extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel header = new Panel();
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));

		RoundedButtonD roundedButtonD = new RoundedButtonD("HOME");
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 55, 484, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("결제가 완료되었습니다!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 4, 462, 61);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 484, 261);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 464, 241);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 235, 205));
		panel_3.setBounds(0, 10, 141, 221);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(141, 10, 311, 221);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("영화제목 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("영화 상영 날짜 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("영화 상영 시간 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("좌석 번호 : ");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("옵션 선택 : ");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("옵션 금액 : ");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("총 결제 금액 : ");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_4.add(label_13);
	}
}
