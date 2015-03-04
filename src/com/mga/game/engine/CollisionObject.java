package com.mga.game.engine;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * Much like GameObject but provides the ability to detect collision.
 * As a result of this extend this class only when necessary as it
 * has n^2 time.
 * @author Charles Chen
 *
 */
public abstract class CollisionObject extends GameObject
{
	/*Class Constants*/
	static final String DEF_COL_NAME = DEF_GO_NAME;
	
	/*Static Variables*/
	// List of InteractObject(s) for collision calculations.
	public static ArrayList<CollisionObject>colObjects
		= new ArrayList<CollisionObject>();
	
	/*Member Variables*/
	// Variable to hold whether or not the collision is turn on.
	private boolean isCol; 
	
	public CollisionObject(Rectangle bound)
	{
		this(bound, 
			DEF_GO_NAME, 
			MGA.getSpriteHandler().getDefContainer().containerObj);
	}
	
	public CollisionObject()
	{
		this(MGA.getSpriteHandler().getDefContainer().containerObj
			.getBoundingRectangle(),
			DEF_COL_NAME, 
			MGA.getSpriteHandler().getDefContainer().containerObj);
	}
	
	public CollisionObject(String name)
	{
		this(MGA.getSpriteHandler().getDefContainer().containerObj
			.getBoundingRectangle(),
			name, 
			MGA.getSpriteHandler().getDefContainer().containerObj);
	}
	
	public CollisionObject(Sprite defSprite)
	{
		this(defSprite.getBoundingRectangle(), DEF_COL_NAME, defSprite);
	}
	
	public CollisionObject(Rectangle bound, String name, Sprite defSprite)
	{
		super(name, defSprite);
		isCol = true;
		colObjects.add(this);
	}
	
	/**
	 * Function that is called when object collides with another.
	 * Given object is the object collided in question.
	 */
	public abstract void collided(CollisionObject colObj);
	
	/*Static Functions*/
	/**
	 *  Function to check collision of each collidable object.
	 */
	public static void updateCollision()
	{
		CollisionObject colOne = null, colTwo = null;
		for(int i = 0; i != colObjects.size(); ++i)
		{
			colOne = colObjects.get(i);
			
			if(colOne == null || colOne.isCol == false)
				continue;
			
			for(int x = i+1; x != colObjects.size(); ++x)
			{
				colTwo = colObjects.get(x);
				
				if(colTwo == null || colTwo.isCol == false)
					continue;
				
				if(Intersector.overlaps(
					colOne.getBoundingBox(), colTwo.getBoundingBox()))
				{
					// Notify the collided objects.
					colOne.collided(colTwo);
					colTwo.collided(colOne);
				}
			}
		}
	}
	
	/**
	 * Removes the CollisionObject from being tracked.
	 * Right now, slightly inefficient, uses ArrayList searching...
	 * Perhaps Tree?
	 */
	public static boolean removeGO(String name)
	{
		GameObject go = goLHMap.remove(name);
		if(!colObjects.remove(go))
			System.out.println("nope");
		return true;
	}
	
	/*Getters*/
	/**
	 * Short cut function to get bounding box from sprite. 
	 * Everytime you call it, bounding box is updated.
	 */
	public Rectangle getBoundingBox()
	{
		return this.getSprite().getBoundingRectangle();
	}
	
	/**
	 * Check if the object is collidable with other objects.
	 */
	public boolean getIsCollidable()
	{
		return isCol;
	}
	
	/*Setters*/
	/**
	 * Set whether or not the object can collide.
	 */
	public boolean setIsCollidable(boolean isCol)
	{
		this.isCol = isCol;
		return true;
	}
}
