package com.mga.logic;

/**
 * A class that handles input. Should be used by Player in order to
 * prevent raw read of controls. This class allows separation of platform
 * inputs.
 * @author Charles Chen
 *
 */
public interface PlayerInput
{
	/* Movement Commands*/
	public boolean movLeft();
	public boolean movRight();
	public boolean movDown();
	public boolean movUp();
	
	/* Action Commands*/
	public boolean shoot();
	public boolean action();
}
