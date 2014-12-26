package com.mga.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteHandler extends Handler<Sprite>
{
	/* Constant Variables */
	static final String DEF_CONT_NAME = "ERRSPRITE";
	static final String DEF_FILE_NAME = "ERRTEX.png";
	
	/* Private */
	private TextureManager texManager; // No need to delete... 
	
	SpriteHandler(Texture tex)
	{
		this(DEF_CONT_NAME, DEF_FILE_NAME, new Sprite(tex));
	}
	
	SpriteHandler(String defContainerName, String defFileName, 
		Sprite containerObj)
	{
		super(defContainerName, defFileName, containerObj);
		texManager = null;
	}

	@Override
	public boolean resourceDeleted(String resourceFileName)
	{
		ArrayList<Container> deletedVect = 
			getContainerAssocResource(resourceFileName);
		Iterator<Container> it = deletedVect.iterator();
		while(it.hasNext())
		{
			Container cont = it.next();
			cont.fileName = getDefContainer().fileName;
			cont.containerObj.setTexture(
				getDefContainer().containerObj.getTexture());
			
		}
		return true;
	}
	
	/// Function that must have TextureManager defined for the class
	/// or else it will not work. Helper function that
	/// creates a texture and then creates a Sprite for that texture.
	/// By passes need for coder to use TextureManager on their own.
	public Sprite createSprite(String spriteName, String textureName,
		String fileName)
	{
		if(texManager == null)
		{
			return getDefContainer().containerObj;
		}
		
		return addContainer(spriteName, fileName, 
			new Sprite(texManager.loadResource(textureName, fileName)));
	} 
	
	/* Getters and Setters */
	public TextureManager getTextureManager()
	{
		return texManager;
	}
	
	/// Sets the TexutreManager, not necessary for handler to work.
	/// Use if you want to use faster adding of Sprites.
	/// If the given TextureManager is null, it will be set to null
	/// and the funciton will return false.
	public boolean setTextureManager(TextureManager texManager)
	{
		this.texManager = texManager;
		if(texManager == null)
			return false;

		return true;
	}
}