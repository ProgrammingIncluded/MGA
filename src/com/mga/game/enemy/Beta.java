package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.projectiles.StraightBullet;
import com.mga.logic.Enemy;
/**
 * Versatile enemy, moves toward player but has the capability of not moving perfectly.
 * Can charge up and attack.
 * @author Nicky
 *
 */
public class Beta extends Enemy
{
	protected float chargePeriod, frozenRadian, chargeTime, chargeFraction,deviation;

	///frozenRadian "freezes" beta into charging straight forward.
	///chargePeriod and chargeTime just exist to keep the pattern
	///chargeFraction tells how much time is spent charging
	///deviation was supposed to be part of Gamma, but I realized that Beta and Gamma where too similar.
	///it just makes the enemy charge away by deviation radians.
	public Beta()
	{
		this(null, 500, 1, "Beta" + Math.random());
	}

	public Beta(Sprite player, int vel, int health, String name)
	{
		
		this(player, vel, health, name, 3);
	}

	public Beta(Sprite player, int vel, int health, String name, float ct) 
	{
		
		this(player, vel, health, name, ct, 5f / 6f);
	}

	public Beta(Sprite player, int vel, int health, String name, float ct,
			float cf)
	{
		this(player,vel,health,name,0,0,ct,cf,0);
	}
	public Beta(Sprite player, int vel, int health, String name,float xPos,float yPos, float ct,
			float cf,float dev) 
	{
		super(player, vel, health, name,xPos,yPos);
		chargeTime = ct;
		chargeFraction = cf;
		chargePeriod = 0;
		deviation=dev;
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Beta", "texture/enemy2.png");

		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 1000 + 500);
		getSprite().setY((float) Math.random() * 1000 + 500);
	}
	public float getChargeFraction()
	{
		return chargeFraction;
	}

	public void setChargeFraction(float chargeFraction) 
	{
		this.chargeFraction = chargeFraction;
	}

	public float getChargePeriod()
	{
		return chargePeriod;
	}

	public void setChargePeriod(float chargePeriod) 
	{
		this.chargePeriod = chargePeriod;
	}

	public float getFrozenRadian()
	{
		return frozenRadian;
	}

	public void setFrozenRadian(float frozenRadian)
	{
		this.frozenRadian = frozenRadian;
	}

	public float getChargeTime() 
	{
		return chargeTime;
	}

	public void setChargeTime(float chargeTime)
	{
		this.chargeTime = chargeTime;
	}

	public float getDeviation() 
	{
		return deviation;
	}

	public void setDeviation(float deviation) 
	{
		this.deviation = deviation;
	}

	/**
	 * This attackPattern is the bull charger. It takes chargeFraction of the
	 * time to turn towards the player, then charges. The fraction should be
	 * changed possibly.
	 */
	@Override
	public void attackPattern(float dTime) 
	{

		if (getPlayer() == null)
		{
			removeGO(getName());
		}

		else 
		{
			chargePeriod += dTime;
			float dx = getPlayer().getX() - getSprite().getX();
			float dy = getPlayer().getY() - getSprite().getY();
			float theta = (float) (180.0 / Math.PI * Math.atan(dy / dx) - 90.0);
			if (dx < 0) {
				theta += 180.0;
			}
			if (chargePeriod <= chargeFraction * chargeTime) 
			{
				getSprite().setRotation(theta);
				frozenRadian = (float) ((theta + 90) * Math.PI / 180+deviation*2*Math.random()-deviation);
				
			} 
			else if (chargePeriod > chargeTime) 
			{
				chargePeriod = 0;
				
				 new StraightBullet(this,frozenRadian,300);

				 
			} 
			else 
			{
				setPosition(
						(float) (getSprite().getX() + dTime * getVel()
								* Math.cos(frozenRadian)),
						(float) (getSprite().getY() + dTime * getVel()
								* Math.sin(frozenRadian)));

			}

		}

	}

}
