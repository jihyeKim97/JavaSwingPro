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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import template.Application.controller.DB_Connect;
import template.Application.controller.Notice_DB;
import template.Application.controller.Notice_data;
import template.Application.controller.RoundedButtonD;
import javax.swing.JTextArea;
import java.awt.Window.Type;

public class Notice_Detail extends JFrame {

	private JPanel contentPane;
	Notice NM;
	Notice_data Notice;
	ArrayList<Notice_data> NoticeArr;
	Notice_DB NoticeDB;

	public Notice_Detail(Notice NM, Notice_data Notice) {
			this.NM = NM;
			this.Notice = Notice;
			NoticeArr = new ArrayList<>();
			NoticeArr = NoticeDB.takeNoticetitle();
			int PK = 0;

//		this.ND = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		Panel pn_Title = new Panel();
		pn_Title.setBounds(10, 10, 444, 55);
		pn_Title.setBackground(SystemColor.controlShadow);
		panel_2.add(pn_Title);
		pn_Title.setLayout(new BorderLayout(0, 0));

		String title = NoticeArr.get(PK).getTitle();
		JLabel lb_Title = new JLabel(title);
		lb_Title.setFont(new Font("굴림", Font.BOLD, 30));
		pn_Title.add(lb_Title, BorderLayout.CENTER);

		int ViewCount = NoticeArr.get(PK).getViewcount();

		JLabel lblNewLabel = new JLabel("조회수:" + ViewCount);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pn_Title.add(lblNewLabel, BorderLayout.SOUTH);

		JPanel pn_Content = new JPanel();
		pn_Content.setBounds(10, 75, 444, 547);
		panel_2.add(pn_Content);
		pn_Content.setLayout(new BorderLayout(0, 0));

		JTextArea content = new JTextArea();
		content.setLineWrap(true);
		content.setText(NoticeArr.get(PK).getContent());
		content.setFont(new Font("돋움체", Font.ITALIC, 25));
		content.setEditable(false);
		pn_Content.add(content, BorderLayout.CENTER);

//		String content = NoticeArr.get(PK).getContent();
//		JLabel lb_Content = new JLabel("<html>안녕하십니까? <br>저희극장을 이용해주셔서 감사합니다 <br>몇가지 유의사항을 알립니다 <br>다음페이지를 참고 해주세요</html>");
//		lb_Content.setFont(new Font("굴림", Font.BOLD, 30));
//		lb_Content.setVerticalAlignment(SwingConstants.TOP);
//		pn_Content.add(lb_Content, BorderLayout.CENTER);

		RoundedButtonD btn_End = new RoundedButtonD("LOGOUT");
		btn_End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_End.setText("돌아가기");
		btn_End.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_End.setBounds(172, 634, 120, 40);
		panel_2.add(btn_End);

		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);

		RoundedButtonD roundedButtonD = new RoundedButtonD("LOGOUT");
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		roundedButtonD.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD.setBounds(12, 10, 100, 35);
		panel.add(roundedButtonD);

		RoundedButtonD roundedButtonD_1 = new RoundedButtonD("HOME");
		roundedButtonD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		roundedButtonD_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD_1.setBounds(372, 10, 100, 35);
		panel.add(roundedButtonD_1);

	}

}
