package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
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
import javax.swing.ScrollPaneConstants;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 10, 444, 200);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 10, 90, 120);
		panel_3.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(344, 10, 90, 120);
		panel_3.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(118, 10, 90, 120);
		panel_3.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(230, 10, 90, 120);
		panel_3.add(panel_8);
		
		JButton btnNewButton_1 = new JButton("예약");
		btnNewButton_1.setBounds(25, 145, 60, 30);
		panel_3.add(btnNewButton_1);
		
		JButton button_3 = new JButton("예약");
		button_3.setBounds(135, 145, 60, 30);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("예약");
		button_4.setBounds(245, 145, 60, 30);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("예약");
		button_5.setBounds(360, 145, 60, 30);
		panel_3.add(button_5);
		
		JButton btnNewButton = new JButton("공지사항");
		btnNewButton.setBounds(10, 642, 440, 30);
		panel_2.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 220, 444, 412);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(panel_9);
		panel_9.setLayout(new GridLayout(2, 0, 0, 0));
		
		for (int i = 0; i < 24; i++) {
			String text = "영화" + i;
			JLabel Movie = new JLabel(text);
			panel_9.add(Movie);
			
		}
	}
}
