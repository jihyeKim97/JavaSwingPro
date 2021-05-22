package template.Application.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class MemberJoinCalendar extends JFrame {


	private JPanel contentPane;
	private JTextField txtYear;
	JComboBox comboMonth;
	JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberJoinCalendar frame = new MemberJoinCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// 논리달력 함수 (MyCalendar2 복사해옴)
	public void showMyCal(int year, int month) {
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
		System.out.println("MyCalendar: ");
		System.out.println( year + "year " + month + "month \n");
		// 하루 날자칸을 스페이스바4개의 칸으로 가정.
		System.out.println("============================"); // 28
		System.out.println(" SUN MON TUE WED THU FRI SAT"); // 요일 컬럼 헤더
		System.out.println("============================"); // 28
		
		// 요일공백 보정 출력
		final String SPC = "    ";
		for (int i = 0; i < yoil; i++) {
			System.out.print(SPC); // 공백 4칸을 각 요일마다 출력
		}
		
		// 요일별 날자 주단위 출력
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
			System.out.printf(" %2d ", day);
			// 토요일마다 한 주가 끝나서 개행
			if( (day+yoil) % 7 == 0 )
				System.out.println();
		}
		System.out.println();
		System.out.println("============================"); // 28
	}


	public String showMyCalReturn(int year, int month) {
		// 그레고리안 역법을 달력으로 표현 (논리상의 달력)
		// 년도의 범위 1582. 10/4 목 => 10/15 금 (10일치 날자가 사라짐)
		// 1583년부터 정상 년도 입력...
		// 입력 : 년도, 월  
//		int year = 2020; //2021;
//		int month = 2; //5; // => 5/1 날자의 요일만 끝나는 문제.
		// 서기력의 총 일수, 각 월별 (총)일수, 요일(각 월의 시작1일의 요일),
		// + 그레고리안 칙령 달력을 표현(윤년판단) 
//		String result = "";  // 불변길이 문자열 (고정문자열로 변화없음)
//		result += "??";
		// 가변길이 문자열 (일종의 컬렉션 ArrayList)
		StringBuffer sb = new StringBuffer();
//		sb.append("???"); // 맨뒤에 붙이며 문자열 자체가 변화되어 늘어남.
		
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
		//System.out.println("MyCalendar: ");
		sb.append("MyCalendar: \n");
		sb.append( year + " year " + month + " month\n ");
		
		// 하루 날자칸을 스페이스바4개의 칸으로 가정.
		sb.append("============================\n"); // 28
		sb.append(" SUN MON TUE WED THU FRI SAT\n"); // 요일 컬럼 헤더
		sb.append("============================\n"); // 28
		
		// 요일공백 보정 출력
		final String SPC = "    ";
		for (int i = 0; i < yoil; i++) {
			sb.append(SPC); // 공백 4칸을 각 요일마다 출력
		}
		
		// 요일별 날자 주단위 출력
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
//			System.out.printf(" %2d ", day); // 화면출력
			sb.append(String.format(" %2d ", day)); // 문자열 리턴
			// 토요일마다 한 주가 끝나서 개행
			if( (day+yoil) % 7 == 0 )
//				System.out.println();
				sb.append("\n");
		}
		sb.append("\n");
		sb.append("============================\n"); // 28
		
		return sb.toString(); // 가변길이문자열을 고정길이문자열 변경생성
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public MemberJoinCalendar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2021\\java_ws\\GUIMemoProject\\icons\\calendar.png"));
		setTitle("This Month \uB2EC\uB825:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(Color.ORANGE);
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("\uB144\uB3C4:");
		lblNewLabel_1.setFont(new Font("휴먼옛체", Font.BOLD, 16));
		pnTop.add(lblNewLabel_1);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("휴먼옛체", Font.BOLD, 16));
		pnTop.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("\uC6D4:");
		lblNewLabel_2.setFont(new Font("휴먼옛체", Font.BOLD, 16));
		pnTop.add(lblNewLabel_2);
		
//		JComboBox comboMonth = new JComboBox();
		comboMonth = new JComboBox(); // 필드화
		comboMonth.setModel(new DefaultComboBoxModel(
				new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMonth.setMaximumRowCount(12);
		pnTop.add(comboMonth);
		
		JButton btnShowCal = new JButton("\uB2EC\uB825\uD45C\uC2DC");
		btnShowCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tYear = Integer.parseInt(
						txtYear.getText());
				int tMonth =						
						Integer.parseInt(
					(String)comboMonth.getSelectedItem());
				showMyCal(tYear, tMonth);
				String calen = showMyCalReturn(tYear, tMonth);
				textArea.setText(calen);
						
			}
		});
		btnShowCal.setFont(new Font("휴먼옛체", Font.BOLD, 16));
		pnTop.add(btnShowCal);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.MAGENTA);
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scrollPane, BorderLayout.CENTER);
		
		//JTextArea textArea = new JTextArea();
		textArea = new JTextArea(); // 필드화
		textArea.setFont(new Font("Consolas", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
		
		JPanel pnBottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnBottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnBottom.setBackground(Color.YELLOW);
		contentPane.add(pnBottom, BorderLayout.SOUTH);
		
		JLabel lbStatus = new JLabel("\uC0C1\uD0DC\uBC14");
		lbStatus.setFont(new Font("휴먼옛체", Font.BOLD, 16));
		lbStatus.setHorizontalAlignment(SwingConstants.LEFT);
		pnBottom.add(lbStatus);
		
		// 오늘날자 (년월)  1) 달력 방식
		Calendar cal = Calendar.getInstance();
		Date today =  cal.getTime();
		DateFormat df = DateFormat.getDateInstance();
		setTitle(getTitle() + " " + df.format(today) );
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		// 2) 문자열 파싱 방식
//		Date today = new Date();
//		System.out.println(today);
//		DateFormat df = DateFormat.getDateInstance();
//		//System.out.println(df.format(today)); // 
//		String todayStr =   //"2021. 5. 12"
//				df.format(today);
//		String temp[] = todayStr.split(". ");
//			// { "2021", "5", "12" }
////		for (String s : temp) {
////			System.out.println(s);
////		}
//		int year = Integer.parseInt(temp[0]);// "2021" => 2021
//		int month = Integer.parseInt(temp[1]);
		
		// 
		txtYear.setText( String.valueOf(year) );  //""+year)
		comboMonth.setSelectedIndex(month-1); // 4번째 "5"월달
	}

}