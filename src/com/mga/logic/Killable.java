package com.mga.logic;


/**
 * Any GameObject that can be killed must implement this class.
 */

public interface Killable
{
	/**
	 * Function to check whether or not the object meets a certain
	 * criteria to be consider dead.
	 */
	public boolean isDead();
	
	/**
	 * Function that should be called when the implemented class
	 * passes the check to be dead. What happens is upto the implementer.
	 * Delete, etc...
	 */
	public boolean kill();
}
