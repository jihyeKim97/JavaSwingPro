package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.Login_data;
import template.Application.controller.RoundedButtonD;
import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import template.Application.controller.DB_Connect;
import template.Application.controller.Login_DB;
import template.Application.controller.SignUp_data;
import template.Application.controller.SIgnUp_DB;

public class SignUp extends JFrame {

	JPanel contentPane;
	JPanel panel;
	JPanel panel_Gender;
	JPanel panel_bday;
	JPasswordField pwf_userPw2;
	JPasswordField pwf_userPw1;
	JTextField txt_userId;
	JTextField txt_userName;
	JTextField txt_phone3;
	JTextField txt_phone1;
	JTextField txt_phone2;
	JTextField txt_DoB;
	JLabel lb_DoB;
	JLabel lb_userId;
	JLabel lb_userPw1;
	JLabel lb_userPw2;
	JLabel lb_userName;
	JLabel lb_Gender;
	JLabel lb_userJoin;
	JLabel lblNewLabel;
	JButton btn_userJoin;
	JRadioButton rd_Female;
	JRadioButton rd_Male;

	final ButtonGroup genderGrp = new ButtonGroup();
	final int MEMBER = 0, NOT_MEMBER = 1;
	boolean bLoginAvail;

	SignUp mj;
	Login mln;
	Connection conn;
	SignUp_data dbui;
	JLabel lb_NoDup;
	DB_Connect dbc;
	Login_data lndt;
	Login_DB dbc2 = new Login_DB();
	SIgnUp_DB mgr = new SIgnUp_DB();

	public SignUp(Login mln) {

		this.conn = DB_Connect.getConn();
		this.mj = this;

		setTitle("Vehicle Outdoor Cinema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lb_userJoin = new JLabel();
		lb_userJoin.setText("회원가입");
		lb_userJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_userJoin.setBounds(0, 10, 497, 43);
		lb_userJoin.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lb_userJoin.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lb_userJoin);

		panel = new JPanel();
		panel.setBounds(10, 108, 475, 337);
		contentPane.add(panel);
		panel.setLayout(null);

		lb_userId = new JLabel("ID");
		lb_userId.setBounds(0, 2, 145, 39);
		lb_userId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_userId.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_userId);

		txt_userId = new JTextField();
		txt_userId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		txt_userId.setBounds(165, 2, 199, 39);
		panel.add(txt_userId);
		txt_userId.setColumns(10);

