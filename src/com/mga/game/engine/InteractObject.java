package com.mga.game.engine;

import java.util.ArrayList;

/**
 * Much like GameObject but provides the ability to detect collision.
 * As a result of this extend this class only when necessary as it
 * has n^2 time.
 * @author Charles Chen
 *
 */
public abstract class InteractObject extends GameObject
{
	// List of InteractObject(s) for collision calculations.
	public static ArrayList<InteractObject>interObjects
		= new ArrayList<InteractObject>();
	
	InteractObject()
	{
		
	}
	
	/*Getters*/
	
	/*Setters*/
	
}
