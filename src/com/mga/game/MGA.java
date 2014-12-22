package com.mga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

<<<<<<< HEAD
public class MGA extends ApplicationAdapter 
{
=======
public class MGA extends ApplicationAdapter {
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
	SpriteBatch batch;
	Texture img;
	
	@Override
<<<<<<< HEAD
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
=======
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
<<<<<<< HEAD
    public void resize (int width, int height) 
	{ 
=======
    public void resize (int width, int height) { 
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
   
	}

	@Override
<<<<<<< HEAD
	public void pause () 
	{ 
=======
	public void pause () { 
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
    
	}

	@Override
<<<<<<< HEAD
    public void resume () 
	{
=======
    public void resume () {
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
    
    }

	@Override
<<<<<<< HEAD
    public void dispose ()
	{ 
=======
    public void dispose () { 
>>>>>>> ac6383259288cb81d4281fa7a4f8adcf411848e0
		
    }
}
