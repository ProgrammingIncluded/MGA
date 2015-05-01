package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;

public class Bullet extends Enemy {

	protected float frozenRadian, timeLimit;
	///frozenRadian does essentially the same thing it does in Beta: force it in a straight line.
	///timeLimit would do something if removeGO worked for me.
	
	public Bullet(){
		this(null,1000,1,"Bullet"+Math.random(),0);
	}
	public Bullet(Sprite player, int vel, int health, String name, float fr) {
		super(player, vel, health, name);
		frozenRadian = fr;
		this.setSprite(this.sprHand.createSprite(this.getName(), "Abigail",
				"texture/Pac/dot.png"));
		getSprite().setPosition(player.getX(),player.getY());
		getSprite().setScale(0.05f);
		// player here actually is currently the Enemy.
		// Well, bullet isn't supposed to extend Enemy anyhow.
		timeLimit = 0;
	}

	@Override
	/**
	 * Move in a straight line in the direction of frozenRadian.
	 */
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub
		timeLimit += dTime;
		if (timeLimit < 5) {
			getSprite().setPosition(
					(float) (getSprite().getX() + dTime * getVel()
							* Math.cos(frozenRadian)),
					(float) (getSprite().getY() + dTime * getVel()
							* Math.sin(frozenRadian)));
		}

		else {
			 //removeGO(getName());
		}
	}

	@Override
	public void collided(CollisionObject colObj) {
		//removeGO(getName());
	}

}
