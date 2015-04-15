package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mga.game.engine.GameObject;
import com.mga.game.engine.State;
import com.mga.game.engine.StateManager;

public class TitleState extends State
{	
	public TitleState()
	{
		super();
	}
	
	@Override
	public void startUp(StateManager stateM)
	{
		//img = new Texture("badlogic.jpg"); 
		sprHandler.setTextureManager(texManager);
		Sound snd = sndHandler.createSound("TestSound", "audio/stroll.wav");
		snd.play();
		GameObject.intialize();
		new KittyCannon();
	}

	@Override
	public void draw(StateManager stateM)
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameObject.draw();
	}

	@Override
	public void update(StateManager stateM)
	{
		GameObject.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height)
	{
		
	}

	@Override
	public void pause(StateManager stateM)
	{
		
	}

	@Override
	public void resume(StateManager stateM)
	{
		
	}

	@Override
	public void cleanUp(StateManager stateM)
	{
		
	}
	
}
