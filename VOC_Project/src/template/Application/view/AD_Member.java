package template.Application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import template.Application.controller.RoundedButtonG;
import template.Application.controller.RoundedButtonR;
import template.Application.controller.RoundedButtonY;
import template.Application.controller.DB.Ad_AdPage_DB;
import template.Application.controller.DB.Login_DB;
import template.Application.controller.Data.Login_data;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AD_Member extends JFrame {

	JPanel contentPane, panel, panel_4;
	JTextField phoneF;
	JTextField nameF;
	RoundedButtonR canbtn;
	RoundedButtonG okbtn;
	RoundedButtonY rebtn;
	JLabel bir;
	JLabel gender;
	JLabel pw;
	JLabel id;
	Panel panel_3, panel_1, panel_2;
	JLabel label_2, label_3, label_4, label_5, label_1, label, label_11;

	AD_Member Mefrm;
	

	public AD_Member(AD_Main frm, Login_data ld) {
		this.Mefrm = this;
		int memberID = ld.getMember_id();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Vehicle Outdoor Cinema");
		setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 424, 613);
		panel.add(panel_1);

		label_11 = new JLabel("Member Info");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
		label_11.setBounds(12, 25, 400, 55);
		panel_1.add(label_11);

		panel_4 = new JPanel();
		panel_4.setBounds(0, 124, 424, 316);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		panel_2 = new Panel();
		panel_2.setBounds(31, 0, 145, 316);
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 10));

		label = new JLabel("아이디 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label);

		label_1 = new JLabel("비밀번호 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_1);

		label_2 = new JLabel("이름 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_2);

		label_3 = new JLabel("전화번호 : ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_3);

		label_4 = new JLabel("성별 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_4);

		label_5 = new JLabel("생년월일 : ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		panel_2.add(label_5);

		panel_3 = new Panel();
		panel_3.setBounds(182, 0, 211, 316);
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 10));

		id = new JLabel();
		id.setText(ld.getId());
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(id);

		pw = new JLabel();
		pw.setText(ld.getPassword());
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(pw);

		nameF = new JTextField();
		nameF.setText(ld.getName());
		nameF.setHorizontalAlignment(SwingConstants.CENTER);
		nameF.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		nameF.setColumns(10);
		panel_3.add(nameF);

		phoneF = new JTextField();
		phoneF.setText("" + ld.getPhone_number());
		phoneF.setHorizontalAlignment(SwingConstants.CENTER);
		phoneF.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		phoneF.setColumns(10);
		panel_3.add(phoneF);

		gender = new JLabel();
		String gen = "";
		if (ld.getGender() == 0) {
			gen = "남자";
		} else {
			gen = "여자";
		}
		gender.setText(gen);
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(gender);

		bir = new JLabel();
		bir.setText(ld.getBirthday());
		bir.setHorizontalAlignment(SwingConstants.CENTER);
		bir.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		panel_3.add(bir);

		rebtn = new RoundedButtonY("Resign");
		rebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_AdPage_DB ADB = new Ad_AdPage_DB();
				int result = JOptionPane.showConfirmDialog(null, "회원탈퇴를 진행 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					ADB.updateMembertoNone(memberID);
					dispose();
				}
			}
		});
		rebtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		rebtn.setBounds(166, 538, 100, 45);
		panel_1.add(rebtn);

		okbtn = new RoundedButtonG("Ok");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_AdPage_DB ADB = new Ad_AdPage_DB();
				if (!nameF.getText().isEmpty() && !phoneF.getText().isEmpty()) {
					ADB.changeAdminMemberInfo(memberID, nameF.getText(), phoneF.getText());
					System.out.println("관리자 권한으로 수정 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "빈칸이 존재 합니다");
				}
			}
		});
		okbtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		okbtn.setBounds(59, 538, 100, 45);
		panel_1.add(okbtn);

		canbtn = new RoundedButtonR("Cancel");
		canbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		canbtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		canbtn.setBounds(273, 538, 100, 45);
		panel_1.add(canbtn);

	}
}
