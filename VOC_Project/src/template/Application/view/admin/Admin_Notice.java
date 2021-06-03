package template.Application.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;

import template.Application.controller.Ad_Notice_DB;
import template.Application.controller.Ad_Notice_data;
import template.Application.controller.Data.Notice_data;
import template.Application.controller.btn.RoundedButtonD;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Admin_Notice {

	private JFrame frmLotice;
	private JTextField ad_txt_Notce_title;
	JTextArea textArea;
	Ad_Notice_DB db = new Ad_Notice_DB();
	int Notice_id = 63; 
	ArrayList<Ad_Notice_data> MyArr = new ArrayList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Notice window = new Admin_Notice();
					window.frmLotice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Notice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyArr = db.GetNotice(Notice_id);
		frmLotice = new JFrame();
		frmLotice.setTitle("Lotice");
		frmLotice.setBounds(100, 100, 342, 528);
		frmLotice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLotice.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 326, 489);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmLotice.getContentPane().add(panel);
		
		JButton ad_btn_ok = new JButton("등록");
		ad_btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("등록클릭");
				String ad_title = ad_txt_Notce_title.getText(); 
				String ad_comment = textArea.getText();
				Notice_data upNotice = new Notice_data(ad_title, ad_comment);
				
				boolean r = db.insertNewNotice(upNotice);
				if(r) {
					JOptionPane.showMessageDialog(null, "등록성공");
				}else
					JOptionPane.showMessageDialog(null, "등록실패");
			}
		});
		ad_btn_ok.setFont(new Font("굴림", Font.PLAIN, 16));
		ad_btn_ok.setBounds(34, 433, 76, 42);
		panel.add(ad_btn_ok);
		
		JButton ad_btn_cancel = new JButton("취소");
		ad_btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ad_btn_cancel.setFont(new Font("굴림", Font.PLAIN, 14));
		ad_btn_cancel.setBounds(208, 433, 76, 42);
		panel.add(ad_btn_cancel);
		
		JLabel lblMemberInformation = new JLabel("Lotice Modification");
		lblMemberInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInformation.setFont(new Font("Candara Light", Font.BOLD, 33));
		lblMemberInformation.setBounds(12, 10, 300, 55);
		panel.add(lblMemberInformation);
		
		ad_txt_Notce_title = new JTextField();
		ad_txt_Notce_title.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		ad_txt_Notce_title.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_Notce_title.setBounds(34, 60, 250, 42);
		ad_txt_Notce_title.setColumns(10);


		panel.add(ad_txt_Notce_title);
		
		
		JScrollPane ad_txt_notce = new JScrollPane();
		ad_txt_notce.setBounds(34, 112, 250, 301);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		ad_txt_notce.setViewportView(textArea);
		textArea.setText(MyArr.get(0).getContent());
		panel.add(ad_txt_notce);
		
		JButton button = new JButton("수정");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = ad_txt_Notce_title.getText();
				String comment = textArea.getText();

				boolean r = db.changeNotice(Notice_id,title, comment);
				if(r) {
					JOptionPane.showMessageDialog(null, "공지 등록성공");
				}else
					JOptionPane.showMessageDialog(null, "공지 등록실패");
			}
			
		});
		button.setFont(new Font("굴림", Font.PLAIN, 16));
		button.setBounds(122, 433, 76, 42);
		panel.add(button);
	}
}
