package org.park.javadesignpattern.oday.mediator;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
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

}
