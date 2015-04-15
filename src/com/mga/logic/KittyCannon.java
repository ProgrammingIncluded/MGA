package com.mga.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class KittyCannon extends Weapon
{
	KittyCannon()
	{
		super(-1, 50, 1);
	}

	/**
	 * Moves the weapon.
	 */
	@Override
    public void move(Vector2 direction)
    {
		Vector2 resultPos = new Vector2();
		Sprite spr = getSprite();
		resultPos.x = spr.getX();
		resultPos.y = spr.getY();
		resultPos.add(direction.x*DEF_SPEED + DEF_DUR, direction.y*DEF_SPEED + DEF_DUR);
		getSprite().setPosition(resultPos.x, resultPos.y);
    }

	@Override
    public void rotate(int angle)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void tick(float dTime)
    {
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			move(new Vector2(1,0));
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			move(new Vector2(-1,0));
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			move(new Vector2(0,1));
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			move(new Vector2(0,-1));
		}
    }

}
