package com.mga.game.engine;

import java.util.LinkedList;

/**
 * Manager to container multiple States. Allows for 
 * modular logic in our game. Custom code for our game to seperate
 * dependency on library specific code.
 * @author Charles
 *
 */
public class StateManager
{
	LinkedList<State> states;
	boolean isQuit;
	
	StateManager()
	{
		isQuit = false;
		states = new LinkedList<State>();
	}
	
	/**
	 * Returns whether or not Quit has been called in StateManager.
	 */
	public boolean isRunning()
	{
		return !isQuit;
	}
	
	/**
	 * Pushes a new state into the class.
	 */
	public void pushState(State state)
	{
		if(!isQuit)
		{
			if(state == null)
				return;
			
			if(!states.isEmpty())
			{
				State prevState = states.peek();
				prevState.pause(this);
			}
			
			states.push(state);
			state.startUp(this);
		}
	}
	
	/**
	 * Pop's the State to switch to the next state.
	 */
	public void popState()
	{
		if(!isQuit)
		{
			State state = states.pop();
			state.cleanUp(this);
			if(states.size() != 0)
			{
				states.peek().resume(this);
			}
		}
	}
	
	/**
	 * Calls the draw function on the current active State.
	 */
	public void draw()
	{
		if(states.size() != 0)
		{
			states.getFirst().draw(this);
		}
		exit();
	}

	/**
	 * Calls the resize function on the current active State.
	 */
	public void resize(int width, int height)
	{
		if(states.size() != 0)
		{
			states.getFirst().resize(width, height);
		}
		exit();
	}
	
	
	/**
	 * Calls the update function on the current active State.
	 */
	public void update()
	{
		if(states.size() != 0)
		{
			states.getFirst().update(this);
		}
		exit();
	}
	
	/**
	 * Calls the pause function on the current active State.
	 */
	public void pause()
	{
		if(states.size() != 0)
		{
			states.getFirst().pause(this);
		}
		exit();
	}
	
	/**
	 * Calls the resume function on the current active State.
	 */
	public void resume()
	{
		if(states.size() != 0)
		{
			states.getFirst().resume(this);
		}
		exit();
	}
	
	/**
	 * Function to clean up active state. Without
	 * starting the next one. Unlike pop state. isQuit
	 * must be true.
	 */
	public void exit()
	{
		if(isQuit)
		{
			if(states.size() != 0)
				states.getFirst().cleanUp(this);
		}
	}
	
	/**
	 * Call this function if you want to close application.
	 */
	public void quit()
	{
		isQuit = true;
	}
}
