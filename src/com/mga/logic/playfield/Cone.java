package com.mga.logic.playfield;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mga.game.engine.CollisionObject;

/**
 * Simple class test in order to see if collision works.
 * For now, object is simply set invisible and non-collidable
 * once hit by Abigail. Later will implement killable.
 */
public class Cone extends CollisionObject
{
	public static boolean OVERLAP = true;
	public static String collector = "Abigail";
	public Cone(Vector2 pos)
	{
		super("Cone"+String.valueOf(Math.random()));
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Cone", "texture/PowerUps/9.bmp"); //TODO custom sprite function, remove sprite handler.
		spr.setScale(1.5f); // TODO: Add sprite scaling for all.
		spr.setPosition(pos.x, pos.y);
		this.setSprite(spr);
	}
	
	@Override
    public void collided(CollisionObject colObj)
    {
		if( OVERLAP == false||colObj.getName() == collector)
		{
			this.setIsCollidable(false);
			this.setIsVisible(false);
		}
	}

	@Override
    public void tick(float dTime)
    {
		
    }

}
