package org.park.javadesignpattern.rday.state;

public interface Context {
	public abstract void setClock(int hour);	// 시간설정
	public abstract void changeState(State state);
	public abstract void callSecurityCenter(String msg);
	public abstract void recordLog(String msg);
}
