package org.park.javadesignpattern.iday.strategy.main;

import org.park.javadesignpattern.iday.strategy.Hand;
import org.park.javadesignpattern.iday.strategy.Player;

import tools.dynamiccreate.DynamicObjectCreater;

public class I_Main2 {

	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Usage: java Main randomseed1 randomseed2");
			System.out.println("Example: java Main 314 15");
			System.exit(0);
		}
		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);
		Player player1 = (Player)DynamicObjectCreater.newInstanceObject
				("Player", "두리", DynamicObjectCreater.newInstanceObject("WinningStrategy", seed1));
		Player player2 = (Player)DynamicObjectCreater.newInstanceObject
				("Player", "하나", DynamicObjectCreater.newInstanceObject("RandomStrategy", seed2));
		for(int i = 0; i < 10000; i++){
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if(nextHand1.isStrongerThan(nextHand2)){
				System.out.println("Winner: " + player1);
				player1.win();
				player2.lose();
			}else if(nextHand2.isStrongerThan(nextHand1)){
				System.out.println("Winner: " + player2);
				player1.lose();
				player2.win();
			}else{
				System.out.println("Even...");
				player1.even();
				player2.even();
			}
		}
		System.out.println("Total result:");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
	}

}
