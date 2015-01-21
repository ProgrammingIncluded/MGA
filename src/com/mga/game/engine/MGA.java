package com.mga.game.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.mga.logic.Config;

public class MGA extends ApplicationAdapter 
{	
	private static StateManager stateManager;
	private static TextureManager texManager;
	private static SpriteHandler sprHandler;
	private static SoundHandler sndHandler;

	/* Static Functions */
	public static TextureManager getTextureManager()
	{
		return texManager;
	}
	
	public static SpriteHandler getSpriteHandler()
	{
		return sprHandler;
	}
	
	public static SoundHandler getSoundHandler()
	{
		return sndHandler;
	}
	
	public static StateManager getStateManger()
	{
		return stateManager;
	}
	
	@Override
	public void create() 
	{
		// Start managers.
		stateManager = new StateManager();
		texManager = new TextureManager();
		sprHandler = new SpriteHandler(texManager.getErrorResource().resource);
		sndHandler = new SoundHandler();
		
		stateManager.pushState(Config.DEF_STATE);
	}

	@Override
	public void render() 
	{
		stateManager.draw();
	}
	
	@Override
    public void resize (int width, int height) 
	{ 
		stateManager.resize(width, height);
	}

	@Override
	public void pause() 
	{ 
		stateManager.pause();
	}

	@Override
    public void resume() 
	{
		stateManager.resume();
    }

	@Override
    public void dispose()
	{ 
		stateManager.quit();
		stateManager.exit();
    }
}
