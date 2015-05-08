package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;
/**
 * Abstract class that superclasses all implementable enemies.
 * @author Nicky
 *
 */
public abstract class Enemy extends Shootable implements Killable {
	protected int health, vel;
	protected Sprite player;

	public Enemy(Sprite player, int vel, int health, String name) {
		super(name);
		this.player = player;
		this.health = health;
		this.vel = vel;
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



	public void onHit(Projectile p) {
		
	}
	
	/**
	 * tick calls attackPattern, the movements of the enemies.
	 */
	@Override
	public void tick(float dTime) {
		attackPattern(dTime);

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
		setHealth(0);
		return true;
	}
	/**
	 * Returns whether health is <=0 or not.
	 */
	public boolean isDead() {
		return (getHealth() <= 0);
	}
}
