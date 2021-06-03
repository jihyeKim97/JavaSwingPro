package template.Application.view.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import template.Application.controller.DB.Login_DB;
import template.Application.view.Login;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
	JTextField jtf = new JTextField();
	

	Login ln;
	Login_FindPW pw;
	
	public Login_FindPW(Login ln) {
		this.ln = ln;
		setTitle("Vehicle Outdoor Cinema");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\82102\\Desktop\\movie\\iconfinder-video-film-camera-movie-photography-4593167_122280.png"));
		setBounds(100, 100, 523, 429);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 619, 390);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uC784\uC2DC \uBE44\uBC00\uBC88\uD638 \uBC1C\uAE09");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 27));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(118, 21, 272, 55);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(78, 103, 72, 37);
		panel_2.add(lblNewLabel_3);

		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(78, 165, 72, 37);
		panel_2.add(lblId);

		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(53, 233, 97, 37);
		panel_2.add(label_3);

		txt_IssuedName = new JTextField();
		txt_IssuedName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_IssuedName.setForeground(Color.black);
				txt_IssuedName.setBackground(Color.yellow);
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
		txt_IssuedName.setBounds(158, 109, 165, 30);
		panel_2.add(txt_IssuedName);
		txt_IssuedName.setColumns(10);

		txt_IssuedId = new JTextField();
		txt_IssuedId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_IssuedId.setForeground(Color.black);
				txt_IssuedId.setBackground(Color.yellow);

			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_IssuedId.setForeground(Color.LIGHT_GRAY);
				txt_IssuedId.setBackground(Color.WHITE);

			}
		});
		txt_IssuedId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_IssuedId.setColumns(10);
		txt_IssuedId.setBounds(158, 171, 165, 30);
		panel_2.add(txt_IssuedId);

		txt_number4 = new JTextField(3);
		txt_number4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 2||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		txt_number4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number4.setForeground(Color.black);
				txt_number4.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number4.setForeground(Color.LIGHT_GRAY);
				txt_number4.setBackground(Color.WHITE);
			}
		});
		txt_number4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number4.setColumns(3);
		txt_number4.setBounds(158, 238, 48, 30);
		panel_2.add(txt_number4);

	
		txt_number5 = new JTextField();
		txt_number5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 3||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		txt_number5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number5.setForeground(Color.black);
				txt_number5.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number5.setForeground(Color.LIGHT_GRAY);
				txt_number5.setBackground(Color.WHITE);
			}
		});
		txt_number5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number5.setColumns(4);
		txt_number5.setBounds(218, 237, 55, 30);
		panel_2.add(txt_number5);

		txt_number6 = new JTextField();
		txt_number6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length() > 3||
						(ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
						)
					ke.consume();
			}
		});
		txt_number6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_number6.setForeground(Color.black);
				txt_number6.setBackground(Color.yellow);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_number6.setForeground(Color.LIGHT_GRAY);
				txt_number6.setBackground(Color.WHITE);
			}
		});
		txt_number6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number6.setColumns(4);
		txt_number6.setBounds(285, 237, 55, 30);
		panel_2.add(txt_number6);

		JLabel lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(207, 239, 12, 30);
		panel_2.add(lblNewLabel_4);

		JLabel label = new JLabel("-");
		label.setBounds(274, 239, 12, 30);
		panel_2.add(label);

		JButton btn_Cancel2 = new JButton("\uCDE8\uC18C");
		btn_Cancel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Cancel2.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Cancel2.setForeground(Color.black);
			}
		});
		btn_Cancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Cancel2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 16));
		btn_Cancel2.setBounds(114, 298, 97, 47);
		panel_2.add(btn_Cancel2);

		JButton btn_Issued = new JButton("\uBC1C\uAE09");
		btn_Issued.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Issued.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Issued.setForeground(Color.black);
			}
		});
		btn_Issued.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 16));

		// PW ã��@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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
		btn_Issued.setBounds(285, 298, 97, 47);
		panel_2.add(btn_Issued);

	}
}
