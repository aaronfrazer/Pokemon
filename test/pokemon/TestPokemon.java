package pokemon;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Tests for the Pokemon class.
 * 
 * @author Aaron Frazer
 */
public class TestPokemon
{	
	@Test
	public void testCreateSimplePokemon()
	{
		Pokemon p = new Pokemon("Pikachu", 5, Type.ELECTRIC);
		
		assertEquals(p.getName(), "Pikachu");
		assertEquals(p.getLevel(), 5);
	}
	
	@Test
	public void testCreateAdvancedPokemon()
	{
		Pokemon p = new Pokemon("Bulbasaur", 8, 20, 3, 5, Type.GRASS);
		
		assertEquals(p.getName(), "Bulbasaur");
		assertEquals(p.getLevel(), 8);
		assertEquals(p.getHealth(), 20);
		assertEquals(p.getAttackStat(), 3);
		assertEquals(p.getDefenseStat(), 5);
	}

	@Test
	public void testHurtPokemon()
	{
		Pokemon p = new Pokemon("Squirtle", 8, 20, 3, 5, Type.WATER);
		
		assertEquals(p.getHealth(), 20);
		p.hurt(5);
		assertEquals(p.getHealth(), 15);
		p.hurt(-4); // negative number, should do nothing
		assertEquals(p.getHealth(), 15);
	}
	
	@Test
	public void testKillPokemon()
	{
		Pokemon p = new Pokemon("Charmander", 8, 20, 3, 5, Type.FIRE);
		
		assertTrue(p.isAlive());
		
		assertEquals(p.getHealth(), 20);
		p.hurt(20);
		assertEquals(p.getHealth(), 0);
		p.hurt(5); // should remain at 0
		assertEquals(p.getHealth(), 0);
		
		assertFalse(p.isAlive());
	}

	@Test
	public void testPokemonEqualStats()
	{
		Pokemon char1 = new Pokemon("Charmander", 8, 20, 3, 5, Type.FIRE);
		Pokemon char2 = new Pokemon("Charmander", 8, 20, 3, 5, Type.FIRE);

		assertTrue(char1.equals(char2));
		
		Pokemon bulb1 = new Pokemon("Bulbasaur", 8, 20, 3, 5, Type.GRASS);

		assertFalse(char1.equals(bulb1));
	}
	
	@Test
	public void testAttack()
	{
		Pokemon attacker = new Pokemon("Squirtle", 8, 20, 3, 5, Type.WATER);
		Pokemon defender = new Pokemon("Bulbasaur", 8, 30, 3, 5, Type.GRASS);
		Attack a = new Attack("Water Gun", 20);

		attacker.assignAttack(a);
		
		ArrayList<Attack> attacks = attacker.getAttacks();
		
		assertEquals(attacks.size(), 1);
		assertEquals(attacks.get(0), a);

		attacker.attack(defender, attacker.getAttack(0).getBaseDamage(), 1, 1, 1, 1);

		assertEquals(defender.getHealth(), 10);
	}
}