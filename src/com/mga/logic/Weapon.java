package com.mga.logic;

import java.util.Hashtable;

/**
 * Weapon base class for all Weapons. Allow internal tracking of all weapons
 * loaded into memory. Each weapon has a uniqueID but not necessary a unique
 * name. Uses Hashtable to keep track of all the weapons. May require 
 * custom hashCode() in the future.
 * @author Charles Chen
 *
 */
public abstract class Weapon
{
	/*Default Weapon Values*/
	static final int DEF_DAMAGE = 1;
	static final int DEF_FIRE_RATE = 10;
	static final int DEF_DUR = 100;
	
	/*Static Members*/
	// List of weapons created. Unique ID's as key.
	private static Hashtable<Integer, Weapon>weapons = 
		new Hashtable<Integer, Weapon>();
	
	/*Private Member Variables*/
	private int weaponID; //!< Must be unique. Utilizes Weapon Count.
	private int damage, fireRate, durability;
	String weaponName; //!< Does not need to be unique.
	
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
	
	// Parameter constructor.
	Weapon(int uniqueID, int damage, int fireRate, int durability)
	{
		weaponID = uniqueID;
		
	}
	
	
	/*Setters*/
	/**
	 * Allows damage of positive and negative values.
	 */
	public boolean setDamage(int dmg)
	{
		
	}
	
	public boolean setDurability(int dur)
	{
		
	}
	
	public boolean setFireRate(int firR)
	{
		
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
