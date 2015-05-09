package com.mga.game.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Class in charge of animations.
 * @author Charles Chen
 */
public abstract class AnimatedGameObject extends GameObject {
	public final static float DEF_PLAYBACK_SPEED = 1.0f;
	
	protected TextureRegion[] frames;
	protected Animation animation;
	protected float animationTime;
	
	AnimatedGameObject()
	{
		this(DEF_GO_NAME, null, 1, 1, DEF_PLAYBACK_SPEED);
	}
	
	AnimatedGameObject(Sprite spr, int cols, int rows, float pbSpeed)
	{
		this(DEF_GO_NAME, null, cols, rows, pbSpeed);
	}
	
	AnimatedGameObject(String name)
	{
		this(name, null, 1, 1, DEF_PLAYBACK_SPEED);
	}
	
	AnimatedGameObject(String name, Sprite spr, int cols, int rows, float pbSpeed)
	{
		super(name, spr);
		Texture thisSprite = getSprite().getTexture();
		TextureRegion[][] tmp = TextureRegion.split(thisSprite, 
			thisSprite.getWidth()/cols, thisSprite.getHeight()/rows);
		int index = 0;
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                frames[index++] = tmp[i][j];
            }
        }
        animation = new Animation(pbSpeed, frames);
        animationTime = 0;
	}
}