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
		context.callSecurityCenter("���:���ɽð� �ݰ���!");

	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(���ɽð�)");

	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("���ɽð� ��ȭ����");

	}

	@Override
	public String toString() {
		return "[���ɽð�]";
	}

}
