package pokemon;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for the Pokemon class.
 * 
 * @author Aaron Frazer
 */
public class TestType
{	
	@Test
	public void testTypeIsSuperEffectiveAgainst()
	{
		Pokemon pidgey = new Pokemon("Pidgey", 5, Type.FLYING);
		Pokemon mankey = new Pokemon("Mankey", 5, Type.FIGHTING);

		Type pidgeyype = (Type) pidgey.getType();
		Type mankeyType = (Type) mankey.getType();

		assertTrue(pidgeyype.isSuperEffectiveAgainst(mankeyType));
	}

	@Test
	public void testTypeIsNotVeryEffectiveAgainst()
	{
		assertTrue(Type.POISON.isNotVeryEffectiveAgainst(Type.GROUND));
	}

	@Test
	public void testTypeHasNoEffectOn()
	{
		assertTrue(Type.ELECTRIC.hasNoEffectOn(Type.GROUND));
	}

	@Test
	public void testTypeIsNormalAgainst()
	{
		assertTrue(Type.NORMAL.isNormalAgainst(Type.NORMAL));
	}
}