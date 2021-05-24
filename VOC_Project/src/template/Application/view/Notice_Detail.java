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
import template.Application.controller.Notice_data;
import template.Application.controller.RoundedButtonD;

public class Notice_Detail extends JFrame {

	private JPanel contentPane;
	Notice NM;
	Notice_data Notice;
	ArrayList<Notice_data> NoticeArr;
	Notice_Detail ND;


	public Notice_Detail(Notice NM) {
		this.NM = NM;
//		this.ND = this;
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
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		Panel pn_Title = new Panel();
		pn_Title.setBounds(10, 10, 444, 55);
		pn_Title.setBackground(SystemColor.controlShadow);
		panel_2.add(pn_Title);
		pn_Title.setLayout(new BorderLayout(0, 0));
		
		String title = NM.Notice.getTitle();
		JLabel lb_Title = new JLabel(title);
		lb_Title.setFont(new Font("굴림", Font.BOLD, 30));
		pn_Title.add(lb_Title, BorderLayout.CENTER);
		
		int ViewCount = NM.Notice.getViewCount();
		JLabel lblNewLabel = new JLabel("조회수:" + ViewCount);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pn_Title.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel pn_Content = new JPanel();
		pn_Content.setBounds(10, 75, 444, 547);
		panel_2.add(pn_Content);
		pn_Content.setLayout(new BorderLayout(0, 0));
		
		String content = NM.Notice.getContent();
		JLabel lb_Content = new JLabel(content);
		lb_Content.setVerticalAlignment(SwingConstants.TOP);
		pn_Content.add(lb_Content, BorderLayout.CENTER);
		
		RoundedButtonD btn_End = new RoundedButtonD("LOGOUT");
		btn_End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		roundedButtonD_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		roundedButtonD_1.setBounds(372, 10, 100, 35);
		panel.add(roundedButtonD_1);

	}
}
