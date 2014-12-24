package com.mga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MGA extends ApplicationAdapter 
{
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg"); 
		TextureManager texManager = new TextureManager();
		img = texManager.loadResource("hellopic", "badlogic.jpg");
		texManager.updateResource("hellopic", "dfsfdajklf;js");
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
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
