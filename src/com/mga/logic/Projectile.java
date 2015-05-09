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
	protected float damage;
	public Projectile() {
		// TODO Auto-generated constructor stub
		this("Projectile"+Math.random());
		
	}
	public Projectile(String name){
		this(name,25.f);
	}

	public Projectile(String name,float damage) {
		super(name);
		this.damage=damage;
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Abigail", "texture/Pac/dot.png");
		//spr.setScale(0.5f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		// TODO Auto-generated constructor stub
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	@Override
	public void collided(CollisionObject colObj) {
		if(colObj instanceof Shootable){
			CollisionObject.removeGO(getName());
		}
		

	}

	@Override
	public void tick(float dTime) {
		setPosition(getSprite().getX(),getSprite().getY()+dTime*300);
		
	}

}
