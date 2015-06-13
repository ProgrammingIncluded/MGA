package com.mga.logic.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mga.game.engine.GameObject;
import com.mga.game.engine.State;
import com.mga.game.engine.StateManager;

public class MenuState extends State{
	Label MGALabel;
	Label[] selectionLabels;
	int selectionLabelChooser;
	int tapLimiter;
	public MenuState() {
		// TODO Auto-generated constructor stub
		MGALabel=new Label("MGA!!!(?)!",new LabelStyle(new BitmapFont(),new Color(Color.WHITE)));
		selectionLabels=new Label[2];
		selectionLabels[0]=new Label("0: Play MGA",new LabelStyle(new BitmapFont(),new Color(Color.WHITE)));;
		selectionLabels[1]=new Label("1: Settings MGA",new LabelStyle(new BitmapFont(),new Color(Color.WHITE)));;
		selectionLabelChooser=0;
		tapLimiter=0;
	}

	@Override
	public void startUp(StateManager stateM) {
		// TODO Auto-generated method stub
		sprHandler.setTextureManager(texManager);
		Sound snd = sndHandler.createSound("TestSound", "audio/title2.mp3");
		snd.play();
		GameObject.intialize();
		
		
	}

	@Override
	public void draw(StateManager stateM) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		//background.draw(batch);
		//MGALabel.setText("MGA!!!(?)!");
		MGALabel.setPosition(Gdx.graphics.getWidth()/2-MGALabel.getOriginX(), Gdx.graphics.getHeight()/2-MGALabel.getOriginY());
		MGALabel.draw(batch, 1.f);
		
		for(int i=0;i<2;i++){
			selectionLabels[i].setPosition(Gdx.graphics.getWidth()/2-MGALabel.getOriginX(), Gdx.graphics.getHeight()/2-MGALabel.getOriginY()-50*(i+1));
			selectionLabels[i].draw(batch, 1.f);
		}
		batch.end();
		
		
	}

	@Override
	public void update(StateManager stateM) {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Input.Keys.UP)&&tapLimiter>10){
			selectionLabelChooser=(selectionLabelChooser+1)%2;
			tapLimiter=0;
		
		}
		tapLimiter++;
		switch(selectionLabelChooser){
		case 0:
			selectionLabels[0].setColor(Color.YELLOW);
			selectionLabels[1].setColor(Color.GRAY);
			break;
		case 1:
			selectionLabels[0].setColor(Color.GRAY);
			selectionLabels[1].setColor(Color.YELLOW);
			break;
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause(StateManager stateM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume(StateManager stateM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanUp(StateManager stateM) {
		// TODO Auto-generated method stub
		
	}

}
