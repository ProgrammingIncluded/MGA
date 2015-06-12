package com.mga.game.projectiles;

import com.mga.game.engine.GameObject;
import com.mga.logic.Projectile;
/**
 * 
 * @author Merrycatch22
 *
 */
public class StraightBullet extends Projectile {
	protected float frozenRadian;
	protected int vel;
	public StraightBullet() {
		this(null);
	}

	

	public StraightBullet(GameObject owner) {
		this("StraightBullet"+Math.random(),25.f,owner,(float)(Math.PI/2),300);
		// TODO Auto-generated constructor stub
	}
	
	public StraightBullet(GameObject owner,float radian,int vel){
		this("StraightBullet"+Math.random(),25.f,owner,radian,vel);
	}

	public StraightBullet(String name, float damage, GameObject owner,float radian,int vel) {
		
		super(name, damage, owner);
		frozenRadian=radian;
		this.vel=vel;
		// TODO Auto-generated constructor stub
	}
	
	public float getFrozenRadian() {
		return frozenRadian;
	}

	public void setFrozenRadian(float frozenRadian) {
		this.frozenRadian = frozenRadian;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	@Override
	public void bulletTick(float dTime) {
		getSprite().setRotation((float)((frozenRadian)/Math.PI*180.0)-90.0f);
		setPosition(
				(float) (getSprite().getX() + dTime * getVel()
						* Math.cos(frozenRadian)),
				(float) (getSprite().getY() + dTime * getVel()
						* Math.sin(frozenRadian)));

	}

}
