package template.Application.view.member;

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
import template.Application.controller.btn.RoundedButtonR;
import template.Application.view.admin.Admin_AdPage;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
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
	RoundedButtonR btn_Login;
	Login_FindID FindId;
	Login_FindPW FindPw;
	ImagePanel contentPane;

	Login ln;
	Main main;
	Login_DB LDB;
	Login_data LD;
	Admin_AdPage ad_page;
	ArrayList<Login_data> LoginArr;

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

		contentPane.setBounds(0, 0, 456, 479);
		contentPane.setBackground(new Color(70, 114, 42));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);

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
		lb_FindID.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

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
		lb_FindPW.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

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

		lb_SignUp.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 114, 42));
		panel_1.setBounds(165, 233, 198, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 10));

		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(txt_id);
		txt_id.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		txt_id.setColumns(10);

		txt_pw = new JPasswordField();
		txt_pw.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(txt_pw);
		txt_pw.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));

		 LD = LDB.SelectMemberFeID(txt_id.getText(), new String(txt_pw.getPassword()));
		btn_Login = new RoundedButtonR();
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = false;
				int ty = 0;
				String id = txt_id.getText();
				String pw = new String(txt_pw.getPassword());
				ArrayList<Login_data> LoginArr = LDB.selectAllMembers();
				for (int i = 0; i < LoginArr.size(); i++) {
					ArrayList<Login_data> memberdata = LDB.SelectMemberID(LoginArr.get(i).getMember_id());
					if (!id.isEmpty() && !pw.isEmpty()) {
						if (id.equals(LoginArr.get(i).getId()) && pw.equals(LoginArr.get(i).getPassword())) {
							check = true;
							if (memberdata.get(i).getIs_member() == 0) {
								System.out.println("회원 로그인 성공\n" + memberdata.get(i));
								main = new Main(ln, memberdata.get(0));
								main.setVisible(true);
								dispose();
							} else if (memberdata.get(i).getIs_member() == 1) {
								ad_page = new Admin_AdPage(ln, LD);
								ad_page.setVisible(true);
								dispose();
							} else if (memberdata.get(i).getIs_member() != 1 && memberdata.get(i).getIs_member() != 0) {
								JOptionPane.showMessageDialog(null, "탈퇴한 회원입니다");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "빈칸이 존재 합니다");
						ty = 1;
						break;
					}
				}
				if (check == false && ty == 0) {
					JOptionPane.showMessageDialog(null, "계정이 존재 하지 않습니다");
					txt_id.setText("");
					txt_pw.setText("");
				}
			}
		});

		btn_Login.setText("LOGIN");
		btn_Login.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_Login.setForeground(new Color(255, 255, 255));

		btn_Login.setBackground(Color.BLUE);
		btn_Login.setBounds(106, 363, 257, 43);
		contentPane.add(btn_Login);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/template/Reference/icons/bg (4).png")));
		lblNewLabel_1.setBounds(0, 0, 456, 482);
		contentPane.add(lblNewLabel_1);

	}
}
