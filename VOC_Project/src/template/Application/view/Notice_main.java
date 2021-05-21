package template.Application.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.awt.SystemColor;

public class Notice_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice_main frame = new Notice_main();
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
	public Notice_main() {
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
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(10, 10, 464, 682);
		panel_1.add(panel_2);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setBounds(10, 10, 444, 55);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("공지 사항");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 472, 444, 200);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
	}
}
