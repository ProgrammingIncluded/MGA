package com.mga.game.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.mga.logic.Config;
import com.mga.logic.states.TitleState;

public class MGA extends ApplicationAdapter 
{	
	/*Manager and Handlers*/
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
		// Load default files. If not exist, leave.
		if(!Config.loadConfigFile())
		{
			System.out.println("Unable to load default files. Exiting.");
			System.exit(1);
		}
			
		// Start managers.
		stateManager = new StateManager();
		texManager = new TextureManager();
		sprHandler = new SpriteHandler(texManager.getErrorResource().resource);
		sndHandler = new SoundHandler();
		
		sprHandler.setTextureManager(texManager);
		
		// Create default state.
		stateManager.pushState(new TitleState());
	}

	@Override
	public void render() 
	{
		stateManager.update();
		
		if(stateManager.isQuit == true)
			System.exit(0);
		
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
