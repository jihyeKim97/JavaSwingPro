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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin_Member_inquiry {

	private JFrame frame;
	private JTextField ad_txt_pw;
	private JTextField ad_txt_name;
	private JTextField ad_txt_pn1;
	private JTextField ad_txt_pn2;
	private JTextField ad_txt_pn3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ad_txt_bd;

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
		
		JLabel ad_lb_id = new JLabel("아이디:");
		ad_lb_id.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_id.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_id.setBounds(12, 85, 73, 31);
		frame.getContentPane().add(ad_lb_id);
		
		JLabel ad_lb_pw = new JLabel("비밀번호:");
		ad_lb_pw.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_pw.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_pw.setBounds(12, 126, 73, 31);
		frame.getContentPane().add(ad_lb_pw);
		
		JLabel ad_lb_name = new JLabel("이름:");
		ad_lb_name.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_name.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_name.setBounds(12, 167, 73, 31);
		frame.getContentPane().add(ad_lb_name);
		
		JLabel ad_lb_pn = new JLabel("전화번호:");
		ad_lb_pn.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_pn.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_pn.setBounds(12, 208, 73, 31);
		frame.getContentPane().add(ad_lb_pn);
		
		JLabel ad_lb_gender = new JLabel("성별:");
		ad_lb_gender.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_gender.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_gender.setBounds(12, 249, 73, 31);
		frame.getContentPane().add(ad_lb_gender);
		
		ad_txt_pw = new JTextField();
		ad_txt_pw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_pw.setForeground(Color.black);
				ad_txt_pw.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_pw.setForeground(Color.LIGHT_GRAY);
				ad_txt_pw.setBackground(Color.WHITE);

			}
		});
		ad_txt_pw.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_pw.setColumns(10);
		ad_txt_pw.setBounds(84, 126, 129, 31);
		frame.getContentPane().add(ad_txt_pw);
		
		ad_txt_name = new JTextField();
		ad_txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_name.setForeground(Color.black);
				ad_txt_name.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_name.setForeground(Color.LIGHT_GRAY);
				ad_txt_name.setBackground(Color.WHITE);

			}
		});
		ad_txt_name.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_name.setColumns(10);
		ad_txt_name.setBounds(84, 167, 129, 31);
		frame.getContentPane().add(ad_txt_name);
		
		ad_txt_pn1 = new JTextField();
		ad_txt_pn1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 2||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		ad_txt_pn1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_pn1.setForeground(Color.black);
				ad_txt_pn1.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_pn1.setForeground(Color.LIGHT_GRAY);
				ad_txt_pn1.setBackground(Color.WHITE);

			}
		});
		ad_txt_pn1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_pn1.setColumns(10);
		ad_txt_pn1.setBounds(84, 208, 40, 31);
		frame.getContentPane().add(ad_txt_pn1);
		
		ad_txt_pn2 = new JTextField();
		ad_txt_pn2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 3||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		ad_txt_pn2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_pn2.setForeground(Color.black);
				ad_txt_pn2.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_pn2.setForeground(Color.LIGHT_GRAY);
				ad_txt_pn2.setBackground(Color.WHITE);

			}
		});
		ad_txt_pn2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_pn2.setColumns(10);
		ad_txt_pn2.setBounds(136, 208, 55, 31);
		frame.getContentPane().add(ad_txt_pn2);
		
		ad_txt_pn3 = new JTextField();
		ad_txt_pn3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 3||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		ad_txt_pn3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_pn3.setForeground(Color.black);
				ad_txt_pn3.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_pn3.setForeground(Color.LIGHT_GRAY);
				ad_txt_pn3.setBackground(Color.WHITE);

			}
		});
		ad_txt_pn3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_pn3.setColumns(10);
		ad_txt_pn3.setBounds(203, 208, 55, 31);
		frame.getContentPane().add(ad_txt_pn3);
		
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
		
		JButton ad_btn_ok = new JButton("ok");
		ad_btn_ok.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_btn_ok.setBounds(39, 337, 97, 39);
		frame.getContentPane().add(ad_btn_ok);
		
		JButton ad_btn_cancel = new JButton("cancel");
		ad_btn_cancel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_btn_cancel.setBounds(192, 337, 97, 39);
		frame.getContentPane().add(ad_btn_cancel);
		
		JLabel ad_lb_birthday = new JLabel("생년월일:");
		ad_lb_birthday.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_birthday.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_lb_birthday.setBounds(12, 282, 73, 31);
		frame.getContentPane().add(ad_lb_birthday);
		
		ad_txt_bd = new JTextField();
		ad_txt_bd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 5||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		ad_txt_bd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ad_txt_bd.setForeground(Color.black);
				ad_txt_bd.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_bd.setForeground(Color.LIGHT_GRAY);
				ad_txt_bd.setBackground(Color.WHITE);

			}
		});
		ad_txt_bd.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_bd.setColumns(10);
		ad_txt_bd.setBounds(84, 282, 129, 31);
		frame.getContentPane().add(ad_txt_bd);
		
		JLabel ad_lb_load_id = new JLabel("계정");
		ad_lb_load_id.setBackground(Color.LIGHT_GRAY);
		ad_lb_load_id.setOpaque(true);
		ad_lb_load_id.setBounds(84, 85, 129, 31);
		frame.getContentPane().add(ad_lb_load_id);
	}
}
