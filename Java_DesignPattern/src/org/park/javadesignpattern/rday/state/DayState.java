package org.park.javadesignpattern.rday.state;

public class DayState implements State {
	private static DayState singleton = new DayState();
	public DayState() {}			// 생성자는 private
	
	public static DayState getSingleton() {			// 유일한 인스턴스를 얻는다.
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {	// 시간설정
		if(hour < 9 || 17 <= hour){
			context.changeState(NightState.getSingleton());
		}
	}

	@Override
	public void doUse(Context context) {			// 금고사용
		context.recordLog("금고사용(주간)");

	}

	@Override
	public void doAlarm(Context context) {			// 비상벨	
		context.callSecurityCenter("비상벨(주간)");

	}

	@Override
	public void doPhone(Context context) {			// 일반통화
		context.callSecurityCenter("일반통화(주간)");

	}

	@Override
	public String toString() {
		return "[주간]";
	}
	
	

}
