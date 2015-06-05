package com.mga.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.CollisionObject;
import com.mga.game.engine.GameObject;
import com.mga.logic.playfield.Abigail;

/**
 * Does nothing at the moment expect exist.
 * @author Nicky
 *
 */
public abstract class Projectile extends CollisionObject {
	protected float damage;
	protected GameObject owner;
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
		if(owner!=null){
			setPosition(owner.getSprite().getX(),owner.getSprite().getY());
		}
		// TODO Auto-generated constructor stub
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
	public void setOwner(GameObject owner) {
		this.owner = owner;
	}
	@Override
	public void collided(CollisionObject colObj) {
		if(colObj instanceof Shootable&&this.getOwner().getName().equals("Abigail")){
			CollisionObject.removeGO(getName());
			this.setIsCollidable(false);
			
		}
		if(colObj instanceof Abigail&&!this.getOwner().getName().equals("Abigail")){
			CollisionObject.removeGO(getName());
			this.setIsCollidable(false);
		}
		

	}
	
	@Override
	public void tick(float dTime) {
		flightPattern(dTime);
		timeLimit+=dTime;
		if(timeLimit>5){
			CollisionObject.removeGO(getName());
			this.setIsCollidable(false);
		}
		
	}
	
	public abstract void flightPattern(float dTime);

}
