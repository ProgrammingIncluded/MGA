package com.mga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
		SpriteHandler sprHandler =
			new SpriteHandler(texManager.getErrorResource().resource);
		sprHandler.setTextureManager(texManager);
		img = sprHandler.createSprite("testSprite", 
			"shouldwork", "texture/badlogic.jpg");
		sprHandler.resourceDeleted("texture/badlogic.jpg");
		texManager.removeResource("shouldword");
		SoundHandler sndHandler = new SoundHandler();
		Sound snd = sndHandler.createSound("TestSound", "audio/stroll.wav");
		snd.play();
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
