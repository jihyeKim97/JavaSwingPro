package template.Application.view.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import template.Application.controller.DB.Ad_Film_DB;
import template.Application.controller.Data.Ad_Film_Data;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;


import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin_FilmManagement_Enrollment extends JDialog {

	JFrame frame;
	JTextField ad_txt_title;
	JTextField ad_txt_ganre;
	JTextField ad_txt_director;
	JTextField ad_txt_age;
	JTextField ad_txt_score;
	JTextField ad_txt_gee;
	JTextField ad_txt_openday;
	JTextField ad_txt_production;
	JTextField ad_txt_runtime;
	JLabel ad_lb_load_poster;
	Admin_FilmManagement_Enrollment dlg;
	String dbImgPath;
	String ppp;
	JLabel ad_lb_poster;
	Ad_Film_Data afd = new Ad_Film_Data();
	Ad_Film_DB db = new Ad_Film_DB();
	File imgFile;
	JTextField ad_txt_schedule_date;
	JTextField ad_txt_img;
	ImageIcon image1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_FilmManagement_Enrollment window = new Admin_FilmManagement_Enrollment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_FilmManagement_Enrollment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("영화정보");
		frame.setBounds(100, 100, 493, 804);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 765);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel);

		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(7, 61, 464, 260);
		panel.add(panel_2);

		JPanel pnMenuImage = new JPanel();
		pnMenuImage.setBounds(10, 10, 180, 240);
		panel_2.add(pnMenuImage);
		pnMenuImage.setLayout(new BorderLayout(0, 0));

		
		ad_lb_load_poster = new JLabel("no path");
		ad_lb_load_poster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String currentDirPath = "./src/template/reference/images";
				final String currentDirPathDetail = "/template/reference/images";
				System.out.println(currentDirPath);
				JFileChooser openDlg = new JFileChooser(currentDirPath);
				if (openDlg.showOpenDialog(dlg) == JFileChooser.APPROVE_OPTION) {
					imgFile = openDlg.getSelectedFile();
					System.out.println("선택된 파일명: " + imgFile.getName());
					System.out.println("선택된 파일경로명: " + imgFile.getPath());
					dbImgPath = currentDirPath + "/" + imgFile.getName();
					ad_lb_load_poster.setText(dbImgPath);
					ad_lb_load_poster.setToolTipText("이미지 경로: " + imgFile.getPath());
					// 42x42 아이콘
					ImageIcon ic = new ImageIcon(imgFile.getPath());
					Image icImg = ic.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
					ic.setImage(icImg);
					ad_lb_load_poster.setIcon(ic);
					ad_lb_load_poster.repaint();
					ppp = currentDirPathDetail + " / " + imgFile.getName();
				}
			}
		});
		ad_lb_load_poster.setForeground(Color.RED);
		pnMenuImage.add(ad_lb_load_poster, BorderLayout.SOUTH);


		JPanel panel_4 = new JPanel();
		panel_4.setBounds(204, 10, 250, 35);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNo = new JLabel("      상영날짜   ");
		lblNo.setBounds(0, 0, 250, 35);
		lblNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblNo);

		ad_txt_schedule_date = new JTextField();
		ad_txt_schedule_date.setForeground(Color.LIGHT_GRAY);
		ad_txt_schedule_date.setText("ex) 2021-01-01");
		ad_txt_schedule_date.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_schedule_date.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_schedule_date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_schedule_date.setForeground(Color.black);
				ad_txt_schedule_date.setBackground(new Color(240, 240, 240));
				if (ad_txt_schedule_date.getText().equals("ex) 2021-01-01"))
					ad_txt_schedule_date.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_schedule_date.setForeground(Color.LIGHT_GRAY);
				ad_txt_schedule_date.setBackground(Color.WHITE);
				if (ad_txt_schedule_date.getText().isEmpty())
					ad_txt_schedule_date.setText("ex) 2021-01-01");
			}
		});
		ad_txt_schedule_date.setColumns(10);
		ad_txt_schedule_date.setBounds(108, 0, 130, 35);
		panel_4.add(ad_txt_schedule_date);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(202, 55, 252, 27);
		panel_2.add(panel_7);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel label_1 = new JLabel("줄거리");
		panel_7.add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(202, 79, 252, 171);
		panel_2.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textArea.setForeground(Color.black);
				textArea.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				textArea.setForeground(Color.LIGHT_GRAY);
				textArea.setBackground(Color.WHITE);
			}
		});
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(7, 337, 464, 360);
		panel.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(0, 30, 464, 330);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(9, 2, 0, 0));

		JLabel ad_lb_title = new JLabel("제목");
		ad_lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_title.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_title);

		ad_txt_title = new JTextField();
		ad_txt_title.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_title.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_title.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_title.setForeground(Color.black);
				ad_txt_title.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_title.setForeground(Color.LIGHT_GRAY);
				ad_txt_title.setBackground(Color.WHITE);
			}
		});
		panel_9.add(ad_txt_title);
		ad_txt_title.setColumns(10);

		JLabel ad_lb_genre = new JLabel("장르");
		ad_lb_genre.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_genre.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		panel_9.add(ad_lb_genre);

		ad_txt_ganre = new JTextField();
		ad_txt_ganre.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_ganre.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_ganre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_ganre.setForeground(Color.black);
				ad_txt_ganre.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_ganre.setForeground(Color.LIGHT_GRAY);
				ad_txt_ganre.setBackground(Color.WHITE);
			}
		});
		panel_9.add(ad_txt_ganre);
		ad_txt_ganre.setColumns(10);

		JLabel ad_lb_director = new JLabel("감독");
		ad_lb_director.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_director.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_director);

		ad_txt_director = new JTextField();
		ad_txt_director.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_director.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_director.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_director.setForeground(Color.black);
				ad_txt_director.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_director.setForeground(Color.LIGHT_GRAY);
				ad_txt_director.setBackground(Color.WHITE);
			}
		});
		panel_9.add(ad_txt_director);
		ad_txt_director.setColumns(10);

		JLabel ad_lb_age = new JLabel("연령등급");
		ad_lb_age.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_age.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_age);

		ad_txt_age = new JTextField();
		ad_txt_age.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_age.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_age.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_age.setForeground(Color.black);
				ad_txt_age.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_age.setForeground(Color.LIGHT_GRAY);
				ad_txt_age.setBackground(Color.WHITE);
			}
		});
		panel_9.add(ad_txt_age);
		ad_txt_age.setColumns(10);
		ad_txt_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 1
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
					ke.consume();
				}
			}

		});

		JLabel ad_lb_score = new JLabel("별점");
		ad_lb_score.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_score.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		panel_9.add(ad_lb_score);

		ad_txt_score = new JTextField();
		ad_txt_score.setForeground(Color.LIGHT_GRAY);
		ad_txt_score.setText("ex) 1.0 ~ 5.0");
		ad_txt_score.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_score.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_score.setForeground(Color.black);
				ad_txt_score.setBackground(new Color(240, 240, 240));
				if (ad_txt_score.getText().equals("ex) 1.0 ~ 5.0"))
					ad_txt_score.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_score.setForeground(Color.LIGHT_GRAY);
				ad_txt_score.setBackground(Color.WHITE);
				if (ad_txt_score.getText().isEmpty())
					ad_txt_score.setText("ex) 1.0 ~ 5.0");
			}
		});
		ad_txt_score.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_score);
		ad_txt_score.setColumns(10);

		JLabel ad_lb_gee = new JLabel("등장인물");
		ad_lb_gee.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_gee.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_gee);

		ad_txt_gee = new JTextField();
		ad_txt_gee.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_gee.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_gee.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_gee.setForeground(Color.black);
				ad_txt_gee.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_gee.setForeground(Color.LIGHT_GRAY);
				ad_txt_gee.setBackground(Color.WHITE);
			}
		});
		panel_9.add(ad_txt_gee);
		ad_txt_gee.setColumns(10);

		JLabel ad_lb_openday = new JLabel("개봉일");
		ad_lb_openday.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_openday.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_openday);

		ad_txt_openday = new JTextField();
		ad_txt_openday.setForeground(Color.LIGHT_GRAY);
		ad_txt_openday.setText("ex) 2021-01-01");
		ad_txt_openday.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_openday.setForeground(Color.black);
				ad_txt_openday.setBackground(new Color(240, 240, 240));
				if (ad_txt_openday.getText().equals("ex) 2021-01-01"))
					ad_txt_openday.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_openday.setForeground(Color.LIGHT_GRAY);
				ad_txt_openday.setBackground(Color.WHITE);
				if (ad_txt_openday.getText().isEmpty())
					ad_txt_openday.setText("ex) 2021-01-01");
			}
		});
		ad_txt_openday.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_openday.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_openday.setColumns(10);
		panel_9.add(ad_txt_openday);

		JLabel ad_lb_production = new JLabel("제작사");
		ad_lb_production.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_production.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_production);

		ad_txt_production = new JTextField();
		ad_txt_production.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_production.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_production.setForeground(Color.black);
				ad_txt_production.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_production.setForeground(Color.LIGHT_GRAY);
				ad_txt_production.setBackground(Color.WHITE);
			}
		});
		ad_txt_production.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_production.setColumns(10);
		panel_9.add(ad_txt_production);

		JLabel ad_lb_runtime = new JLabel("영화 상영 시간");
		ad_lb_runtime.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_runtime.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_runtime);

		ad_txt_runtime = new JTextField();
		ad_txt_runtime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		ad_txt_runtime.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_runtime.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ad_txt_runtime.setForeground(Color.black);
				ad_txt_runtime.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void focusLost(FocusEvent e) {
				ad_txt_runtime.setForeground(Color.LIGHT_GRAY);
				ad_txt_runtime.setBackground(Color.WHITE);
			}
		});
		ad_txt_runtime.setColumns(10);
		panel_9.add(ad_txt_runtime);

		JLabel label_20 = new JLabel("영화 정보");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("굴림", Font.BOLD, 20));
		label_20.setBounds(0, -10, 232, 40);
		panel_8.add(label_20);

		JLabel label_21 = new JLabel("내용");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("굴림", Font.BOLD, 20));
		label_21.setBounds(232, -10, 232, 40);
		panel_8.add(label_21);

		JButton ad_btn_up = new JButton("등록");
		ad_btn_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad_title = ad_txt_title.getText();
				String ad_genre = ad_txt_ganre.getText();
				String ad_director = ad_txt_director.getText();
				String age_group = ad_txt_age.getText();
				String ad_story = textArea.getText();
				String ad_average_score = ad_txt_score.getText();
				String ad_gee = ad_txt_gee.getText();
				String ad_open_date = ad_txt_openday.getText();
				String ad_production = ad_txt_production.getText();
				String ad_schedule_date = ad_txt_schedule_date.getText();
				String ad_running_time = ad_txt_runtime.getText();
				Ad_Film_Data upmovie = new Ad_Film_Data(ad_title, ad_genre, ad_director, age_group, ad_story,
						ad_average_score, ad_gee, ad_open_date, ad_production, ad_schedule_date, ppp,
						ad_running_time);
				boolean r = db.insertNewMovie(upmovie);
				if (r) {
					JOptionPane.showMessageDialog(null, "등록성공");
				} else
					JOptionPane.showMessageDialog(null, "등록실패");

			}
		});
		ad_btn_up.setBounds(7, 707, 107, 48);
		panel.add(ad_btn_up);

		JButton ad_btn_cancel = new JButton("cancel");
		ad_btn_cancel.setBounds(364, 707, 107, 48);
		panel.add(ad_btn_cancel);

		JLabel label_3 = new JLabel("Film Management");

		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Candara Light", Font.BOLD, 33));
		label_3.setBounds(30, 0, 400, 55);
		panel.add(label_3);
	}
}
