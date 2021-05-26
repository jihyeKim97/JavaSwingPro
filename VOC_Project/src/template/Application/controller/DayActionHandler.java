package template.Application.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class DayActionHandler implements ActionListener {
	GUICalendarFrame frm;

	public DayActionHandler(GUICalendarFrame frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton dayBtn = (JButton) e.getSource();
		// �����-����-����
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();
		String strDay = dayBtn.getText().trim();

		if (strMonth.length() == 1)
			strMonth = "0" + strMonth;
		if (strDay.length() == 1)
			strDay = "0" + strDay;
		String strDate = strYear + "-" + strMonth + "-" + strDay;

		System.out.println("���� ��ư ������! " + strDate);

		// strDate Ư�� ���ڸ� DB�� ����!!

//		TodoDBMgr tdMgr = new TodoDBMgr(); // beginConnection()
//		
//     	ArrayList<Todo> todos 
////     		=	tdMgr.selectAllTodos(); // ��� todos ���ڵ��
//     		=	tdMgr.selectAllTodos(strDate); 
//     				// Ư������ strDate���� �ش�Ǵ� todos ���ڵ��
////     	for (Todo td : todos) {
////     		System.out.println(td.toList());
////     	}
//     	String dbResult = "";
//     	int nTdSize = 0; //todos.size(); // �ش� ������ todo ����
//     	if( todos != null && todos.size() > 0 ) {  //  !todos.isEmpty() )
//     		for (Todo td : todos) {
//     			dbResult += td.toList();
//     		}
//     		nTdSize = todos.size();
//     	} else {
//     		dbResult = strDate + " ���ڿ��� Todos ���̺� DB ���ڵ尡 ����";
//     	}
//     	// ���� �������� ��ȭ���ڿ� ����
//     	TodoDialog tdDlg = 
//     		new TodoDialog(this.frm, dbResult, 
//     					strDate, nTdSize);
//     	// �̺�Ʈ�� �߻��� ��ư ��ġ...
////     	Point btnPos = dayBtn.getLocation(); 
////     			// ������â�� �»�� �������� �ϴ� ��ư�� �»�� ��ġ
//     	Point btnPos = dayBtn.getLocationOnScreen();
//     			// ȭ�� screen �»�� �������� �ϴ� ��ġ..
//     	tdDlg.setLocation(
//     			btnPos.x + (int)(dayBtn.getWidth()*0.7)
//     		, btnPos.y + (int)(dayBtn.getHeight()*0.7));
////     	tdDlg.setLocation(x, y);     	
//     	tdDlg.setVisible(true);		
//     	
//		
//		tdMgr.endConnection();
	}

}

/*
 * ���� ��ư ������! 2021-05-14 DB ���� ����! Fri May 14 13:36:19 KST 2021 sql:
 * select * from todos where created_at >= TO_DATE('2021-05-14','YYYY-MM-DD')
 * and created_at < TO_DATE('2021-05-14','YYYY-MM-DD')+1 DB���� ��ȸ�� todo ����:
 * 6 [ ] #21 | ���� ���� | 3. ���� | ���� | 2021-05-14 | [ ] #22 | ���� ���� |
 * 3. ���� | ���� | 2021-05-14 | [ ] #50 | ���ξ��� ���� | 3. ���� | ���� |
 * 2021-05-14 | [ ] #23 | ���ξ��� ���� | 3. ���� | ���� | 2021-05-14 | [ ] #7 |
 * �������� ������ũ �Ա� | 1. ��� | ���� | 2021-05-14 | [v] #24 | ���Ÿ A �����ϱ�
 * | 3. ���� | ���� | 2021-05-14 | DB ���� ����!! ���� ��ư ������! 2021-05-13 DB
 * ���� ����! Fri May 14 13:36:35 KST 2021 sql: select * from todos where
 * created_at >= TO_DATE('2021-05-13','YYYY-MM-DD') and created_at <
 * TO_DATE('2021-05-13','YYYY-MM-DD')+1 DB���� ��ȸ�� todo ����: 4 [ ] #3 | ����
 * ���� | 3. ���� | ���� | 2021-05-13 | [ ] #4 | ���� ���� | 3. ���� | ���� |
 * 2021-05-13 | [ ] #5 | ���� ���� | 3. ���� | ���� | 2021-05-13 | [ ] #6 | ����
 * ���� | 3. ���� | ���� | 2021-05-13 | DB ���� ����!! ���� ��ư ������!
 * 2021-05-12 DB ���� ����! Fri May 14 13:36:38 KST 2021 sql: select * from
 * todos where created_at >= TO_DATE('2021-05-12','YYYY-MM-DD') and created_at <
 * TO_DATE('2021-05-12','YYYY-MM-DD')+1 DB���� ��ȸ�� todo ����: 1 [ ] #25 | ���Ÿ
 * B �����ϱ� | 3. ���� | ���� | 2021-05-12 | DB ���� ����!! ���� ��ư ������!
 * 2021-05-11 DB ���� ����! Fri May 14 13:36:44 KST 2021 sql: select * from
 * todos where created_at >= TO_DATE('2021-05-11','YYYY-MM-DD') and created_at <
 * TO_DATE('2021-05-11','YYYY-MM-DD')+1 DB���� ��ȸ�� todo ����: 0 DB ���� ����!!
 * 
 */