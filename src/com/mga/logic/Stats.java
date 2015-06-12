package com.mga.logic;

public class Stats {
	int health;
	int stamina;
	int strength;
	
	Stats()
	{
		health = 100;
		stamina = 100;
		strength = 100;
	}
	
	Stats(int health, int stamina, int strength)
	{
		this.health = health;
		this.stamina = stamina;
		this.strength = strength;
	}
}
