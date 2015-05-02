package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Delta extends Enemy
{
	protected float frozenRadian,safeDistance;
	///frozenRadian sets what degree value Delta will deviate if within safeDistance from x.
	///safeDistance tells Delta when to stop moving away from Abigail.
	public Delta(Sprite player, int vel, int health, String name,float fr,float sd) 
	{
		super(player, vel, health, name);
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Delta", "texture/enemy.png");
		spr.setScale(0.2f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 300);
		getSprite().setY((float) Math.random() * 300 + 300);
		frozenRadian=fr;
		safeDistance=sd;
	}

	public Delta(Sprite player, int vel, int health, String name) 
	{
		this(player,vel,health,name,(float)(Math.PI/4),100);
	}
	public Delta()
	{
		this(null,200,1,"Delta"+Math.random());
	}

	@Override
	/**
	 * Delta is the standard "move down the screen" enemy.
	 *  It tries to shy away from the player until it reaches a safeDistance.
	 */
	public void attackPattern(float dTime)
	{
		// TODO Auto-generated method stub
		float dx = getPlayer().getX() - getSprite().getX();
		if(dx>=0&&dx<safeDistance)
		{
			getSprite().setRotation((float)((Math.PI-frozenRadian)/Math.PI*180.0));
			getSprite().setPosition(
				(float) (getSprite().getX() + dTime * getVel()
				* Math.cos(Math.PI*3.0/2.0-frozenRadian)),
				(float) (getSprite().getY() + dTime * getVel()
				* Math.sin(Math.PI*3.0/2.0-frozenRadian)));
		}
		else if(dx<0&&dx>-safeDistance)
		{
			getSprite().setRotation((float)((Math.PI+frozenRadian)/Math.PI*180.0));
			getSprite().setPosition(
				(float) (getSprite().getX() + dTime * getVel()
				* Math.cos(Math.PI*3.0/2.0+frozenRadian)),
				(float) (getSprite().getY() + dTime * getVel()
				* Math.sin(Math.PI*3.0/2.0+frozenRadian)));
		}
		else
		{
			getSprite().setRotation((float)(Math.PI/Math.PI*180.0));
			getSprite().setPosition(
				(float) (getSprite().getX() + dTime * getVel()
				* Math.cos(Math.PI*3.0/2.0)),
				(float) (getSprite().getY() + dTime * getVel()
				* Math.sin(Math.PI*3.0/2.0)));
		}
		moveBackUp();
	}
	/**
	 * Used for testing only.
	 */
	public void moveBackUp()
	{
		if(getSprite().getY()<-100)
		{
			setPosition((float)(Math.random()*500), 500);
		}
	}

}
