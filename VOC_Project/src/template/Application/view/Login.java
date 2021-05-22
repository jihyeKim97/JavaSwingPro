package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	JPanel panel_1;
	JPanel panel_2;
	private JTextField txt_name;
	private JTextField txt_number1;
	private JTextField txt_number2;
	private JTextField txt_number3;
	String id = "java";
	String pass = "123123";
	String finalPhonenumber = "00000000000";
	private JTextField txt_IssuedName;
	private JTextField txt_IssuedId;
	private JTextField txt_number4;
	private JTextField txt_number5;
	private JTextField txt_number6;
	Login mln;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\82102\\Desktop\\movie\\iconfinder-video-film-camera-movie-photography-4593167_122280.png"));
		frame.setBounds(100, 100, 635, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -1, 619, 391);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_id = new JLabel("");
		lb_id.setHorizontalAlignment(SwingConstants.CENTER);
		lb_id.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\status_online.png"));
		lb_id.setBackground(SystemColor.activeCaptionText);
		lb_id.setBounds(169, 211, 35, 31);
		
		panel.add(lb_id);
		
		txt_id = new JTextField();
		txt_id.setBounds(204, 211, 185, 31);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lb_pw = new JLabel("");
		lb_pw.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUICafeProject\\icons\\key.png"));
		lb_pw.setHorizontalAlignment(SwingConstants.CENTER);
		lb_pw.setBackground(Color.WHITE);
		lb_pw.setBounds(169, 252, 35, 31);
		panel.add(lb_pw);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (id.equals(txt_id.getText()) && pass.equals(txt_pw.getText())) {
					JOptionPane.showMessageDialog(null, "로그인성공");
				} else {
					JOptionPane.showMessageDialog(null, "로그인실패");
				}
			}
		});
		btn_Login.setFont(new Font("굴림", Font.BOLD, 16));
		btn_Login.setForeground(SystemColor.desktop);
		btn_Login.setBackground(Color.BLUE);
		btn_Login.setBounds(401, 209, 97, 74);
		panel.add(btn_Login);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\82102\\Desktop\\movie\\VOC.png"));
		lblNewLabel_1.setBounds(216, 20, 212, 181);
		panel.add(lblNewLabel_1);
		
		JLabel lb_FindID = new JLabel("\uC544\uC774\uB514/");
		lb_FindID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("아이디 찾기 누름");
				panel.setVisible(false);
				panel_1.setVisible(true);
				lb_FindID.setOpaque(true);// 배경 불투명도 조정
				lb_FindID.setBackground(Color.LIGHT_GRAY);
			}
		});
		lb_FindID.setFont(new Font("굴림", Font.BOLD, 12));
		lb_FindID.setBounds(204, 293, 46, 25);
		panel.add(lb_FindID);
		
		JLabel lb_SignUp = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lb_SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp mbj = new SignUp (mln);
				mbj.setVisible(true);
				System.out.println("회원가입 누름");
				lb_SignUp.setOpaque(true);// 배경 불투명도 조정
				lb_SignUp.setBackground(Color.LIGHT_GRAY);
			}
		});
		lb_SignUp.setFont(new Font("굴림", Font.BOLD, 12));
		lb_SignUp.setBounds(401, 293, 56, 25);
		panel.add(lb_SignUp);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(204, 252, 185, 31);
		panel.add(txt_pw);
		
		JLabel lb_FindPW = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lb_FindPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("비밀번호 찾기 누름");
				panel.setVisible(false);
				panel_2.setVisible(true);
				lb_FindID.setOpaque(true);// 배경 불투명도 조정
				lb_FindID.setBackground(Color.LIGHT_GRAY);
			}
		});
		lb_FindPW.setFont(new Font("굴림", Font.BOLD, 12));
		lb_FindPW.setBounds(250, 293, 83, 25);
		panel.add(lb_FindPW);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 619, 390);
		frame.getContentPane().add(panel_1);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(216, 51, 187, 61);
		panel_1.add(lblNewLabel);
		
		JLabel lb_Name = new JLabel("\uC774\uB984");
		lb_Name.setFont(new Font("굴림", Font.BOLD, 17));
		lb_Name.setBounds(149, 139, 66, 40);
		panel_1.add(lb_Name);
		
		JLabel lb_number = new JLabel("\uC804\uD654\uBC88\uD638");
		lb_number.setFont(new Font("굴림", Font.BOLD, 17));
		lb_number.setBounds(149, 201, 79, 40);
		panel_1.add(lb_number);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_name.setBounds(216, 144, 144, 27);
		panel_1.add(txt_name);
		txt_name.setColumns(10);
		
		txt_number1 = new JTextField();
		txt_number1.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_number1.setBounds(240, 206, 50, 27);
		panel_1.add(txt_number1);
		txt_number1.setColumns(3);
		
		txt_number2 = new JTextField();
		txt_number2.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_number2.setColumns(4);
		txt_number2.setBounds(302, 206, 66, 27);
		panel_1.add(txt_number2);
		
		txt_number3 = new JTextField();
		txt_number3.setFont(new Font("굴림", Font.PLAIN, 16));
		txt_number3.setColumns(4);
		txt_number3.setBounds(380, 206, 66, 27);
		panel_1.add(txt_number3);
		
		JButton btn_Cancel = new JButton("\uCDE8\uC18C");
		btn_Cancel.setBackground(Color.RED);
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		btn_Cancel.setBounds(173, 270, 79, 40);
		panel_1.add(btn_Cancel);
		
		JButton btn_findId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btn_findId.setBackground(Color.BLUE);
		btn_findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Phonenumber = new String(txt_number1.getText()+txt_number2.getText()+txt_number3.getText());
				if (Phonenumber.equals(finalPhonenumber)) {
					JOptionPane.showMessageDialog(null, "귀하의 아이디는 "+ id + "입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "등록되지않은 아이디입니다.");
				}
			}
		});
		btn_findId.setBounds(302, 270, 117, 40);
		panel_1.add(btn_findId);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(370, 206, 11, 27);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(290, 206, 11, 27);
		panel_1.add(label_2);
		
		panel_2 = new JPanel();
		panel_2.setBounds(1, 0, 618, 390);
		frame.getContentPane().add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC784\uC2DC \uBE44\uBC00\uBC88\uD638 \uBC1C\uAE09");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(173, 10, 272, 55);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(133, 103, 72, 37);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("굴림", Font.BOLD, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(133, 165, 72, 37);
		panel_2.add(lblId);
		
		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		label_3.setFont(new Font("굴림", Font.BOLD, 18));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(108, 233, 97, 37);
		panel_2.add(label_3);
		
		txt_IssuedName = new JTextField();
		txt_IssuedName.setFont(new Font("굴림", Font.PLAIN, 17));
		txt_IssuedName.setBounds(213, 109, 165, 30);
		panel_2.add(txt_IssuedName);
		txt_IssuedName.setColumns(10);
		
		txt_IssuedId = new JTextField();
		txt_IssuedId.setFont(new Font("굴림", Font.PLAIN, 17));
		txt_IssuedId.setColumns(10);
		txt_IssuedId.setBounds(213, 171, 165, 30);
		panel_2.add(txt_IssuedId);
		
		txt_number4 = new JTextField();
		txt_number4.setFont(new Font("굴림", Font.PLAIN, 17));
		txt_number4.setColumns(3);
		txt_number4.setBounds(213, 238, 53, 30);
		panel_2.add(txt_number4);
		
		txt_number5 = new JTextField();
		txt_number5.setFont(new Font("굴림", Font.PLAIN, 17));
		txt_number5.setColumns(4);
		txt_number5.setBounds(287, 239, 79, 30);
		panel_2.add(txt_number5);
		
		txt_number6 = new JTextField();
		txt_number6.setFont(new Font("굴림", Font.PLAIN, 17));
		txt_number6.setColumns(4);
		txt_number6.setBounds(393, 239, 72, 30);
		panel_2.add(txt_number6);
		
		JLabel lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(274, 238, 12, 30);
		panel_2.add(lblNewLabel_4);
		
		JLabel label = new JLabel("-");
		label.setBounds(378, 238, 12, 30);
		panel_2.add(label);
		
		JButton btn_Cancel2 = new JButton("\uCDE8\uC18C");
		btn_Cancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btn_Cancel2.setFont(new Font("굴림", Font.BOLD, 17));
		btn_Cancel2.setBounds(169, 298, 97, 47);
		panel_2.add(btn_Cancel2);
		
		JButton btn_Issued = new JButton("\uBC1C\uAE09");
		btn_Issued.setBackground(SystemColor.activeCaption);
		btn_Issued.setFont(new Font("굴림", Font.BOLD, 16));
		btn_Issued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id == "java") {
					JOptionPane.showMessageDialog(null, "임시비밀번호 : 0a1b2c3d4e 입니다." );
				} else {
					JOptionPane.showMessageDialog(null, "임시비밀번호 발급 실패 !");
				}
			}
		});
		btn_Issued.setBounds(348, 298, 97, 47);
		panel_2.add(btn_Issued);
	}
}
