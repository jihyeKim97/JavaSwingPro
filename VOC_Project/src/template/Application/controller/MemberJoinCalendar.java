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

	// ���޷� �Լ� (MyCalendar2 �����ؿ�)
	public void showMyCal(int year, int month) {
		// �׷����� ������ �޷����� ǥ�� (������ �޷�)
		// �⵵�� ���� 1582. 10/4 �� => 10/15 �� (10��ġ ���ڰ� �����)
		// 1583����� ���� �⵵ �Է�...
		// �Է� : �⵵, ��
//		int year = 2020; //2021;
//		int month = 2; //5; // => 5/1 ������ ���ϸ� ������ ����.
		// ������� �� �ϼ�, �� ���� (��)�ϼ�, ����(�� ���� ����1���� ����),
		// + �׷����� Ģ�� �޷��� ǥ��(�����Ǵ�)

		int totalDays = 0; // 2021. 5. 1�ϱ����� �� �ϼ���...

		// ���� 1 ~ ���� 2020 �⵵�� �� �ϼ� ��� (2021�� ���⵵/�۳������ ���ϼ� ��)
		for (int y = 1; y < year; y++) {
			if (y % 400 == 0)
				totalDays += 366; // ����
			else if (y % 100 == 0)
				totalDays += 365;// ���
			else if (y % 4 == 0)
				totalDays += 366; // ����
			else
				totalDays += 365;// ���
		} // 2020.12.31������ ��� �ϼ� ��...

		// Ÿ�Ͽ��� 2021�� �����Ǵ�
		boolean bLeap = false;// ���
		if (year % 400 == 0)
			bLeap = true; // ����
		else if (year % 100 == 0)
			bLeap = false;// ���
		else if (year % 4 == 0)
			bLeap = true; // ����
		else
			bLeap = false;// ���

		// Ÿ�Ͽ����� Ÿ�Ͽ� ���������� �� �ϼ� �� ���ϱ� (2�� �������� 29��/28��?)
		// �츮���
		int daysInMonth[] = { 0, 31, bLeap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		} // 4.30����..

		// Ÿ�ϳ�Ÿ�Ͽ��� 1���� �߰�
		totalDays++; // 5.1
		// ������� �Ͽ��Ϻ��� �����ϴ� �޷����� ��������.
		// 0�� �Ͽ���, 1�� ������ ~ 6 ����� // ������ 7�Ϸ� ���� �������� ���� ������ȣ.
		// 0 ~ 6 �� ~ ��
		int yoil = totalDays % 7;
//		System.out.println("yoil => " + yoil); // 6

		// �ؽ�Ʈ ��� ������ �޷� ��� (���� ������ ��Ʈ fixed width)
		System.out.println("MyCalendar: ");
		System.out.println(year + "year " + month + "month \n");
		// �Ϸ� ����ĭ�� �����̽���4���� ĭ���� ����.
		System.out.println("============================"); // 28
		System.out.println(" SUN MON TUE WED THU FRI SAT"); // ���� �÷� ���
		System.out.println("============================"); // 28

		// ���ϰ��� ���� ���
		final String SPC = "    ";
		for (int i = 0; i < yoil; i++) {
			System.out.print(SPC); // ���� 4ĭ�� �� ���ϸ��� ���
		}

		// ���Ϻ� ���� �ִ��� ���
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
			System.out.printf(" %2d ", day);
			// ����ϸ��� �� �ְ� ������ ����
			if ((day + yoil) % 7 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("============================"); // 28
	}

	public String showMyCalReturn(int year, int month) {
		// �׷����� ������ �޷����� ǥ�� (������ �޷�)
		// �⵵�� ���� 1582. 10/4 �� => 10/15 �� (10��ġ ���ڰ� �����)
		// 1583����� ���� �⵵ �Է�...
		// �Է� : �⵵, ��
//		int year = 2020; //2021;
//		int month = 2; //5; // => 5/1 ������ ���ϸ� ������ ����.
		// ������� �� �ϼ�, �� ���� (��)�ϼ�, ����(�� ���� ����1���� ����),
		// + �׷����� Ģ�� �޷��� ǥ��(�����Ǵ�)
//		String result = "";  // �Һ����� ���ڿ� (�������ڿ��� ��ȭ����)
//		result += "??";
		// �������� ���ڿ� (������ �÷��� ArrayList)
		StringBuffer sb = new StringBuffer();
//		sb.append("???"); // �ǵڿ� ���̸� ���ڿ� ��ü�� ��ȭ�Ǿ� �þ.

		int totalDays = 0; // 2021. 5. 1�ϱ����� �� �ϼ���...

		// ���� 1 ~ ���� 2020 �⵵�� �� �ϼ� ��� (2021�� ���⵵/�۳������ ���ϼ� ��)
		for (int y = 1; y < year; y++) {
			if (y % 400 == 0)
				totalDays += 366; // ����
			else if (y % 100 == 0)
				totalDays += 365;// ���
			else if (y % 4 == 0)
				totalDays += 366; // ����
			else
				totalDays += 365;// ���
		} // 2020.12.31������ ��� �ϼ� ��...

		// Ÿ�Ͽ��� 2021�� �����Ǵ�
		boolean bLeap = false;// ���
		if (year % 400 == 0)
			bLeap = true; // ����
		else if (year % 100 == 0)
			bLeap = false;// ���
		else if (year % 4 == 0)
			bLeap = true; // ����
		else
			bLeap = false;// ���

		// Ÿ�Ͽ����� Ÿ�Ͽ� ���������� �� �ϼ� �� ���ϱ� (2�� �������� 29��/28��?)
		// �츮���
		int daysInMonth[] = { 0, 31, bLeap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		} // 4.30����..

		// Ÿ�ϳ�Ÿ�Ͽ��� 1���� �߰�
		totalDays++; // 5.1
		// ������� �Ͽ��Ϻ��� �����ϴ� �޷����� ��������.
		// 0�� �Ͽ���, 1�� ������ ~ 6 ����� // ������ 7�Ϸ� ���� �������� ���� ������ȣ.
		// 0 ~ 6 �� ~ ��
		int yoil = totalDays % 7;
//		System.out.println("yoil => " + yoil); // 6

		// �ؽ�Ʈ ��� ������ �޷� ��� (���� ������ ��Ʈ fixed width)
		// System.out.println("MyCalendar: ");
		sb.append("MyCalendar: \n");
		sb.append(year + " year " + month + " month\n ");

		// �Ϸ� ����ĭ�� �����̽���4���� ĭ���� ����.
		sb.append("============================\n"); // 28
		sb.append(" SUN MON TUE WED THU FRI SAT\n"); // ���� �÷� ���
		sb.append("============================\n"); // 28

		// ���ϰ��� ���� ���
		final String SPC = "    ";
		for (int i = 0; i < yoil; i++) {
			sb.append(SPC); // ���� 4ĭ�� �� ���ϸ��� ���
		}

		// ���Ϻ� ���� �ִ��� ���
		for (int day = 1; day <= daysInMonth[month]; day++) {
//			System.out.printf("%4d", day);
//			System.out.printf(" %2d ", day); // ȭ�����
			sb.append(String.format(" %2d ", day)); // ���ڿ� ����
			// ����ϸ��� �� �ְ� ������ ����
			if ((day + yoil) % 7 == 0)
//				System.out.println();
				sb.append("\n");
		}
		sb.append("\n");
		sb.append("============================\n"); // 28

		return sb.toString(); // �������̹��ڿ��� �������̹��ڿ� �������
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
		lblNewLabel_1.setFont(new Font("�޸տ�ü", Font.BOLD, 16));
		pnTop.add(lblNewLabel_1);

		txtYear = new JTextField();
		txtYear.setFont(new Font("�޸տ�ü", Font.BOLD, 16));
		pnTop.add(txtYear);
		txtYear.setColumns(4);

		JLabel lblNewLabel_2 = new JLabel("\uC6D4:");
		lblNewLabel_2.setFont(new Font("�޸տ�ü", Font.BOLD, 16));
		pnTop.add(lblNewLabel_2);

//		JComboBox comboMonth = new JComboBox();
		comboMonth = new JComboBox(); // �ʵ�ȭ
		comboMonth.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboMonth.setMaximumRowCount(12);
		pnTop.add(comboMonth);

		JButton btnShowCal = new JButton("\uB2EC\uB825\uD45C\uC2DC");
		btnShowCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tYear = Integer.parseInt(txtYear.getText());
				int tMonth = Integer.parseInt((String) comboMonth.getSelectedItem());
				showMyCal(tYear, tMonth);
				String calen = showMyCalReturn(tYear, tMonth);
				textArea.setText(calen);

			}
		});
		btnShowCal.setFont(new Font("�޸տ�ü", Font.BOLD, 16));
		pnTop.add(btnShowCal);

		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.MAGENTA);
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scrollPane, BorderLayout.CENTER);

		// JTextArea textArea = new JTextArea();
		textArea = new JTextArea(); // �ʵ�ȭ
		textArea.setFont(new Font("Consolas", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);

		JPanel pnBottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnBottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnBottom.setBackground(Color.YELLOW);
		contentPane.add(pnBottom, BorderLayout.SOUTH);

		JLabel lbStatus = new JLabel("\uC0C1\uD0DC\uBC14");
		lbStatus.setFont(new Font("�޸տ�ü", Font.BOLD, 16));
		lbStatus.setHorizontalAlignment(SwingConstants.LEFT);
		pnBottom.add(lbStatus);

		// ���ó��� (���) 1) �޷� ���
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		DateFormat df = DateFormat.getDateInstance();
		setTitle(getTitle() + " " + df.format(today));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		// 2) ���ڿ� �Ľ� ���
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
		txtYear.setText(String.valueOf(year)); // ""+year)
		comboMonth.setSelectedIndex(month - 1); // 4��° "5"����
	}

}