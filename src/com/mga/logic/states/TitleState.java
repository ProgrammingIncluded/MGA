package com.mga.logic.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mga.game.engine.MGA;
import com.mga.game.engine.State;
import com.mga.game.engine.StateManager;

public class TitleState extends State
{
	Sprite logo;
	int timer = 0;
	int waitTime = 300;
	public TitleState()
	{
		super();
	}
	
	@Override
	public void startUp(StateManager stateM)
	{
		sprHandler.setTextureManager(texManager);
		logo = sprHandler.createSprite("LOGO", "Logo", "textures/logo.png");
		logo.setAlpha(0);
	}

	@Override
	public void draw(StateManager stateM)
	{
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		//background.draw(batch);
		logo.draw(batch);
		batch.end();
	}

	@Override
	public void update(StateManager stateM)
	{
		logo.setPosition(Gdx.graphics.getWidth()/2 - logo.getOriginX(), Gdx.graphics.getHeight()/2 - logo.getOriginY());
		
		if(timer < waitTime/2)
			logo.setAlpha((timer/(waitTime/2.f)));
		else
			logo.setAlpha((1.f-(timer/(waitTime/2.f))));
		
		if(timer >= waitTime)
		{
			// TODO add delete pixel.
			sprHandler.deleteContainer("LOGO");
			this.texManager.removeResource("Logo");
			stateM.popState();
			stateM.pushState(new MenuState());			
		}
		++timer;
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
			timer = waitTime;
		}
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
