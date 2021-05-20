package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class Reservation_Detail extends JFrame {

	private JPanel contentPane;
	JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_Detail frame = new Reservation_Detail();
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
	public Reservation_Detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Head = new JPanel();
		pn_Head.setBackground(Color.WHITE);
		pn_Head.setBounds(0, 0, 434, 24);
		contentPane.add(pn_Head);
		pn_Head.setLayout(null);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Logout.setBounds(0, 0, 71, 23);
		pn_Head.add(btn_Logout);
		
		JLabel lb_Profile = new JLabel("=");
		lb_Profile.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lb_Profile.setBounds(419, 3, 15, 15);
		pn_Head.add(lb_Profile);
		
		JButton btn_Home = new JButton("home");
		btn_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Home.setToolTipText("\uBA54\uC778\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_Home.setBounds(345, 0, 65, 23);
		pn_Head.add(btn_Home);
		
		JPanel pn_Movieposter = new JPanel();
		pn_Movieposter.setBackground(Color.LIGHT_GRAY);
		pn_Movieposter.setBounds(0, 24, 165, 208);
		contentPane.add(pn_Movieposter);
		
		JPanel pn_MovieTime = new JPanel();
		pn_MovieTime.setBounds(165, 24, 269, 31);
		contentPane.add(pn_MovieTime);
		pn_MovieTime.setLayout(null);
		
		JLabel lb_MovieNUmber = new JLabel("NO.");
		lb_MovieNUmber.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_MovieNUmber.setBounds(25, 0, 32, 31);
		pn_MovieTime.add(lb_MovieNUmber);
		
		JLabel lb_MovieDate = new JLabel("\uC0C1\uC601\uB0A0\uC790");
		lb_MovieDate.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_MovieDate.setBounds(88, 0, 69, 31);
		pn_MovieTime.add(lb_MovieDate);
		
		JLabel lb_MovieTiem = new JLabel("\uC0C1\uC601\uC2DC\uAC04");
		lb_MovieTiem.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_MovieTiem.setBounds(188, 0, 69, 31);
		pn_MovieTime.add(lb_MovieTiem);
		
		JPanel pn_MovieStory = new JPanel();
		pn_MovieStory.setBackground(Color.YELLOW);
		pn_MovieStory.setBounds(165, 145, 269, 87);
		contentPane.add(pn_MovieStory);
		pn_MovieStory.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		pn_MovieStory.add(scrollBar, BorderLayout.EAST);
		
		JLabel lb_MovieStoryTitle = new JLabel("\uC904\uAC70\uB9AC");
		lb_MovieStoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MovieStory.add(lb_MovieStoryTitle, BorderLayout.NORTH);
		
		JLabel lb_MovieStory = new JLabel("\uC65C \uC904\uBC14\uAFC8\uC774 \uC548\uB418\uB294\uAC70\uC57C");
		lb_MovieStory.setHorizontalAlignment(SwingConstants.LEFT);
		lb_MovieStory.setVerticalAlignment(SwingConstants.TOP);
		pn_MovieStory.add(lb_MovieStory, BorderLayout.CENTER);
		
		JPanel pn_MovieDateTime1 = new JPanel();
		pn_MovieDateTime1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_MovieDateTime1.setBounds(165, 55, 269, 45);
		contentPane.add(pn_MovieDateTime1);
		pn_MovieDateTime1.setLayout(null);
		
		JLabel lb_movieNum1 = new JLabel("1");
		lb_movieNum1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_movieNum1.setBounds(24, 15, 23, 15);
		pn_MovieDateTime1.add(lb_movieNum1);
		
		JLabel lb_MovieDate1 = new JLabel("05/18");
		lb_MovieDate1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_MovieDate1.setBounds(90, 15, 55, 15);
		pn_MovieDateTime1.add(lb_MovieDate1);
		
		JLabel label = new JLabel("19:50");
		label.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(190, 16, 55, 15);
		pn_MovieDateTime1.add(label);
		
		JPanel pn_MovieDateTime2 = new JPanel();
		pn_MovieDateTime2.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_MovieDateTime2.setBounds(165, 100, 269, 45);
		contentPane.add(pn_MovieDateTime2);
		pn_MovieDateTime2.setLayout(null);
		
		JLabel lb_movieNum2 = new JLabel("2");
		lb_movieNum2.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_movieNum2.setBounds(24, 15, 23, 15);
		pn_MovieDateTime2.add(lb_movieNum2);
		
		JLabel lb_MovieDate2 = new JLabel("05/18");
		lb_MovieDate2.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		lb_MovieDate2.setBounds(91, 15, 48, 15);
		pn_MovieDateTime2.add(lb_MovieDate2);
		
		JLabel label_1 = new JLabel("23:20");
		label_1.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(189, 16, 55, 15);
		pn_MovieDateTime2.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 232, 434, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel pn_MoiveImformation = new JPanel();
		pn_MoiveImformation.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_MoiveImformation.setBounds(0, 18, 434, 190);
		panel.add(pn_MoiveImformation);
		pn_MoiveImformation.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lb_MovieTitle = new JLabel("\uC81C\uBAA9");
		lb_MovieTitle.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieTitle);
		
		JLabel lb_Title = new JLabel("New label");
		lb_Title.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_Title.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_Title);
		
		JLabel lb_MovieDirector = new JLabel("\uAC10\uB3C5");
		lb_MovieDirector.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieDirector.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieDirector);
		
		JLabel lb_Director = new JLabel("New label");
		lb_Director.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_Director.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_Director);
		
		JLabel lb_MovieGenre = new JLabel("\uC7A5\uB974");
		lb_MovieGenre.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieGenre.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieGenre);
		
		JLabel lb_Genre = new JLabel("New label");
		lb_Genre.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_Genre.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_Genre);
		
		JLabel lb_MovieStar = new JLabel("\uBCC4\uC810");
		lb_MovieStar.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieStar.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieStar);
		
		JLabel lb_star = new JLabel("New label");
		lb_star.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_star.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_star);
		
		JLabel lb_MovieProducer = new JLabel("\uC81C\uC791\uC0AC");
		lb_MovieProducer.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieProducer.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieProducer);
		
		JLabel lb_producer = new JLabel("New label");
		lb_producer.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_producer.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_producer);
		
		JLabel lb_MovieAge = new JLabel("\uC5F0\uB839\uB4F1\uAE09");
		lb_MovieAge.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieAge.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieAge);
		
		JLabel lb_Age = new JLabel("New label");
		lb_Age.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_Age.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_Age);
		
		JLabel lb_MoviePeople = new JLabel("\uB4F1\uC7A5\uC778\uBB3C");
		lb_MoviePeople.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MoviePeople.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MoviePeople);
		
		JLabel lb_people = new JLabel("New label");
		lb_people.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_people.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_people);
		
		JLabel lb_MovieYear = new JLabel("\uAC1C\uBD09\uC5F0\uB3C4");
		lb_MovieYear.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_MovieYear.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_MovieYear);
		
		JLabel lb_year = new JLabel("New label");
		lb_year.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lb_year.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MoiveImformation.add(lb_year);
		
		JPanel pn_MovieImformationTitle = new JPanel();
		pn_MovieImformationTitle.setBounds(0, 0, 434, 18);
		panel.add(pn_MovieImformationTitle);
		pn_MovieImformationTitle.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lb_MovieImformationSubject = new JLabel("\uC601\uD654 \uC815\uBCF4");
		lb_MovieImformationSubject.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MovieImformationTitle.add(lb_MovieImformationSubject);
		
		JLabel lb_MovieImformation = new JLabel("\uB0B4\uC6A9");
		lb_MovieImformation.setHorizontalAlignment(SwingConstants.CENTER);
		pn_MovieImformationTitle.add(lb_MovieImformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 439, 434, 175);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(417, 0, 17, 175);
		panel_1.add(scrollBar_1);
	}
}
