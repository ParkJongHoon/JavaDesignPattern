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
	 * Caretaker(관리인)역할
	 * 
	 * GamePlay의 생성자 안에서 프로그램이 실행이 되는데,
	 * 여기서 isUndo()가 실행 될 때 해당 분기문에서
	 *  gamer.getMoney() < Momento.getMoney() / 2 조건에 만족할 때
	 *  gamer안에 있던 money, fruits의 변수들이 Momento안에 저장된 변수들로
	 *  교체가 됨(undo 기능 발생)  
	 *  
	 *  여기서 핵심은
	 *  1) 실행취소가 발생 할 때 이전으로 돌릴 데이터들을 저장할 Model을 정의: Momento
	 *  2) 실행취소로 돌리기 전 데이터를 갱신할 지점이 존재해야 함
	 *  gamer.getMoney() > Momento.getMoney() <- 이 지점에서 Momento에 데이터 저장
	 * 
	 */
	public static final String SAVEFILENAME = "game.dat";
	public GamePlayIO() {
		GamerIO gamer = (GamerIO)DynamicObjectCreater.newInstanceObject("GamerIO", 100);
		MementoIO memento = loadMemento();	// 최초의 상태를 저장해 본다.
		for(int i =0; i < 100; i++){
			System.out.println("====" + i);		// 개수 표시
			System.out.println("현상:" + gamer);	// 현재 주인공의 상태 표시
			
			gamer.bet(); 	// 게임을 진행시킨다.
			
			System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
			
			// Memento의 취급 결정
			isUndo(gamer, memento);
			
			// 시간 기다림
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
			System.out.println("");
		}
	}
	
	public void isUndo(GamerIO gamer, MementoIO memento){
		if(gamer.getMoney() > memento.getMoney()){
			System.out.println(" (많이 증가했으므로 현재의 상태를 저장하자");
			memento = gamer.createMemento();
			saveMemento(memento);
		}else if(gamer.getMoney() < memento.getMoney() / 2){
			System.out.println(" (많이 감소했으므로 이전의 상태로 복원하자)");
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
