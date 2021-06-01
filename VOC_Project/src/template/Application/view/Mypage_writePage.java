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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Mypage_writePage extends JFrame {

	JPanel contentPane;
	MyPage frm;
	private JTextField textField;

	public Mypage_writePage(MyPage frm) {
		this.frm = frm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 352);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 400, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 156, 350, 37);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("당신의 별점은?");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 137, 37);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		comboBox.setBounds(149, 0, 201, 37);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"★☆☆☆☆ : 1점", "★★☆☆☆ : 2점", "★★★☆☆ : 3점", "★★★★☆ : 4점", "★★★★★ : 5점"}));
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("한줄 리뷰를 작성해 주세요!");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 38, 402, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(25, 103, 350, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("완료!");
		btnNewButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btnNewButton.setBounds(25, 255, 350, 43);
		panel.add(btnNewButton);
	}
}
