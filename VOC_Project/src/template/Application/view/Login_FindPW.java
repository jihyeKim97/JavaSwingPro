package template.Application.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import template.Application.controller.DB_Connect2;

public class Login_FindPW extends JFrame {

	public JFrame frmVoc;
	public JTextField txt_id;
	public JPasswordField txt_pw;
	JPanel panel_2;
	public JTextField txt_IssuedName;
	public JTextField txt_IssuedId;
	public JTextField txt_number4;
	public JTextField txt_number5;
	public JTextField txt_number6;

	public JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_FindPW window = new Login_FindPW();
					window.frmVoc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_FindPW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVoc = new JFrame();
		frmVoc.setTitle("Vehicle Outdoor Cinema");
		frmVoc.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\82102\\Desktop\\movie\\iconfinder-video-film-camera-movie-photography-4593167_122280.png"));
		frmVoc.setBounds(100, 100, 635, 429);
		frmVoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoc.getContentPane().setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 619, 390);
		frmVoc.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uC784\uC2DC \uBE44\uBC00\uBC88\uD638 \uBC1C\uAE09");
		lblNewLabel_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 27));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(173, 10, 272, 55);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(133, 103, 72, 37);
		panel_2.add(lblNewLabel_3);

		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(133, 165, 72, 37);
		panel_2.add(lblId);

		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 18));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(108, 233, 97, 37);
		panel_2.add(label_3);

		txt_IssuedName = new JTextField();
		txt_IssuedName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_IssuedName.setBounds(213, 109, 165, 30);
		panel_2.add(txt_IssuedName);
		txt_IssuedName.setColumns(10);

		txt_IssuedId = new JTextField();
		txt_IssuedId.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_IssuedId.setColumns(10);
		txt_IssuedId.setBounds(213, 171, 165, 30);
		panel_2.add(txt_IssuedId);

		txt_number4 = new JTextField();
		txt_number4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number4.setColumns(3);
		txt_number4.setBounds(213, 238, 53, 30);
		panel_2.add(txt_number4);

		txt_number5 = new JTextField();
		txt_number5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number5.setColumns(4);
		txt_number5.setBounds(287, 239, 79, 30);
		panel_2.add(txt_number5);

		txt_number6 = new JTextField();
		txt_number6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 17));
		txt_number6.setColumns(4);
		txt_number6.setBounds(393, 239, 72, 30);
		panel_2.add(txt_number6);

		JLabel lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setBounds(274, 238, 12, 30);
		panel_2.add(lblNewLabel_4);

		JLabel label = new JLabel("-");
		label.setBounds(378, 238, 12, 30);
		panel_2.add(label);

		JButton btn_Cancel2 = new JButton("\uCDE8\uC18C");
		btn_Cancel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Cancel2.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Cancel2.setForeground(Color.black);
			}
		});
		btn_Cancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Cancel2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 16));
		btn_Cancel2.setBounds(169, 298, 97, 47);
		panel_2.add(btn_Cancel2);

		JButton btn_Issued = new JButton("\uBC1C\uAE09");
		btn_Issued.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Issued.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Issued.setForeground(Color.black);
			}
		});
		btn_Issued.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 16));

		// PW ã��@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		btn_Issued.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_IssuedName.getText();
				String id = txt_IssuedId.getText();
				DB_Connect2 db = new DB_Connect2();
				String Phonenumber = new String(
						txt_number4.getText() + "" + txt_number5.getText() + "" + txt_number6.getText());
				int find = db.findpw(name, id, Phonenumber);
				switch (find) {
				case 1:
					JOptionPane.showMessageDialog(null, "입력하신정보를 확인해주세요");
					break;
				case 2:
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "입력하신정보를 확인");
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "핸드폰번호를 확인해주세요");
					break;
				default:
					break;
				}

			}
		});
		btn_Issued.setBounds(348, 298, 97, 47);
		panel_2.add(btn_Issued);

	}
}
