package com.mga.game.engine;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Class in charge of animations.
 * @author Charles Chen
 */
public class AnimatedGameObject extends GameObject {
	protected TextureRegion[] frames;
	protected Animation animation;
	
	
	
	@Override
	public void tick(float dTime) {
		getSprite().getTexture();
	}
}