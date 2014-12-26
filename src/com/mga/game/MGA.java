package com.mga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MGA extends ApplicationAdapter 
{
	SpriteBatch batch;
	Sprite img;
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg"); 
		TextureManager texManager = new TextureManager();
		SpriteHandler sprHandler = new SpriteHandler(
			texManager.loadResource(TextureManager.DEF_FILE_NAME, 
			TextureManager.DEF_RSRC_NAME));
		sprHandler.setTextureManager(texManager);
		img = sprHandler.createSprite("THIS SHOULD WORK, BACON", 
			"shouldwork", "badlogic.jpg");
		sprHandler.resourceDeleted("badlogic.jpg");
		texManager.unloadResource("shouldwork");
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		img.draw(batch);
		batch.end();
	}
	
	@Override
    public void resize (int width, int height) 
	{ 
   
	}

	@Override
	public void pause () 
	{ 
    
	}

	@Override
    public void resume () 
	{
    
    }

	@Override
    public void dispose ()
	{ 
		
    }
}
