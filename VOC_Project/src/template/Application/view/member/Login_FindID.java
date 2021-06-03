package template.Application.view.member;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import template.Application.controller.DB.DB_Connect;
import template.Application.controller.DB.Login_DB;
import template.Application.view.Login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\82102\\Desktop\\movie\\iconfinder-video-film-camera-movie-photography-4593167_122280.png"));
		setBounds(100, 100, 523, 429);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 511, 390);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
		lblNewLabel.setBounds(169, 52, 187, 61);
		panel_1.add(lblNewLabel);

		JLabel lb_Name = new JLabel("\uC774\uB984");
		lb_Name.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 17));
		lb_Name.setBounds(126, 140, 66, 40);
		panel_1.add(lb_Name);

		JLabel lb_number = new JLabel("\uC804\uD654\uBC88\uD638");
		lb_number.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 17));
		lb_number.setBounds(102, 202, 79, 40);
		panel_1.add(lb_number);

		txt_name = new JTextField();
		txt_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_name.setForeground(Color.black);
				txt_name.setBackground(Color.yellow);
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
		txt_name.setBounds(192, 145, 144, 27);
		panel_1.add(txt_name);
		txt_name.setColumns(10);

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
		txt_number1 = new JTextField(3);
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
				txt_number1.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number1.setForeground(Color.LIGHT_GRAY);
				txt_number1.setBackground(Color.WHITE);
			}
		});
		txt_number1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number1.setBounds(193, 207, 48, 27);
		panel_1.add(txt_number1);
		txt_number1.setColumns(3);

		txt_number2 = new JTextField(4);
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
				txt_number2.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number2.setForeground(Color.LIGHT_GRAY);
				txt_number2.setBackground(Color.WHITE);
			}
		});
		txt_number2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number2.setColumns(4);
		txt_number2.setBounds(253, 208, 55, 27);
		panel_1.add(txt_number2);

		txt_number3 = new JTextField(4);
		txt_number3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 3
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}
		});
		panel_1.add(txt_number3);
		txt_number3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number3.setForeground(Color.black);
				txt_number3.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number3.setForeground(Color.LIGHT_GRAY);
				txt_number3.setBackground(Color.WHITE);
			}
		});
		txt_number3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_number3.setColumns(4);
		txt_number3.setBounds(320, 208, 55, 27);
		panel_1.add(txt_number3);

		JButton btn_Cancel = new JButton("\uCDE8\uC18C");
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
		btn_Cancel.setBounds(126, 271, 79, 40);
		panel_1.add(btn_Cancel);

		JButton btn_findId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btn_findId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_findId.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_findId.setForeground(Color.black);
			}
		});

		btn_findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name.getText();
				Login_DB db = new Login_DB();
				String Phonenumber = new String(txt_number1.getText() + txt_number2.getText() + txt_number3.getText());
				int find = db.findid(name, Phonenumber);
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
		btn_findId.setBounds(255, 271, 117, 40);
		panel_1.add(btn_findId);

		JLabel label_1 = new JLabel("-");
		label_1.setBounds(310, 207, 11, 27);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("-");
		label_2.setBounds(243, 207, 11, 27);
		panel_1.add(label_2);

	}
}
