package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Alpha extends Enemy {

	public Alpha(Sprite player, int vel, int health, String name) {
		super(player, vel, health, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atk(float dTime) {
		// TODO Auto-generated method stub
		
		if(player == null){
			removeGO("name");
		}
		// TODO Auto-generated method stub
		else{
			
			float dx=player.getX()-getSprite().getX();
			float dy=player.getY()-getSprite().getY();
			float theta=(float)(180.0/Math.PI*Math.atan(dy/dx)-90.0);
			if(dx<0){
				theta+=180.0;
			}
			getSprite().setRotation(theta);
			getSprite().setPosition((float)(getSprite().getX()+dTime*vel*dx/Math.sqrt(dx*dx+dy*dy)),(float)(getSprite().getY()+ dTime*vel*dy/Math.sqrt(dx*dx+dy*dy)));
			
			
		}

	}

}
