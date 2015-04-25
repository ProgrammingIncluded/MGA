package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;

public abstract class Enemy extends CollisionObject{
	protected int health,vel;
	protected Sprite player;
	
	public Enemy(Sprite player,int vel, int health,String name){
		super(name);
		this.player = player;
		this.health=health;
		this.vel=vel;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public Sprite getPlayer() {
		return player;
	}

	public void setPlayer(Sprite player) {
		this.player = player;
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
