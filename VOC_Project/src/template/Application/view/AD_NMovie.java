package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Ad_AdPage_DB;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.Data.Movie_Data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AD_NMovie extends JFrame {

	JPanel contentPane;
	JTextField title;
	JTextField ger;
	JTextField dir;
	JTextField age;
	JTextField com;
	JTextField per;
	JTextField open;

	File imgFile;
	AD_NMovie Mofrm;
	Ad_AdPage_DB AMDB;
	String dbImgPath;
	String ppp;

	public AD_NMovie(AD_Main frm) {
		this.Mofrm = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 841);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Vehicle Outdoor Cinema");
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Movie Infomation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 534, 51);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 61, 534, 212);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 0, 179, 212);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(AD_NMovie.class.getResource("/template/Reference/icons/no_image.png")));
		panel_2.add(lblNewLabel_4);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(203, 0, 319, 212);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("[ 줄거리를 기재하세요 ]");
		lblNewLabel_2.setBackground(new Color(112, 128, 144));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(12, 5, 295, 27);
		panel_3.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 38, 297, 163);
		panel_3.add(scrollPane);

		JTextArea contentTA = new JTextArea();
		contentTA.setLineWrap(true);
		scrollPane.setViewportView(contentTA);
		contentTA.setText("");

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 283, 534, 432);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 10, 510, 412);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 166, 412);
		panel_6.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 20));

		JLabel lblNewLabel_3 = new JLabel("제목");
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label = new JLabel("장르");
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("감독");
		panel_4.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_2 = new JLabel("연령등급");
		panel_4.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_3 = new JLabel("등장인물");
		panel_4.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_4 = new JLabel("개봉일");
		panel_4.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel label_5 = new JLabel("제작사");
		panel_4.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("이미지 경로");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_5);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(178, 0, 332, 412);
		panel_6.add(panel_7);
		panel_7.setLayout(null);

		title = new JTextField();
		title.setBounds(0, 0, 332, 34);
		panel_7.add(title);
		title.setText("");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		title.setColumns(10);

		ger = new JTextField();
		ger.setBounds(0, 54, 332, 34);
		panel_7.add(ger);
		ger.setText("");
		ger.setHorizontalAlignment(SwingConstants.CENTER);
		ger.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		ger.setColumns(10);

		dir = new JTextField();
		dir.setBounds(0, 108, 332, 34);
		panel_7.add(dir);
		dir.setText("");
		dir.setHorizontalAlignment(SwingConstants.CENTER);
		dir.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		dir.setColumns(10);
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() > 2
						|| (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
					ke.consume();
			}
		});
		age.setBounds(0, 162, 332, 34);
		panel_7.add(age);
		age.setText("");
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		age.setColumns(10);

		per = new JTextField();
		per.setBounds(0, 216, 332, 34);
		panel_7.add(per);
		per.setText("");
		per.setHorizontalAlignment(SwingConstants.CENTER);
		per.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		per.setColumns(10);

		open = new JTextField();
		open.setBounds(0, 270, 332, 34);
		panel_7.add(open);
		open.setText("");
		open.setHorizontalAlignment(SwingConstants.CENTER);
		open.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		open.setColumns(10);

		com = new JTextField();
		com.setBounds(0, 324, 332, 34);
		panel_7.add(com);
		com.setText("");
		com.setHorizontalAlignment(SwingConstants.CENTER);
		com.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		com.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 378, 332, 34);
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_6);

		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String currentDirPath = "./src/template/reference/images";
				final String currentDirPathDetail = "/template/reference/images";
				System.out.println(currentDirPath);
				JFileChooser openDlg = new JFileChooser(currentDirPath);
				if (openDlg.showOpenDialog(Mofrm) == JFileChooser.APPROVE_OPTION) {
					imgFile = openDlg.getSelectedFile();
					System.out.println("선택된 파일명: " + imgFile.getName());
					System.out.println("선택된 파일경로명: " + imgFile.getPath());
					dbImgPath = "/template/reference/images/" + imgFile.getName();
					dbImgPath.trim();
					lblNewLabel_4.setText(dbImgPath);
					lblNewLabel_4.setToolTipText("이미지 경로: " + imgFile.getPath());
					// 42x42 아이콘
					ImageIcon ic = new ImageIcon(imgFile.getPath());
					Image icImg = ic.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
					ic.setImage(icImg);
					lblNewLabel_4.setIcon(ic);
					lblNewLabel_4.repaint();
					ppp = currentDirPathDetail + "/" + imgFile.getName();
					lblNewLabel_6.setText(dbImgPath);
				}
			}
		});

		JLabel label_6 = new JLabel("예 ) 12세 연령제한  =>  12");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		label_6.setBounds(5, 197, 313, 15);
		panel_7.add(label_6);

		JLabel label_7 = new JLabel("예 ) 2020년 5월 24일  =>  2020/05/24 & 2020.05.24");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		label_7.setBounds(5, 305, 313, 15);
		panel_7.add(label_7);

		RoundedButtonG btnNewButton = new RoundedButtonG("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String runningTime = "120분";
				if (contentTA.getText().isEmpty() || title.getText().isEmpty() || ger.getText().isEmpty()
						|| age.getText().isEmpty() || per.getText().isEmpty() || open.getText().isEmpty()
						|| com.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "빈칸이 존재 합니다.");
				} else {
					Ad_AdPage_DB AMDB = new Ad_AdPage_DB();
					AMDB.addNewMovie(title.getText(), ger.getText(), dir.getText(), Integer.parseInt(age.getText()),
							contentTA.getText(), per.getText(), open.getText(), com.getText(), lblNewLabel_6.getText().trim(), runningTime);
					JOptionPane.showMessageDialog(null, "영화가 등록되었습니다.");
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnNewButton.setBounds(162, 737, 100, 45);
		panel.add(btnNewButton);

		RoundedButtonR btnCancel = new RoundedButtonR("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnCancel.setBounds(268, 737, 100, 45);
		panel.add(btnCancel);
	}
}
