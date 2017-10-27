package org.park.javadesignpattern.rday.state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60);			// 현재시간 표시
	private TextArea textScreen = new TextArea(10, 60);			// 경비센터 출력
	private Button buttonUse = new Button("금고사용");			// 금고사용
	private Button buttonAlarm = new Button("비상벨");			// 비상벨 버튼
	private Button buttonPhone = new Button("일반통화");		// 일반통화 버튼
	private Button buttonExit = new Button("종료");				// 종료버튼
	
	private State state	= DayState.getSingleton();				// 현재상태

	// 생성자
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// textClock을 배치
		add(textClock, BorderLayout.NORTH);
	}
	@Override
	public void setClock(int hour) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeState(State state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void callSecurityCenter(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recordLog(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
