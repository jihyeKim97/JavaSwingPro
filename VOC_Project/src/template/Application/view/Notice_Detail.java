package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Notice_Detail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice_Detail frame = new Notice_Detail();
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
	public Notice_Detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(0, 0, 484, 55);
		contentPane.add(panel);
		
		JButton button = new JButton("LogOut");
		button.setBounds(12, 10, 100, 35);
		panel.add(button);
		
		JButton button_1 = new JButton("Home");
		button_1.setBounds(310, 10, 100, 35);
		panel.add(button_1);
		
		JButton button_2 = new JButton("〓");
		button_2.setBounds(422, 10, 50, 35);
		panel.add(button_2);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 55, 484, 705);
		contentPane.add(panel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(10, 10, 444, 55);
		panel_3.setBackground(SystemColor.controlShadow);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Notice_Title");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("공지사항으로");
		btnNewButton.setBounds(70, 632, 120, 40);
		panel_2.add(btnNewButton);
		
		JButton button_3 = new JButton("메인화면으로");
		button_3.setBounds(276, 632, 120, 40);
		panel_2.add(button_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 75, 444, 547);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Notice");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel_1, BorderLayout.CENTER);
	}
}
