package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;

public class Admin_Member_inquiry {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Member_inquiry window = new Admin_Member_inquiry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Member_inquiry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원정보");
		frame.setBounds(100, 100, 339, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디:");
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 85, 73, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("비밀번호:");
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 126, 73, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("이름:");
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 167, 73, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("전화번호:");
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 208, 73, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("성별:");
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(12, 249, 73, 31);
		frame.getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(84, 126, 129, 31);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(84, 167, 129, 31);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(84, 208, 40, 31);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(136, 208, 55, 31);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(203, 208, 55, 31);
		frame.getContentPane().add(textField_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("남");
		rdbtnNewRadioButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(84, 253, 52, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("여");
		radioButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		buttonGroup.add(radioButton);
		radioButton.setBounds(140, 253, 52, 23);
		frame.getContentPane().add(radioButton);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Candara Light", Font.BOLD, 33));
		lblProfile.setBounds(0, 20, 323, 55);
		frame.getContentPane().add(lblProfile);
		
		JButton btnNewButton = new JButton("적 용");
		btnNewButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btnNewButton.setBounds(39, 337, 97, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("취 소");
		button.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		button.setBounds(192, 337, 97, 39);
		frame.getContentPane().add(button);
		
		JLabel label_4 = new JLabel("생년월일:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label_4.setBounds(12, 282, 73, 31);
		frame.getContentPane().add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(84, 282, 129, 31);
		frame.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("계정");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(84, 85, 129, 31);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
