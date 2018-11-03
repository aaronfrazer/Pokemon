package pokemon;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests for the Pokemon class.
 * 
 * @author Aaron Frazer
 */
public class TestBattle
{	
	@Test
	public void testTwoPokemonBattle()
	{
		Pokemon pikachu = new Pokemon("Pikachu", 5, Type.ELECTRIC);
		Pokemon charmander = new Pokemon("Charmander", 5, Type.FIRE);
		Battle battle = new Battle(pikachu, charmander);
		battle.start();

		assertEquals(battle.getTurn(), pikachu);

		battle.nextRound();
		assertEquals(battle.getTurn(), charmander);

		battle.nextRound();
		assertEquals(battle.getTurn(), pikachu);

		battle.reset();
		assertEquals(battle.getTurn(), pikachu);
	}
}