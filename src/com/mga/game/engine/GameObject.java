package com.mga.game.engine;

import java.util.LinkedHashMap;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mga.logic.Config;

/**
 *	An abstract class that deals with any classes involving in game
 * objects that will interact with each other. So, Sprite will be
 * assigned for each GameObject. Once assigned, Sprite is deleted by GO
 * automatically when GO is destroyed by calling ContainerHandler's
 * deleteResource(). 
 */
public abstract class GameObject
{
	/* Variables from MGA */
	private SpriteHandler sprHand;
	private SoundHandler sndHand;
	
	/*Static Variables*/
	static String DEF_GO_NAME = Config.DEF_GO_NAME;
	static LinkedHashMap<String, GameObject> goLHMap;
	static boolean isIntialized = false;

	/*Local Variables*/
	private boolean isVisible;
	//private int uniqueID;
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
		isVisible = true;
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
		Sprite dSpr = null;
		for(GameObject go : goLHMap.values())
		{
			dSpr = go.goSpr;
			if(go.isVisible == true && dSpr != null)
				dSpr.draw(batch);
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
		GameObject go = goLHMap.remove(name);
		go.sprHand.deleteContainer(go.name); // TODO remove spritehandler and let GO handle sprite naming w/unique id.
		return true;
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
	
	public boolean getVisible()
	{
		return isVisible;
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
	 * Short cut function for set position of Sprite. Sets the pos.
	 * of GO.
	 */
	public boolean setPosition(Vector2 pos)
	{
		goSpr.setPosition(pos.x, pos.y);
		return true;
	}
	
	/**
	 * Short cut function for set Position of Sprite. Sets the pos.
	 * of GO.
	 */
	public boolean setPosition(float x, float y)
	{
		goSpr.setPosition(x,y);
		return true;
	}
	
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
	 * Set the sprite of the GameObject. Does not allow null Sprite,
	 * returns false if so. Use setVisible for invisible GO.
	 */
	public boolean setSprite(Sprite spr)
	{
		if(spr == null)
			return false;
		this.goSpr = spr;
		return true;
	}
	
	/**
	 * Setter for isVisible that determines whether or not the GO 
	 * can be seen.
	 */
	public boolean setIsVisible(boolean isVisible)
	{
		this.isVisible = isVisible;
		return true;
	}
}