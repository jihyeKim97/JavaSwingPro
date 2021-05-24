package template.Application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.RoundedButtonD;
import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.RoundedButtonY;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JTextPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import java.awt.Component;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private final Panel header_panel = new Panel();
	private RoundedButtonD btn_home;
	private Panel content_panel;
	private Panel div_panel;
	private Panel title_panel;
	private final Panel cpn_panel = new Panel();
	private Panel mem_panel;
	private Panel mem_detail;
	private Panel screening_panel;
	private RoundedButtonD btn_edit;
	private Panel txt_panel;
	private JLabel lb_name;
	private JLabel lb_ld;
	private JLabel lb_phone;
	private JLabel lb_bir;
	private JLabel lb_cp;
	private JLabel lb_np;
	private JLabel lb_cnp;
	private Panel txtF_panel;
	private JLabel lb_gen;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Button button;
	private JLabel lblNewLabel;
	private Button button_1;
	private Panel released_panel;
	private Button btn_notice;
	private JLabel lb_title1;
	private JLabel lb_title2;
	private Panel screen_guid_line;
	private Panel movie1_panel;
	private Panel poster_1;
	private Button btn_poster_1;
	private Panel movie4_panel;
	private Panel poster_4;
	private Button btn_poster_4;
	private Panel movie3_panel;
	private Panel poster_3;
	private Button btn_poster_3;
	private Panel movie2_panel;
	private Panel poster_2;
	private Button btn_poster_2;
	private Panel panel_10;
	
	Reservation Reserve;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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
	public Reservation() {
		this.Reserve = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		header_panel.setBackground(new Color(169, 169, 169));
		header_panel.setBounds(0, 0, 484, 55);
		contentPane.add(header_panel);
		header_panel.setLayout(null);

		RoundedButtonR btn_logout = new RoundedButtonR("LOGOUT");
		btn_logout.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_logout.setBounds(12, 10, 100, 35);
		header_panel.add(btn_logout);

		btn_home = new RoundedButtonD("HOME");
		btn_home.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_home.setBounds(320, 10, 100, 35);
		header_panel.add(btn_home);

		RoundedButtonD btn_myPage = new RoundedButtonD("HOME");
		btn_myPage.setText("=");
		btn_myPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_myPage.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_myPage.setBounds(430, 10, 41, 35);
		header_panel.add(btn_myPage);

		content_panel = new Panel();
		content_panel.setBackground(new Color(255, 255, 255));
		content_panel.setBounds(0, 55, 484, 705);
		contentPane.add(content_panel);
		content_panel.setLayout(null);

		div_panel = new Panel();
		div_panel.setBackground(new Color(255, 255, 255));
		div_panel.setBounds(10, 0, 464, 705);
		content_panel.add(div_panel);
		div_panel.setLayout(null);

		title_panel = new Panel();
		title_panel.setBackground(new Color(255, 255, 255));
		title_panel.setBounds(10, 16, 444, 55);
		div_panel.add(title_panel);
		title_panel.setLayout(null);
		
		button = new Button("prev");
		button.setFont(new Font("Dialog", Font.PLAIN, 15));
		button.setBounds(0, 0, 73, 55);
		title_panel.add(button);
		
		lblNewLabel = new JLabel("2020-05-17");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel.setBounds(79, 0, 280, 55);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		title_panel.add(lblNewLabel);
		
		button_1 = new Button("next");
		button_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_1.setBounds(365, 0, 79, 55);
		title_panel.add(button_1);
		mem_panel = new Panel();
		mem_panel.setBackground(new Color(255, 228, 196));
		mem_panel.setBounds(10, 120, 444, 570);
//		div_panel.add(mem_panel);
		mem_panel.setLayout(null);

		mem_detail = new Panel();
		mem_detail.setBackground(new Color(255, 255, 255));
		mem_detail.setBounds(10, 10, 424, 550);
		mem_panel.add(mem_detail);
		mem_detail.setLayout(null);
		mem_panel.setVisible(false);
		btn_edit = new RoundedButtonD("Edit");
		btn_edit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_edit.setBounds(162, 505, 100, 35);
		mem_detail.add(btn_edit);

		txt_panel = new Panel();
		txt_panel.setBounds(0, 0, 162, 462);
		mem_detail.add(txt_panel);
		txt_panel.setLayout(new GridLayout(0, 1, 0, 0));

		lb_name = new JLabel("Name");
		lb_name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_name);

		lb_ld = new JLabel("ID");
		lb_ld.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_ld.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_ld);

		lb_phone = new JLabel("Phone");
		lb_phone.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_phone.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_phone);

		lb_gen = new JLabel("Gender");
		lb_gen.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_gen.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_gen);

		lb_bir = new JLabel("BirthDay");
		lb_bir.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_bir.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_bir);

		lb_cp = new JLabel("Current PW");
		lb_cp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_cp.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_cp);

		lb_np = new JLabel("New PW");
		lb_np.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_np.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_np);

		lb_cnp = new JLabel("Confirm New PW");
		lb_cnp.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lb_cnp.setHorizontalAlignment(SwingConstants.CENTER);
		txt_panel.add(lb_cnp);

		txtF_panel = new Panel();
		txtF_panel.setBounds(168, 0, 256, 462);
		mem_detail.add(txtF_panel);
		txtF_panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 10, 246, 40);
		txtF_panel.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 65, 246, 40);
		txtF_panel.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(0, 123, 246, 40);
		txtF_panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(0, 183, 246, 40);
		txtF_panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(0, 242, 246, 40);
		txtF_panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(0, 302, 246, 40);
		txtF_panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(0, 358, 246, 40);
		txtF_panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(0, 412, 246, 40);
		txtF_panel.add(textField_7);
		cpn_panel.setBackground(Color.WHITE);
		cpn_panel.setBounds(10, 77, 444, 613);
		div_panel.add(cpn_panel);
		cpn_panel.setLayout(null);

		screening_panel = new Panel();
		screening_panel.setBackground(new Color(255, 255, 255));
		screening_panel.setBounds(10, 10, 424, 210);
		cpn_panel.add(screening_panel);
		screening_panel.setLayout(null);
		
		lb_title1 = new JLabel("상영중인 영화");
		lb_title1.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		lb_title1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title1.setBounds(0, 0, 424, 39);
		screening_panel.add(lb_title1);
		
		screen_guid_line = new Panel();
		screen_guid_line.setBounds(0, 39, 424, 171);
		screening_panel.add(screen_guid_line);
		screen_guid_line.setLayout(null);
		
		movie1_panel = new Panel();
		movie1_panel.setBounds(10, 0, 94, 161);
		screen_guid_line.add(movie1_panel);
		movie1_panel.setLayout(null);
		
		poster_1 = new Panel();
		poster_1.setBounds(0, 0, 94, 125);
		movie1_panel.add(poster_1);
		
		btn_poster_1 = new Button("예매");
		btn_poster_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_poster_1.setBounds(0, 131, 94, 30);
		movie1_panel.add(btn_poster_1);
		movie1_panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btn_poster_1, poster_1}));
		
		movie4_panel = new Panel();
		movie4_panel.setLayout(null);
		movie4_panel.setBounds(320, 0, 94, 161);
		screen_guid_line.add(movie4_panel);
		
		poster_4 = new Panel();
		poster_4.setBounds(0, 0, 94, 125);
		movie4_panel.add(poster_4);
		
		btn_poster_4 = new Button("예매");
		btn_poster_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_poster_4.setBounds(0, 131, 94, 30);
		movie4_panel.add(btn_poster_4);
		
		movie3_panel = new Panel();
		movie3_panel.setLayout(null);
		movie3_panel.setBounds(217, 0, 94, 161);
		screen_guid_line.add(movie3_panel);
		
		poster_3 = new Panel();
		poster_3.setBounds(0, 0, 94, 125);
		movie3_panel.add(poster_3);
		
		btn_poster_3 = new Button("예매");
		btn_poster_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_poster_3.setBounds(0, 131, 94, 30);
		movie3_panel.add(btn_poster_3);
		
		movie2_panel = new Panel();
		movie2_panel.setLayout(null);
		movie2_panel.setBounds(113, 0, 94, 161);
		screen_guid_line.add(movie2_panel);
		
		poster_2 = new Panel();
		poster_2.setBounds(0, 0, 94, 125);
		movie2_panel.add(poster_2);
		
		btn_poster_2 = new Button("예매");
		btn_poster_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_poster_2.setBounds(0, 131, 94, 30);
		movie2_panel.add(btn_poster_2);
		
		released_panel = new Panel();
		released_panel.setLayout(null);
		released_panel.setBackground(Color.WHITE);
		released_panel.setBounds(10, 226, 424, 309);
		cpn_panel.add(released_panel);
		
		lb_title2 = new JLabel("개봉예정 영화");
		lb_title2.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		lb_title2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title2.setBounds(0, 0, 424, 44);
		released_panel.add(lb_title2);
		
		panel_10 = new Panel();
		panel_10.setBounds(0, 43, 423, 265);
		released_panel.add(panel_10);
		panel_10.setLayout(null);
		
		Panel poster_re_1 = new Panel();
		poster_re_1.setBounds(10, 0, 94, 125);
		panel_10.add(poster_re_1);
		
		Panel poster_re_2 = new Panel();
		poster_re_2.setBounds(113, 0, 94, 125);
		panel_10.add(poster_re_2);
		
		Panel poster_re_3 = new Panel();
		poster_re_3.setBounds(217, 0, 94, 125);
		panel_10.add(poster_re_3);
		
		Panel poster_re_4 = new Panel();
		poster_re_4.setBounds(320, 0, 94, 125);
		panel_10.add(poster_re_4);
		
		Panel poster_re_5 = new Panel();
		poster_re_5.setBounds(10, 131, 94, 125);
		panel_10.add(poster_re_5);
		
		Panel poster_re_6 = new Panel();
		poster_re_6.setBounds(113, 131, 94, 125);
		panel_10.add(poster_re_6);
		
		Panel poster_re_7 = new Panel();
		poster_re_7.setBounds(217, 131, 94, 125);
		panel_10.add(poster_re_7);
		
		Panel poster_re_8 = new Panel();
		poster_re_8.setBounds(320, 131, 94, 125);
		panel_10.add(poster_re_8);
		
		btn_notice = new Button("공지사항");
		btn_notice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notice_main NM = new Notice_main(Reserve);
				java.awt.Point fPt = Reserve.getLocationOnScreen();
				NM.setLocation(fPt.x + Reserve.getWidth() + 20, fPt.x);
				NM.setVisible(true);
			}
		});
		btn_notice.setBounds(10, 543, 424, 60);
		cpn_panel.add(btn_notice);
		cpn_panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lb_title1, screening_panel, btn_poster_1, screen_guid_line, movie1_panel, poster_1, movie4_panel, poster_4, btn_poster_4, movie3_panel, poster_3, btn_poster_3, movie2_panel, poster_2, btn_poster_2, released_panel, lb_title2, panel_10, poster_re_1, poster_re_2, poster_re_3, poster_re_4, poster_re_5, poster_re_6, poster_re_7, poster_re_8, btn_notice}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btn_myPage, contentPane, header_panel, btn_logout, btn_home, content_panel, div_panel, title_panel, button, lblNewLabel, button_1, cpn_panel, screening_panel, lb_title1, screen_guid_line, movie1_panel, poster_1, btn_poster_1, movie4_panel, poster_4, btn_poster_4, movie3_panel, poster_3, btn_poster_3, movie2_panel, poster_2, btn_poster_2, released_panel, lb_title2, panel_10, poster_re_1, poster_re_2, poster_re_3, poster_re_4, poster_re_5, poster_re_6, poster_re_7, poster_re_8, btn_notice}));

	}
}
