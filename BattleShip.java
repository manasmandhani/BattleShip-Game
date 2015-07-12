/**
 * BattleShip.java
 *
 * Description: Implementation of BattleShip game 
 *
 * @version 1.0   04/05/2014 6:30 pm
 * $Id:
 *
 * @author  Poorn Pragya
 * @author  Manas Mandhani
 *
 * Revisions:
 *      
 */

public class BattleShip {
	/**
	*
	* Class "Battleship" initiates the game.
	*
	* @version 1.1
	*
	* @author  Poorn Pragya
	* @author  Manas Mandhani
	*/

	public static void main(String[] args) {
	    /**
	     * The method main controls the game.
	     */
		View v=new View();
		Model m=new Model();
		new Controller(m,v);
	}
}
