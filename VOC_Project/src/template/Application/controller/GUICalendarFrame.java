package template.Application.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class GUICalendarFrame extends JFrame {
	public static final Font ftDAY = 
				new Font("Gulim", Font.PLAIN, 20);
	public static final Font ftSDAY = 
				new Font("Gulim", Font.BOLD, 20);
	private JPanel contentPane;
	private JTextField txtYear;
	private JTextField txtMonth;	
	JLabel[] lbDayOfWeek; // 요일 레이블 배열	 7
	JButton[] btnDays;  // 날자 버튼 배열 42 (6주 분량)
	
	
	// readonly getter
	public String getTxtYearText() {
		return txtYear.getText();
	}
	public JTextField getTxtYear() {
		return txtYear;
	}
	public JTextField getTxtMonth() {
		return txtMonth;
	}

	/**
	 * Launch the application.
	 */

	// 복사해온 달력 알고리즘 함수
	// 논리달력 함수 (MyCalendar2 복사해옴)
	public void showMyCalGUI(int year, int month) {
		// 그레고리안 역법을 달력으로 표현 (논리상의 달력)
		// 년도의 범위 1582. 10/4 목 => 10/15 금 (10일치 날자가 사라짐)
		// 1583년부터 정상 년도 입력...
		// 입력 : 년도, 월  
//		int year = 2020; //2021;
//		int month = 2; //5; // => 5/1 날자의 요일만 끝나는 문제.
		// 서기력의 총 일수, 각 월별 (총)일수, 요일(각 월의 시작1일의 요일),
		// + 그레고리안 칙령 달력을 표현(윤년판단) 
		
		int totalDays = 0; // 2021. 5. 1일까지의 총 일수합...
		
		// 서기 1 ~ 서기 2020 년도별 총 일수 계산 (2021의 전년도/작년까지의 총일수 합)
		for (int y = 1; y < year; y++) {
			if( y % 400 == 0 ) totalDays += 366; // 윤년
			else if( y % 100 == 0 ) totalDays += 365;// 평년
			else if( y % 4 == 0 ) totalDays += 366; // 윤년
			else totalDays += 365;// 평년
		} // 2020.12.31까지의 모든 일수 합...
		
		// 타켓연도 2021의 윤년판단
		boolean bLeap = false;// 평년
		if( year % 400 == 0 ) bLeap = true; // 윤년
		else if( year % 100 == 0 ) bLeap = false;// 평년
		else if( year % 4 == 0 ) bLeap = true; // 윤년
		else bLeap = false;// 평년
		
		// 타켓연도의 타켓월 전월까지의 총 일수 합 구하기 (2월 윤년유무 29일/28일?)
		// 쥴리어스력
		int daysInMonth[] = {
			0, 31, bLeap ? 29 : 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31
		};
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		} // 4.30까지..
		
		// 타켓년타켓월의 1일을 추가
		totalDays++; // 5.1
		// 서양력은 일요일부터 시작하는 달력으로 만들어야함.
		// 0을 일요일, 1을 월요일 ~ 6 토요일  // 일주일 7일로 나눈 나머지가 요일 순서번호.
		// 0 ~ 6 월 ~ 토
		int yoil = totalDays % 7; 
//		System.out.println("yoil => " + yoil); // 6
		
		// 텍스트 모드 월단위 달력 출력 (고정 가로폭 폰트 fixed width)
//		System.out.println("MyCalendar: ");
//		System.out.println( year + "년 " + month + "월");
		// 하루 날자칸을 스페이스바4개의 칸으로 가정.
//		System.out.println("============================"); // 28
//		System.out.println(" SUN MON TUE WED THU FRI SAT"); // 요일 컬럼 헤더
//		System.out.println("============================"); // 28
		
		// 요일공백 보정 출력
		final String SPC = "    ";
//		for (int i = 0; i < yoil; i++) {
//			System.out.print(SPC); // 공백 4칸을 각 요일마다 출력
//		}
		// 42개 날자 버튼 리셋
		for (JButton dayBtn : btnDays) {
			dayBtn.setText("");
			dayBtn.setEnabled(false);
			dayBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		
		// 요일별 날자 주단위 출력
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
			//System.out.printf(" %2d ", day);
			String dayStr = String.format("%2d", day);
			//btnDays[?].setText(dayStr);
			JButton btnDay = btnDays[day+yoil-1];
			btnDay.setText(dayStr);
			btnDay.setEnabled(true); // 활성화
			// 토요일마다 한 주가 끝나서 개행
//			if( (day+yoil) % 7 == 0 )
//				System.out.println();
		}
//		System.out.println();
//		System.out.println("============================"); // 28
	}

	
	
	
	
	/**
	 * Create the frame.
	 */
	public GUICalendarFrame() {
		this(1990, 1); // epoch
	}
	
	public GUICalendarFrame(int year, int month) {
		setTitle("GUI \uCE98\uB9B0\uB354");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uB144:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		pnTop.add(lblNewLabel);
		
		txtYear = new JTextField();
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtYear.setFont(new Font("Dialog", Font.PLAIN, 14));
		pnTop.add(txtYear);
		txtYear.setColumns(4);
		txtYear.setText(""+year);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D4:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		pnTop.add(lblNewLabel_1);
		
		txtMonth = new JTextField();
		txtMonth.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonth.setFont(new Font("Dialog", Font.PLAIN, 14));
		pnTop.add(txtMonth);
		txtMonth.setColumns(2);
		txtMonth.setText(String.valueOf(month));
		
		JToolBar toolBar = new JToolBar();
		pnTop.add(toolBar);
		
		JButton bthShow = new JButton("");
		bthShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(txtYear.getText());
				int month = Integer.parseInt(txtMonth.getText());
				showMyCalGUI(year, month);
			}
		});
		bthShow.setToolTipText("\uB2EC\uB825 \uBCF4\uAE30");
		bthShow.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\DraftProject\\icons\\calendar.gif"));
		toolBar.add(bthShow);
		
		JButton btnPrevMonth = new JButton("");
		btnPrevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 달 표시
				int pyear = Integer.parseInt(txtYear.getText());
				int pmonth = Integer.parseInt(txtMonth.getText());
				
				pmonth--; // 1월달에서 빼면 0월달?  이전년도의 12월!
				if( pmonth == 0 ) {
					pmonth = 12;
					pyear--;
					txtYear.setText(""+pyear);
				}				
				txtMonth.setText(""+pmonth);
				
				showMyCalGUI(pyear, pmonth);			
			}
		});
		btnPrevMonth.setToolTipText("\uC774\uC804 \uB2EC \uD45C\uC2DC");
		toolBar.add(btnPrevMonth);
		btnPrevMonth.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\arrow_left.png"));
		
		JButton btnNextMonth = new JButton("");
		btnNextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 다음 달 표시
				int qyear = Integer.parseInt(txtYear.getText());
				int qmonth = Integer.parseInt(txtMonth.getText());
				
				qmonth++; // 12월달에서 더하면 13월달?  다음년도의 1월!
				if( qmonth == 13 ) {
					qmonth = 1;
					qyear++;
					txtYear.setText(""+qyear);
				}				
				txtMonth.setText(""+qmonth);
				
				showMyCalGUI(qyear, qmonth);
			}
		});
		btnNextMonth.setToolTipText("\uB2E4\uC74C \uB2EC \uD45C\uC2DC");
		toolBar.add(btnNextMonth);
		btnNextMonth.setIcon(new ImageIcon("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\arrow_right.png"));
		
		JButton btnNewButton = new JButton("New button");
		pnTop.add(btnNewButton);
		
		JPanel pnCenter = new JPanel();
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new GridLayout(7, 7, 0, 0));
			// 49칸의 달력 영역
			// 1행 7칸열을 요일헤더 레이블로 채움..
		
		
		JLabel lbSunday = new JLabel("SUN");
		lbSunday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunday.setForeground(Color.RED);
		pnCenter.add(lbSunday);
		
		JLabel lbMonday = new JLabel("MON");
		lbMonday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbMonday);
		
		JLabel lbTuesday = new JLabel("TUE");
		lbTuesday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbTuesday);
		
		JLabel lbWednesday = new JLabel("WED");
		lbWednesday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbWednesday);
		
		JLabel lbThursday = new JLabel("THU");
		lbThursday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbThursday);
		
		JLabel lbFriday = new JLabel("FRI");
		lbFriday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbFriday.setHorizontalAlignment(SwingConstants.CENTER);
		pnCenter.add(lbFriday);
		
		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setFont(new Font("Broadway", Font.BOLD, 14));
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setForeground(Color.BLUE);
		pnCenter.add(lbSaturday);
		
		// 요일 레이블 배열	 7
		this.lbDayOfWeek = new JLabel[] {
			lbSunday, lbMonday, lbTuesday, lbWednesday,
			lbThursday, lbFriday, lbSaturday
		};		
		
		// 날자 버튼 배열 42 (6주 분량)
		final int BTN_LIMIT = 42;
		this.btnDays = new JButton[BTN_LIMIT];
		for (int i = 0; i < btnDays.length; i++) {//0~41
//			JButton btnDay = new JButton("0"); // 날자배치없는상태버튼
			JButton btnDay = new JButton(""); // 날자배치없는상태버튼
			btnDay.setHorizontalAlignment(JButton.CENTER);			
			if( i % 7 == 0 ) {
				btnDay.setForeground(Color.RED); // sunday
				btnDay.setFont(ftSDAY);
			} else if (i % 7 == 6) {
				btnDay.setForeground(Color.BLUE); // saturday
				btnDay.setFont(ftSDAY);
			} else {
				btnDay.setForeground(Color.BLACK);
				btnDay.setFont(ftDAY);
			}
			btnDays[i] = btnDay;
			pnCenter.add(btnDay);// gridlayout 7 ~ 48번 칸
			btnDay.setEnabled(false); // 비활성화
		}
		
		// 버튼 이벤트 처리 (공통)
		DayActionHandler dayHanlder = 
				new DayActionHandler(this);
		for (JButton btnDay : btnDays) { // 42
			btnDay.addActionListener(dayHanlder);
				// 하나의 공통 actionPerformed() 사용
		}
	}

}
