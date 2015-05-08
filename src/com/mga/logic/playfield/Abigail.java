package com.mga.logic.playfield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.mga.game.engine.CollisionObject;
import com.mga.game.engine.MGA;

/**
 * Test class for GameObject.
 *
 */
public class Abigail extends CollisionObject
{
	/* Local Variables */
	public boolean isDead = false;
	Vector2 movSpeed = new Vector2(400f, 400f);
	
	public Abigail()
	{
		super("Abigail");
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Abigail", "texture/Pac/dot.png");
		spr.setScale(0.5f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		//this.setPosition((float)(Math.random()*500), (float)(Math.random()*500));
	}

	@Override
	public void tick(float dTime)
	{
		Sprite miniCube = this.getSprite();
		Vector2 moveVect = new Vector2(miniCube.getX(), miniCube.getY());
		Vector2 movSpeed = new Vector2(this.movSpeed);
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
		{
			movSpeed.set(movSpeed.x*2f, movSpeed.y*2f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D))
		{
			moveVect.add(movSpeed.x * dTime, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A))
		{
			moveVect.add(-movSpeed.x * dTime, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W))
		{
			moveVect.add(0, movSpeed.y * dTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S))
		{
			moveVect.add(0, -movSpeed.y * dTime);
		}
		

		miniCube.setPosition(moveVect.x, moveVect.y);
	}
	
	public void die()
	{
		isDead = true;
	}

	@Override
    public void collided(CollisionObject colObj)
    {
	   die();
    }
}
