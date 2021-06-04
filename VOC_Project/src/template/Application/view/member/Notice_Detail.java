package template.Application.view.member;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.SystemColor;
import template.Application.controller.DB.Notice_DB;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.btn.RoundedButtonR;
import javax.swing.JTextArea;

public class Notice_Detail extends JFrame {

	private JPanel contentPane;
	Notice NM;
	Notice_data Notice;
	ArrayList<Notice_data> NoticeArr = new ArrayList<>();
	Notice_DB NoticeDB;

	public Notice_Detail(Notice NM, Notice_data Notice) {
		this.NM = NM;
		this.Notice = Notice;
		NoticeArr = NoticeDB.takeNoticetitle();
		int PK = 0;
		int i = Notice.getNoticeid();
		if (i == 4) {
			i = 2;
		} else if (i == 5) {
			i = 3;
		} else if (i == 6) {
			i = 4;
		}
		PK = i - 1;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		setTitle("Vehicle Outdoor Cinema");
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
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 484, 705);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		Panel pn_Title = new Panel();
		pn_Title.setBounds(10, 24, 464, 55);
		pn_Title.setBackground(new Color(255, 255, 255));
		panel_2.add(pn_Title);
		pn_Title.setLayout(new BorderLayout(0, 0));

		String title = NoticeArr.get(PK).getTitle();
		JLabel lb_Title = new JLabel(title);
		lb_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Title.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		pn_Title.add(lb_Title, BorderLayout.CENTER);

		int ViewCount = NoticeArr.get(PK).getViewcount();

		JLabel lblNewLabel = new JLabel("조회수:" + ViewCount);
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pn_Title.add(lblNewLabel, BorderLayout.SOUTH);

		JPanel pn_Content = new JPanel();
		pn_Content.setBounds(20, 95, 441, 600);
		panel_2.add(pn_Content);
		pn_Content.setLayout(new BorderLayout(0, 0));

		JTextArea content = new JTextArea();
		content.setLineWrap(true);
		content.setText(NoticeArr.get(PK).getContent());
		content.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		content.setEditable(false);
		pn_Content.add(content, BorderLayout.CENTER);

		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);

		RoundedButtonR roundedButtonD = new RoundedButtonR("HOME");
		roundedButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		roundedButtonD.setBounds(12, 10, 100, 35);
		panel.add(roundedButtonD);

	}
}
