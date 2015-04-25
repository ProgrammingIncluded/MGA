package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Beta extends Enemy
{
	public float chargePeriod=0,frozenRadian,chargeTime;
	///frozenRadian "freezes" beta into charging straight forward.
	///chargePeriod and chargeTime just exist to keep the pattern?
	public Beta(){
		super(null,500,1,""+Math.random());
	}
	public Beta(Sprite player, int vel, int health, String name) 
	{
		super(player, vel, health, name);
		chargeTime=6;
		Sprite spr = this.getSpriteHandler().createSprite(
			this.getName(), "Enemy2", "texture/enemy2.png");
		spr.setScale(0.1f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		setPosition(400,400);
		
	}
	public Beta(Sprite player, int vel, int health, String name, float ct) 
	{
		super(player, vel, health, name);
		chargeTime=ct;
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Enemy2", "texture/enemy2.png");
		spr.setScale(0.1f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		setPosition(400,400);
	}

	@Override
	public void attackPattern(float dTime) 
	{
		// TODO Auto-generated method stub

		if(player == null)
		{
			removeGO("name");
		}
		// TODO Auto-generated method stub
		else{
			chargePeriod+=dTime;
			float dx=player.getX()-getSprite().getX();
			float dy=player.getY()-getSprite().getY();
			float theta=(float)(180.0/Math.PI*Math.atan(dy/dx)-90.0);
			if(dx<0){
				theta+=180.0;
			}
			if(chargePeriod%chargeTime<=5.0*chargeTime/6.0){
				getSprite().setRotation(theta);
				frozenRadian=(float)((theta+90)*Math.PI/180);
			}
			else{
				getSprite().setPosition((float)(getSprite().getX()+dTime*vel*Math.cos(frozenRadian)),
					(float)(getSprite().getY()+ dTime*vel*Math.sin(frozenRadian)));
				//new Beta ();
				//new Bullet(getSpriteHandler().createSprite(
						//this.getName(), "Abigail", "texture/Pac/dot.png"),1000,1,"Bullet"+Math.random(),frozenRadian);
			}
			
		}

	}

}
