package org.park.javadesignpattern.rday.state;

public class NightState implements State {
	private static NightState singleton = new NightState();
	private NightState() {}
	
	public static NightState getSingleton() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {	// 시간설정
		if(9 <= hour && hour < 17){
			context.changeState(DayState.getSingleton());
		}
	}

	@Override
	public void doUse(Context context) {				// 금고사용
		context.callSecurityCenter("비상 : 야간금고 사용!");

	}

	@Override
	public void doAlarm(Context context) {				// 비상벨
		context.callSecurityCenter("비상벨(야간)");

	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("야간통화 녹음");

	}

	@Override
	public String toString() {
		return "[야간]";
	}
	
	

}
