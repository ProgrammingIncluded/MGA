package com.mga.game.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.mga.logic.Config;

public class TextureManager extends ResourceManager<Texture>
{
	/* Static Values */
	static final String DEF_RSRC_NAME = Config.DEF_TEX_NAME;
	static final String DEF_FILE_NAME = Config.DEF_TEX_FILE_NAME;
	
	public TextureManager()
	{
		this(DEF_RSRC_NAME, DEF_FILE_NAME,
			new Texture(Gdx.files.internal(DEF_FILE_NAME))); 
	}
	
	public TextureManager(String defRsrcName, String defFileName,
		Texture defRsrcObj)
	{
		super(defRsrcName, defFileName, defRsrcObj);
		// TODO Auto-generated constructor stub
	}
	
	public Texture loadResource(String name, String fileName)
	{
		if(resourceExists(name))
		{
			return getResource(name).resource;
		}
		
		FileHandle file = Gdx.files.internal(fileName);
		if(file.exists() == false)
		{
			return getErrorResource().resource;
		}

		Resource rsrc = new Resource();
		rsrc.name = name;
		rsrc.fileName = fileName;
		rsrc.resource = new Texture(file);
		addResource(rsrc);

		return rsrc.resource;
	}
	
	public boolean unloadResource(String name)
	{
		getResource(name).resource.dispose();
		return removeResource(name);
	}
	
	/// Updates the texture. If given filename does not work,
	/// will assign said texture to err tex. If filename does not exist
	/// then it will still return true, but the texture will still
	/// be assigned to error.
	public boolean updateResource(String name, String fileName)
	{
		if(!resourceExists(name))
		{
			return false;
		}
		
		Resource rsrc = getResource(name);
		
		FileHandle file = Gdx.files.internal(fileName);
		if(file.exists() == false)
		{
			rsrc.fileName = getErrorResource().fileName;
			rsrc.resource.dispose();
			rsrc.resource = getErrorResource().resource;
			return true;
		}
		rsrc.fileName = fileName;
		// Dispose resource
		rsrc.resource = new Texture(file);
		return true;
	}
}
