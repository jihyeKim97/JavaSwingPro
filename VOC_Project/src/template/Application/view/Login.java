package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import template.Application.controller.ImagePanel;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.Data.Login_data;
import template.Application.controller.btn.RoundedButtonD;
import template.Application.view.member.Login_FindID;
import template.Application.view.member.Login_FindPW;
import template.Application.view.member.SignUp;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.GridLayout;

public class Login extends JFrame {
	JTextField txt_id;
	JPasswordField txt_pw;
	JLabel lb_SignUp;
	JPanel panel_1;
	JLabel lblNewLabel_1;
	JLabel lb_FindPW;
	JLabel lb_FindID;
	JPanel panel;
	JLabel lblNewLabel;
	JLabel label;
	RoundedButtonD btn_Login;
	Login_FindID FindId;
	Login_FindPW FindPw;
	ImagePanel contentPane;

	Login ln;
	Main main;
	Login_DB LDB;
	int memberID = 24;
	Admin_AdPage ad_page;
	Login_data LD = new Login_data();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		this.ln = this;
		ArrayList<Login_data> loArr = LDB.SelectMemberID(memberID);
		setTitle("Vehicle Outdoor Cinema");
		setBounds(100, 100, 460, 508);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		ImageIcon icBack = new ImageIcon(".src/template/Reference/icons/movie2.jpg");
		Image bgImg = icBack.getImage();
		contentPane = new ImagePanel(bgImg, "bg1.jpg", 456, 534);
		contentPane.setImgFilename("");

		contentPane.setBounds(0, 0, 456, 534);
		contentPane.setBackground(new Color(240, 240, 240));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);

		btn_Login = new RoundedButtonD("Login");
		btn_Login.setText("LOGIN");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txt_id.getText();
				String pw = new String(txt_pw.getPassword());
				Login_DB mgr = new Login_DB();
				int r = mgr.loginProcess(login, pw);

				switch (r) {
				case Login_DB.LOGIN_SUCCESS:
					
					if (loArr.get(0).getIs_member() == 0) {
						// 회원 메인 페이지로 이동
						main = new Main(ln, LD);
						main.setVisible(true);
						dispose();
					} else if (loArr.get(0).getIs_member() == 1) {
						// 관리자 페이지로 이동
						System.out.println(loArr.get(0).getIs_member());
						ad_page = new Admin_AdPage(ln, LD);
						ad_page.setVisible(true);
						dispose();

					} else if (loArr.get(0).getIs_member() == 2) {
						JOptionPane.showMessageDialog(null, "탈퇴 회원입니다");
					} else {
						JOptionPane.showMessageDialog(null, "로그인 회원 계정명 없음!!");
					}
					
					
					break;
				case Login_DB.LOGIN_FAIL_NOT_FOUND:
					JOptionPane.showMessageDialog(null, "로그인 회원 계정명 없음!!");
					break;
				case Login_DB.LOGIN_FAIL_PW_MISMATCH:
					JOptionPane.showMessageDialog(null, "로그인 암호가 불일치!!");

					break;
				case Login_DB.LOGIN_ERROR:
					JOptionPane.showMessageDialog(null, "로그인 인증 입력/DB에러!!");
					break;

				default:
					System.out.println("지원하지않습니다.");
					break;
				}
			}
		});

		btn_Login.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_Login.setForeground(new Color(255, 255, 255));

		btn_Login.setBackground(Color.BLUE);
		btn_Login.setBounds(181, 363, 114, 39);
		contentPane.add(btn_Login);

		lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(126, 240, 29, 24);
		contentPane.add(lblNewLabel);

		label = new JLabel("PW");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label.setBounds(118, 283, 37, 24);
		contentPane.add(label);

		panel = new JPanel();
		panel.setBackground(new Color(70, 114, 42));
		panel.setBounds(106, 323, 257, 30);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		lb_FindID = new JLabel("아이디 찾기");
		lb_FindID.setForeground(Color.WHITE);
		lb_FindID.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_FindID);
		lb_FindID.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("아이디 찾기 누름");
				Login_FindID fid = new Login_FindID(ln);
				Point fPt = ln.getLocationOnScreen();
				fid.setLocation(fPt.x + ln.getWidth() + 20, fPt.y);
				fid.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_FindID.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_FindID.setForeground(Color.WHITE);
			}
		});
		lb_FindID.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		lb_FindPW = new JLabel("비밀번호 찾기");
		lb_FindPW.setForeground(Color.WHITE);
		lb_FindPW.setHorizontalAlignment(SwingConstants.CENTER);
		lb_FindPW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_FindPW fpw = new Login_FindPW(ln);
				Point fPt = ln.getLocationOnScreen();
				fpw.setLocation(fPt.x + ln.getWidth() + 20, fPt.y);
				fpw.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_FindPW.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_FindPW.setForeground(Color.WHITE);
			}
		});
		panel.add(lb_FindPW);
		lb_FindPW.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		lb_SignUp = new JLabel();
		lb_SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignUp sign = new SignUp(ln);
				Point fPt = ln.getLocationOnScreen();
				sign.setLocation(fPt.x + ln.getWidth() + 20, fPt.y);
				sign.setVisible(true);
			}
		});
		lb_SignUp.setForeground(Color.WHITE);
		lb_SignUp.setText("회원가입");
		lb_SignUp.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_SignUp);

		lb_SignUp.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 114, 42));
		panel_1.setBounds(165, 233, 198, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 10));

		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(txt_id);
		txt_id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_id.setForeground(Color.black);
				txt_id.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_id.setForeground(Color.LIGHT_GRAY);
				txt_id.setBackground(Color.WHITE);

			}
		});
		txt_id.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_id.setColumns(10);

		txt_pw = new JPasswordField();
		txt_pw.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(txt_pw);
		txt_pw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_pw.setForeground(Color.black);
				txt_pw.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				txt_pw.setForeground(Color.LIGHT_GRAY);
				txt_pw.setBackground(Color.WHITE);
			}
		});
		txt_pw.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/template/Reference/icons/bg (4).png")));
		lblNewLabel_1.setBounds(0, 0, 458, 483);
		contentPane.add(lblNewLabel_1);

	}
}
