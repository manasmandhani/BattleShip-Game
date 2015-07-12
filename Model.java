/**
 * Model.java
 *
 * Description: This program models the data structure of the entire game. 
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

import java.util.Random;

public class Model {
	/**
	*
	* Class "Model" contains the data structure of the game. 
	*
	* @version 1.1
	*
	* @author  Poorn Pragya
	* @author  Manas Mandhani
	*/

	int p1_ships[][];
	int p2_ships[][];

    /**
     * Constructor "Model" initializes the grid for the ships.
     */
	public Model() {
		p1_ships = new int[6][6];
		p2_ships = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				p1_ships[i][j] = 0;
				p2_ships[i][j] = 0;
			}
		}
	}
	
    /**
     * Method "comp_ship_placement_logic" contains the logic for the computer driven game.
     */
	void comp_ship_placement_logic() {
		Random r = new Random();
		for (int i = 0; i < 6;) {
			int x = r.nextInt(5) + 1;
			int y = r.nextInt(5) + 1;
			if (p2_ships[x][y] != 1) {
				p2_ships[x][y] = 1;
				i++;
			}
		}
	}
}
