package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class AlphaSpawner extends EnemySpawner<Alpha> {

	public AlphaSpawner() {
		this(null);
	}

	public AlphaSpawner(Sprite player) {
		this(player, "AlphaSpawner" + Math.random());
	}

	public AlphaSpawner(Sprite player, String name) {

		super(player, name);

	}

	public AlphaSpawner(Sprite player, String name, float chargeMax,
			float minX, float minY, float maxX, float maxY) {
		super(player, name, chargeMax, minX, minY, maxX, maxY);
	}

	@Override
	protected Alpha createEnemy() {
		return new Alpha(getPlayer(), 300, 100, "Alpha" + Math.random(),
				(float) (minX + Math.random() * (maxX - minX)),
				(float) (minY + Math.random() * (maxY - minY)));
	}

}
