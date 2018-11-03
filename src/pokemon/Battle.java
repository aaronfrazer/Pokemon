package pokemon;

/**
 * The Battle class consists of two Pokemon engaged in combat.
 * 
 * @author Aaron Frazer
 */
public class Battle
{
	Pokemon p1;
	Pokemon p2;
	Pokemon whoseTurn;
	int round;
	
	/**
	 * Constructs a battle between two pokemon.
	 * 
	 * @param p1 - Pokemon #1
	 * @param p2 - Pokemon #2
	 */
	public Battle(Pokemon p1, Pokemon p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		whoseTurn = p1;
		round = 1;
	}

//	public void printPokemonStats()
//	{
//		System.out.print(p1.getName() + "'s HP = " + p1.getHealth() + ". ");
//		System.out.println(p2.getName() + "'s HP = " + p2.getHealth() + ".");
//	}

	/**
	 * Starts a battle.
	 */
	public void start()
	{
		
//		System.out.println("Starting battle between: " + p1.getName() + " vs " + p2.getName());
	}
	
	/**
	 * Resets a battle.
	 * Reinitializes all Pokemon stats back to their base values.
	 */
	public void reset()
	{
		// call constructor?
		p1.resetAllStats();
		p2.resetAllStats();
		whoseTurn = p1;
		round = 1;
	}
	
	/**
	 * Returns the Pokemon that is currently attacking.
	 * 
	 * @return pokemon - the pokemon who is attacking
	 */
	public Pokemon getTurn()
	{
		Pokemon p = p1;
		
		if (whoseTurn == p1)
			p = p1;
		else if (whoseTurn == p2)
			p = p2;
		
		return p;
	}
	
	/**
	 * Initiates the next round of the battle.
	 */
	public void nextRound()
	{	
		if (whoseTurn == p1)
			whoseTurn = p2;
		else if (whoseTurn == p2)
			whoseTurn = p1;
		
		round++;
	}
}
