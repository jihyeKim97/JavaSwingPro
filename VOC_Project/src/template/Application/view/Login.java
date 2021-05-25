package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import template.Application.controller.DB_Connect;
import template.Application.controller.DB_Connect2;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	public JFrame frmVoc;
	public JTextField txt_id;
	public JPasswordField txt_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmVoc.setVisible(true);
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
		frmVoc = new JFrame();
		frmVoc.setTitle("Vehicle Outdoor Cinema");
		frmVoc.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\82102\\Desktop\\movie\\iconfinder-video-film-camera-movie-photography-4593167_122280.png"));
		frmVoc.setBounds(100, 100, 635, 429);
		frmVoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoc.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 619, 390);
		panel.setBackground(Color.LIGHT_GRAY);
		frmVoc.getContentPane().add(panel);
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
		btn_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Login.setBackground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Login.setBackground(Color.blue);
			}
		});
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txt_id.getText();
				String pw = new String(
						txt_pw.getPassword());
				DB_Connect2 mgr = new DB_Connect2();
				int r = mgr.loginProcess(login, pw);
				switch (r) {
				case DB_Connect2.LOGIN_SUCCESS:
					break;
				case DB_Connect2.LOGIN_FAIL_NOT_FOUND:
					JOptionPane.showMessageDialog(null, "로그인 회원 계정명 없음!!");
					break;
				case DB_Connect2.LOGIN_FAIL_PW_MISMATCH:
					JOptionPane.showMessageDialog(null, "로그인 암호가 불일치!!");
					break;
				case DB_Connect2.LOGIN_ERROR:	
					JOptionPane.showMessageDialog(null, "로그인 인증 입력/DB에러!!");
					break;	
				default:
					System.out.println("미지원!!");
					break;
				}
			}
		});
		btn_Login.setFont(new Font("굴림", Font.BOLD, 16));
		btn_Login.setForeground(SystemColor.desktop);
		btn_Login.setBackground(Color.BLUE);
		btn_Login.setBounds(401, 209, 112, 74);
		panel.add(btn_Login);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\82102\\Desktop\\movie\\VOC.png"));
		lblNewLabel_1.setBounds(216, 20, 212, 181);
		panel.add(lblNewLabel_1);
		
		JLabel lb_FindID = new JLabel("\uC544\uC774\uB514");
		lb_FindID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("아이디 찾기 누름");
				panel.setVisible(false);
			
			
				
				lb_FindID.setOpaque(true);// 배경 불투명도 조정
				lb_FindID.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_FindID.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_FindID.setForeground(Color.black);
			}
		});
		lb_FindID.setFont(new Font("굴림", Font.BOLD, 13));
		lb_FindID.setBounds(204, 293, 46, 25);
		panel.add(lb_FindID);
		
		JLabel lb_SignUp = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lb_SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입 누름");
				lb_SignUp.setOpaque(true);// 배경 불투명도 조정
				lb_SignUp.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_SignUp.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_SignUp.setForeground(Color.black);
			}
		});
		lb_SignUp.setFont(new Font("굴림", Font.BOLD, 13));
		lb_SignUp.setBounds(401, 293, 56, 25);
		panel.add(lb_SignUp);
		
		txt_pw = new JPasswordField();
		txt_pw.setBounds(204, 252, 185, 31);
		panel.add(txt_pw);
		
		JLabel lb_FindPW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lb_FindPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("비밀번호 찾기 누름");
				
				lb_FindID.setOpaque(true);
				lb_FindID.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_FindPW.setForeground(Color.red); 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_FindPW.setForeground(Color.black);
			}
		});
		lb_FindPW.setFont(new Font("굴림", Font.BOLD, 13));
		lb_FindPW.setBounds(256, 293, 56, 25);
		panel.add(lb_FindPW);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_5.setBounds(247, 279, 13, 52);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uCC3E\uAE30");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_6.setBounds(314, 298, 30, 15);
		panel.add(lblNewLabel_6);
	}
}
