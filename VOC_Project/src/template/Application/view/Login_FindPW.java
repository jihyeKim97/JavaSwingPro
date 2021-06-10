package template.Application.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Login_DB;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;

public class Login_FindPW extends JFrame {

	JFrame frmVoc = new JFrame();
	JTextField txt_id;
	JPasswordField txt_pw;
	JPanel panel_2;
	JTextField txt_IssuedName;
	JTextField txt_IssuedId;
	JTextField txt_first;
	JTextField txt_second;
	JTextField txt_third;
	JLabel lb_title;
	JPanel panel;
	RoundedButtonR btn_Cancel;
	RoundedButtonG btn_Issued;
	JPanel panel_1;
	JLabel lb_userName;
	JLabel lb_userId;
	JLabel lblNewLabel_4;
	JPanel panel_3;
	JLabel label;
	JLabel lb_userPhoneNumber;

	Login ln;
	Login_FindPW pw;

	public Login_FindPW(Login ln) {
		this.ln = ln;
		setTitle("Vehicle Outdoor Cinema");
		setBounds(100, 100, 418, 423);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 402, 390);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lb_title = new JLabel("임시 비밀번호 발급");
		lb_title.setBounds(0, 21, 401, 55);
		lb_title.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lb_title);

		panel = new JPanel();
		panel.setBounds(79, 326, 256, 43);
		panel_2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 30, 0));

		btn_Cancel = new RoundedButtonR("취소");
		btn_Cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btn_Cancel);

		btn_Issued = new RoundedButtonG("완료");
		panel.add(btn_Issued);
		btn_Issued.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panel_1 = new JPanel();
		panel_1.setBounds(23, 109, 354, 189);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		lb_userName = new JLabel("이름");
		lb_userName.setBounds(0, 0, 100, 53);
		panel_1.add(lb_userName);
		lb_userName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lb_userName.setHorizontalAlignment(SwingConstants.CENTER);

		txt_IssuedName = new JTextField();
		txt_IssuedName.setBounds(112, 0, 242, 53);
		panel_1.add(txt_IssuedName);
		txt_IssuedName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_IssuedName.setForeground(Color.black);
				txt_IssuedName.setBackground(new Color(240, 240, 240));
				if (txt_IssuedName.getText().equals("ex) 홍길동"))
					txt_IssuedName.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_IssuedName.setForeground(Color.LIGHT_GRAY);
				txt_IssuedName.setBackground(Color.WHITE);
				if (txt_IssuedName.getText().isEmpty())
					txt_IssuedName.setText("ex) 홍길동");
			}
		});
		txt_IssuedName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_IssuedName.setColumns(10);

		lb_userId = new JLabel("ID");
		lb_userId.setBounds(0, 68, 100, 53);
		panel_1.add(lb_userId);
		lb_userId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lb_userId.setHorizontalAlignment(SwingConstants.CENTER);

		txt_IssuedId = new JTextField();
		txt_IssuedId.setBounds(112, 68, 242, 53);
		panel_1.add(txt_IssuedId);
		txt_IssuedId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_IssuedId.setForeground(Color.black);
				txt_IssuedId.setBackground(new Color(240, 240, 240));

			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_IssuedId.setForeground(Color.LIGHT_GRAY);
				txt_IssuedId.setBackground(Color.WHITE);

			}
		});
		txt_IssuedId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_IssuedId.setColumns(10);
		lb_userPhoneNumber = new JLabel("전화번호");
		lb_userPhoneNumber.setBounds(0, 136, 100, 53);
		panel_1.add(lb_userPhoneNumber);
		lb_userPhoneNumber.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lb_userPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);

		panel_3 = new JPanel();
		panel_3.setBounds(112, 136, 242, 53);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		txt_first = new JTextField(3);
		txt_first.setBounds(1, 0, 70, 53);
		panel_3.add(txt_first);
		txt_first.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_first.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_first.setForeground(Color.black);
				txt_first.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_first.setForeground(Color.LIGHT_GRAY);
				txt_first.setBackground(Color.WHITE);
			}
		});
		txt_first.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_first.setColumns(3);
		lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(54, 0, 48, 53);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);

		txt_second = new JTextField();
		txt_second.setBounds(85, 0, 70, 53);
		panel_3.add(txt_second);
		txt_second.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_second.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_second.setForeground(Color.black);
				txt_second.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_second.setForeground(Color.LIGHT_GRAY);
				txt_second.setBackground(Color.WHITE);
			}
		});
		txt_second.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_second.setColumns(4);

		label = new JLabel("-");
		label.setBounds(139, 0, 48, 53);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label);

		txt_third = new JTextField();
		txt_third.setBounds(172, 0, 70, 53);
		panel_3.add(txt_third);
		txt_third.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_third.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_third.setForeground(Color.black);
				txt_third.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_third.setForeground(Color.LIGHT_GRAY);
				txt_third.setBackground(Color.WHITE);
			}
		});
		txt_third.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_third.setColumns(4);

		btn_Issued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_IssuedName.getText();
				String id = txt_IssuedId.getText();
				Login_DB db = new Login_DB();
				String Phonenumber = new String(
						txt_first.getText() + "" + txt_second.getText() + "" + txt_third.getText());
				int find = db.findpw(name, id, Phonenumber);
				switch (find) {
				case 1:
					JOptionPane.showMessageDialog(null, "입력하신정보를 확인해주세요");
					break;
				case 2:
					dispose();
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "빈칸이 존재 합니다");
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "핸드폰번호를 확인해주세요");
					break;
				default:
					break;
				}
			}
		});
	}
}
