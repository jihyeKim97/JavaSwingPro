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

public class Mypage_writePage extends JFrame {

	private JPanel contentPane;

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
		poster.setBounds(10, 68, 116, 208);
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
				System.exit(0);
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
		reviewtxtA.setBounds(12, 58, 299, 208);
		content.add(reviewtxtA);
		
		JRadioButton score_1 = new JRadioButton("1point");
		score_1.setFont(new Font("Candara Light", Font.PLAIN, 11));
		score_1.setBounds(24, 29, 53, 23);
		content.add(score_1);
		
		JRadioButton score_2 = new JRadioButton("2point");
		score_2.setFont(new Font("Candara Light", Font.PLAIN, 11));
		score_2.setBounds(81, 29, 53, 23);
		content.add(score_2);
		
		JRadioButton score_3 = new JRadioButton("3point");
		score_3.setFont(new Font("Candara Light", Font.PLAIN, 11));
		score_3.setBounds(138, 29, 60, 23);
		content.add(score_3);
		
		JRadioButton score_4 = new JRadioButton("4point");
		score_4.setFont(new Font("Candara Light", Font.PLAIN, 11));
		score_4.setBounds(195, 29, 61, 23);
		content.add(score_4);
		
		JRadioButton score_5 = new JRadioButton("5point");
		score_5.setFont(new Font("Candara Light", Font.PLAIN, 11));
		score_5.setBounds(252, 29, 61, 23);
		content.add(score_5);
		
		JLabel lbscore = new JLabel("Give me a Score!");
		lbscore.setHorizontalAlignment(SwingConstants.CENTER);
		lbscore.setFont(new Font("Candara Light", Font.PLAIN, 15));
		lbscore.setBounds(12, 14, 299, 15);
		content.add(lbscore);
		
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
