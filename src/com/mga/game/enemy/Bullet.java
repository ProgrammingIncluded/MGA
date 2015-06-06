package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;
import com.mga.logic.Enemy;
/**
 * Exists only for enemy firing testing purposes.
 * @author Nicky
 *
 */
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
		setPosition(player.getX(),player.getY());
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
			setPosition(
					(float) (getSprite().getX() + dTime * getVel()
							* Math.cos(frozenRadian)),
					(float) (getSprite().getY() + dTime * getVel()
							* Math.sin(frozenRadian)));
		}

		else {
			setHealth(0);
		}
	}

	@Override
	public void collided(CollisionObject colObj) {
		if(colObj.getName().equals("Abigail"))
			setHealth(0);
	}

}
