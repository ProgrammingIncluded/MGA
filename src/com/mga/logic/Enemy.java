package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;

public abstract class Enemy extends CollisionObject{
	public int health,vel;
	public Sprite player;
	
	public Enemy(Sprite player,int vel, int health,String name){
		super(name);
		this.player = player;
		this.health=health;
		this.vel=vel;
	}
	
	@Override
	public void collided(CollisionObject colObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(float dTime) {
		attackPattern(dTime);
		
	}
	public abstract void attackPattern(float dTime);
	

}
