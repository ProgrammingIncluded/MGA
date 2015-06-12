package com.mga.game.enemy;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mga.game.engine.GameObject;
import com.mga.logic.Enemy;
import com.mga.logic.Score;

public abstract class EnemySpawner<T extends Enemy> extends GameObject 
{
	protected Sprite player;
	protected ArrayList <T> enemyArrayList;
	protected float chargeTime, chargeMax;
	protected float minX,minY,maxX,maxY;
	protected Score score;
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
		
		this(player,name,1,330,330,330,330);
		
	}
	

	

	public EnemySpawner(Sprite player,String name, float chargeMax,float minX,float minY,float maxX,float maxY) {
		super(name);
		this.player=player;
		enemyArrayList=new ArrayList<T>(10);
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Alpha", "texture/enemy.png");
		//spr.setScale(0.2f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 500);
		getSprite().setY((float) Math.random() * 500);
		this.setIsVisible(false);
		chargeTime = 0.f;
		this.chargeMax = chargeMax;
		this.minX=minX;
		this.minY=minY;
		this.maxX=maxX;
		this.maxY=maxY;
	}
	public EnemySpawner(Sprite player,String name, float chargeMax,float minX,float minY,float maxX,float maxY,int maxEnemies) {
		super(name);
		this.player=player;
		enemyArrayList=new ArrayList<T>(maxEnemies);
		Sprite spr = this.getSpriteHandler().createSprite(this.getName(),
				"Alpha", "texture/enemy.png");
		//spr.setScale(0.2f); // TODO: Add sprite scaling for all.
		this.setSprite(spr);
		getSprite().setX((float) Math.random() * 500);
		getSprite().setY((float) Math.random() * 500);
		this.setIsVisible(false);
		chargeTime = 0.f;
		this.chargeMax = chargeMax;
		this.minX=minX;
		this.minY=minY;
		this.maxX=maxX;
		this.maxY=maxY;
	}
	
	public float getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(float chargeTime) {
		this.chargeTime = chargeTime;
	}
	public float getChargeMax() {
		return chargeMax;
	}
	public void setChargeMax(float chargeMax) {
		this.chargeMax = chargeMax;
	}
	public float getMinX() {
		return minX;
	}
	public void setMinX(float minX) {
		this.minX = minX;
	}
	public float getMinY() {
		return minY;
	}
	public void setMinY(float minY) {
		this.minY = minY;
	}
	public float getMaxX() {
		return maxX;
	}
	public void setMaxX(float maxX) {
		this.maxX = maxX;
	}
	public float getMaxY() {
		return maxY;
	}
	public void setMaxY(float maxY) {
		this.maxY = maxY;
	}
	public Sprite getPlayer()
	{
		return player;
	}
	public void setPlayer(Sprite player)
	{
		this.player = player;
	}
	public ArrayList<T> getEnemyArrayList()
	{
		return enemyArrayList;
	}
	public void setEnemyArrayList(ArrayList<T> enemyArrayList) 
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
		chargeTime+=dTime;
		if(chargeTime>chargeMax){
			chargeTime=0;
			T d=createEnemy();
			enemyArrayList.add(d);
		}
		for (Iterator<T> it = enemyArrayList.iterator(); it.hasNext() != false;)
		{
			T enemy = it.next();
			if(enemy.isDead())
			{
				score.addPoints(1);
				it.remove();
				removeGO(enemy.getName());
			}
		}
			//System.out.println(enemyArrayList.size());
		
	}
	public void setScoreBoard(Score s){
		score=s;
	}
	
	protected abstract T createEnemy();

}
