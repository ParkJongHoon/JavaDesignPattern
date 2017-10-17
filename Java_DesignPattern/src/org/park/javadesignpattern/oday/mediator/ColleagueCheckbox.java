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
		this.mediator = mediator;
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
	public void itemStateChanged(ItemEvent arg0) {		// 상태가 바뀌면 Mediator에게 통지
		mediator.colleagueChanged();
	}

}
