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
	private TextField textClock = new TextField(60);			// ����ð� ǥ��
	private TextArea textScreen = new TextArea(10, 60);			// ����� ���
	private Button buttonUse = new Button("�ݰ���");			// �ݰ���
	private Button buttonAlarm = new Button("���");			// ��� ��ư
	private Button buttonPhone = new Button("�Ϲ���ȭ");		// �Ϲ���ȭ ��ư
	private Button buttonExit = new Button("����");				// �����ư
	
	private State state	= DayState.getSingleton();				// �������

	// ������
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// textClock�� ��ġ
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
