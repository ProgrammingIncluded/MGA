package com.mga.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Score {
	
	protected int points;
	protected Label label;
	
	public Score() {
		// TODO Auto-generated constructor stub		
		points=0;
		label=new Label("0",new LabelStyle(new BitmapFont(),new Color(Color.WHITE)));
		label.setPosition(0.f, 0.f);
	}
	public void addPoints(int p){
		points+=p;
	}
	public void printPoints(){
		System.out.printf("Points: %d\n",points);
	}
	public void draw(Batch batch){
		label.setText(""+points);
		
		label.draw(batch,1.f);
	}

}