		RoundedButtonD btn_DupCheck = new RoundedButtonD("중복 확인");
		btn_DupCheck.setBounds(376, 2, 99, 39);
		panel.add(btn_DupCheck);
		btn_DupCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String inLogin = txt_userId.getText();
				Login_data ld = dbc2.selectOneMemberByLogin(inLogin);
				if (ld == null) {
					bLoginAvail = true;
					JOptionPane.showMessageDialog(null, "사용가능한 id 입니다");
					checkJoinAvailable();
					System.out.println("사용가능");
				} else {
					bLoginAvail = false;
					JOptionPane.showMessageDialog(null, "사용불가능한 id 입니다");
					System.out.println("사용불가능");
				}
			}
		});

		btn_DupCheck.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		lb_userPw1 = new JLabel("비밀번호");
		lb_userPw1.setBounds(0, 51, 145, 39);
		lb_userPw1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_userPw1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_userPw1);

		pwf_userPw1 = new JPasswordField();
		pwf_userPw1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		pwf_userPw1.setBounds(165, 51, 237, 39);
		pwf_userPw1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				pwf_userPw1.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pwf_userPw1.setBackground(Color.white);
			}
		});
		panel.add(pwf_userPw1);

		lb_userPw2 = new JLabel("비밀번호 확인");
		lb_userPw2.setBounds(0, 100, 145, 39);
		lb_userPw2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_userPw2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_userPw2);

		pwf_userPw2 = new JPasswordField();
		pwf_userPw2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		pwf_userPw2.setBounds(165, 100, 237, 39);
		pwf_userPw2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwf_userPw2.setBackground(Color.yellow);
				String strPw1 = new String(pwf_userPw1.getPassword());
				if (strPw1.isEmpty()) {
					pwf_userPw1.requestFocusInWindow();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				pwf_userPw2.setBackground(Color.white);
				String strPw1 = new String(pwf_userPw1.getPassword());
				String strPw2 = new String(pwf_userPw2.getPassword());
				if (strPw1.length() > 0 && strPw2.isEmpty()) {

				} else {
					if (strPw1.length() > 0 && strPw2.length() > 0) {
						if (strPw2.equals(strPw1)) {
							System.out.println("암호 일치");

							checkJoinAvailable();
						} else {
							System.out.println("암호 불일치");
							pwf_userPw1.requestFocusInWindow();
						}
					}
				}
			}
		});
		panel.add(pwf_userPw2);

		lb_userName = new JLabel("이름");
		lb_userName.setBounds(0, 149, 145, 39);
		lb_userName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_userName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_userName);

		txt_userName = new JTextField();
		txt_userName.setBounds(165, 149, 237, 39);
		txt_userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_userName.setForeground(Color.black);
				txt_userName.setBackground(Color.yellow);
				if (txt_userName.getText().equals("ex) 홍길동"))
					txt_userName.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_userName.setForeground(Color.LIGHT_GRAY);
				txt_userName.setBackground(Color.WHITE);
				if (txt_userName.getText().isEmpty())
					txt_userName.setText("ex) 홍길동");
			}
		});
		txt_userName.setForeground(Color.LIGHT_GRAY);
		txt_userName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel.add(txt_userName);
		txt_userName.setColumns(10);

		lb_Gender = new JLabel("성별");
		lb_Gender.setBounds(0, 198, 145, 39);
		lb_Gender.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_Gender.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_Gender);

		panel_Gender = new JPanel();
		panel_Gender.setBounds(165, 198, 237, 39);
		panel.add(panel_Gender);
		panel_Gender.setLayout(new GridLayout(0, 2, 0, 0));

		rd_Female = new JRadioButton("\uC5EC\uC131");
		genderGrp.add(rd_Female);
		rd_Female.setSelected(true);
		rd_Female.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		rd_Female.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Gender.add(rd_Female);

		rd_Male = new JRadioButton("\uB0A8\uC131");
		genderGrp.add(rd_Male);
		rd_Male.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		rd_Male.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Gender.add(rd_Male);

		lb_DoB = new JLabel("생년월일");
		lb_DoB.setBounds(0, 247, 145, 39);
		lb_DoB.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_DoB.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_DoB);

		panel_bday = new JPanel();
		panel_bday.setBounds(165, 247, 237, 39);
		panel.add(panel_bday);
		panel_bday.setLayout(new GridLayout(0, 1, 0, 0));

		txt_DoB = new JTextField();
		panel_bday.add(txt_DoB);

		txt_DoB.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 5
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});

		txt_DoB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_DoB.setForeground(Color.black);
				txt_DoB.setBackground(Color.yellow);
				if (txt_DoB.getText().equals("ex) 19910101"))
					txt_DoB.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_DoB.setForeground(Color.LIGHT_GRAY);
				txt_DoB.setBackground(Color.WHITE);
				if (txt_DoB.getText().isEmpty())
					txt_DoB.setText("ex) 19910101");
			}
		});
		txt_DoB.setForeground(Color.LIGHT_GRAY);
		txt_DoB.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		txt_DoB.setText("ex) 19910101");
		txt_DoB.setColumns(10);

		JLabel lb_phoneNumber = new JLabel("전화번호");
		lb_phoneNumber.setBounds(0, 296, 145, 39);
		lb_phoneNumber.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lb_phoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_phoneNumber);

		JPanel panel_phoneNum = new JPanel();
		panel_phoneNum.setBounds(165, 296, 310, 39);
		panel.add(panel_phoneNum);

		txt_phone1 = new JTextField();
		txt_phone1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		txt_phone1.setBounds(0, 0, 80, 39);

		txt_phone1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_phone1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_phone1.setForeground(Color.black);
				txt_phone1.setBackground(Color.yellow);
				if (txt_phone1.getText().equals("010"))
					txt_phone1.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_phone1.setForeground(Color.LIGHT_GRAY);
				txt_phone1.setBackground(Color.WHITE);
				if (txt_phone1.getText().isEmpty())
					txt_phone1.setText("010");
			}
		});
		panel_phoneNum.setLayout(null);
		txt_phone1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_phone1.setForeground(Color.LIGHT_GRAY);
		txt_phone1.setText("010");
		panel_phoneNum.add(txt_phone1);
		txt_phone1.setColumns(10);

		JLabel lb_phoneNum2 = new JLabel(" -");
		lb_phoneNum2.setBounds(80, 0, 30, 39);
		lb_phoneNum2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_phoneNum.add(lb_phoneNum2);

		txt_phone3 = new JTextField();
		txt_phone3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		txt_phone3.setBounds(220, 0, 80, 39);
		txt_phone3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_phone3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_phone3.setForeground(Color.black);
				txt_phone3.setBackground(Color.yellow);
				if (txt_phone3.getText().equals("5678"))
					txt_phone3.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_phone3.setForeground(Color.LIGHT_GRAY);
				txt_phone3.setBackground(Color.WHITE);
				if (txt_phone3.getText().isEmpty())
					txt_phone3.setText("5678");
			}
		});

		txt_phone2 = new JTextField();
		txt_phone2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		txt_phone2.setBounds(110, 0, 80, 39);

		txt_phone2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_phone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_phone2.setForeground(Color.black);
				txt_phone2.setBackground(Color.yellow);
				if (txt_phone2.getText().equals("1234"))
					txt_phone2.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_phone2.setForeground(Color.LIGHT_GRAY);
				txt_phone2.setBackground(Color.WHITE);
				if (txt_phone2.getText().isEmpty())
					txt_phone2.setText("1234");

			}
		});
		txt_phone2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_phone2.setForeground(Color.LIGHT_GRAY);
		txt_phone2.setText("1234");
		panel_phoneNum.add(txt_phone2);
		txt_phone2.setColumns(10);

		JLabel lb_phoneNum1 = new JLabel("-");
		lb_phoneNum1.setBounds(190, 0, 30, 39);
		lb_phoneNum1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_phoneNum.add(lb_phoneNum1);
		txt_phone3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_phone3.setForeground(Color.LIGHT_GRAY);
		txt_phone3.setText("5678");
		panel_phoneNum.add(txt_phone3);
		txt_phone3.setColumns(10);

		RoundedButtonR btn_cancel = new RoundedButtonR("\uCDE8\uC18C");
		btn_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_cancel.setBackground(Color.LIGHT_GRAY);
		btn_cancel.setBounds(51, 505, 136, 50);
		contentPane.add(btn_cancel);

		RoundedButtonG btn_userJoin = new RoundedButtonG("가입 완료");
		btn_userJoin.setText("완료");
		btn_userJoin.setBackground(new Color(255, 175, 175));
		btn_userJoin.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		SIgnUp_DB mgr = new SIgnUp_DB();
		btn_userJoin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String UserId = txt_userId.getText();
				String UserPw = new String(pwf_userPw1.getPassword());
				String UserName = txt_userId.getText();
				int Gender = rd_Female.isSelected() ? SignUp_data.GENDER_FEMALE : SignUp_data.GENDER_MALE;
				String UserDoB = txt_DoB.getText();
				String UserPhoneNum = txt_phone1.getText() + txt_phone2.getText() + txt_phone3.getText();
				SignUp_data newUI = new SignUp_data(UserId, UserPw, UserName, Gender, UserPhoneNum, UserDoB);

				boolean r = mgr.insertNewMember(newUI);
				if (r) {
					JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
					dispose();
				} else
					JOptionPane.showMessageDialog(null, "회원 가입 실패! 다시 확인해주세요.");
			}
		});

		btn_userJoin.setEnabled(true);
		btn_userJoin.setBounds(303, 505, 136, 50);
		contentPane.add(btn_userJoin);

		lblNewLabel = new JLabel("자동차 예매 극장 프로그램");
		lblNewLabel.setBounds(173, 55, 154, 15);
		contentPane.add(lblNewLabel);
	}

	public void checkJoinAvailable() {
		String strPw1 = new String(pwf_userPw1.getPassword());
		String strPw2 = new String(pwf_userPw2.getPassword());
		if ((strPw1.length() > 0 && strPw2.length() > 0) && bLoginAvail == true
				&& (!txt_DoB.getText().isEmpty() == false)
				&& (txt_userName.getText().isEmpty() == false && txt_userName.getText().equals("ex) 홍길동") == false)) {
			if (strPw2.equals(strPw1)) {
				btn_userJoin.setEnabled(true);
			} else {
				btn_userJoin.setEnabled(false);
			}
		}
	}
}
