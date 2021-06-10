package template.Application.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.DB.Ad_AdPage_DB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class AD_Notice extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextArea textArea;

	AD_Notice Nfrm;
	Ad_AdPage_DB NDB;
	boolean A = false;

	public AD_Notice(AD_Main frm) {
		this.Nfrm = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 841);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Vehicle Outdoor Cinema");
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Notice Infomation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 534, 51);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 61, 534, 642);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 510, 47);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("제목 : ");
		lblNewLabel_1.setBounds(0, 0, 86, 47);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_1);

		textField = new JTextField("");
		textField.setBounds(87, 0, 423, 47);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 67, 510, 563);
		panel_1.add(scrollPane);

		textArea = new JTextArea("");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		RoundedButtonG btnNewButton = new RoundedButtonG("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = textField.getText();
				String content = textArea.getText();
				if (title.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "제목을 입력해주세요");
				} else if (content.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "내용을 입력해주세요");
				} else {
					NDB.addNotice(title, content);
					System.out.println("공지사항이 등록되었습니다.");
					dispose();
				}
			}

		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnNewButton.setBounds(161, 724, 100, 45);
		panel.add(btnNewButton);

		RoundedButtonR btnCancel = new RoundedButtonR("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnCancel.setBounds(267, 724, 100, 45);
		panel.add(btnCancel);
	}
}
