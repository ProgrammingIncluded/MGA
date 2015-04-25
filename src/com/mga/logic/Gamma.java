package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Gamma extends Beta {

	public Gamma() {
		// TODO Auto-generated constructor stub
		super(null,500,1,""+Math.random());
	}

	public Gamma(Sprite player, int vel, int health, String name) {
		super(player, vel, health, name);
		// TODO Auto-generated constructor stub
	}

	public Gamma(Sprite player, int vel, int health, String name, float ct) {
		super(player, vel, health, name, ct);
		// TODO Auto-generated constructor stub
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
			if(chargePeriod%chargeTime<=1.0*chargeTime/50.0){
				getSprite().setRotation(theta);
				frozenRadian=(float)((theta+90)*Math.PI/180);
			}
			else{
				double deviation=Math.random()*20-10;
				getSprite().setPosition((float)(getSprite().getX()+dTime*vel*Math.cos(frozenRadian+deviation)),
					(float)(getSprite().getY()+ dTime*vel*Math.sin(frozenRadian+deviation)));
				
			}
			
		}

	}
	

}
