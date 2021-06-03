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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import template.Application.controller.DB.Ad_Film_DB;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.Data.Ad_Film_Data;
import template.Application.controller.btn.RoundedButtonD;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Admin_FilmManagement extends JDialog{

	private JFrame frame;
	private JTextField ad_txt_title;
	private JTextField ad_txt_ganre;
	private JTextField ad_txt_director;
	private JTextField ad_txt_age;
	private JTextField ad_txt_score;
	private JTextField ad_txt_gee;
	private JTextField ad_txt_openday;
	private JTextField ad_txt_production;
	private JTextField ad_txt_runtime;
	JLabel ad_lb_load_poster;
	Admin_FilmManagement dlg;
	private JTextField ad_txt_schedule_date;
	private JTextField ad_txt_schedule_time;
	Ad_Film_Data afd = new Ad_Film_Data();
	Ad_Film_DB AFD = new Ad_Film_DB();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_FilmManagement window = new Admin_FilmManagement();
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
	public Admin_FilmManagement() {
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
		
		JLabel ad_lb_poster = new JLabel("");
		pnMenuImage.add(ad_lb_poster, BorderLayout.CENTER);
		
//		JLabel lbMenuImgPath = new JLabel("no path");
		ad_lb_load_poster = new JLabel("no path");
		ad_lb_load_poster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String currentDirPath
				 = "./src/template/reference/images";
				final String currentDirPathDetail
				 = "./src/template/reference/images";
				System.out.println(currentDirPath);
				JFileChooser openDlg 
				 = new JFileChooser(currentDirPath);					
				if( openDlg.showOpenDialog(dlg) 
						== JFileChooser.APPROVE_OPTION ) {
					File imgFile = openDlg.getSelectedFile();
					System.out.println("선택된 파일명: " + imgFile.getName());
					System.out.println("선택된 파일경로명: " + imgFile.getPath());
					
					String dbImgPath
						= currentDirPath + "/" + imgFile.getName();
					ad_lb_load_poster.setText(dbImgPath);
					ad_lb_load_poster.setToolTipText("이미지 경로: " + imgFile.getPath());
					// 42x42 아이콘
					ImageIcon ic = new ImageIcon(imgFile.getPath());
					Image icImg = ic.getImage()
						.getScaledInstance(180, 230, Image.SCALE_SMOOTH);
					ic.setImage(icImg);
					ad_lb_poster.setIcon(ic);
					ad_lb_poster.repaint();
					int find = AFD.setmovie(ad_lb_poster.getText());
					
				}
			}
		});
		ad_lb_load_poster.setForeground(Color.RED);
		pnMenuImage.add(ad_lb_load_poster, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(204, 10, 250, 35);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNo = new JLabel("      상영날짜            상영시간");
		lblNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblNo, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(202, 102, 252, 148);
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JTextArea ad_txt_story = new JTextArea();
		ad_txt_story.setText((String) null);
		ad_txt_story.setLineWrap(true);
		ad_txt_story.setEditable(false);
		panel_5.add(ad_txt_story, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("줄거리");
		panel_7.add(label_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(204, 57, 250, 35);
		panel_2.add(panel_6);
		
		ad_txt_schedule_date = new JTextField();
		ad_txt_schedule_date.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_schedule_date.setBounds(25, 0, 82, 35);
		panel_6.add(ad_txt_schedule_date);
		ad_txt_schedule_date.setColumns(10);
		
		ad_txt_schedule_time = new JTextField();
		ad_txt_schedule_time.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_schedule_time.setColumns(10);
		ad_txt_schedule_time.setBounds(156, 0, 82, 35);
		panel_6.add(ad_txt_schedule_time);
		
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
		ad_txt_title.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_title);
		ad_txt_title.setColumns(10);
		
		JLabel ad_lb_genre = new JLabel("장르");
		ad_lb_genre.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_genre.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_genre);
		
		ad_txt_ganre = new JTextField();
		ad_txt_ganre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_ganre);
		ad_txt_ganre.setColumns(10);
		
		JLabel ad_lb_director = new JLabel("감독");
		ad_lb_director.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_director.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_director);
		
		ad_txt_director = new JTextField();
		ad_txt_director.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_director);
		ad_txt_director.setColumns(10);
		
		JLabel ad_lb_age = new JLabel("연령등급");
		ad_lb_age.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_age.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_age);
		
		ad_txt_age = new JTextField();
		ad_txt_age.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_age);
		ad_txt_age.setColumns(10);
		
		JLabel ad_lb_score = new JLabel("별점");
		ad_lb_score.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_score.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_score);
		
		ad_txt_score = new JTextField();
		ad_txt_score.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_score);
		ad_txt_score.setColumns(10);
		
		JLabel ad_lb_gee = new JLabel("등장인물");
		ad_lb_gee.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_gee.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_gee);
		
		ad_txt_gee = new JTextField();
		ad_txt_gee.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(ad_txt_gee);
		ad_txt_gee.setColumns(10);
		
		JLabel ad_lb_openday = new JLabel("개봉일");
		ad_lb_openday.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_openday.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_openday);
		
		ad_txt_openday = new JTextField();
		ad_txt_openday.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_openday.setColumns(10);
		panel_9.add(ad_txt_openday);
		
		JLabel ad_lb_production = new JLabel("제작사");
		ad_lb_production.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_production.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_production);
		
		ad_txt_production = new JTextField();
		ad_txt_production.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_production.setColumns(10);
		panel_9.add(ad_txt_production);
		
		JLabel ad_lb_runtime = new JLabel("영화 상영 시간");
		ad_lb_runtime.setHorizontalAlignment(SwingConstants.CENTER);
		ad_lb_runtime.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(ad_lb_runtime);
		
		ad_txt_runtime = new JTextField();
		ad_txt_runtime.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JButton ad_btn_up = new JButton("UP");
		ad_btn_up.setBounds(30, 707, 107, 48);
		panel.add(ad_btn_up);
		
		JButton ad_btn_cancel = new JButton("cancel");
		ad_btn_cancel.setBounds(364, 707, 107, 48);
		panel.add(ad_btn_cancel);
		
		JLabel label_3 = new JLabel("Film Management");
		
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Candara Light", Font.BOLD, 33));
		label_3.setBounds(30, 0, 400, 55);
		panel.add(label_3);
		
		JButton btnDown = new JButton("DOWN");
		btnDown.setBounds(165, 707, 107, 48);
		panel.add(btnDown);
	}
}
