package pokemon;

import java.util.ArrayList;

/**
 * The Pokemon class represents a Pokemon from the Red and Blue versions of the Gameboy
 * game Pocket Monsters.  Pokemon are specified by their name and stats, meaning that
 * new Pokemon can be created.
 * 
 * @author Aaron Frazer
 *
 */
public class Pokemon
{
	private String name;
	private int level, health, attack, defense;
	private Enum type;
	private boolean alive;
	private ArrayList<Attack> attacks;
	
	/**
	 * Constructs a Pokemon.
	 * 
	 * @param name 		- the name of the Pokemon
	 * @param level		- the level
	 * @param health 	- amount of starting health
	 * @param attack 	- the attack stat
	 * @param defense 	- the defense stat
	 * @param type 		- the Pokemon's type
	 */
	public Pokemon(String name, int level, int health, int attack, int defense, Type type)
	{
		this.name = name;
		this.level = level;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.type = type;
		this.alive = true;
		this.attacks = new ArrayList<Attack>();
	}
	
	/**
	 * Constructs a Pokemon.
	 * 
	 * @param name - the name of the Pokemon
	 * @param level - the level
	 * @param type - the Pokemon's type
	 */
	public Pokemon(String name, int level, Type type)
	{
		this.name = name;
		this.level = level;
		this.type = type;
		this.alive = true;
		this.attacks = new ArrayList<Attack>();
	}
	
	/**
	 * Decreases a Pokemon's health points.
	 * 
	 * @param damage - the damage amount, should never be < 0
	 */
	public void hurt(int damage)
	{
		if (damage > 0)
			health = health - damage;
		
		if (health <= 0)
		{
			health = 0;
			alive = false;
		}
	}

	/**
	 * Causes a Pokemon to attack another Pokemon.  The attack is specified
	 * by its base damage, critical hit modifier, type modifier, Same-Type Attack
	 * Bonus and random modifier.  The other stats for computing damage belong to
	 * the attacking Pokemon.  Assume that other is 1.0.  The method should print
	 * the name of the attacking and defending Pokemon, as well as the damage done.
	 * A critical hit message should be printed if critical equals 2.0.  Also print
	 * whether the target faints.  The method should compute the damage of the attack
	 * and call hurt() to decrease the health of the target Pokemon.
	 *
	 * @param target - the defending Pokemon
	 * @param base - the base damage of the attack
	 * @param critical - the critical damage modifier: 1.0 for non-critical, 2.0 for critical
	 * @param typeModifier - the type damage modifier: {0.25, 0.5, 1.0, 2.0, 4.0}
	 * @param STAB - the Same Type Attack Bonus: either 1.0 or 1.5
	 * @param random - a random value between [0.85, 1.0]
	 * @return damage - the damage done, as a rounded-down integer
	 */
	public int attack(Pokemon target, int base, float critical, float typeModifier, float STAB, float random)
	{
		int damage = base;
		target.hurt(damage);

		// TODO: simulate pokemon attack animation

		return damage;
	}
	
	/**
	 * Gets the current health of the Pokemon.
	 * 
	 * @return health - the current health points
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * Gets the name of the Pokemon.
	 * 
	 * @return name - the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the level of the Pokemon.
	 * 
	 * @return level - the current level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * Gets the attack stat of the Pokemon.
	 * 
	 * @return attack - the attack stat
	 */
	public int getAttackStat()
	{
		return attack;
	}
	
	/**
	 * Gets the defense stat of the Pokemon.
	 * 
	 * @return defense - the defense stat
	 */
	public int getDefenseStat()
	{
		return defense;
	}
	
	/**
	 * Determines whether the Pokemon is still alive.
	 * 
	 * @return alive - true if the pokemon is alive, false otherwise
	 */
	public boolean isAlive()
	{
		return alive;	
	}
	
	/**
	 * Test whether Pokemon are equal based on their name and level only, ignoring case.
	 * 
	 * @param other - the other Pokemon for comparison
	 * @return equal - true if the names and levels are the same
	 */
	public boolean equals(Pokemon other)
	{
		if (name == other.name && level == other.level)
		{
			return true;
		} else 
		{
			return false;
		}
	}

	/**
	 * Assigns an attack to this Pokemon.  Attacks are continuously added until there are no attack
	 * slots remaining.
	 * 
	 * TODO: When a pokemon has 4 attack slots filled, the user should be prompted to choose an attack to
	 * overwrite
	 * 
	 * @param a - the attack being assigned
	 */
	public void assignAttack(Attack a)
	{		
		if (attacks.size() <= 4)
			attacks.add(a);
	}
	
	/**
	 * Returns all of the Pokemon's Attacks.
	 * 
	 * @return attacks - the arraylist of attacks
	 */
	public ArrayList<Attack> getAttacks()
	{
		return attacks;
	}

	/**
	 * Returns an attack by the specified index.
	 * 
	 * @return attack - the Pokemon's attack
	 */
	public Attack getAttack(int index)
	{
		Attack attack = attacks.get(index);
		
		return attack;
	}

	/**
	 * Resets all of the pokemon's stats to their base value.  Used when resetting battles
	 * (for testing purposes).
	 */
	public void resetAllStats()
	{
		// TODO: Save a pokemon's base stats when the battle starts
	}

	/**
	 * Returns the type of this Pokemon.
	 * @return type
	 */
	public Enum getType()
	{
		return type;
	}
}