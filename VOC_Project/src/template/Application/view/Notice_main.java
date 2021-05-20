package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Notice_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice_main frame = new Notice_main();
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
	public Notice_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Head = new JPanel();
		pn_Head.setLayout(null);
		pn_Head.setBackground(Color.WHITE);
		pn_Head.setBounds(0, 0, 434, 24);
		contentPane.add(pn_Head);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.setBounds(0, 0, 79, 23);
		pn_Head.add(btn_Logout);
		
		JLabel lb_profile = new JLabel("=");
		lb_profile.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lb_profile.setBounds(419, 3, 15, 15);
		pn_Head.add(lb_profile);
		
		JButton btn_Home = new JButton("home");
		btn_Home.setToolTipText("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_Home.setBounds(341, 0, 69, 23);
		pn_Head.add(btn_Home);
		
		JLabel lb_NoticeTitle = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
		lb_NoticeTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 34));
		lb_NoticeTitle.setBounds(136, 23, 145, 60);
		contentPane.add(lb_NoticeTitle);
		
		JPanel pn_Introduction = new JPanel();
		pn_Introduction.setBackground(Color.WHITE);
		pn_Introduction.setBounds(0, 434, 434, 269);
		contentPane.add(pn_Introduction);
		pn_Introduction.setLayout(null);
		
		JPanel pn_IntroductionTitle = new JPanel();
		pn_IntroductionTitle.setBackground(Color.LIGHT_GRAY);
		pn_IntroductionTitle.setBounds(0, 0, 434, 65);
		pn_Introduction.add(pn_IntroductionTitle);
		pn_IntroductionTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lb_IntroductionTtitle = new JLabel("Movie Theater Introduction");
		lb_IntroductionTtitle.setFont(new Font("±¼¸²", Font.BOLD, 30));
		lb_IntroductionTtitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn_IntroductionTitle.add(lb_IntroductionTtitle, BorderLayout.CENTER);
		
		JLabel lb_TheaterNumber = new JLabel("\uC804\uD654\uBC88\uD638:");
		lb_TheaterNumber.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterNumber.setBounds(60, 93, 74, 18);
		pn_Introduction.add(lb_TheaterNumber);
		
		JLabel lb_TheatorNumber2 = new JLabel("03-5652-5658");
		lb_TheatorNumber2.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheatorNumber2.setBounds(144, 93, 122, 18);
		pn_Introduction.add(lb_TheatorNumber2);
		
		JLabel lb_TheaterDaytime = new JLabel("\uC601\uC5C5\uC2DC\uAC04:");
		lb_TheaterDaytime.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterDaytime.setBounds(60, 123, 74, 18);
		pn_Introduction.add(lb_TheaterDaytime);
		
		JLabel lb_TheaterDaytime1 = new JLabel("18:00 ~ 03:00");
		lb_TheaterDaytime1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterDaytime1.setBounds(144, 123, 122, 18);
		pn_Introduction.add(lb_TheaterDaytime1);
		
		JLabel lb_TheaterCEO = new JLabel("\uB300\uD45C\uC790:");
		lb_TheaterCEO.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterCEO.setBounds(60, 153, 57, 18);
		pn_Introduction.add(lb_TheaterCEO);
		
		JLabel lb_TheaterCEO1 = new JLabel("\uACE0\uC990\uB9C1");
		lb_TheaterCEO1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterCEO1.setBounds(121, 153, 122, 18);
		pn_Introduction.add(lb_TheaterCEO1);
		
		JLabel lb_BusinessNumber = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638:");
		lb_BusinessNumber.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_BusinessNumber.setBounds(60, 183, 103, 18);
		pn_Introduction.add(lb_BusinessNumber);
		
		JLabel lb_BusinessNumber1 = new JLabel("03-5652-5658");
		lb_BusinessNumber1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_BusinessNumber1.setBounds(165, 183, 122, 18);
		pn_Introduction.add(lb_BusinessNumber1);
		
		JLabel lb_TheaterLocation = new JLabel("\uC704\uCE58:");
		lb_TheaterLocation.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterLocation.setBounds(60, 215, 46, 18);
		pn_Introduction.add(lb_TheaterLocation);
		
		JLabel lb_TheaterLocation1 = new JLabel("03-5652-5658");
		lb_TheaterLocation1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lb_TheaterLocation1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lb_TheaterLocation1.setBounds(109, 215, 122, 18);
		pn_Introduction.add(lb_TheaterLocation1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 79, 434, 330);
		contentPane.add(panel);
	}
}
