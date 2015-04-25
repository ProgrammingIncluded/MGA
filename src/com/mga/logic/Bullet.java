package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;

public class Bullet extends Enemy {
	protected float frozenRadian,timeLimit=0;
	public Bullet(Sprite player, int vel, int health, String name,float fr) {
		super(player, vel, health, name);
		frozenRadian=fr;
		this.setSprite(this.sprHand.createSprite(this.getName(), "Abigail", "texture/Pac/dot.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub
		timeLimit+=dTime;
		if(timeLimit<5){
			getSprite().setPosition((float)(getSprite().getX()+dTime*getVel()*Math.cos(frozenRadian)),
				(float)(getSprite().getY()+ dTime*getVel()*Math.sin(frozenRadian)));
		}
		
		else{
			//removeGO(getName());
		}
	}
	@Override
    public void collided(CollisionObject colObj)
    {
		//removeGO(getName());
    }

}
