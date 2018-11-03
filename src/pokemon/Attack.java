package pokemon;

/**
 * The Attack class represents a Pokemon's attack.  Pokemon can attack other Pokemon.
 * Each attack has a base damage stat (no type weakness, effects)
 * 
 * @author Aaron Frazer
 */
public class Attack
{
	private String name;
	private int baseDamage;
	
	/**
	 * Constructs an attack.
	 * 
	 * @param name - the name of the attack
	 * @param baseDamage - the amount of base damage the attack does
	 */
	public Attack(String name, int baseDamage)
	{
		this.name = name;
		this.baseDamage = baseDamage;
	}
	
	/**
	 * Gets the name of the attack.
	 * 
	 * @return name - the name of the attack
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the base damage the attack can do.
	 * 
	 * @return baseDamage - the base damage
	 */
	public int getBaseDamage()
	{
		return baseDamage;
	}
}
