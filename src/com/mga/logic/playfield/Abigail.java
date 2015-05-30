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
	boolean isDead = false;
	Vector2 movSpeed = new Vector2(100f, 100f);
	
	public Abigail()
	{
		super("Abigail");
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Abigail", "textures/ERRTEX.jpg");
		spr.setScale(1);
		this.setSprite(spr);
		this.setAnimation(20, 5, 0.01f);
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
	   System.out.println(this.getName() + " colliding with " + colObj.getName());
    }
}
