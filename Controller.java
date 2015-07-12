/**
 * Controller.java
 *
 * Description: This program controlls the entire program logic. 
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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
*
* Class "Controller" controls the entire game logic.
*
* @version 1.1
*
* @author  Poorn Pragya
* @author  Manas Mandhani
*/
public class Controller {

	ActionListener p0, p1, p2, player1, player2;
	ActionListener sp1, sp2, sp3;
	Model m;
	View v;
	volatile int count_ships_p1 = 0;
	volatile int count_ships_p2 = 0;
	int player1wincount = 0, player2wincount = 0;

    /**
     * Constructor "Controller" initializes the objects of Model class and View class.
     */
	public Controller(Model m, View v) {
		this.m = m;
		this.v = v;
		control();
	}

    /**
     * Method "control" creates action listeners to record the pattern.
     */
	void control() {

	    /**
	     * Action Listener for Single-Player game.
	     */
		sp2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				int i = 0, j = 0;
				if (player1wincount != 6 && player2wincount != 6) {
					for (i = 0; i < 6; i++) {
						for (j = 0; j < 6; j++)
							if (e.getSource() == v.grid2[i][j]) {
								flag = 1;
								break;
							}
						if (flag == 1)
							break;
					}
					if (v.grid2[i][j].getBackground() != Color.BLACK
							&& v.grid2[i][j].getBackground() != Color.GREEN) {
						if (m.p2_ships[i][j] == 1) {
							v.grid2[i][j].setBackground(Color.BLACK);
							JOptionPane.showMessageDialog(v.frame, "hit");
							player1wincount++;
						} else {
							v.grid2[i][j].setBackground(Color.GREEN);
							JOptionPane.showMessageDialog(v.frame, "Miss");
						}
						if (player1wincount == 6)
							JOptionPane.showMessageDialog(v.frame,
									"Player 1 wins");
						comp_turn();
					}
				} else
					JOptionPane.showMessageDialog(v.frame, "Game has finshed");
			}
		};

	    /**
	     * Action Listener for Single-Player game.
	     */
		sp1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count_ships_p1 < 6) {
					for (int x = 0; x < 6; x++) {
						for (int y = 0; y < 6; y++) {
							if (e.getSource() == v.grid1[x][y]
									&& m.p1_ships[x][y] != 1) {
								m.p1_ships[x][y] = 1;
								v.grid1[x][y].setBackground(Color.RED);
								count_ships_p1++;
							}
						}
					}
				}

				if (count_ships_p1 == 6) {
					m.comp_ship_placement_logic();
					v.playScreenSingle();
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (m.p1_ships[i][j] == 1)
								v.grid1[i][j].setBackground(Color.RED);
						}
					}

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							v.grid2[i][j].addActionListener(sp2);
						}
					}
				}
			}

		};

	    /**
	     * Action Listener for Placing the ships.
	     */
		p1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count_ships_p1 < 6) {
					for (int x = 0; x < 6; x++) {
						for (int y = 0; y < 6; y++) {
							if (e.getSource() == v.grid1[x][y]
									&& m.p1_ships[x][y] != 1) {
								m.p1_ships[x][y] = 1;
								v.grid1[x][y].setBackground(Color.RED);
								count_ships_p1++;
							}
						}
					}
				}
				if (count_ships_p1 == 6 && count_ships_p2 == 6) {
					v.playScreen();

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (m.p1_ships[i][j] == 1)
								v.grid1[i][j].setBackground(Color.RED);
						}
					}

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (m.p2_ships[i][j] == 1)
								v.grid3[i][j].setBackground(Color.RED);
						}
					}

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							v.grid2[i][j].addActionListener(player1);
						}

					}

					for (int i = 0; i < 6; i++)
						for (int j = 0; j < 6; j++)
							v.grid4[i][j].addActionListener(player2);
				}
			}
		};

	    /**
	     * Action Listener for placing the ships.
	     */
		p2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count_ships_p2 < 6) {
					for (int x = 0; x < 6; x++) {
						for (int y = 0; y < 6; y++) {
							if (e.getSource() == v.grid2[x][y]
									&& m.p2_ships[x][y] != 1) {
								m.p2_ships[x][y] = 1;
								v.grid2[x][y].setBackground(Color.RED);
								count_ships_p2++;
							}
						}
					}
				}

				if (count_ships_p1 == 6 && count_ships_p2 == 6) {
					v.playScreen();

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (m.p1_ships[i][j] == 1)
								v.grid1[i][j].setBackground(Color.RED);
						}
					}

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (m.p2_ships[i][j] == 1)
								v.grid3[i][j].setBackground(Color.RED);
						}
					}

					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							v.grid2[i][j].addActionListener(player1);
						}

					}

					for (int i = 0; i < 6; i++)
						for (int j = 0; j < 6; j++)
							v.grid4[i][j].addActionListener(player2);
				}
			}
		};

	    /**
	     * Action Listener for Main Page.
	     */
		p0 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton temp = (JButton) arg0.getSource();
				if (temp.getText().equals("Single Player")) {
					v.PlaceShipScreenSingle();
					for (int x = 0; x < 6; x++)
						for (int y = 0; y < 6; y++)
							v.grid1[x][y].addActionListener(sp1);
				}

				else if (temp.getText().equals("Two Player")) {
					v.PlaceShipScreen();
					for (int x = 0; x < 6; x++)
						for (int y = 0; y < 6; y++)
							v.grid1[x][y].addActionListener(p1);

					for (int x = 0; x < 6; x++)
						for (int y = 0; y < 6; y++)
							v.grid2[x][y].addActionListener(p2);
				}

				else {
					v.frame.dispose();
					System.exit(0);
				}
			}
		};

		v.button1.addActionListener(p0);
		v.button2.addActionListener(p0);
		v.button3.addActionListener(p0);

	    /**
	     * Action Listener for Two-Player game.
	     */
		player1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int flag = 0;
				int i = 0, j = 0;
				if (player1wincount != 6) {
					for (i = 0; i < 6; i++) {
						for (j = 0; j < 6; j++)
							if (arg0.getSource() == v.grid2[i][j]) {
								flag = 1;
								break;
							}
						if (flag == 1)
							break;
					}
					if (v.grid2[i][j].getBackground() != Color.BLACK
							&& v.grid2[i][j].getBackground() != Color.GREEN) {
						if (m.p2_ships[i][j] == 1) {
							v.grid2[i][j].setBackground(Color.BLACK);
							JOptionPane.showMessageDialog(v.frame, "hit");
							player1wincount++;
						} else {
							v.grid2[i][j].setBackground(Color.GREEN);
							JOptionPane.showMessageDialog(v.frame, "Miss");
						}
						if (player1wincount == 6)
							JOptionPane.showMessageDialog(v.frame,
									"Player 1 wins");
						else
							v.Player2Screen();
					}
				} else
					JOptionPane.showMessageDialog(v.frame, "Game has finshed");
			}
		};

	    /**
	     * Action Listener for Two-Player game.
	     */
		player2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				int i = 0, j = 0;
				if (player2wincount != 6) {
					for (i = 0; i < 6; i++) {
						for (j = 0; j < 6; j++)
							if (e.getSource() == v.grid4[i][j]) {
								flag = 1;
								break;
							}
						if (flag == 1)
							break;
					}
					if (v.grid4[i][j].getBackground() != Color.BLACK
							&& v.grid4[i][j].getBackground() != Color.GREEN) {
						if (m.p1_ships[i][j] == 1) {
							v.grid4[i][j].setBackground(Color.BLACK);
							JOptionPane.showMessageDialog(v.frame, "hit");
							player2wincount++;
						} else {
							v.grid4[i][j].setBackground(Color.GREEN);
							JOptionPane.showMessageDialog(v.frame, "Miss");
						}
						if (player2wincount == 6)
							JOptionPane.showMessageDialog(v.frame,
									"Player 2 wins");
						else
							v.Player1Screen();
					}
				} else
					JOptionPane.showMessageDialog(v.frame, "Game has finshed");
			}
		};
	}

    /**
     * Method "comp_turn" contains the logic for implementing the computer driven moves.
     */
	void comp_turn() {
		int flag = 0;
		int i = 0, j = 0;
		Random r = new Random();

		if (player1wincount != 6 && player2wincount != 6) {
			while (flag == 0) {
				i = r.nextInt(6);
				j = r.nextInt(6);
				if (v.grid1[i][j].getBackground() != Color.BLACK
						&& v.grid1[i][j].getBackground() != Color.GREEN) {
					if (m.p1_ships[i][j] == 1) {
						v.grid1[i][j].setBackground(Color.BLACK);
						JOptionPane.showMessageDialog(v.frame, "hit");
						player2wincount++;
					} else {
						v.grid1[i][j].setBackground(Color.GREEN);
						JOptionPane.showMessageDialog(v.frame, "Miss");
					}
					if (player2wincount == 6)
						JOptionPane.showMessageDialog(v.frame, "Computer wins");
					flag = 1;
				}
			}
		} else
			JOptionPane.showMessageDialog(v.frame, "Game has finshed");
	}
}
