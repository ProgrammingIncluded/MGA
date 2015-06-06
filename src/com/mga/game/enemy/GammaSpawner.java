package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GammaSpawner extends EnemySpawner<Gamma> {

	public GammaSpawner() {
		this(null);
	}

	public GammaSpawner(Sprite player) {
		this(player, "GammaSpawner" + Math.random());
	}

	public GammaSpawner(Sprite player, String name) {

		super(player, name);

	}

	public GammaSpawner(Sprite player, String name, float chargeMax,
			float minX, float minY, float maxX, float maxY) {
		super(player, name, chargeMax, minX, minY, maxX, maxY);
	}

	@Override
	protected Gamma createEnemy() {
		return new Gamma(getPlayer(), 50, 100, "Gamma" + Math.random(),
				(float) (minX + Math.random() * (maxX - minX)),
				(float) (minY + Math.random() * (maxY - minY)),100);
		//new Gamma(abig.getSprite(), 50, 100, "Gamma" + Math.random(),100);
	}

}
