package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mga.game.engine.CollisionObject;
import com.mga.game.engine.GameObject;
import com.mga.game.engine.State;
import com.mga.game.engine.StateManager;
import com.mga.logic.playfield.Abigail;
import com.mga.logic.playfield.Cone;
import com.mga.logic.playfield.ConeGenerator;

public class TitleState extends State
<<<<<<< HEAD
{	
=======
{
>>>>>>> c0971885945fdeadd552dcfcd54a0dd3be4aa064
	public TitleState()
	{
		super();
	}
	
	@Override
	public void startUp(StateManager stateM)
	{
		//img = new Texture("badlogic.jpg"); 
		sprHandler.setTextureManager(texManager);
<<<<<<< HEAD
		Sound snd = sndHandler.createSound("TestSound", "audio/stroll.wav");
		snd.play();
		GameObject.intialize();
		new KittyCannon();
=======
		/*
		img = sprHandler.createSprite("testSprite", 
			"shouldwork", "texture/badlogic.jpg");
		// Function order to call when deleting resources.
		sprHandler.resourceDeleted("texture/badlogic.jpg");
		texManager.removeResource("shouldword");
		*/
		Sound snd = sndHandler.createSound("TestSound", "audio/title2.mp3");
		snd.play();
		GameObject.intialize();
		new Abigail();
		// Create the cones!
		new ConeGenerator();
>>>>>>> c0971885945fdeadd552dcfcd54a0dd3be4aa064
	}

	@Override
	public void draw(StateManager stateM)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameObject.draw();
	}

	@Override
	public void update(StateManager stateM)
	{
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			stateM.exit();
		if(Gdx.input.isKeyPressed(Input.Keys.O))
			Cone.OVERLAP = !Cone.OVERLAP;
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
