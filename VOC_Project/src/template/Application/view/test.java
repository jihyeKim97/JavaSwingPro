package template.Application.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test {

	JFrame frame;
	JPanel jp_label, jp_btn;
	JScrollPane scroll;
	JPanel label;
	JButton btn;
	int count = 1;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;

	test() {

		frame = new JFrame();
		frame.getContentPane().setLayout(null); // 레이아웃을 NULL로 설정한다
		frame.setSize(543, 632);

		jp_label = new JPanel();

		// 라벨이 들어갈 panel 은 레이아웃을 GridBag을 사용한다.
		jp_label.setLayout(Gbag);

		jp_label.setBackground(Color.green);

		label = new JPanel();
		label.setSize(300,300);
		create_form(label, 0,  10); // GridBagLayout 을 위한 함수호출

		scroll = new JScrollPane(jp_label); // 스크롤패널을 선언
		scroll.setBounds(0, 0, 295, 264); // 프레임에 스크롤패널의 위치를 정한다

		jp_btn = new JPanel(); // 버튼 패널
		jp_btn.setBounds(292, 10, 223, 252);
		btn = new JButton("add"); // 버튼 생성
		btn.addActionListener(new Add());
		jp_btn.add(btn);

		frame.getContentPane().add(scroll); // 스크롤패널 추가
		frame.getContentPane().add(jp_btn); // 버튼 패널 추가

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

// 버튼 리스너

	class Add implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			JPanel pan = new JPanel();
			pan.setSize(300,300);
			create_form(pan, count++* 300, 300);

		}

	}

// 라벨 추가 

	public void create_form(Component cmpt, int y,  int h) {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL ;
		gbc.gridy = y;
		gbc.gridheight = h;
		this.Gbag.setConstraints(cmpt, gbc);
		jp_label.add(cmpt);
		jp_label.updateUI();

	}

	public static void main(String[] args) {
		test bar = new test();
	}

}
