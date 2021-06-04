package template.Application.view.member;

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
import template.Application.controller.DB.Login_DB;
import template.Application.controller.btn.RoundedButtonG;
import template.Application.controller.btn.RoundedButtonR;
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
	JTextField txt_number4;
	JTextField txt_number5;
	JTextField txt_number6;
	JLabel lblNewLabel_2;
	JPanel panel;
	RoundedButtonR btn_Cancel2;
	RoundedButtonG btn_Issued;
	JPanel panel_1;
	JLabel lblNewLabel_3;
	JLabel lblId;
	JLabel lblNewLabel_4;
	JPanel panel_3;
	JLabel label;
	JLabel label_3;

	Login ln;
	Login_FindPW pw;

	public Login_FindPW(Login ln) {
		this.ln = ln;
		setTitle("Vehicle Outdoor Cinema");
		setBounds(100, 100, 418, 423);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 409, 390);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_2 = new JLabel("임시 비밀번호 발급");
		lblNewLabel_2.setBounds(0, 21, 401, 55);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);

		panel = new JPanel();
		panel.setBounds(79, 326, 256, 43);
		panel_2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 30, 0));

		btn_Cancel2 = new RoundedButtonR("취소");
		btn_Cancel2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_Cancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btn_Cancel2);

		btn_Issued = new RoundedButtonG("완료");
		panel.add(btn_Issued);
		btn_Issued.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panel_1 = new JPanel();
		panel_1.setBounds(23, 109, 354, 189);
		panel_2.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(0, 0, 100, 53);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

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

		lblId = new JLabel("ID");
		lblId.setBounds(0, 68, 100, 53);
		panel_1.add(lblId);
		lblId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);

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
		label_3 = new JLabel("전화번호");
		label_3.setBounds(0, 136, 100, 53);
		panel_1.add(label_3);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);

		panel_3 = new JPanel();
		panel_3.setBounds(112, 136, 242, 53);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		txt_number4 = new JTextField(3);
		txt_number4.setBounds(1, 0, 70, 53);
		panel_3.add(txt_number4);
		txt_number4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_number4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number4.setForeground(Color.black);
				txt_number4.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number4.setForeground(Color.LIGHT_GRAY);
				txt_number4.setBackground(Color.WHITE);
			}
		});
		txt_number4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number4.setColumns(3);
		lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(54, 0, 48, 53);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);

		txt_number5 = new JTextField();
		txt_number5.setBounds(85, 0, 70, 53);
		panel_3.add(txt_number5);
		txt_number5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_number5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number5.setForeground(Color.black);
				txt_number5.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number5.setForeground(Color.LIGHT_GRAY);
				txt_number5.setBackground(Color.WHITE);
			}
		});
		txt_number5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number5.setColumns(4);

		label = new JLabel("-");
		label.setBounds(139, 0, 48, 53);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label);

		txt_number6 = new JTextField();
		txt_number6.setBounds(172, 0, 70, 53);
		panel_3.add(txt_number6);
		txt_number6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		txt_number6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number6.setForeground(Color.black);
				txt_number6.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number6.setForeground(Color.LIGHT_GRAY);
				txt_number6.setBackground(Color.WHITE);
			}
		});
		txt_number6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number6.setColumns(4);

		btn_Issued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_IssuedName.getText();
				String id = txt_IssuedId.getText();
				Login_DB db = new Login_DB();
				String Phonenumber = new String(
						txt_number4.getText() + "" + txt_number5.getText() + "" + txt_number6.getText());
				int find = db.findpw(name, id, Phonenumber);
				switch (find) {
				case 1:
					JOptionPane.showMessageDialog(null, "입력하신정보를 확인해주세요");
					break;
				case 2:
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "입력하신정보를 확인");
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
