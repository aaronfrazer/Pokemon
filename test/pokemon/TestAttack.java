package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Attack class.
 * 
 * @author Aaron Frazer
 */
public class TestAttack
{
	@Test
	public void testCreateAttack()
	{
		Attack a = new Attack("Quick Attack", 10);		
		assertEquals(a.getName(), "Quick Attack");
		assertEquals(a.getBaseDamage(), 10);
	}
	
	
}
