package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollBar;

public class Reservation_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_main frame = new Reservation_main();
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
	public Reservation_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_head = new JPanel();
		pn_head.setBackground(Color.WHITE);
		pn_head.setBounds(0, 0, 432, 28);
		contentPane.add(pn_head);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.setBounds(0, 0, 79, 27);
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "�α׾ƿ� �Ͻðڽ��ϱ�?", "�α׾ƿ�", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		});
		pn_head.setLayout(null);
		btn_Logout.setHorizontalAlignment(SwingConstants.LEFT);
		pn_head.add(btn_Logout);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setBounds(404, 4, 14, 18);
		pn_head.add(lblNewLabel);
		
		JButton btn_home = new JButton("home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_home.setBounds(335, 0, 69, 27);
		pn_head.add(btn_home);
		
		JPanel pn_todaymovie = new JPanel();
		pn_todaymovie.setBackground(Color.WHITE);
		pn_todaymovie.setBounds(0, 77, 432, 214);
		contentPane.add(pn_todaymovie);
		pn_todaymovie.setLayout(null);
		
		JButton btn_Resevation = new JButton("\uC608\uC57D");
		btn_Resevation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Resevation.setBounds(20, 178, 61, 27);
		pn_todaymovie.add(btn_Resevation);
		
		JButton button = new JButton("\uC608\uC57D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(126, 178, 61, 27);
		pn_todaymovie.add(button);
		
		JButton button_1 = new JButton("\uC608\uC57D");
		button_1.setBounds(235, 178, 61, 27);
		pn_todaymovie.add(button_1);
		
		JButton button_2 = new JButton("\uC608\uC57D");
		button_2.setBounds(345, 178, 61, 27);
		pn_todaymovie.add(button_2);
		
		JPanel pn_movie1 = new JPanel();
		pn_movie1.setBounds(10, 12, 92, 155);
		pn_todaymovie.add(pn_movie1);
		
		JPanel pn_movie2 = new JPanel();
		pn_movie2.setBounds(116, 12, 92, 155);
		pn_todaymovie.add(pn_movie2);
		
		JPanel pn_movie3 = new JPanel();
		pn_movie3.setBounds(222, 12, 92, 155);
		pn_todaymovie.add(pn_movie3);
		
		JPanel pn_movie4 = new JPanel();
		pn_movie4.setBounds(328, 12, 92, 155);
		pn_todaymovie.add(pn_movie4);
		
		JPanel pn_tomorrowmovie = new JPanel();
		pn_tomorrowmovie.setBackground(Color.WHITE);
		pn_tomorrowmovie.setBounds(0, 342, 432, 313);
		contentPane.add(pn_tomorrowmovie);
		pn_tomorrowmovie.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(0, 292, 432, 21);
		pn_tomorrowmovie.add(scrollBar);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 86, 146);
		pn_tomorrowmovie.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(86, 0, 86, 146);
		pn_tomorrowmovie.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(172, 0, 86, 146);
		pn_tomorrowmovie.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(258, 0, 86, 146);
		pn_tomorrowmovie.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(258, 145, 86, 145);
		pn_tomorrowmovie.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 145, 86, 145);
		pn_tomorrowmovie.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(86, 145, 86, 145);
		pn_tomorrowmovie.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(172, 145, 86, 145);
		pn_tomorrowmovie.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(346, 145, 86, 145);
		pn_tomorrowmovie.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(346, 0, 86, 146);
		pn_tomorrowmovie.add(panel_9);
	}
}
