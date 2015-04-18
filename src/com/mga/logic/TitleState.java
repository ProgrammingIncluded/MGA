package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.mga.game.engine.*;
import com.mga.logic.playfield.Abigail;
import com.mga.logic.playfield.Cone;

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
		Abigail a=new Abigail();
		// Create the cones!
		//new ConeGenerator();
		//new Alpha(a.getSprite(),50,1,"Alpha");
		//new Alpha(a.getSprite(),800,1,"Alpha");
		new Beta(a.getSprite(),400,1,"Beta",3);
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
