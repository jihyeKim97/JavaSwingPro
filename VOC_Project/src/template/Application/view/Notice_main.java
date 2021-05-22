package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

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
import java.awt.Panel;
import java.awt.SystemColor;
import template.Application.controller.RoundedButtonD;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class Notice_main extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 55, 484, 705);
		contentPane.add(panel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setBounds(10, 10, 444, 55);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("공지 사항");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 472, 444, 200);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Movie Theater Introducer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("● 전화번호 : 02 - 333 - 4848 ");
		lblNewLabel_2.setBounds(10, 10, 210, 30);
		panel_6.add(lblNewLabel_2);
		
		JLabel label = new JLabel("● 영업시간 : 18:00 ~ 03:00");
		label.setBounds(10, 40, 198, 30);
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("● 대표자 : 고즐링");
		label_1.setBounds(10, 70, 198, 30);
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("● 사업자 번호: 653-25-0698");
		label_2.setBounds(10, 100, 198, 30);
		panel_6.add(label_2);

		JLabel label_3 = new JLabel("● 위치: 서울 성동구 왕십리로 303");
		label_3.setBounds(10, 130, 236, 30);
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 71, 444, 389);
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_7.add(table, BorderLayout.CENTER);
		String[] Notice = new String[] {"번호","제목", "작성자", "등록일" }; 
		Object[][] data = new Object[][] {
			{"         1", "회원 정보 시스템 점검", "관리자", "21.05.18"},
			{"         2", "불법촬영 금지", "관리자", "21.05.19"},
			{"         3", "", "", ""},{"         4", "", "", ""},
			{"         5", "", "", ""},{"         6", "", "", ""},
			{"         7", "", "", ""},{"         8", "", "", ""},
			{"         9", "", "", ""},{"        10", "", "", ""},
			{"        11", "", "", ""},{"        12", "", "", ""},
			{"        13", "", "", ""},{"        14", "", "", ""},
			{"        15", "", "", ""},{"        16", "", "", ""}
		};
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);
		
		RoundedButtonD roundedButtonD = new RoundedButtonD("LOGOUT");
		roundedButtonD.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD.setBounds(12, 10, 100, 35);
		panel.add(roundedButtonD);
		
		RoundedButtonD roundedButtonD_1 = new RoundedButtonD("HOME");
		roundedButtonD_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD_1.setBounds(320, 10, 100, 35);
		panel.add(roundedButtonD_1);
		
		RoundedButtonD roundedButtonD_2 = new RoundedButtonD("HOME");
		roundedButtonD_2.setText("=");
		roundedButtonD_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD_2.setBounds(430, 10, 41, 35);
		panel.add(roundedButtonD_2);
	}
}
