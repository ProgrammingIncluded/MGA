package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mga.game.engine.CollisionObject;

/**
 * Does nothing at the moment expect exist.
 * @author Nicky
 *
 */
public class Projectile extends CollisionObject {

	public Projectile(Rectangle bound) {
		super(bound);
		// TODO Auto-generated constructor stub
	}

	public Projectile() {
		// TODO Auto-generated constructor stub
	}

	public Projectile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Projectile(Sprite defSprite) {
		super(defSprite);
		// TODO Auto-generated constructor stub
	}

	public Projectile(Rectangle bound, String name, Sprite defSprite) {
		super(bound, name, defSprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collided(CollisionObject colObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tick(float dTime) {
		// TODO Auto-generated method stub

	}

}
