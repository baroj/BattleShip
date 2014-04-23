import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class BattleShipGUI {

/**
 * Class is responsible for constructing two maps and populating them with appropriate data.
 * Class contains methods for updating GUI with new map data.
 * @param user Board object containing user's data.
 * @param comp Board object containing computer's data.
 */
	public BattleShipGUI(Board user, Board comp){
		userBoard = user;
		compBoard = comp;
		gameBoard = new JFrame("Battle Ship!");
		gameBoard.setBounds(400,75,400,650);
		gameBoard.setResizable(false);
		gameBoard.setLayout(new GridLayout(17,8));
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userGrid = new BSButton[Board.getSize()][Board.getSize()];
		compGrid = new BSButton[Board.getSize()][Board.getSize()];
		b = new Border();
		border = new JLabel[Board.getSize()];
		
		//draw user grid
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				userGrid[r][c] = new BSButton();
				userGrid[r][c].setText("~");
				gameBoard.add(userGrid[r][c]);
			}
		}

		//draw border
		for(int i = 0; i < Board.getSize(); i++){
			border[i] = new JLabel(b);
			gameBoard.add(border[i]);
		}
		
		//draw computer grid
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				compGrid[r][c] = new BSButton();
				compGrid[r][c].setText("~");
				gameBoard.add(compGrid[r][c]);
			}
		}
	}

	
	/**
	 * Check user's map for any new hits or misses and update GUI accordingly.
	 */
	public void updateUserGUI(){
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				if(userBoard.grid[r][c] == 2){
					userGrid[r][c].setText("M");
				}
				else if(userBoard.grid[r][c] == 3){
					userGrid[r][c].setText("!");
				}
			}
		}
		
	}
	
	
	/**
	 * Check computer's map for any new hits or misses and update GUI accordingly.
	 */
	public void updateCompGUI(){
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				if(compBoard.grid[r][c] == 1){
					compGrid[r][c].setText("S");
				}
				else if(compBoard.grid[r][c] == 2){
					compGrid[r][c].setText("M");
				}
				else if(compBoard.grid[r][c] == 3){
					compGrid[r][c].setText("!");
				}
			}
		}
	}
	
	/**
	 * Make GUI visible
	 */
	public void displayGUI(){
		gameBoard.setVisible(true);
	}
	
	
	

	private Border b;
	private Board userBoard;
	private Board compBoard;
	private BSButton[][] userGrid;
	private BSButton[][] compGrid;
	private JLabel[] border;
	private JFrame gameBoard;
}
