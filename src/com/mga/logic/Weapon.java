package com.mga.logic;

import java.util.Hashtable;

import com.badlogic.gdx.math.Vector2;
import com.mga.game.engine.CollisionObject;

/**
 * Weapon base class for all Weapons. Allow internal tracking of all weapons
 * loaded into memory. Each weapon has a uniqueID but not necessary a unique
 * name. Uses Hashtable to keep track of all the weapons. May require 
 * custom hashCode() in the future.
 * @author Charles Chen
 *
 */
public abstract class Weapon extends CollisionObject
{
	/*Default Weapon Values*/
	static final int DEF_DAMAGE = 1;
	static final int DEF_FIRE_RATE = 10;
	static final int DEF_DUR = 100;
	static final int DEF_SPEED = 2;
	
	/*Static Members*/
	// List of weapons created. Unique ID's as key.
	private static Hashtable<Integer, Weapon>weapons = 
		new Hashtable<Integer, Weapon>();
	
	/*Private Member Variables*/
	private int weaponID; //!< Must be unique. Utilizes Weapon Count.
	private int damage, fireRate, durability;
	private Projectile projectile; // Variable to hold project instances.
	
	// Default constructor.
	Weapon()
	{
		this(generateUniqueID());
	}

	// Parameter with uniqueID value.
	Weapon(int uniqueID)
	{
		this(uniqueID, DEF_DAMAGE, DEF_FIRE_RATE, DEF_DUR);
	}
	
	Weapon(int damage, int fireRate, int durability)
	{
		this(generateUniqueID(), damage, fireRate, durability);
	}
	
	// Parameter constructor.
	Weapon(int uniqueID, int damage, int fireRate, int durability)
	{
		if(!setUniqueID(uniqueID))
		{
			this.weaponID = generateUniqueID();
		}
		if(!setDurability(durability))
		{
			this.durability = this.DEF_DUR;
		}
		if(!setFireRate(fireRate))
		{
			this.fireRate = this.DEF_FIRE_RATE;
		}
		if(!setDamage(damage))
		{
			this.damage = this.DEF_DAMAGE;
		}
	}
	
	/**
	 * Function to move the weapon. Algorithm will be given in child class.
	 * This function will move the weapon based on factors such as durability.
	 */
	public abstract void move(Vector2 direction);
	
	/**
	 * Euler angle given in order to rotate the object based on values such
	 * as durability.
	 */
	public abstract void rotate(int angle);
	
	/*Setters*/
	/**
	 * Allows damage of positive and negative values.
	 */
	public boolean setDamage(int dmg)
	{
		damage = dmg;
		return true;
	}
	
	/**
	 * No negative values, sets to zero if so.
	 */
	public boolean setDurability(int dur)
	{
		if(dur < 0)
		{
			this.durability = 0;
			return false;
		}
		this.durability = dur;
		return true;
	}
	
	/**
	 * Does not allow negative fire rate, sets the fire rate to zero if so.
	 */
	public boolean setFireRate(int firR)
	{
		if(firR < 0)
		{
			this.fireRate = 0;
			return false;
		}
		
		this.fireRate = firR;
		return true;
	}
	
	/**
	 * Sets the unique ID of the weapon. If ID given is not 
	 * unique, will not change the ID, also returns false.
	 */
	public boolean setUniqueID(int weaponID)
	{
		if(weapons.containsKey(weaponID))
		{
			return false;
		}
		weapons.remove(this.weaponID);
		this.weaponID = weaponID;
		weapons.put(weaponID, this);
		return true;
	}
	
	/* Getters */
	public int getDamage()
	{
		return damage;
	}
	
	public int getFireRate()
	{
		return fireRate;
	}
	
	public int getDurability()
	{
		return durability;
	}
	
	public int getUniqueWeaponID()
	{
		return weaponID;
	}
	
	/*Static Functions*/
	/**
	 * Getter for static variable of all the weapons allocated in memory.
	 */
	public static Hashtable<Integer, Weapon> getWeapons()
	{
		return weapons;
	}
	
	/**
	 * Function to generate a unique ID for weapons.
	 * Uses the size of the current weapons and checks if integer is available,
	 * if not, checks the next integer index. Perhaps implement quadratic
	 * probing like check for next index?
	 */
	public static int generateUniqueID()
	{
		int result = weapons.size();
		while(weapons.containsKey(result))
		{
			++result;
		}
		return result;
	}
}
