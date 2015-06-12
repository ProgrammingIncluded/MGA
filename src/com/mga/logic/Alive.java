package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mga.game.engine.CollisionObject;

/**
 * This exists so that Projectile can collide and use onHit and Enemy can
 * interact. 
 * 
 * @author Nicky & Charles Chen
 *
 */
public abstract class Alive extends CollisionObject 
{
	// Value to hold object stats.
	private Stats stat;
	public Alive()
	{
		// TODO Auto-generated constructor stub
		this("Shootable" + Math.random());
	}

	public Alive(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Function to set stats. Sets directly, only checks if null.
	 */
	public boolean setStats(Stats stat)
	{
		if(stat == null)
			return false;
		
		this.stat.health = stat.health;
		this.stat.stamina = stat.stamina;
		this.stat.strength = stat.strength;
		return true;
	}
	
	/**
	 * If collided sees a Projectile, then onHit is called.
	 */
	@Override
	public void collided(CollisionObject colObj) 
	{
		if (colObj instanceof Projectile) 
		{
			onHit((Projectile) (colObj));
		}
	}
	
	public abstract void tick(float dTime);

	/**
	 * OnHit does whatever is supposed to happen when this object hits a
	 * projectile.
	 */
	public abstract void onHit(Projectile p);

}
