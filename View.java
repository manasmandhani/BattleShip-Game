/**
 * View.java
 *
 * Description: This program implements the display logic of the game.  
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* Class "View" implements the display logic of the game.
*
* @version 1.1
*
* @author  Poorn Pragya
* @author  Manas Mandhani
*/
public class View {
	JFrame frame;
	JPanel panel1,panel2;
	JPanel panel_play1,panel_play2,panel_play3,panel_play4;
	JButton[][] grid1,grid2,grid3,grid4;
	JButton button1,button2,button3;
	JPanel panel;
	JPanel tempPanel;
	
    /**
     * Constructor "View" created the BattleShip field using java swing.
     */
	public View() {
		frame = new JFrame("BATTLE SHIP");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(new GridLayout());
		frame.getContentPane().add(panel);
		GridBagConstraints g = new GridBagConstraints();
		button1 = new JButton("Single Player");
		g.gridx = 1;
		g.gridy = 1;
		panel.add(button1, g);
		button2 = new JButton("Two Player");
		g.gridx = 1;
		g.gridy = 2;
		panel.add(button2,g);
		button3 = new JButton("Exit");
		g.gridx = 1;
		g.gridy = 3;
		panel.add(button3,g);
		frame.setVisible(true);
	}
	
    /**
     * Method "PlaceShipScreen" creates the field for placing the ships.
     */
	void PlaceShipScreen() {
		frame.remove(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label1 = new JLabel("Player-1 place your ships here: ");
		JLabel label2 = new JLabel("Player-2 place your ships here: ");
		tempPanel = new JPanel(new GridLayout(0,2));
		tempPanel.add(label1, BorderLayout.WEST);
		tempPanel.add(label2, BorderLayout.EAST);
		frame.add(tempPanel,BorderLayout.NORTH);
		panel1 = new JPanel();
		panel2 = new JPanel();
		grid1 = new JButton[6][6]; 
		grid2= new JButton[6][6]; 
		Create_Pannel(panel1,grid1);
		Create_Pannel(panel2,grid2);
		frame.add(panel1,BorderLayout.WEST);
		frame.add(panel2,BorderLayout.EAST);
		frame.repaint();
		frame.pack();
		frame.setVisible(true);
	}
	
    /**
     * Method "Create_Pannel" creates a panel with desired color.
     */
	void Create_Pannel(JPanel panel,JButton grid[][]) {
	panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(new GridLayout(6, 6)); 
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				grid[x][y] = new JButton(x+" "+y); 
				grid[x][y].setOpaque(true);
				grid[x][y].setBackground(Color.BLUE);
				grid[x][y].setBorder(BorderFactory
						.createLineBorder(Color.black));
				panel.add(grid[x][y]); 
			}
		}
	}
	
    /**
     * Method "PlayScreen" creates the playing field.
     */
	void playScreen() {
		frame.remove(tempPanel);
		frame.remove(panel1);
		frame.remove(panel2);
		panel1=new JPanel(new GridLayout(0,2));
		JLabel label1 = new JLabel("Player-1's ship arrangement: ");
		JLabel label2 = new JLabel("Player-1 Strategy Map: ");
		panel1.add(label1,BorderLayout.WEST);
		panel1.add(label2,BorderLayout.EAST);
		panel_play1=new JPanel();
		grid1 = new JButton[6][6]; 
		Create_Pannel(panel_play1,grid1);
		panel_play2=new JPanel();
		grid2=new JButton[6][6];
		Create_Pannel(panel_play2,grid2);
		panel_play3=new JPanel();
		grid3=new JButton[6][6];
		Create_Pannel(panel_play3,grid3);
		panel_play4=new JPanel();
		grid4=new JButton[6][6];
		Create_Pannel(panel_play4,grid4);
		panel_play1.setVisible(true);
		panel_play2.setVisible(true);
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel_play1,BorderLayout.WEST);
		frame.add(panel_play2,BorderLayout.EAST);
		frame.pack();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
    /**
     * Method "Player1Screen" creates Player-1's ship arrangement and playing field.
     */
	void Player1Screen() {
		frame.remove(panel2);
		frame.remove(panel_play3);
		frame.remove(panel_play4);
		panel1=new JPanel(new GridLayout(0,2));
		JLabel label1 = new JLabel("Player-1's ship arrangement: ");
		JLabel label2 = new JLabel("Player-1 Strategy Map: ");
		panel1.add(label1,BorderLayout.WEST);
		panel1.add(label2,BorderLayout.EAST);
		panel_play1.setVisible(true);
		panel_play2.setVisible(true);
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel_play1,BorderLayout.WEST);
		frame.add(panel_play2,BorderLayout.EAST);
		frame.pack();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
    /**
     * Method "Player2Screen" creates Player-2's ship arrangement and playing field.
     */
	void Player2Screen() {
		frame.remove(panel1);
		frame.remove(panel_play1);
		frame.remove(panel_play2);
		panel2=new JPanel(new GridLayout(0,2));
		JLabel label1 = new JLabel("Player-2's ship arrangement: ");
		JLabel label2 = new JLabel("Player-2 Strategy Map: ");
		panel2.add(label1,BorderLayout.WEST);
		panel2.add(label2,BorderLayout.EAST);
		panel_play3.setVisible(true);
		panel_play4.setVisible(true);
		frame.add(panel2,BorderLayout.NORTH);
		frame.add(panel_play3,BorderLayout.WEST);
		frame.add(panel_play4,BorderLayout.EAST);
		frame.repaint();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

    /**
     * Method "PlaceShipScreenSingle" creates the field for placing the ships for the Single Player game.
     */
	public void PlaceShipScreenSingle() {
		frame.remove(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label1 = new JLabel("Player-1 place your ships here: ");
		tempPanel = new JPanel(new GridLayout(0,2));
		tempPanel.add(label1, BorderLayout.WEST);
		frame.add(tempPanel,BorderLayout.NORTH);
		panel1 = new JPanel();
		grid1 = new JButton[6][6]; 
		Create_Pannel(panel1,grid1);
		frame.add(panel1,BorderLayout.WEST);
		frame.repaint();
		frame.pack();
		frame.setVisible(true);
	}

    /**
     * Method "playScreenSingle" creates the playing field for Single Player game.
     */
	public void playScreenSingle() {
		frame.remove(tempPanel);
		frame.remove(panel1);
		panel1=new JPanel(new GridLayout(0,2));
		JLabel label1 = new JLabel("Player-1 Map ");
		JLabel label2 = new JLabel("Computer Map: ");
		panel1.add(label1,BorderLayout.WEST);
		panel1.add(label2,BorderLayout.EAST);
		panel_play1=new JPanel();
		grid1 = new JButton[6][6]; 
		Create_Pannel(panel_play1,grid1);
		panel_play2=new JPanel();
		grid2=new JButton[6][6];
		Create_Pannel(panel_play2,grid2);
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel_play1,BorderLayout.WEST);
		frame.add(panel_play2,BorderLayout.EAST);
		frame.pack();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
