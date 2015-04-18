package com.mga.logic;

import com.mga.game.engine.GameObject;

/**
 * Player class that handles movement and stats of character.
 * @author Charles Chen
 *
 */
public class Player extends GameObject implements Killable
{
	/* Static Members */
	// Max stats for every player value.
	static final int MAX_STAT = 9999;
	
	/* Private Variables */
	private int hp, mp, str;
	private int hpMax, mpMax, strMax;
	
	// Default Constructor.
	Player()
	{
		this(100,100,100);
	}
	
	// Parameter Constructor.
	Player(int hp, int mp, int str)
	{
		if(!setHp(hp))
			this.hp = 100;
		if(!setMp(mp))
			this.mp = 100;
		if(!setStr(str))
			this.str = 100;
		
		
	}
	
	/* Setters */
	// If the health is less than zero, sets value to zero but returns false.
	// If the health is greater than the max value allowed, then returns false
	// and does not set value.
	// Finally, return true when given value is set as internal value.
	public boolean setHp(int hp)
	{
		if(hp > MAX_STAT)
		{	
			return false;
		}
		else if(hp < 0)
		{
			this.hp = 0;
			return false;
		}
			
		this.hp = hp;
		return true;
	}
	
	// If the magic is less than zero, sets value to zero but returns false.
	// If the magic is greater than the max value allowed, then returns false
	// and does not set value.
	// Finally, return true when given value is set as internal value.
	public boolean setMp(int mp)
	{
		if(mp > MAX_STAT)
		{	
			return false;
		}
		else if(mp < 0)
		{
			this.mp = 0;
			return false;
		}
			
		this.mp = mp;
		return true;
	}
	
	// If the strength is less than zero, sets value to zero but returns false.
	// If the strength is greater than the max value allowed, then returns false
	// and does not set value.
	// Finally, return true when given value is set as internal value.
	public boolean setStr(int str)
	{
		if(str > MAX_STAT)
		{	
			return false;
		}
		else if(str < 0)
		{
			this.str = 0;
			return false;
		}
			
		this.str = str;
		return true;
	}
	
	/* Getters */
	public int getHp()
	{
		return hp;
	}
	
	public int getMp()
	{
		return mp;
	}
	
	public int getStr()
	{
		return str;
	}

	// Function to satisfy whether or not player is dead.
	@Override
    public boolean isDead()
    {
		return (hp <= 0);
    }

	@Override
    public boolean kill()
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public void tick(float dTime)
    {
	    // TODO Auto-generated method stub
	    
    }
}
