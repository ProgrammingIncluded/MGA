package com.mga.logic.playfield;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mga.game.engine.GameObject;

public class ConeGenerator extends GameObject
{
	private static final int MAX_CONES = 1500;
	public Rectangle playRect = new Rectangle(0f,0f,3000f,3000f);
	private Cone cones[];
	
	public ConeGenerator()
	{
		super("ConeGenerator");
		this.setIsVisible(false);
		cones = new Cone[MAX_CONES];
		initCones();
	}
	
	@Override
    public void tick(float dTime)
    {
		Random rand = new Random();
		for(Cone cone : cones)
		{
			if(cone.getVisible() == false)
			{
				cone.setPosition(new Vector2(rand.nextInt((int)playRect.height),
				rand.nextInt((int)playRect.height)));
				cone.setIsVisible(true);
				cone.setIsCollidable(true);
			}
		}
    }
	
	public void initCones()
	{
		Random rand = new Random();
		for(int i = 0; i < cones.length; ++i)
		{
			cones[i] = new Cone(new Vector2(rand.nextInt((int)playRect.height),
				rand.nextInt((int)playRect.height)));
		}
	}
}
