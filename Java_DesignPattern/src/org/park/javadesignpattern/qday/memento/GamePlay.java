package org.park.javadesignpattern.qday.memento;

import tools.dynamiccreate.DynamicObjectCreater;

public class GamePlay {
	/**
	 * Caretaker(������)����
	 * 
	 * GamePlay�� ������ �ȿ��� ���α׷��� ������ �Ǵµ�,
	 * ���⼭ isUndo()�� ���� �� �� �ش� �б⹮����
	 *  gamer.getMoney() < memento.getMoney() / 2 ���ǿ� ������ ��
	 *  gamer�ȿ� �ִ� money, fruits�� �������� memento�ȿ� ����� �������
	 *  ��ü�� ��(undo ��� �߻�)  
	 *  
	 *  ���⼭ �ٽ���
	 *  1) ������Ұ� �߻� �� �� �������� ���� �����͵��� ������ Model�� ����: memento
	 *  2) ������ҷ� ������ �� �����͸� ������ ������ �����ؾ� ��
	 *  gamer.getMoney() > memento.getMoney() <- �� �������� Memento�� ������ ����
	 * 
	 */
	public GamePlay() {
		Gamer gamer = (Gamer)DynamicObjectCreater.newInstanceObject("Gamer", 100);
		Memento memento = gamer.createMemento();		// ������ ���¸� ������ ����.
		for(int i =0; i < 100; i++){
			System.out.println("====" + i);		// ���� ǥ��
			System.out.println("����:" + gamer);	// ���� ���ΰ��� ���� ǥ��
			
			gamer.bet(); 	// ������ �����Ų��.
			
			System.out.println("�������� " + gamer.getMoney() + "���� �Ǿ����ϴ�.");
			
			// Memento�� ��� ����
			isUndo(gamer, memento);
			
			// �ð� ��ٸ�
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
			System.out.println("");
		}
	}
	
	public void isUndo(Gamer gamer, Memento memento){
		if(gamer.getMoney() > memento.getMoney()){
			System.out.println(" (���� ���������Ƿ� ������ ���¸� ��������");
			memento = gamer.createMemento();
		}else if(gamer.getMoney() < memento.getMoney() / 2){
			System.out.println(" (���� ���������Ƿ� ������ ���·� ��������)");
			gamer.restoreMemento(memento);
		}
	}
}
