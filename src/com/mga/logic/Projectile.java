package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;
import com.mga.game.engine.GameObject;
import com.mga.logic.playfield.Nicholas;

/**
 * Project that is in charge of sending information packets across different
 * @author Nicky & Charles
 *
 */
public abstract class Projectile extends CollisionObject {
	protected float damage;
	protected GameObject owner;
	
	// If negative then no vanish time.
	protected float timeLimit;
	
	public Projectile() {
		// TODO Auto-generated constructor stub
		this("Projectile"+Math.random());
		
	}
	public Projectile(String name){
		this(name,25.f);
	}

	public Projectile(String name,float damage) {
		this(name,damage,null);
	}
	
	public Projectile(GameObject owner){
		this("Projectile"+Math.random(),25.f,owner);
	}
	
	public Projectile(String name,float damage,GameObject owner) {
		super(name);
		this.damage=damage;
		this.owner=owner;
		timeLimit=0;
		Sprite spr = this.getSpriteHandler().createSprite(
				this.getName(), "Abigail", "texture/Pac/dot.png");
		//spr.setScale(0.5f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		// DELETE
		if(owner!=null)
		{
			setPosition(owner.getSprite().getX(),owner.getSprite().getY());
		}
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public GameObject getOwner() {
		return owner;
	}
	
	public boolean setOwner(GameObject owner) {
		if(owner == null)
			return false;
		this.owner = owner;
		return true;
	}
	
	@Override
	public void collided(CollisionObject colObj) {
		
	}
	
	@Override
	public void tick(float dTime) {
		bulletTick(dTime);
		timeLimit += dTime;
		if(timeLimit>5){
			CollisionObject.removeGO(getName());
			this.setIsCollidable(false);
		}
	}
	
	// Overided function 
	public abstract void bulletTick(float deltaTime);
}
