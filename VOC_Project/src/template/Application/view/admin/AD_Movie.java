package template.Application.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.btn.RoundedButtonG;
import template.Application.controller.btn.RoundedButtonR;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AD_Movie extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AD_Movie frame = new AD_Movie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AD_Movie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 841);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Vehicle Outdoor Cinema");
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Movie Infomation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 534, 51);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 61, 534, 282);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 179, 261);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(AD_Movie.class.getResource("/template/Reference/images/어바웃타임.jpg")));
		panel_2.add(lblNewLabel_4);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(203, 0, 319, 271);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("줄거리");
		lblNewLabel_2.setBackground(new Color(112, 128, 144));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(12, 10, 295, 27);
		panel_3.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 297, 233);
		panel_3.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 353, 534, 362);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 10, 510, 340);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 166, 340);
		panel_6.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 10));

		JLabel lblNewLabel_3 = new JLabel("제목");
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label = new JLabel("장르");
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("감독");
		panel_4.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_2 = new JLabel("연령등급");
		panel_4.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_3 = new JLabel("등장인물");
		panel_4.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_4 = new JLabel("개봉일");
		panel_4.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_5 = new JLabel("제작사");
		panel_4.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("이미지 경로");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_5);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(178, 0, 332, 340);
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 10));

		textField = new JTextField();
		panel_7.add(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField.setColumns(10);

		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		panel_7.add(textField_2);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		panel_7.add(textField_3);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_3.setColumns(10);

		textField_5 = new JTextField();
		panel_7.add(textField_5);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		panel_7.add(textField_6);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_6.setColumns(10);

		textField_4 = new JTextField();
		panel_7.add(textField_4);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("  NO PATH");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_6);

		RoundedButtonG btnNewButton = new RoundedButtonG("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnNewButton.setBounds(162, 737, 100, 45);
		panel.add(btnNewButton);

		RoundedButtonR btnCancel = new RoundedButtonR("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnCancel.setBounds(268, 737, 100, 45);
		panel.add(btnCancel);
	}
}
