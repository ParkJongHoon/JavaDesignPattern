package org.park.javadesignpattern.oday.mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener,
		Colleague {
	private Mediator mediator;
	public ColleagueCheckbox(String caption, CheckboxGroup group, 
			boolean state) {
		super(caption, group, state);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;

	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
										// Mediator에서 유효/무효를 지시
		setEnabled(enabled);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {		
		/*
		 * ItemListener interface를 implements 로 지정할 시 구현해야 할 메소드
		 * 본 메소드의 기능은 본 클래스가 checkbox를 상속 받았으므로
		 * 해당 checkbox안에 있는 addItemListener라는 메소드의 인자로 
		 * 실행할 기능을 itemStateChanged라는 메소드안에서 실행 할 수 있음
		 */
		
		// 상태가 바뀌면 Mediator에게 통지
		mediator.colleagueChanged();
	}

}
