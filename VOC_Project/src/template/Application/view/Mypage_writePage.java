package template.Application.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;

import template.Application.view.MyPage;

public class Mypage_writePage extends JFrame {

	JPanel contentPane;
	ButtonGroup buttonGroup = new ButtonGroup();
	MyPage frm;

	public Mypage_writePage(MyPage frm) {
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 408, 262);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 402, 233);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	}
}
