package org.park.javadesignpattern.qday.memento.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import tools.dynamiccreate.DynamicObjectCreater;

public class GamerIO {
	/**
	 * Originator�� ����
	 * Memento�� ���¸� �����ϰ� �ִٰ� ���������� �Ǿ�����
	 * Memento�� ���·� �ڽ��� ���·� �ٲ۴�.
	 */
	
	private int money;
	private List fruits = new ArrayList();
	private Random random = new Random();
	private static String[] fruitsname={
		"���", "����", "�ٳ���", "��"
	};
	public GamerIO(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	public void bet(){
		int dice = random.nextInt(6) + 1;
		if(dice == 1){
			money += 100;
			System.out.println("�������� �����߽��ϴ�.");
		}else if(dice == 2){
			money /=2 ;
			System.out.println("�������� ������ �Ǿ����ϴ�.");
		}else if(dice == 6){
			String f = getFruit();
			System.out.println("����(" + f + ")�� �޾ҽ��ϴ�.");
			fruits.add(f);
		}else{
			System.out.println("���� ���� �����ϴ�.");
		}
	}
	
	public MementoIO createMemento(){
		// Memento m = new Memento(money);
		MementoIO m = (MementoIO)DynamicObjectCreater.newInstanceObject("MementoIO", money);
		Iterator it = fruits.iterator();
		while(it.hasNext()){
			String f = (String)it.next();
			if(f.startsWith("���ִ�")){
				m.addFruit(f);
			}
		}
		return m;
	}
	
	public void restoreMemento(MementoIO memento){
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	
	
	
	@Override
	public String toString() {
		return "[money=" + money + ", fruits=" + fruits + "]";
	}
	
	private String getFruit(){
		String prefix = "";
		if(random.nextBoolean()){
			prefix = "���ִ�";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
