package com.mga.logic;

import com.mga.game.engine.GameObject;

public class Score {
	protected GameObject abig;
	protected int points;
	public Score(GameObject a) {
		// TODO Auto-generated constructor stub
		abig=a;
		points=0;
	}
	public void addPoints(int p){
		points+=p;
	}
	public void printPoints(){
		System.out.printf("Points: %d\n",points);
	}

}
