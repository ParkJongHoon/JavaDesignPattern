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
										// Mediator���� ��ȿ/��ȿ�� ����
		setEnabled(enabled);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {		// ���°� �ٲ�� Mediator���� ����
		mediator.colleagueChanged();
	}

}
