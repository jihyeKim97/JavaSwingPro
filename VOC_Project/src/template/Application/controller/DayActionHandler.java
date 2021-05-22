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
		// 년년년년-월월-일일 
//		String strYear = frm.getTxtYear().getText();
		String strYear = frm.getTxtYearText().trim();
		String strMonth = frm.getTxtMonth().getText().trim();		
		String strDay = dayBtn.getText().trim();
		
		if( strMonth.length() == 1 ) strMonth = "0" + strMonth;
		if( strDay.length() == 1 ) strDay = "0" + strDay;
		String strDate = strYear + "-" 
					+ strMonth + "-" + strDay; 
		
		System.out.println("날자 버튼 눌렀음! " + strDate );
		
		// strDate 특정 날자만 DB에 적용!!
		
//		TodoDBMgr tdMgr = new TodoDBMgr(); // beginConnection()
//		
//     	ArrayList<Todo> todos 
////     		=	tdMgr.selectAllTodos(); // 모든 todos 레코드들
//     		=	tdMgr.selectAllTodos(strDate); 
//     				// 특정날자 strDate에만 해당되는 todos 레코드들
////     	for (Todo td : todos) {
////     		System.out.println(td.toList());
////     	}
//     	String dbResult = "";
//     	int nTdSize = 0; //todos.size(); // 해당 날자의 todo 개수
//     	if( todos != null && todos.size() > 0 ) {  //  !todos.isEmpty() )
//     		for (Todo td : todos) {
//     			dbResult += td.toList();
//     		}
//     		nTdSize = todos.size();
//     	} else {
//     		dbResult = strDate + " 날자에는 Todos 테이블 DB 레코드가 없음";
//     	}
//     	// 별도 날자전용 대화상자에 띄우기
//     	TodoDialog tdDlg = 
//     		new TodoDialog(this.frm, dbResult, 
//     					strDate, nTdSize);
//     	// 이벤트가 발생한 버튼 위치...
////     	Point btnPos = dayBtn.getLocation(); 
////     			// 프레임창의 좌상단 기준으로 하는 버튼의 좌상단 위치
//     	Point btnPos = dayBtn.getLocationOnScreen();
//     			// 화면 screen 좌상단 기준으로 하는 위치..
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
날자 버튼 눌렀음! 2021-05-14
DB 접속 성공! Fri May 14 13:36:19 KST 2021
sql: select * from todos where created_at >= TO_DATE('2021-05-14','YYYY-MM-DD')  and created_at < TO_DATE('2021-05-14','YYYY-MM-DD')+1
DB에서 조회한 todo 개수: 6
[ ] #21 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #22 | 수박 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #50 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #23 | 파인애플 구매 | 3. 구매 | 진영 | 2021-05-14 | 
[ ] #7 | 만섭씨랑 스테이크 먹기 | 1. 약속 | 진영 | 2021-05-14 | 
[v] #24 | 통기타 A 구매하기 | 3. 구매 | 동근 | 2021-05-14 | 
DB 종료 성공!!
날자 버튼 눌렀음! 2021-05-13
DB 접속 성공! Fri May 14 13:36:35 KST 2021
sql: select * from todos where created_at >= TO_DATE('2021-05-13','YYYY-MM-DD')  and created_at < TO_DATE('2021-05-13','YYYY-MM-DD')+1
DB에서 조회한 todo 개수: 4
[ ] #3 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #4 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #5 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
[ ] #6 | 삼겹살 구매 | 3. 구매 | 진영 | 2021-05-13 | 
DB 종료 성공!!
날자 버튼 눌렀음! 2021-05-12
DB 접속 성공! Fri May 14 13:36:38 KST 2021
sql: select * from todos where created_at >= TO_DATE('2021-05-12','YYYY-MM-DD')  and created_at < TO_DATE('2021-05-12','YYYY-MM-DD')+1
DB에서 조회한 todo 개수: 1
[ ] #25 | 통기타 B 구매하기 | 3. 구매 | 동근 | 2021-05-12 | 
DB 종료 성공!!
날자 버튼 눌렀음! 2021-05-11
DB 접속 성공! Fri May 14 13:36:44 KST 2021
sql: select * from todos where created_at >= TO_DATE('2021-05-11','YYYY-MM-DD')  and created_at < TO_DATE('2021-05-11','YYYY-MM-DD')+1
DB에서 조회한 todo 개수: 0
DB 종료 성공!!

*/