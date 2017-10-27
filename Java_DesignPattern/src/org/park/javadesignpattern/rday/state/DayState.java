package org.park.javadesignpattern.rday.state;

public class DayState implements State {
	private static DayState singleton = new DayState();
	public DayState() {}			// �����ڴ� private
	
	public static DayState getSingleton() {			// ������ �ν��Ͻ��� ��´�.
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {	// �ð�����
		if(hour < 9 || 17 <= hour){
			context.changeState(NightState.getSingleton());
		}
	}

	@Override
	public void doUse(Context context) {			// �ݰ���
		context.recordLog("�ݰ���(�ְ�)");

	}

	@Override
	public void doAlarm(Context context) {			// ���	
		context.callSecurityCenter("���(�ְ�)");

	}

	@Override
	public void doPhone(Context context) {			// �Ϲ���ȭ
		context.callSecurityCenter("�Ϲ���ȭ(�ְ�)");

	}

	@Override
	public String toString() {
		return "[�ְ�]";
	}
	
	

}
