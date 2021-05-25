package template.Application.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;

import template.Application.controller.RoundedButtonD;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reservation_step3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_step3 frame = new Reservation_step3();
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
	public Reservation_step3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel header = new Panel();
		header.setBounds(0, 0, 484, 55);
		contentPane.add(header);
		header.setLayout(null);
		header.setBackground(new Color(169, 169, 169));

		RoundedButtonD roundedButtonD = new RoundedButtonD("HOME");
		roundedButtonD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		roundedButtonD.setBounds(12, 10, 100, 35);
		header.add(roundedButtonD);

		JPanel content = new JPanel();
		content.setBackground(new Color(220, 220, 220));
		content.setBounds(0, 55, 484, 605);
		contentPane.add(content);
		content.setLayout(null);

		JLabel lblNewLabel = new JLabel("결제가 완료되었습니다!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 4, 462, 61);
		content.add(lblNewLabel);

		JPanel reservationInfoBox = new JPanel();
		reservationInfoBox.setBounds(0, 69, 484, 261);
		content.add(reservationInfoBox);
		reservationInfoBox.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 464, 241);
		reservationInfoBox.add(panel_2);
		panel_2.setLayout(null);

		JPanel posterImage = new JPanel();
		posterImage.setBackground(new Color(255, 235, 205));
		posterImage.setBounds(0, 10, 141, 221);
		panel_2.add(posterImage);

		JPanel txtPanel = new JPanel();
		txtPanel.setBounds(153, 10, 311, 221);
		panel_2.add(txtPanel);
		txtPanel.setLayout(null);

		JLabel label = new JLabel("영화제목 : ");
		label.setBounds(0, 2, 100, 31);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label);

		JLabel movieTitle = new JLabel("");
		movieTitle.setBounds(100, 2, 211, 31);
		movieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		movieTitle.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(movieTitle);

		JLabel label_2 = new JLabel("영화 상영 날짜 : ");
		label_2.setBounds(0, 33, 100, 31);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_2);

		JLabel movieDate = new JLabel("");
		movieDate.setBounds(100, 33, 211, 31);
		movieDate.setHorizontalAlignment(SwingConstants.CENTER);
		movieDate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(movieDate);

		JLabel label_4 = new JLabel("영화 상영 시간 : ");
		label_4.setBounds(0, 64, 100, 31);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_4);

		JLabel movieTime = new JLabel("");
		movieTime.setBounds(100, 64, 211, 31);
		movieTime.setHorizontalAlignment(SwingConstants.CENTER);
		movieTime.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(movieTime);

		JLabel label_6 = new JLabel("좌석 번호 : ");
		label_6.setBounds(0, 95, 100, 31);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_6);

		JLabel seatNum = new JLabel("");
		seatNum.setBounds(100, 95, 211, 31);
		seatNum.setHorizontalAlignment(SwingConstants.CENTER);
		seatNum.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(seatNum);

		JLabel label_8 = new JLabel("옵션 선택 : ");
		label_8.setBounds(0, 126, 100, 31);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_8);

		JLabel optionName = new JLabel("");
		optionName.setBounds(100, 126, 211, 31);
		optionName.setHorizontalAlignment(SwingConstants.CENTER);
		optionName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(optionName);

		JLabel label_10 = new JLabel("옵션 금액 : ");
		label_10.setBounds(0, 157, 100, 31);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_10);

		JLabel optionPrice = new JLabel("");
		optionPrice.setBounds(100, 157, 211, 31);
		optionPrice.setHorizontalAlignment(SwingConstants.CENTER);
		optionPrice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(optionPrice);

		JLabel label_12 = new JLabel("총 결제 금액 : ");
		label_12.setBounds(0, 188, 100, 31);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(label_12);

		JLabel totalPrice = new JLabel("");
		totalPrice.setBounds(100, 188, 211, 31);
		totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		totalPrice.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		txtPanel.add(totalPrice);

		JPanel precautionsBox = new JPanel();
		precautionsBox.setLayout(null);
		precautionsBox.setBounds(0, 344, 484, 248);
		content.add(precautionsBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 464, 225);
		precautionsBox.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_9 = new JLabel("영화 관람 시 유의사항");
		label_9.setBounds(0, 15, 464, 30);
		label_9.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_9);

		JLabel lblNewLabel_3 = new JLabel("극장 입구에서 차량의 미등까지 모두 소등합니다.");
		lblNewLabel_3.setBounds(0, 55, 464, 20);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_3);

		JLabel label_7 = new JLabel("창문을 열고 감상하실 때에는 다른 손님에게 피해가 가지 않도록 음향 볼륨을 낮춰 주세요.");
		label_7.setBounds(0, 76, 464, 20);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(label_7);

		JLabel label_1 = new JLabel("정산 티켓을 운전석 와이퍼에 꼭끼워주세요.");
		label_1.setBounds(0, 98, 464, 20);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(label_1);

		JLabel label_5 = new JLabel("다른 손님에게 방해가 되지 않도록 소음이나 눈에 거슬리는 행동은 삼가해 주세요.");
		label_5.setBounds(0, 119, 464, 20);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(label_5);

		JLabel lblNewLabel_5 = new JLabel("타고오신 차량에 이상이 있을 경우에 극장 직원에게 도움을 요청 하십시오.");
		lblNewLabel_5.setBounds(0, 139, 464, 20);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_5);

		JLabel label_3 = new JLabel("영화상영 도중 라이트를 켜지 말아 주세요.");
		label_3.setBounds(0, 161, 464, 20);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(label_3);

		JLabel lblNewLabel_6 = new JLabel("주파수를 미리 맟추시고 소리가 잘 들리는지 미리 테스트 해보십시오.");
		lblNewLabel_6.setBounds(0, 183, 464, 20);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_6);
	}
}
