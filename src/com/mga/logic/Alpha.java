package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Alpha extends Enemy 
{

	public Alpha(Sprite player, int vel, int health, String name) 
	{
		super(player, vel, health, name);
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Enemy", "texture/enemy.png");
		spr.setScale(0.25f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		setPosition(400,400);
	}
	/**
	 * This is the overridden atk method for all my enemy versions
	 */
	@Override
	public void attackPattern(float dTime) 
	{
		// TODO Auto-generated method stub
		
		if(getPlayer() == null)
		{
			removeGO("name");
		}
		// TODO Auto-generated method stub
		else
		{
			float dx=getPlayer().getX()-getSprite().getX();
			float dy=getPlayer().getY()-getSprite().getY();
			float theta=(float)(180.0/Math.PI*Math.atan(dy/dx)-90.0);
			if(dx<0){
				theta+=180.0;
			}
			getSprite().setRotation(theta);
			getSprite().setPosition((float)(getSprite().getX()+dTime*getVel()*dx/Math.sqrt(dx*dx+dy*dy)),
				(float)(getSprite().getY()+ dTime*getVel()*dy/Math.sqrt(dx*dx+dy*dy)));
		}

	}

}
