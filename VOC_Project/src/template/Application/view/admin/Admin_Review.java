package template.Application.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import template.Application.controller.DB.Ad_Review_DB;
import template.Application.controller.Data.Ad_Notice_data;
import template.Application.controller.Data.Ad_Review_Data;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Admin_Review {

	private JFrame frmReview;
	JTextArea ad_review_txt;
	JLabel lblNewLabel;
	JPanel panel;
	JScrollPane scrollPane;
	JButton ad_btn_ok;
	JButton ad_btn_cancel;
	int Review_id = 2; 
	Ad_Review_DB db = new Ad_Review_DB();
	ArrayList<Ad_Review_Data> MyArr = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Review window = new Admin_Review();
					window.frmReview.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Review() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyArr = db.GetReview(Review_id);
		frmReview = new JFrame();
		frmReview.setTitle("Review");
		frmReview.setBounds(100, 100, 342, 499);
		frmReview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReview.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 326, 460);
		frmReview.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Review Management");
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 302, 47);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 67, 277, 298);
		
		ad_review_txt = new JTextArea();
		ad_review_txt.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		scrollPane.setViewportView(ad_review_txt);
		ad_review_txt.setText(MyArr.get(0).getContent());
		panel.add(scrollPane);
		
		ad_btn_ok = new JButton("수정");
		ad_btn_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String comment = ad_review_txt.getText();
					
					boolean r = db.changeReview(Review_id, comment);
					if(r) {
						JOptionPane.showMessageDialog(null, "리뷰 등록성공");
					}else
						JOptionPane.showMessageDialog(null, "리뷰 등록실패");
				}
		});
		ad_btn_ok.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		ad_btn_ok.setBounds(26, 387, 115, 47);
		panel.add(ad_btn_ok);
		
		ad_btn_cancel = new JButton("취소");
		ad_btn_cancel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		ad_btn_cancel.setBounds(188, 387, 115, 47);
		panel.add(ad_btn_cancel);
	}
}
