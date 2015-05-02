package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Gamma extends Enemy {
	protected float velX,velY,acceleration;
	///velX and velY are now separate variables for velocity, from vel.
	///acceleration is how much acceleration is directed towards the player.
	public Gamma(Sprite player, int vel, int health, String name,float acc) {
		super(player, vel, health, name);
		acceleration=acc;
		getSprite().setX((float) Math.random() * 100 + 50);
		getSprite().setY((float) Math.random() * 100 + 50);
		float dx = getPlayer().getX() - getSprite().getX();
		float dy = getPlayer().getY() - getSprite().getY();
		float theta = (float) (180.0 / Math.PI * Math.atan(dy / dx) - 90.0);
		if (dx < 0) {
			theta += 180.0;
		}
		getSprite().setRotation(theta);
				velX=(float) (getSprite().getX() + getVel() * dx
						/ Math.sqrt(dx * dx + dy * dy));
				velY=(float) (getSprite().getY() +   getVel() * dy
						/ Math.sqrt(dx * dx + dy * dy));
		
	}
	public Gamma (Sprite player, int vel, int health, String name){
		this(player, vel,health,name,1000);
	}
	public Gamma(){
		this(null,50,1,"Gamma"+Math.random());
	}

	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}
	@Override
	/**
	 * attackPattern for Gamma is now to orbit around the player, as it tries to accelerate towards it. 
	 */
	public void attackPattern(float dTime) {
		
		if (getPlayer() == null) {
			removeGO(getName());
		}

		else {
			float dx = getPlayer().getX() - getSprite().getX();
			float dy = getPlayer().getY() - getSprite().getY();
			float theta = (float) (180.0 / Math.PI * Math.atan(dy / dx) - 90.0);
			if (dx < 0) {
				theta += 180.0;
			}
			getSprite().setRotation(theta);
			setPosition(
					(float) (getSprite().getX() + dTime * velX),
					(float) (getSprite().getY() + dTime * velY));
			velX+=(float)(dTime*acceleration* dx / Math.sqrt(dx * dx + dy * dy));
			velY+=(float)(dTime*acceleration* dy / Math.sqrt(dx * dx + dy * dy));
		}

	}

}
