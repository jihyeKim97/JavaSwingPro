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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage_Reservation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage_Reservation frame = new MyPage_Reservation();
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
	public MyPage_Reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Head = new JPanel();
		pn_Head.setLayout(null);
		pn_Head.setBackground(Color.WHITE);
		pn_Head.setBounds(0, 0, 434, 40);
		contentPane.add(pn_Head);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.setBounds(0, 0, 79, 23);
		pn_Head.add(btn_Logout);
		
		JLabel lb_UserInformation = new JLabel("=");
		lb_UserInformation.setFont(new Font("����", Font.PLAIN, 16));
		lb_UserInformation.setBounds(419, 3, 15, 15);
		pn_Head.add(lb_UserInformation);
		
		JButton btn_Home = new JButton("home");
		btn_Home.setToolTipText("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_Home.setBounds(341, 0, 69, 23);
		pn_Head.add(btn_Home);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 50, 408, 491);
		contentPane.add(panel_1);
		
		JPanel pn_ReservationTitle = new JPanel();
		pn_ReservationTitle.setBackground(Color.WHITE);
		pn_ReservationTitle.setBounds(0, 0, 408, 54);
		panel_1.add(pn_ReservationTitle);
		pn_ReservationTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lb_ReservaitonTitle = new JLabel("\uC608\uB9E4 \uC815\uBCF4 \uD655\uC778 \uBC0F \uCDE8\uC18C");
		lb_ReservaitonTitle.setFont(new Font("����", Font.BOLD, 20));
		lb_ReservaitonTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn_ReservationTitle.add(lb_ReservaitonTitle, BorderLayout.CENTER);
		
		JButton btn_UserImfomation = new JButton("\uD68C\uC6D0\uC815\uBCF4\r\n");
		btn_UserImfomation.setHorizontalAlignment(SwingConstants.LEFT);
		btn_UserImfomation.setFont(new Font("����", Font.PLAIN, 12));
		btn_UserImfomation.setBounds(10, 64, 90, 60);
		panel_1.add(btn_UserImfomation);
		
		JButton btn_UserReservaution = new JButton("\uC608\uB9E4\uD655\uC778");
		btn_UserReservaution.setHorizontalAlignment(SwingConstants.LEFT);
		btn_UserReservaution.setFont(new Font("����", Font.PLAIN, 12));
		btn_UserReservaution.setBounds(0, 162, 86, 54);
		panel_1.add(btn_UserReservaution);
		
		JButton btn_Review = new JButton("\uB9AC\uBDF0\uB0B4\uC5ED");
		btn_Review.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Review.setFont(new Font("����", Font.PLAIN, 12));
		btn_Review.setBounds(0, 243, 86, 54);
		panel_1.add(btn_Review);
		
		JPanel pn_UserReservation = new JPanel();
		pn_UserReservation.setBackground(Color.WHITE);
		pn_UserReservation.setBounds(111, 75, 283, 151);
		panel_1.add(pn_UserReservation);
		pn_UserReservation.setLayout(null);
		
		JButton btn_ReservationCancle = new JButton("\uCDE8\uC18C");
		btn_ReservationCancle.setBounds(192, 124, 61, 27);
		pn_UserReservation.add(btn_ReservationCancle);
		btn_ReservationCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "���Ÿ� ����Ͻðڽ��ϱ�?", "�������", JOptionPane.YES_NO_OPTION , JOptionPane.PLAIN_MESSAGE);
			}
		});
		btn_ReservationCancle.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel pn_MoviePoster = new JPanel();
		pn_MoviePoster.setBounds(178, 12, 61, 68);
		pn_UserReservation.add(pn_MoviePoster);
		
		JLabel lb_MovieTitle = new JLabel("\uC601\uD654 \uC81C\uBAA9");
		lb_MovieTitle.setBounds(14, 12, 62, 18);
		pn_UserReservation.add(lb_MovieTitle);
		
		JLabel lb_MovieTime = new JLabel("\uC601\uD654 \uC2DC\uC791 \uC2DC\uAC04 \uBC0F \uB0A0\uC790");
		lb_MovieTime.setBounds(14, 39, 150, 18);
		pn_UserReservation.add(lb_MovieTime);
		
		JLabel lb_MovieUserLocation = new JLabel("\uC88C\uC11D \uBC88\uD638");
		lb_MovieUserLocation.setBounds(14, 69, 62, 18);
		pn_UserReservation.add(lb_MovieUserLocation);
		
		JLabel lb_ReservationNumber = new JLabel("\uC608\uB9E4 \uBC88\uD638");
		lb_ReservationNumber.setBounds(14, 99, 62, 18);
		pn_UserReservation.add(lb_ReservationNumber);
		
		JLabel lblNewLabel = new JLabel("1538745848976");
		lblNewLabel.setBounds(82, 99, 157, 18);
		pn_UserReservation.add(lblNewLabel);
	}

}
