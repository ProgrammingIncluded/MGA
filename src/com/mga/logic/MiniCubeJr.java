package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mga.game.engine.GameObject;
import com.mga.game.engine.MGA;

/**
 * Test class for GameObject.
 *
 */
public class MiniCubeJr extends GameObject
{
	/* Local Variables */
	boolean isDead = false;
	Vector2 movSpeed = new Vector2(100f, 100f);
	
	MiniCubeJr()
	{
		super("CubeJr");
		this.setSprite(
			this.getSpriteHandler().createSprite(
			this.getName(), "CubeJr", "texture/CubeJr.png"));
	}

	@Override
	public void tick(float dTime)
	{
		Sprite miniCube = this.getSprite();
		Vector2 moveVect = new Vector2(miniCube.getX(), miniCube.getY());
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			moveVect.add(movSpeed.x * dTime, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			moveVect.add(-movSpeed.x * dTime, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			moveVect.add(0, movSpeed.y * dTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			moveVect.add(0, -movSpeed.y * dTime);
		}
		miniCube.setPosition(moveVect.x, moveVect.y);
	}
	
	public void die()
	{
		isDead = true;
	}
}
