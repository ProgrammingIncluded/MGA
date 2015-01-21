package com.mga.game.engine;

public abstract class State
{
	protected TextureManager texManager;
	protected SpriteHandler sprHandler;
	protected SoundHandler sndHandler;
	
	public State()
	{
		texManager = MGA.getTextureManager();
		sprHandler = MGA.getSpriteHandler();
		sndHandler = MGA.getSoundHandler();
	}
	
	public abstract void startUp(StateManager stateM);
	public abstract void draw(StateManager stateM);
	public abstract void update(StateManager stateM);
	public abstract void resize(int width, int height);
	public abstract void pause(StateManager stateM);
	public abstract void resume(StateManager stateM);
	public abstract void cleanUp(StateManager stateM);
}
