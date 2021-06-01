package template.Application.view;

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

import template.Application.controller.RoundedButtonD;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	JLabel lbMenuImgPath;
	Admin_FilmManagement dlg;
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
		
		JLabel lbMenuImg = new JLabel("");
		pnMenuImage.add(lbMenuImg, BorderLayout.CENTER);
		
//		JLabel lbMenuImgPath = new JLabel("no path");
		lbMenuImgPath = new JLabel("no path");
		lbMenuImgPath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String currentDirPath
				 = "../Reference/icons";
				final String currentDirPathDetail
				 = "../Reference/icons";
				JFileChooser openDlg 
				 = new JFileChooser(currentDirPath);					
				if( openDlg.showOpenDialog(dlg) 
						== JFileChooser.APPROVE_OPTION ) {
					File imgFile = openDlg.getSelectedFile();
				//C:\Users\82102\javaPro\VOC_Project\src\template\Reference\images\7번방의 선물.jpg
					System.out.println("선택된 파일명: " +  imgFile.getName());
					System.out.println("선택된 파일경로명: " +  imgFile.getPath());
					
					String dbImgPath
						= currentDirPath + "/" + imgFile.getName();
					lbMenuImgPath.setText(dbImgPath);
					lbMenuImgPath.setToolTipText("이미지 경로: " + imgFile.getPath());
					// 42x42 아이콘
					ImageIcon ic = new ImageIcon(imgFile.getPath());
					Image icImg = ic.getImage()
						.getScaledInstance(180, 230, Image.SCALE_SMOOTH);
					ic.setImage(icImg);
					lbMenuImg.setIcon(ic);
					lbMenuImg.repaint();
				
				}
			}
		});
		lbMenuImgPath.setForeground(Color.RED);
		pnMenuImage.add(lbMenuImgPath, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(204, 10, 250, 35);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNo = new JLabel("상영날짜                     상영시간");
		lblNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblNo, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(202, 102, 252, 148);
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setText((String) null);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		panel_5.add(textArea, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("줄거리");
		panel_7.add(label_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(204, 57, 250, 35);
		panel_2.add(panel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(7, 337, 464, 360);
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(0, 30, 464, 330);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(9, 2, 0, 0));
		
		JLabel label = new JLabel("제목");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label);
		
		textField = new JTextField();
		panel_9.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("장르");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_2);
		
		textField_1 = new JTextField();
		panel_9.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_6 = new JLabel("감독");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_6);
		
		textField_2 = new JTextField();
		panel_9.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_8 = new JLabel("연령등급");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_8);
		
		textField_3 = new JTextField();
		panel_9.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_10 = new JLabel("별점");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_10);
		
		textField_4 = new JTextField();
		panel_9.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_12 = new JLabel("등장인물");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_12);
		
		textField_5 = new JTextField();
		panel_9.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_14 = new JLabel("개봉일");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_14);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_9.add(textField_6);
		
		JLabel label_16 = new JLabel("제작사");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_16);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_9.add(textField_7);
		
		JLabel label_18 = new JLabel("영화 상영 시간");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_9.add(label_18);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_9.add(textField_8);
		
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
		
		JButton btnNewButton = new JButton("UP");
		btnNewButton.setBounds(30, 707, 107, 48);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(364, 707, 107, 48);
		panel.add(btnCancel);
		
		JLabel label_3 = new JLabel("Film Management");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Candara Light", Font.BOLD, 33));
		label_3.setBounds(30, 0, 400, 55);
		panel.add(label_3);
		
		JButton btnDown = new JButton("DOWN");
		btnDown.setBounds(165, 707, 107, 48);
		panel.add(btnDown);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(443, 682, 57, 15);
		panel.add(label_4);
	}
}
