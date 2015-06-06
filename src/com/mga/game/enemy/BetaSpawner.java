package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class BetaSpawner extends EnemySpawner<Beta> {

	public BetaSpawner() {
		this(null);
	}

	public BetaSpawner(Sprite player) {
		this(player, "BetaSpawner" + Math.random());
	}

	public BetaSpawner(Sprite player, String name) {

		super(player, name);

	}

	public BetaSpawner(Sprite player, String name, float chargeMax,
			float minX, float minY, float maxX, float maxY) {
		super(player, name, chargeMax, minX, minY, maxX, maxY);
	}

	@Override
	protected Beta createEnemy() {
		return new Beta(getPlayer(),300, 100, "Beta" + Math.random(),
				(float) (minX + Math.random() * (maxX - minX)),
				(float) (minY + Math.random() * (maxY - minY)),0.5f,1f/24f,(float)(Math.PI/6));
		//new Beta(abig.getSprite(), 500, 100, "Beta"+Math.random(), 0.5f,1f/24f,(float)(Math.PI/6));
	}

}
