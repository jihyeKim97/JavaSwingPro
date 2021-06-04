package template.Application.view.member;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;

import template.Application.controller.DB.DB_Connect;
import template.Application.controller.DB.Notice_DB;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.btn.RoundedButtonD;
import template.Application.controller.btn.RoundedButtonR;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Notice extends JFrame {

	private JPanel contentPane;
	Main reserfrm;
	DB_Connect connect;
	Notice NM;
	Notice_data Notice;
	Notice_Detail ND;
	ArrayList<Notice_data> NoticeArray;

	/**
	 * Create the frame.
	 */
	public Notice(Main reserfrm) {
		Notice_DB NDB = null;
		NoticeArray = new ArrayList<>();
		this.reserfrm = reserfrm;
		this.NM = this;

		NoticeArray = NDB.takeNoticetitle();

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
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 484, 705);
		panel_1.add(panel_2);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(70, 114, 42));
		panel_3.setBounds(0, 0, 484, 55);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lb_Title = new JLabel("공지 사항");
		lb_Title.setForeground(new Color(255, 255, 255));
		lb_Title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lb_Title.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lb_Title, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(70, 114, 42));
		panel_4.setBounds(0, 633, 484, 72);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pn_MovieInformaiton = new JPanel();
		panel_4.add(pn_MovieInformaiton);
		pn_MovieInformaiton.setBackground(new Color(70, 114, 42));
		pn_MovieInformaiton.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Movie Theater Introducer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		pn_MovieInformaiton.add(lblNewLabel_1);

		JLabel lb_TheaterNumber = new JLabel("전화번호 : 02 - 333 - 4848 ");
		lb_TheaterNumber.setForeground(new Color(255, 255, 255));
		lb_TheaterNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TheaterNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pn_MovieInformaiton.add(lb_TheaterNumber);

		JLabel lb_TheaterTime = new JLabel("영업시간 : 18:00 ~ 03:00");
		lb_TheaterTime.setForeground(new Color(255, 255, 255));
		lb_TheaterTime.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TheaterTime.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pn_MovieInformaiton.add(lb_TheaterTime);

		JLabel lb_TheaterCEO = new JLabel("대표자 : 고즐링");
		lb_TheaterCEO.setForeground(new Color(255, 255, 255));
		lb_TheaterCEO.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TheaterCEO.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pn_MovieInformaiton.add(lb_TheaterCEO);

		JLabel lb_Theater = new JLabel("사업자 번호: 653-25-0698");
		lb_Theater.setForeground(new Color(255, 255, 255));
		lb_Theater.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Theater.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pn_MovieInformaiton.add(lb_Theater);

		JLabel lb_TheaterLocaiton = new JLabel("위치: 서울 성동구 왕십리로 303");
		lb_TheaterLocaiton.setForeground(new Color(255, 255, 255));
		lb_TheaterLocaiton.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TheaterLocaiton.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lb_TheaterLocaiton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locaiton NL = new Locaiton(NM);
				NL.setVisible(true);
			}
		});
		pn_MovieInformaiton.add(lb_TheaterLocaiton);

		JPanel pn_NoticeMain = new JPanel();
		pn_NoticeMain.setBackground(new Color(255, 255, 255));
		pn_NoticeMain.setBounds(10, 61, 464, 562);
		panel_2.add(pn_NoticeMain);
		pn_NoticeMain.setLayout(null);

		for (int i = 0; i < NoticeArray.size(); i++) {
			String text = NoticeArray.get(i).getTitle();
			JLabel lbNotice = new JLabel(" " + (i + 1) + ". " + text);
			lbNotice.setHorizontalAlignment(JLabel.LEFT);
			lbNotice.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			LineBorder Line = new LineBorder(Color.GRAY, 1);
			lbNotice.setBorder(Line);
			Notice_data NB = NoticeArray.get(i);
			lbNotice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					boolean b = false;
					Notice_DB NDB = new Notice_DB();
					int count = 0;
					String title = "";
					count = NB.getViewcount() + 1;
					title = NB.getTitle();
					b = NDB.changeViewCount(title, count);
					ND = new Notice_Detail(NM, NB);
					Point fPt = NM.getLocationOnScreen();
					ND.setLocation(fPt.x + NM.getWidth() + 20, fPt.y);
					ND.setVisible(true);
				}
			});
			lbNotice.setBounds(10, 10 * (i + 1) + (i * 50), 446, 50);
			pn_NoticeMain.add(lbNotice);

		}

		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);

		RoundedButtonR roundedButtonD = new RoundedButtonR("HOME");
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		roundedButtonD.setBounds(12, 10, 100, 35);
		panel.add(roundedButtonD);

	}
}

class Locaiton extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Notice Notice;

	public Locaiton(Notice Notice) {
		this.Notice = Notice;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("../template/Reference/icons/VOC.png"));
			contentPanel.add(lblNewLabel, BorderLayout.CENTER);
		}
	}

}
