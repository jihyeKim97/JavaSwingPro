package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage_Member extends JFrame {

	private JPanel contentPane;
	private JTextField txt_OldPw;
	private JTextField txt_NewPw;
	private JTextField txt_NewPw2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage_Member frame = new MyPage_Member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyPage_Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Head = new JPanel();
		pn_Head.setLayout(null);
		pn_Head.setBackground(Color.WHITE);
		pn_Head.setBounds(0, 0, 434, 24);
		contentPane.add(pn_Head);
		
		JButton button = new JButton("Logout");
		button.setBounds(0, 0, 79, 23);
		pn_Head.add(button);
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label.setBounds(419, 3, 15, 15);
		pn_Head.add(label);
		
		JButton button_1 = new JButton("home");
		button_1.setToolTipText("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		button_1.setBounds(341, 0, 69, 23);
		pn_Head.add(button_1);
		
		JPanel pn_userinfomation = new JPanel();
		pn_userinfomation.setBounds(10, 36, 408, 505);
		contentPane.add(pn_userinfomation);
		pn_userinfomation.setLayout(null);
		
		JPanel pn_UserInfomationTitle = new JPanel();
		pn_UserInfomationTitle.setBackground(Color.WHITE);
		pn_UserInfomationTitle.setBounds(0, 0, 408, 54);
		pn_userinfomation.add(pn_UserInfomationTitle);
		pn_UserInfomationTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lb_UserInfomationTitle = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lb_UserInfomationTitle.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lb_UserInfomationTitle.setForeground(Color.BLACK);
		lb_UserInfomationTitle.setBackground(Color.WHITE);
		lb_UserInfomationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn_UserInfomationTitle.add(lb_UserInfomationTitle, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(181, 66, 101, 106);
		pn_userinfomation.add(panel);
		
		JLabel lb_Name = new JLabel("\uC131\uBA85");
		lb_Name.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lb_Name.setBounds(144, 198, 62, 18);
		pn_userinfomation.add(lb_Name);
		
		JLabel lb_UserName = new JLabel("\uC774\uB984\uC785\uB825");
		lb_UserName.setBounds(268, 198, 62, 18);
		pn_userinfomation.add(lb_UserName);
		
		JLabel lb_Id = new JLabel("\uC544\uC774\uB514");
		lb_Id.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lb_Id.setBounds(144, 249, 62, 18);
		pn_userinfomation.add(lb_Id);
		
		JLabel lb_UserId = new JLabel("\uC544\uC774\uB514\uC785\uB825");
		lb_UserId.setBounds(268, 249, 114, 18);
		pn_userinfomation.add(lb_UserId);
		
		JLabel lb_Phonenumber = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lb_Phonenumber.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lb_Phonenumber.setBounds(144, 301, 95, 18);
		pn_userinfomation.add(lb_Phonenumber);
		
		JLabel lb_UserPhonenumber = new JLabel("01012345678");
		lb_UserPhonenumber.setBounds(268, 302, 114, 18);
		pn_userinfomation.add(lb_UserPhonenumber);
		
		JLabel lb_ChangePw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		lb_ChangePw.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lb_ChangePw.setBounds(144, 331, 126, 18);
		pn_userinfomation.add(lb_ChangePw);
		
		txt_OldPw = new JTextField();
		txt_OldPw.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		txt_OldPw.setText("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		txt_OldPw.setBounds(144, 361, 171, 24);
		pn_userinfomation.add(txt_OldPw);
		txt_OldPw.setColumns(10);
		
		txt_NewPw = new JTextField();
		txt_NewPw.setText("\uC0C8 \uBE44\uBC00\uBC88\uD638");
		txt_NewPw.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		txt_NewPw.setColumns(10);
		txt_NewPw.setBounds(144, 397, 171, 24);
		pn_userinfomation.add(txt_NewPw);
		
		txt_NewPw2 = new JTextField();
		txt_NewPw2.setText("\uC0C8 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		txt_NewPw2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		txt_NewPw2.setColumns(10);
		txt_NewPw2.setBounds(144, 433, 171, 24);
		pn_userinfomation.add(txt_NewPw2);
		
		JButton btnNewButton = new JButton("\uC218\uC815\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "¼öÁ¤ÇÏ½Ã°Ú½À´Ï±î?", "È®ÀÎÃ¢", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(210, 478, 105, 27);
		pn_userinfomation.add(btnNewButton);
		
		JButton btn_UserInfomation = new JButton("\uD68C\uC6D0\uC815\uBCF4\r\n");
		btn_UserInfomation.setHorizontalAlignment(SwingConstants.LEFT);
		btn_UserInfomation.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btn_UserInfomation.setBounds(0, 82, 86, 54);
		pn_userinfomation.add(btn_UserInfomation);
		
		JButton btn_UserReservation = new JButton("\uC608\uB9E4\uD655\uC778");
		btn_UserReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_UserReservation.setHorizontalAlignment(SwingConstants.LEFT);
		btn_UserReservation.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btn_UserReservation.setBounds(0, 162, 86, 54);
		pn_userinfomation.add(btn_UserReservation);
		
		JButton btn_Review = new JButton("\uB9AC\uBDF0\uB0B4\uC5ED");
		btn_Review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Review.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Review.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btn_Review.setBounds(0, 243, 86, 54);
		pn_userinfomation.add(btn_Review);
	}
}
