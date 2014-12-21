package com.mga.game;

import java.util.Iterator;
import java.util.LinkedHashMap;

public abstract class GameObject
{
	/*Static Variables*/
	static LinkedHashMap<String, GameObject> goLHMap;
	static boolean isIntialized = false;
	
	/*Local Variables*/
	private String name;

	public GameObject()
	{
		this("DEFGONAME");
	}
	
	public GameObject(String name)
	{
		this.name = name;
	}
	
	public abstract void update(int dTime);
	
	/*Static Functions*/
	/// Function to update each individual GameOjbect per frame
	public static boolean tick(int dTime)
	{
		Iterator<GameObject> it = goLHMap.values().iterator();
		while(it.hasNext())
		{
			it.next().update(dTime);
		}
		return false;
	}

	/// Add a GameObject to the static tracker.
	public static boolean addGO(String name, GameObject gameObject)
	{
		if(goLHMap.containsKey(name))
		{
			return false; // Object already exists, return false.
		}
		goLHMap.put(name, gameObject);
		return false;
	}

	/// Remove a GameObject from the static tracker.
	public static boolean removeGO(String name)
	{
		goLHMap.remove(name);
		return false;
	}
	
	public static boolean intialize()
	{
		if(isIntialized == false)
		{
			goLHMap = new LinkedHashMap<String, GameObject>();
			return true;
		}
		return false;
	}
	
	/*Getters*/
	public String getName()
	{
		return name;
	}
	
	/*Setters*/
	/// Setter for name of GO. Returns false if name length is 0
	/// or null string.
	public boolean setName(String name)
	{
		if(name == null || name.length() == 0 )
		{
			return false;
		}
		this.name = name;
		return true;
	}
}