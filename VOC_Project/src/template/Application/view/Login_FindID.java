package template.Application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import template.Application.controller.DB_Connect;
import template.Application.controller.DB_Connect2;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login_FindID extends JFrame {

	public JFrame frame;
	public JFrame frmVoc;
	public JTextField txt_id;
	public JPasswordField txt_pw;
	JPanel panel_1;
	JPanel panel_2;
	public JTextField txt_name;
	public JTextField txt_number1;
	public JTextField txt_number2;
	public JTextField txt_number3;

	public JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_FindID window = new Login_FindID();
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
	public Login_FindID() {
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

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 619, 390);
		frmVoc.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(216, 51, 187, 61);
		panel_1.add(lblNewLabel);

		JLabel lb_Name = new JLabel("\uC774\uB984");
		lb_Name.setFont(new Font("����", Font.BOLD, 17));
		lb_Name.setBounds(149, 139, 66, 40);
		panel_1.add(lb_Name);

		JLabel lb_number = new JLabel("\uC804\uD654\uBC88\uD638");
		lb_number.setFont(new Font("����", Font.BOLD, 17));
		lb_number.setBounds(149, 201, 79, 40);
		panel_1.add(lb_number);

		txt_name = new JTextField();
		txt_name.setFont(new Font("����", Font.PLAIN, 16));
		txt_name.setBounds(216, 144, 144, 27);
		panel_1.add(txt_name);
		txt_name.setColumns(10);

		txt_number1 = new JTextField();
		txt_number1.setFont(new Font("����", Font.PLAIN, 16));
		txt_number1.setBounds(240, 206, 50, 27);
		panel_1.add(txt_number1);
		txt_number1.setColumns(3);

		txt_number2 = new JTextField();
		txt_number2.setFont(new Font("����", Font.PLAIN, 16));
		txt_number2.setColumns(4);
		txt_number2.setBounds(302, 206, 66, 27);
		panel_1.add(txt_number2);

		txt_number3 = new JTextField();
		txt_number3.setFont(new Font("����", Font.PLAIN, 16));
		txt_number3.setColumns(4);
		txt_number3.setBounds(380, 206, 66, 27);
		panel_1.add(txt_number3);

		JButton btn_Cancel = new JButton("\uCDE8\uC18C");
		btn_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Cancel.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Cancel.setForeground(Color.black);
			}
		});
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_Cancel.setBounds(173, 270, 79, 40);
		panel_1.add(btn_Cancel);

		JButton btn_findId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btn_findId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_findId.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_findId.setForeground(Color.black);
			}
		});

		// ID ã��@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		btn_findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name.getText();
				DB_Connect2 db = new DB_Connect2();
				String Phonenumber = new String(txt_number1.getText() + txt_number2.getText() + txt_number3.getText());
				int find = db.findid(name, Phonenumber);
				switch (find) {
				case 1:
					JOptionPane.showMessageDialog(null, "�Է��Ͻ������� Ȯ�����ּ���");
					break;
				case 2:
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "�Է��Ͻ������� Ȯ��");
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "�ڵ�����ȣ�� Ȯ�����ּ���");
					break;
				default:
					break;
				}

			}
		});
		btn_findId.setBounds(302, 270, 117, 40);
		panel_1.add(btn_findId);

		JLabel label_1 = new JLabel("-");
		label_1.setBounds(370, 206, 11, 27);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("-");
		label_2.setBounds(290, 206, 11, 27);
		panel_1.add(label_2);

	}
}
