package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.awt.SystemColor;

import template.Application.controller.DB_Connect;
import template.Application.controller.Notice_DB;
import template.Application.controller.Notice_data;
import template.Application.controller.RoundedButtonD;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;

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
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);

		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setBounds(10, 10, 444, 55);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lb_Title = new JLabel("공지 사항");
		lb_Title.setFont(new Font("굴림", Font.BOLD, 40));
		lb_Title.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lb_Title, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 472, 444, 200);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel pn_TheaterTitle = new JPanel();
		pn_TheaterTitle.setBackground(SystemColor.activeCaption);
		panel_4.add(pn_TheaterTitle, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Movie Theater Introducer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		pn_TheaterTitle.add(lblNewLabel_1);

		JPanel pn_MovieInformaiton = new JPanel();
		panel_4.add(pn_MovieInformaiton, BorderLayout.CENTER);
		pn_MovieInformaiton.setLayout(null);

		JLabel lb_TheaterNumber = new JLabel("● 전화번호 : 02 - 333 - 4848 ");
		lb_TheaterNumber.setBounds(10, 10, 210, 30);
		pn_MovieInformaiton.add(lb_TheaterNumber);

		JLabel lb_TheaterTime = new JLabel("● 영업시간 : 18:00 ~ 03:00");
		lb_TheaterTime.setBounds(10, 40, 198, 30);
		pn_MovieInformaiton.add(lb_TheaterTime);

		JLabel lb_TheaterCEO = new JLabel("● 대표자 : 고즐링");
		lb_TheaterCEO.setBounds(10, 70, 198, 30);
		pn_MovieInformaiton.add(lb_TheaterCEO);

		JLabel lb_Theater = new JLabel("● 사업자 번호: 653-25-0698");
		lb_Theater.setBounds(10, 100, 198, 30);
		pn_MovieInformaiton.add(lb_Theater);

//		LineBorder LineB = new LineBorder(Color.black,1);
		JLabel lb_TheaterLocaiton = new JLabel("● 위치: 서울 성동구 왕십리로 303");
//		lb_TheaterLocaiton.setBorder(LineB);
		lb_TheaterLocaiton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locaiton NL = new Locaiton(NM);
				NL.setVisible(true);
			}
		});
		lb_TheaterLocaiton.setBounds(10, 130, 236, 30);
		pn_MovieInformaiton.add(lb_TheaterLocaiton);

		JPanel pn_NoticeMain = new JPanel();
		pn_NoticeMain.setBounds(10, 75, 444, 387);
		panel_2.add(pn_NoticeMain);
		pn_NoticeMain.setLayout(null);

		for (int i = 0; i <NoticeArray.size(); i++) {
			String text = NoticeArray.get(i).getTitle();
			JLabel lbNotice = new JLabel( (i + 1) + ". " + text);
			lbNotice.setHorizontalAlignment(JLabel.LEFT);
			lbNotice.setFont(new Font("굴림", Font.BOLD, 25));
			LineBorder Line = new LineBorder(Color.RED,3);
			lbNotice.setBorder(Line);
			Notice_data NB = NoticeArray.get(i);
			lbNotice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ND = new Notice_Detail(NM, NB);
					ND.setVisible(true);
					}
				
			});
			lbNotice.setBounds(10, 10 * (i + 1) + (i * 80), 416, 80);
			pn_NoticeMain.add(lbNotice);

		}

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
			lblNewLabel.setIcon(new ImageIcon("./template/Reference/icons/VOC.png"));
			contentPanel.add(lblNewLabel, BorderLayout.CENTER);
		}
	}

}
