package com.mga.game.enemy;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.GameObject;
import com.mga.logic.Enemy;

public class EnemySpawner extends GameObject 
{
	protected Sprite player;
	protected ArrayList <Enemy> enemyArrayList;
	public EnemySpawner()
	{
		this(null);
	}
	public EnemySpawner(Sprite player)
	{
		this(player,"EnemySpawner"+Math.random());
	}

	public EnemySpawner(Sprite player,String name) 
	{
		super(name);
		this.player=player;
		enemyArrayList=new ArrayList<Enemy>();
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Alpha", "texture/enemy.png");
		//spr.setScale(0.2f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 500);
		getSprite().setY((float) Math.random() * 500);
		this.setIsVisible(false);
		// TODO Auto-generated constructor stub
		
	}

	

	public Sprite getPlayer()
	{
		return player;
	}
	public void setPlayer(Sprite player)
	{
		this.player = player;
	}
	public ArrayList<Enemy> getEnemyArrayList()
	{
		return enemyArrayList;
	}
	public void setEnemyArrayList(ArrayList<Enemy> enemyArrayList) 
	{
		this.enemyArrayList = enemyArrayList;
	}
	@Override
	public void tick(float dTime)
	{
		//new Beta(player, 500, 100, "Beta"+Math.random(), 0.5f,1f/24f,(float)(Math.PI/6));
		//new Beta(player, 1000, 100, "Beta"+Math.random());
		//new Alpha(player, 150, 100, "Alpha" + Math.random());
		//new Gamma(player, 50, 100, "Gamma" + Math.random());
		Enemy d=new Delta(player, 300, 200, "Delta"+Math.random());
		enemyArrayList.add(d);
		for (Iterator<Enemy> it = enemyArrayList.iterator(); it.hasNext() != false;)
		{
			Enemy enemy = it.next();
			if(enemy.isDead())
			{
				it.remove();
				removeGO(enemy.getName());
			}
		}
		System.out.println(enemyArrayList.size());
	}

}
