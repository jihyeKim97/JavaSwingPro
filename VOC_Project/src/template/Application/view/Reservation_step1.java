package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Color;
import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;

public class Reservation_step1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_step1 frame = new Reservation_step1();
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
	public Reservation_step1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 870);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 821);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBounds(0, 0, 484, 55);
		panel.add(panel_1);
		
		RoundedButtonD roundedButtonD = new RoundedButtonD("HOME");
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		panel_1.add(roundedButtonD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(0, 55, 484, 163);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 464, 143);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 0, 444, 45);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Step1. info");
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 444, 45);
		panel_4.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 102, 444, 41);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 5, 444, 31);
		panel_6.add(comboBox);
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"세단 & 경차", "SUV"}));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 44, 444, 58);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select movie : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 7, 102, 20);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblSelectDate = new JLabel("Select Date : ");
		lblSelectDate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblSelectDate.setBounds(10, 32, 102, 20);
		panel_5.add(lblSelectDate);
		
		JLabel lblNewLabel_2 = new JLabel("극한직업");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(110, 7, 174, 20);
		panel_5.add(lblNewLabel_2);
		
		JLabel label = new JLabel("2021 - 05 - 18 ");
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		label.setBounds(110, 32, 174, 20);
		panel_5.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setLayout(null);
		panel_7.setBounds(0, 218, 484, 409);
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(10, 10, 464, 389);
		panel_7.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(10, 0, 444, 45);
		panel_8.add(panel_9);
		
		JLabel lblStepInfo = new JLabel("Step2. Selection");
		lblStepInfo.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 24));
		lblStepInfo.setBounds(0, 0, 444, 45);
		panel_9.add(lblStepInfo);
		
		Panel panel_10 = new Panel();
		panel_10.setBounds(10, 51, 444, 328);
		panel_8.add(panel_10);
		panel_10.setLayout(null);
		
		RoundedButtonD button = new RoundedButtonD("Screen");
		button.setBounds(10, 0, 424, 30);
		button.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_10.add(button);
		
		Panel panel_11 = new Panel();
		panel_11.setBounds(10, 30, 424, 298);
		panel_10.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_12.setBounds(0, 627, 484, 184);
		panel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(10, 10, 464, 164);
		panel_12.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(10, 0, 444, 45);
		panel_13.add(panel_14);
		
		JLabel lblStepOption = new JLabel("Step3. Option");
		lblStepOption.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 24));
		lblStepOption.setBounds(0, 0, 444, 45);
		panel_14.add(lblStepOption);
	}
}
