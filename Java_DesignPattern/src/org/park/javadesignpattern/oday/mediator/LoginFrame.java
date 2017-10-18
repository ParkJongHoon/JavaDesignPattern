package org.park.javadesignpattern.oday.mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.TextEvent;

import tools.dynamiccreate.DynamicObjectCreater;

public class LoginFrame extends Frame implements ActionListener, Mediator {
	
	/*
	 * Main���� LoginFrame�� ��ü�� ������ ���α׷��� �����
	 * -> �����ڿ� ���α׷� �����ڵ带 �Է���
	 * mediator
	 * 
	 * Checkbox <--> interface ���: addItemListener, ���౸��: itemStateChanged(ItemEvent arg0)
	 * TextField <--> interface ���: addTextListener, ���౸��: textValueChanged(TextEvent arg0)
	 * Button <--> interface ���: ActionListener, ���౸��: actionPerformed(ActionEvent e)
	 */
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	private LoginFrameBusinessLogic loginFramebusinessLogic;
	
	// ������
	// Colleague���� �����ϰ�, ��ġ�� �Ŀ� ǥ�ø� �����Ѵ�.
	public LoginFrame(String title) {
		super(title);
		loginFramebusinessLogic = (LoginFrameBusinessLogic)DynamicObjectCreater.newInstanceObject("LoginFrameBusinessLogic");
		this.loginFramebusinessLogic = loginFramebusinessLogic;
		setBackground(Color.lightGray);
		// ���̾ƿ� �Ŵ����� ����ؼ� 4X2�� �׸��带 �����.
		setLayout(new GridLayout(4, 2));
		// Colleague���� ����
		createColleagues();
		// ��ġ
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// ��ȿ/��ȿ�� �ʱ� ����
		colleagueChanged();
		// ǥ��
		pack();	// Frame�� ũ�⸦ �����ϰ� ����������
		show();	// Frame�� �����ִ� �޼ҵ�
	}
	
	@Override
	public void createColleagues() {
		// ����
		
		CheckboxGroup g = new CheckboxGroup(); 
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = (ColleagueTextField)DynamicObjectCreater.newInstanceObject("ColleagueTextField", "", 10);
		textPass = (ColleagueTextField)DynamicObjectCreater.newInstanceObject("ColleagueTextField", "", 10);
		textPass.setEchoChar('*');
		buttonOk = (ColleagueButton)DynamicObjectCreater.newInstanceObject("ColleagueButton", "OK");
		buttonCancel = (ColleagueButton)DynamicObjectCreater.newInstanceObject("ColleagueButton", "Cancel");
		// Mediator�� ��Ʈ
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listener�� ��Ʈ
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);

	}

	// Colleage������ ������ Colleage�� ��ȿ/��ȿ�� �����Ѵ�.
	@Override
	public void colleagueChanged() {
		loginFramebusinessLogic.colleagueChanged(this);
	}
	
	// textUser �Ǵ� textPass�� ������ �־���.
	// �� Colleague�� ��ȿ/��ȿ�� �����Ѵ�.
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);

	}

	public ColleagueCheckbox getCheckGuest() {
		return checkGuest;
	}

	public void setCheckGuest(ColleagueCheckbox checkGuest) {
		this.checkGuest = checkGuest;
	}

	public ColleagueCheckbox getCheckLogin() {
		return checkLogin;
	}

	public void setCheckLogin(ColleagueCheckbox checkLogin) {
		this.checkLogin = checkLogin;
	}

	public ColleagueTextField getTextUser() {
		return textUser;
	}

	public void setTextUser(ColleagueTextField textUser) {
		this.textUser = textUser;
	}

	public ColleagueTextField getTextPass() {
		return textPass;
	}

	public void setTextPass(ColleagueTextField textPass) {
		this.textPass = textPass;
	}

	public ColleagueButton getButtonOk() {
		return buttonOk;
	}

	public void setButtonOk(ColleagueButton buttonOk) {
		this.buttonOk = buttonOk;
	}

	public ColleagueButton getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(ColleagueButton buttonCancel) {
		this.buttonCancel = buttonCancel;
	}
	
	

}
