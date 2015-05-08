package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.logic.Enemy;
/**
 * Enemy that follows the player, constant velocity
 * @author Nicky
 *
 */
public class Alpha extends Enemy {
	public Alpha() {
		this(null, 150, 1, "Alpha" + Math.random());
	}

	public Alpha(Sprite player, int vel, int health, String name) {
		super(player, vel, health, name);
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Alpha", "texture/enemy.png");

		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 1000 + 500);
		getSprite().setY((float) Math.random() * 1000 + 500);
	}

	/**
	 * Attack Pattern for Alpha is simply to move towards the enemy at a fixed
	 * rate. dx and dy is the difference between the player and Alpha. theta
	 * turns the image to face the direction of the player.
	 * 
	 */
	@Override
	public void attackPattern(float dTime) {
		// TODO Auto-generated method stub

		if (getPlayer() == null) {
			removeGO(getName());
		}
		// TODO Auto-generated method stub
		else {
			float dx = getPlayer().getX() - getSprite().getX();
			float dy = getPlayer().getY() - getSprite().getY();
			float theta = (float) (180.0 / Math.PI * Math.atan(dy / dx) - 90.0);
			if (dx < 0) {
				theta += 180.0;
			}
			getSprite().setRotation(theta);
			setPosition(
					(float) (getSprite().getX() + dTime * getVel() * dx
							/ Math.sqrt(dx * dx + dy * dy)),
					(float) (getSprite().getY() + dTime * getVel() * dy
							/ Math.sqrt(dx * dx + dy * dy)));
		}

	}

}
