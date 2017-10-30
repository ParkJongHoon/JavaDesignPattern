package org.park.javadesignpattern.rday.state;

public class NoonState implements State {
	private static NoonState singleton = new NoonState();
	
	public static NoonState getSingleton() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		if(hour == 13){
			context.changeState(DayState.getSingleton());
		}

	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("비상:점심시간 금고사용!");

	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(점심시간)");

	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("점심시간 통화녹음");

	}

	@Override
	public String toString() {
		return "[점심시간]";
	}

}
