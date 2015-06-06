package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mga.game.engine.CollisionObject;

/**
 * This exists so that Projectile can collide and use onHit and Enemy can
 * interact.
 * 
 * @author Nicky
 *
 */
public abstract class Shootable extends CollisionObject 
{

	public Shootable()
	{
		// TODO Auto-generated constructor stub
		this("Shootable" + Math.random());
	}

	public Shootable(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * If collided sees a Projectile, then onHit is called.
	 * 
	 * @param p
	 */
	@Override
	public void collided(CollisionObject colObj) 
	{
		// TODO Auto-generated method stub
		if (colObj instanceof Projectile) 
		{
			onHit((Projectile) (colObj));
		}

	}

	@Override
	public void tick(float dTime) 
	{
		// TODO Auto-generated method stub

	}

	/**
	 * OnHit does whatever is supposed to happen when this object hits a
	 * projectile.
	 * 
	 * @param p
	 */
	public abstract void onHit(Projectile p);

}
