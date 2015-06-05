package com.mga.game.enemy;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class DeltaSpawner extends EnemySpawner<Delta> {

	public DeltaSpawner() {
		this(null);
	}

	public DeltaSpawner(Sprite player) {
		this(player, "EnemySpawner" + Math.random());
	}

	public DeltaSpawner(Sprite player, String name) {

		super(player, name);

	}

	public DeltaSpawner(Sprite player, String name, float chargeMax,
			float minX, float minY, float maxX, float maxY) {
		super(player, name, chargeMax, minX, minY, maxX, maxY);
	}

	@Override
	protected Delta createEnemy() {
		return new Delta(getPlayer(), 300, 100, "Delta" + Math.random(),
				(float) (minX + Math.random() * (maxX - minX)),
				(float) (minY + Math.random() * (maxY - minY)),
				(float) (Math.PI / 4), 100.f);
	}

}
