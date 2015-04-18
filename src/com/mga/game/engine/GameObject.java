package com.mga.game.engine;

import java.util.LinkedHashMap;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mga.logic.Config;

/**
 *	An abstract class that deals with any classes involving in game
 * objects that will interact with each other. So, Sprite will be
 * assigned for each GameObject.  
 */
public abstract class GameObject
{
	/* Variables from MGA */
	protected SpriteHandler sprHand;
	protected SoundHandler sndHand;
	
	/*Static Variables*/
	static String DEF_GO_NAME = Config.DEF_GO_NAME;
	static LinkedHashMap<String, GameObject> goLHMap;
	static boolean isIntialized = false;

	/*Local Variables*/
	private String name;
	private Sprite goSpr;

	public GameObject()
	{
		this(DEF_GO_NAME, 
			MGA.getSpriteHandler().getDefContainer().containerObj);
	}
	
	public GameObject(String name)
	{
		this(name, MGA.getSpriteHandler().getDefContainer().containerObj);
	}
	
	public GameObject(Sprite defSprite)
	{
		this(DEF_GO_NAME, defSprite);
	}
	
	public GameObject(String name, Sprite defSprite)
	{
		if(!setName(name))
		{
			this.name = DEF_GO_NAME;
		}
		if(!setSprite(defSprite))
		{
			this.goSpr = MGA.getSpriteHandler().getDefContainer().containerObj;
		}
		GameObject.addGO(name, this);
		sprHand = MGA.getSpriteHandler();
		sndHand = MGA.getSoundHandler();
	}
	
	public abstract void tick(float dTime);
	
	/**
	 * Draw method that should be called inside a State's draw method.
	 * Internally managed, including batches, in order to prevent confusion.
	 * TODO: Optimize draw calls here.
	 */
	public static void draw()
	{
		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		for(GameObject go : goLHMap.values())
		{
			go.getSprite().draw(batch);
		}
		batch.end();
	}
	
	/*Static Functions*/
	/// Function to update each individual GameOjbect per frame
	public static boolean update(float dTime)
	{
		for(GameObject go : goLHMap.values())
		{
			go.tick(dTime);
		}
		return true;
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
	
	public Sprite getSprite()
	{
		return goSpr;
	}
	
	public SoundHandler getSoundHandler()
	{
		return sndHand;
	}
	
	public SpriteHandler getSpriteHandler()
	{
		return sprHand;
	}
	
	/* Setters */
	/**
	 * Setter for name of GO. Returns false if name length is 0
	 * or null string.
	 */
	public boolean setName(String name)
	{
		if(name == null || name.length() == 0)
		{
			return false;
		}
		this.name = name;
		return true;
	}
	
	/**
	 * Set the sprite of the GameObject. If sprite is null,
	 * returns false.
	 */
	public boolean setSprite(Sprite spr)
	{
		if(spr == null)
		{
			return false;
		}
		this.goSpr = spr;
		return true;
	}
}