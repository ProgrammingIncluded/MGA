package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;

/**
 * Abstract class that superclasses all implementable enemies.
 * @author Nicky
 *
 */
public abstract class Enemy extends Shootable implements Killable {
	protected int vel;
	protected Sprite player;
	protected float health;

	public Enemy(Sprite player, int vel, int health, String name) {
		super(name);
		this.player = player;
		this.health = health;
		this.vel = vel;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
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


	/** 
	 * takes damage from projectile.
	 */
	public void onHit(Projectile p) {
		setHealth(getHealth()-p.getDamage());
	}
	
	/**
	 * tick calls attackPattern, the movements of the enemies. Also kills the Enemy if it isDead.
	 */
	@Override
	public void tick(float dTime) {
		attackPattern(dTime);
		if(isDead()){
			CollisionObject.removeGO(getName());
		}

	}
	/**
	 * All enemies but extend attackPattern to move.
	 * @param dTime
	 */
	public abstract void attackPattern(float dTime);
	/**
	 * sets health to zero when called.
	 */
	public boolean kill() {
		setHealth(0.f);
		return true;
	}
	/**
	 * Returns whether health is <=0 or not.
	 */
	public boolean isDead() {
		return (getHealth() <= 0);
	}
}
