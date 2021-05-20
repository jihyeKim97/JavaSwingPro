package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;

public class MyPage_Review extends JFrame {

	private JPanel contentPane;
	private final Panel panel = new Panel();
	private JButton btnHome;
	private Panel panel_1;
	private Panel panel_2;
	private Panel panel_3;
	private JLabel lblNewLabel;
	private JButton btnMember;
	private JButton btnReservation;
	private JButton btnReview;
	private Panel panel_4;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage_Review frame = new MyPage_Review();
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
	public MyPage_Review() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.setBounds(12, 10, 100, 35);
		panel.add(btnNewButton);

		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(310, 10, 100, 35);
		panel.add(btnHome);

		JButton button = new JButton("〓");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(422, 10, 50, 35);
		panel.add(button);

		panel_1 = new Panel();
		panel_1.setBackground(UIManager.getColor("Button.light"));
		panel_1.setBounds(0, 55, 484, 705);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new Panel();
		panel_2.setBackground(UIManager.getColor("ScrollBar.trackForeground"));
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		panel_3 = new Panel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setBounds(10, 10, 444, 55);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("Review");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 33));
		panel_3.add(lblNewLabel, BorderLayout.CENTER);

		panel_4 = new Panel();
		panel_4.setBackground(SystemColor.controlShadow);
		panel_4.setBounds(10, 75, 300, 30);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));

		btnMember = new JButton("Member");
		panel_4.add(btnMember);
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnReservation = new JButton("Reservation");
		panel_4.add(btnReservation);

		btnReview = new JButton("Review");
		panel_4.add(btnReview);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 444, 561);
		
		JPanel panel_ex = new JPanel();// 스크롤팬에 붙일 패널 생성
		panel_ex.setBackground(Color.blue);
		panel_ex.setSize(444,100);
//		Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
//		size.setSize(444, 100);// 객체의 사이즈를 지정
//		panel_ex.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
		scrollPane.setViewportView(panel_ex);// 스크롤 팬 위에 패널을 올린다.
		
		panel_2.add(scrollPane);


	}
}
