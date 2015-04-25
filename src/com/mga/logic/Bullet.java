package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends Enemy {
	public float frozenRadian;
	public Bullet(Sprite player, int vel, int health, String name,float fr) {
		super(player, vel, health, name);
		frozenRadian=fr;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub
		getSprite().setPosition((float)(getSprite().getX()+dTime*vel*Math.cos(frozenRadian)),
				(float)(getSprite().getY()+ dTime*vel*Math.sin(frozenRadian)));
	}

}
