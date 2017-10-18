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
	 * Main에서 LoginFrame의 객체를 생성시 프로그램이 실행됨
	 * -> 생성자에 프로그램 생성코드를 입력함
	 * mediator
	 * 
	 * Checkbox <--> interface 등록: addItemListener, 실행구현: itemStateChanged(ItemEvent arg0)
	 * TextField <--> interface 등록: addTextListener, 실행구현: textValueChanged(TextEvent arg0)
	 * Button <--> interface 등록: ActionListener, 실행구현: actionPerformed(ActionEvent e)
	 */
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	private LoginFrameBusinessLogic loginFramebusinessLogic;
	
	// 생성자
	// Colleague들을 생성하고, 배치한 후에 표시를 실행한다.
	public LoginFrame(String title) {
		super(title);
		loginFramebusinessLogic = (LoginFrameBusinessLogic)DynamicObjectCreater.newInstanceObject("LoginFrameBusinessLogic");
		this.loginFramebusinessLogic = loginFramebusinessLogic;
		setBackground(Color.lightGray);
		// 레이아웃 매니저를 사용해서 4X2의 그리드를 만든다.
		setLayout(new GridLayout(4, 2));
		// Colleague들의 생성
		createColleagues();
		// 배치
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 유효/무효의 초기 지정
		colleagueChanged();
		// 표시
		pack();	// Frame의 크기를 적절하게 유지시켜줌
		show();	// Frame을 보여주는 메소드
	}
	
	@Override
	public void createColleagues() {
		// 생성
		
		CheckboxGroup g = new CheckboxGroup(); 
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = (ColleagueTextField)DynamicObjectCreater.newInstanceObject("ColleagueTextField", "", 10);
		textPass = (ColleagueTextField)DynamicObjectCreater.newInstanceObject("ColleagueTextField", "", 10);
		textPass.setEchoChar('*');
		buttonOk = (ColleagueButton)DynamicObjectCreater.newInstanceObject("ColleagueButton", "OK");
		buttonCancel = (ColleagueButton)DynamicObjectCreater.newInstanceObject("ColleagueButton", "Cancel");
		// Mediator의 세트
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listener의 세트
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);

	}

	// Colleage에서의 통지로 Colleage의 유효/무효를 판정한다.
	@Override
	public void colleagueChanged() {
		loginFramebusinessLogic.colleagueChanged(this);
	}
	
	// textUser 또는 textPass의 변경이 있었다.
	// 각 Colleague의 유효/무효를 판정한다.
	
	

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
