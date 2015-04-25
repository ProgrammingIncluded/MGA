package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mga.game.engine.CollisionObject;
import com.mga.game.engine.GameObject;
import com.mga.game.engine.State;
import com.mga.game.engine.StateManager;
import com.mga.logic.playfield.Abigail;
import com.mga.logic.playfield.Cone;
import com.mga.logic.playfield.ConeGenerator;

public class TitleState extends State
{
	Abigail abig;
	Sprite background;
	public TitleState()
	{
		super();
	}
	
	@Override
	public void startUp(StateManager stateM)
	{
		sprHandler.setTextureManager(texManager);
		Sound snd = sndHandler.createSound("TestSound", "audio/title2.mp3");
		snd.play();
		GameObject.intialize();
		
		background = sprHandler.createSprite("Air", "Air", "texture/dawn1.png");
		background.setScale(12f,10f);
		
		abig = new Abigail();
		for(int x = 0; x < 1; ++x)
		{
			Beta b = 
			new Beta(abig.getSprite(), 500, 100, "EnemyTwo"+Math.random(), 2.f);
			b.getSprite().setX((float)Math.random()*1000 + 500);
			b.getSprite().setY((float)Math.random()*1000 + 500);
			Alpha a = new Alpha(abig.getSprite(), 150, 100, "Enemy" + Math.random());
			a.getSprite().setX((float)Math.random()*1000 + 500);
			a.getSprite().setY((float)Math.random()*1000 + 500);
			Gamma g = new Gamma(abig.getSprite(), 150, 100, "EnemyThree" + Math.random());
			g.getSprite().setX((float)Math.random()*1000 + 500);
			g.getSprite().setY((float)Math.random()*1000 + 500);
		}

	}

	@Override
	public void draw(StateManager stateM)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		background.draw(batch);
		batch.end();
		GameObject.draw();
	}

	@Override
	public void update(StateManager stateM)
	{
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			stateM.exit();
		if(Gdx.input.isKeyPressed(Input.Keys.O))
			Cone.OVERLAP = !Cone.OVERLAP;
		if(abig.isDead)
		{
			abig.getSprite().setPosition((float)(Math.random()*500), (float)(Math.random()*500));
			abig.isDead = false;
		}
		// Order of call does not matter, but best for update col after GO.
		GameObject.update(Gdx.graphics.getDeltaTime());
		CollisionObject.updateCollision();
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
