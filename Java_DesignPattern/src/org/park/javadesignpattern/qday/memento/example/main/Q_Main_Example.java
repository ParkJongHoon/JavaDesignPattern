package org.park.javadesignpattern.qday.memento.example.main;

import org.park.javadesignpattern.qday.memento.GamePlay;
import org.park.javadesignpattern.qday.memento.Gamer;
import org.park.javadesignpattern.qday.memento.Memento;

import tools.dynamiccreate.DynamicObjectCreater;

public class Q_Main_Example {
	/**
	 * Memento Pattern은 일정조건에 부합하면 실행취소(실행이전단계)로
	 * 돌아가는 기능을 구현한 Pattern임
	 * @param args
	 */
	
	public static void main(String[] args) {
		DynamicObjectCreater.newInstanceObject("GamePlayIO");		
	}

}
