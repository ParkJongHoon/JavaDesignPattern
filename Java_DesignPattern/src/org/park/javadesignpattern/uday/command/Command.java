package org.park.javadesignpattern.uday.command;

/**
 * 
 * 작성일: 2017-11-16
 * 작성자: 박종훈
 * 작성내용: Command Pattern의 의도
 * 결론 인터페이스에서 실행 될 메소드 이름을 선언하고
 * 해당 인터페이스를 받아서 클래스에서 해당 메소드의 기능을 구현한다.
 * 그리고 실행 단에서 클래스 객체 생성 후 인터페이스에서 정의된 메소드를
 * 사용(이미 메소드 이름은 결정되어있기 때문에 해당기능만 클래스에서 
 * 구현하면 된다)
 *
 */

public interface Command {
	public abstract void execute();
}
