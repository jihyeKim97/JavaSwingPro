package template.Application.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Panel;
import template.Application.controller.btn.RoundedButtonG;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import template.Application.controller.btn.RoundedButtonR;
import template.Application.controller.btn.RoundedButtonY;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AD_Member extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AD_Member frame = new AD_Member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AD_Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Vehicle Outdoor Cinema");
		setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 424, 613);
		panel.add(panel_1);

		JLabel label_11 = new JLabel("Member Info");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
		label_11.setBounds(12, 25, 400, 55);
		panel_1.add(label_11);

		RoundedButtonY rndbtnrSecession = new RoundedButtonY("Cancel");
		rndbtnrSecession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rndbtnrSecession.setText("Resign");
		rndbtnrSecession.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		rndbtnrSecession.setBounds(166, 538, 100, 45);
		panel_1.add(rndbtnrSecession);

		RoundedButtonG roundedButtonG = new RoundedButtonG("Ok");
		roundedButtonG.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		roundedButtonG.setBounds(59, 538, 100, 45);
		panel_1.add(roundedButtonG);

		RoundedButtonR rndbtngCancel = new RoundedButtonR("Ok");
		rndbtngCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		rndbtngCancel.setText("Cancel");
		rndbtngCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		rndbtngCancel.setBounds(273, 538, 100, 45);
		panel_1.add(rndbtngCancel);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 124, 424, 316);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		Panel panel_2 = new Panel();
		panel_2.setBounds(31, 0, 145, 316);
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 10));

		JLabel label = new JLabel("아이디 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label);

		JLabel label_1 = new JLabel("비밀번호 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("이름 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("전화번호 : ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("성별 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("생년월일 : ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_5);

		Panel panel_3 = new Panel();
		panel_3.setBounds(182, 0, 211, 316);
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 10));

		JLabel label_6 = new JLabel();
		label_6.setText((String) null);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(label_6);

		JLabel label_7 = new JLabel();
		label_7.setText((String) null);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(label_7);

		textField = new JTextField();
		textField.setText((String) null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField.setColumns(10);
		panel_3.add(textField);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_1.setColumns(10);
		panel_3.add(textField_1);

		JLabel label_8 = new JLabel();
		label_8.setText((String) null);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(label_8);

		JLabel label_9 = new JLabel();
		label_9.setText("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(label_9);
	}
}
