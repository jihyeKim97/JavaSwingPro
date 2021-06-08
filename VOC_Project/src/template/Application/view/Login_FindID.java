package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Login_FindID extends JFrame {

	JTextField txt_id;
	JPasswordField txt_pw;
	JPanel panel_1;
	JPanel panel_2;
	JTextField txt_name;
	JTextField txt_number1;
	JTextField txt_number2;
	JTextField txt_number3;

	Login ln;
	Login_FindID ID;

	public Login_FindID(Login ln) {
		this.ln = ln;
		setTitle("Vehicle Outdoor Cinema");
		setBounds(100, 100, 383, 429);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 373, 390);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디 찾기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(-3, 51, 373, 61);
		panel_1.add(lblNewLabel);

		txt_number1 = new JTextField();
		txt_number1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}

		});

		JPanel panel = new JPanel();
		panel.setBounds(18, 129, 332, 90);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lb_Name = new JLabel("\uC774\uB984");
		lb_Name.setBounds(0, 0, 100, 37);
		lb_Name.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_Name);
		lb_Name.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));

		txt_name = new JTextField();
		txt_name.setBounds(95, 0, 236, 37);
		panel.add(txt_name);
		txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_name.setForeground(Color.black);
				txt_name.setBackground(new Color(240, 240, 240));
				if (txt_name.getText().equals("ex) 홍길동")) {
					txt_name.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_name.setForeground(Color.LIGHT_GRAY);
				txt_name.setBackground(Color.WHITE);
				if (txt_name.getText().isEmpty())
					txt_name.setText("ex) 홍길동");
			}
		});
		txt_name.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_name.setColumns(10);

		JLabel lb_number = new JLabel("\uC804\uD654\uBC88\uD638");
		lb_number.setBounds(0, 52, 100, 37);
		lb_number.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_number);
		lb_number.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(95, 52, 236, 37);
		panel.add(panel_3);
		panel_3.setLayout(null);
		txt_number1 = new JTextField(3);
		txt_number1.setBounds(0, 0, 70, 37);
		panel_3.add(txt_number1);
		txt_number1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}
		});
		txt_number1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number1.setForeground(Color.black);
				txt_number1.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number1.setForeground(Color.LIGHT_GRAY);
				txt_number1.setBackground(Color.WHITE);
			}
		});
		txt_number1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number1.setColumns(3);

		JLabel label_2 = new JLabel("-");
		label_2.setBounds(65, 0, 20, 37);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_2);

		txt_number2 = new JTextField(4);
		txt_number2.setBounds(82, 0, 70, 37);
		panel_3.add(txt_number2);
		txt_number2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}
		});
		txt_number2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number2.setForeground(Color.black);
				txt_number2.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number2.setForeground(Color.LIGHT_GRAY);
				txt_number2.setBackground(Color.WHITE);
			}
		});
		txt_number2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number2.setColumns(4);

		JLabel label_1 = new JLabel("-");
		label_1.setBounds(148, 0, 20, 37);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_1);

		txt_number3 = new JTextField(4);
		txt_number3.setBounds(165, 0, 70, 37);
		panel_3.add(txt_number3);
		txt_number3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}
		});
		txt_number3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number3.setForeground(Color.black);
				txt_number3.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number3.setForeground(Color.LIGHT_GRAY);
				txt_number3.setBackground(Color.WHITE);
			}
		});
		txt_number3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number3.setColumns(4);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(41, 320, 298, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 30, 0));

		RoundedButtonR btn_Cancel = new RoundedButtonR("취소");
		btn_Cancel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel_4.add(btn_Cancel);

		RoundedButtonG btn_findId = new RoundedButtonG("완료");
		btn_findId.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel_4.add(btn_findId);

		btn_findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name.getText();
				Login_DB db = new Login_DB();
				String Phonenumber = new String(txt_number1.getText() + txt_number2.getText() + txt_number3.getText());
			
				int find = db.findid(name, Phonenumber);
				System.out.println(name);
				System.out.println(Phonenumber);
				System.out.println(find);
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
				dispose();
			}
		});
		btn_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Cancel.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Cancel.setForeground(Color.black);
			}
		});
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}
