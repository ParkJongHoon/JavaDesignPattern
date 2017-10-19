package org.park.javadesignpattern.qday.memento.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.park.javadesignpattern.qday.memento.Gamer;
import org.park.javadesignpattern.qday.memento.Memento;

import tools.dynamiccreate.DynamicObjectCreater;

public class GamePlayIO {
	/**
	 * Caretaker(������)����
	 * 
	 * GamePlay�� ������ �ȿ��� ���α׷��� ������ �Ǵµ�,
	 * ���⼭ isUndo()�� ���� �� �� �ش� �б⹮����
	 *  gamer.getMoney() < Momento.getMoney() / 2 ���ǿ� ������ ��
	 *  gamer�ȿ� �ִ� money, fruits�� �������� Momento�ȿ� ����� �������
	 *  ��ü�� ��(undo ��� �߻�)  
	 *  
	 *  ���⼭ �ٽ���
	 *  1) ������Ұ� �߻� �� �� �������� ���� �����͵��� ������ Model�� ����: Momento
	 *  2) ������ҷ� ������ �� �����͸� ������ ������ �����ؾ� ��
	 *  gamer.getMoney() > Momento.getMoney() <- �� �������� Momento�� ������ ����
	 * 
	 */
	public static final String SAVEFILENAME = "game.dat";
	public GamePlayIO() {
		GamerIO gamer = (GamerIO)DynamicObjectCreater.newInstanceObject("GamerIO", 100);
		MementoIO memento = loadMemento();	// ������ ���¸� ������ ����.
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
	
	public void isUndo(GamerIO gamer, MementoIO memento){
		if(gamer.getMoney() > memento.getMoney()){
			System.out.println(" (���� ���������Ƿ� ������ ���¸� ��������");
			memento = gamer.createMemento();
			saveMemento(memento);
		}else if(gamer.getMoney() < memento.getMoney() / 2){
			System.out.println(" (���� ���������Ƿ� ������ ���·� ��������)");
			gamer.restoreMemento(memento);
		}
	}
	
	public void saveMemento(MementoIO memento){
		try{
			ObjectOutput out = new ObjectOutputStream
					(new FileOutputStream(SAVEFILENAME));
			out.writeObject(memento);
			out.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public MementoIO loadMemento(){
		MementoIO memento = null;
		try {
			ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
			memento = (MementoIO)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return memento;
	}
}
