package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Beta extends Enemy {
	private float chargePeriod=0,frozenRadian,chargeTime;
	///frozenRadian "freezes" beta into charging straight forward.
	///chargePeriod and chargeTime just exist to keep the pattern?

	public Beta(Sprite player, int vel, int health, String name) {
		super(player, vel, health, name);
		chargeTime=6;
		// TODO Auto-generated constructor stub
	}
	public Beta(Sprite player, int vel, int health, String name, float ct) {
		super(player, vel, health, name);
		chargeTime=ct;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub
		
		if(player == null){
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
				getSprite().setPosition((float)(getSprite().getX()+dTime*vel*Math.cos(frozenRadian)),(float)(getSprite().getY()+ dTime*vel*Math.sin(frozenRadian)));
			}
			
			
			
		}

	}

}
