package template.Application.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Notice_Detail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice_Detail frame = new Notice_Detail();
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
	public Notice_Detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_head = new JPanel();
		pn_head.setBackground(Color.WHITE);
		pn_head.setBounds(0, 0, 432, 28);
		contentPane.add(pn_head);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.setBounds(0, 0, 79, 27);
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		});
		pn_head.setLayout(null);
		btn_Logout.setHorizontalAlignment(SwingConstants.LEFT);
		pn_head.add(btn_Logout);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setBounds(404, 4, 14, 18);
		pn_head.add(lblNewLabel);
		
		JButton btn_home = new JButton("home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_home.setBounds(335, 0, 69, 27);
		pn_head.add(btn_home);
		
		JPanel pn_NoticeContent = new JPanel();
		pn_NoticeContent.setBackground(Color.WHITE);
		pn_NoticeContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_NoticeContent.setBounds(14, 74, 404, 525);
		contentPane.add(pn_NoticeContent);
		pn_NoticeContent.setLayout(new BorderLayout(0, 0));
		
		JLabel lb_NoticeContent = new JLabel("\uB0B4\uC6A9");
		lb_NoticeContent.setBackground(Color.WHITE);
		lb_NoticeContent.setVerticalAlignment(SwingConstants.TOP);
		pn_NoticeContent.add(lb_NoticeContent, BorderLayout.CENTER);
		
		JLabel lb_NoticeTitle = new JLabel("\uACF5\uC9C0\uC0AC\uD56D \uC81C\uBAA9");
		lb_NoticeTitle.setBounds(14, 40, 404, 22);
		contentPane.add(lb_NoticeTitle);
		
		JButton btn_GoToMain = new JButton("\uBA54\uC778\uC73C\uB85C");
		btn_GoToMain.setBounds(42, 627, 148, 49);
		contentPane.add(btn_GoToMain);
		
		JButton btn_GoToNotice = new JButton("\uACF5\uC9C0\uC0AC\uD56D\uC73C\uB85C");
		btn_GoToNotice.setBounds(235, 627, 148, 49);
		contentPane.add(btn_GoToNotice);
		
		JLabel lb_ViewNumber = new JLabel("\uC22B\uC790");
		lb_ViewNumber.setBounds(387, 56, 31, 18);
		contentPane.add(lb_ViewNumber);
		
		JLabel lb_View = new JLabel("\uC870\uD68C\uC218:");
		lb_View.setBounds(339, 56, 47, 18);
		contentPane.add(lb_View);
	}	

}
