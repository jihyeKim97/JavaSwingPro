package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Admin_Notice {

	private JFrame frame;
	private JTextField ad_txt_Notce_title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Notice window = new Admin_Notice();
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
	public Admin_Notice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 443, 580);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("적 용");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(34, 433, 99, 42);
		panel.add(btnNewButton);
		
		JButton button = new JButton("취 소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 16));
		button.setBounds(185, 433, 99, 42);
		panel.add(button);
		
		JLabel lblMemberInformation = new JLabel("Lotice Modification");
		lblMemberInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInformation.setFont(new Font("Candara Light", Font.BOLD, 33));
		lblMemberInformation.setBounds(12, 10, 300, 55);
		panel.add(lblMemberInformation);
		
		ad_txt_Notce_title = new JTextField();
		ad_txt_Notce_title.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		ad_txt_Notce_title.setHorizontalAlignment(SwingConstants.CENTER);
		ad_txt_Notce_title.setText("Title");
		ad_txt_Notce_title.setBounds(34, 60, 250, 42);
		panel.add(ad_txt_Notce_title);
		ad_txt_Notce_title.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 112, 250, 301);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
	}
}
