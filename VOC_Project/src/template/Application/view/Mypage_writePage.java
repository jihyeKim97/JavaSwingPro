package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;

public class Mypage_writePage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage_writePage frame = new Mypage_writePage();
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
	public Mypage_writePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel review_box = new JPanel();
		review_box.setBounds(10, 10, 465, 332);
		contentPane.add(review_box);
		review_box.setLayout(null);
		
		Panel poster = new Panel();
		poster.setBackground(new Color(255, 192, 203));
		poster.setBounds(10, 78, 116, 208);
		review_box.add(poster);
		
		JLabel title = new JLabel("Title : ");
		title.setFont(new Font("Candara Light", Font.PLAIN, 15));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setBounds(10, 46, 57, 15);
		review_box.add(title);
		
		Button btn_ok = new Button("ok");
		btn_ok.setFont(new Font("Candara Light", Font.PLAIN, 12));
		btn_ok.setBounds(297, 292, 76, 30);
		review_box.add(btn_ok);
		
		Button btn_cancel = new Button("cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_cancel.setFont(new Font("Candara Light", Font.PLAIN, 12));
		btn_cancel.setBounds(379, 292, 76, 30);
		review_box.add(btn_cancel);
		
		Panel content = new Panel();
		content.setBounds(132, 10, 323, 276);
		review_box.add(content);
		content.setLayout(null);
		
		JTextArea reviewtxtA = new JTextArea();
		reviewtxtA.setBounds(12, 97, 299, 169);
		content.add(reviewtxtA);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 299, 77);
		content.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Give me a Score");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton rd_1 = new JRadioButton("1점");
		rd_1.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rd_1);
		panel_1.add(rd_1);
		
		JRadioButton rd_2 = new JRadioButton("2점");
		rd_2.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rd_2);
		panel_1.add(rd_2);
		
		JRadioButton rd_3 = new JRadioButton("3점");
		rd_3.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rd_3);
		panel_1.add(rd_3);
		
		JRadioButton rd_4 = new JRadioButton("4점");
		rd_4.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rd_4);
		panel_1.add(rd_4);
		
		JRadioButton rd_5 = new JRadioButton("5점");
		rd_5.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rd_5);
		panel_1.add(rd_5);
		
		JLabel lblD = new JLabel("Date : ");
		lblD.setHorizontalAlignment(SwingConstants.LEFT);
		lblD.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lblD.setBounds(10, 21, 57, 15);
		review_box.add(lblD);
		
		JLabel datetxt = new JLabel("");
		datetxt.setBounds(54, 20, 72, 15);
		review_box.add(datetxt);
		
		JLabel titletxt = new JLabel("");
		titletxt.setBounds(54, 45, 72, 15);
		review_box.add(titletxt);
	}
}
