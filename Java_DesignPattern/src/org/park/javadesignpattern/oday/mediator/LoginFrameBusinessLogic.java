package org.park.javadesignpattern.oday.mediator;

public class LoginFrameBusinessLogic {
	
	public void colleagueChanged(LoginFrame loginFrame) {
		if(loginFrame.getCheckGuest().getState()){
			loginFrame.getTextUser().setColleagueEnabled(false);
			loginFrame.getTextPass().setColleagueEnabled(false);
			loginFrame.getButtonOk().setColleagueEnabled(true);
		}else{
			loginFrame.getTextUser().setColleagueEnabled(true);	
			userpassCharge(loginFrame);
		}
	}
	
	private void userpassCharge(LoginFrame loginFrame){
		if(loginFrame.getTextUser().getText().length() > 0){
			loginFrame.getTextPass().setColleagueEnabled(true);
			if(loginFrame.getTextPass().getText().length() > 0){
				loginFrame.getButtonOk().setColleagueEnabled(true);
			}else{
				loginFrame.getButtonOk().setColleagueEnabled(false);
			}
		}else{
			loginFrame.getTextPass().setColleagueEnabled(false);
			loginFrame.getButtonOk().setColleagueEnabled(false);
		}
	}
}
