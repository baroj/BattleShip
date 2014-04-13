/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class responsible for generating ships and randomly placing them on the map.
 *
 * @author Jonathan and Justin
 */
public class Ship extends Tester {

    /**
     * Creates desired number of ships and randomly determines their size, orientation, and location on board.
     * @param board The game board where ships are being placed.
     * @param size The size of the game board being used.
     */
    public void createShip(Board board, int size) {
    	//I changed it to 3 ships to simplify things
    	//******************************************
        for (int j = 0; j < shipCount; j++) {

        	//Random number determines whether ship is placed horizontally or vertically    	
            if (Math.random() < 0.5) {	//Places ship on map horizontally
            	System.out.println("Creating Ship:\nRandom # < .5");
            	int col = (int) (Math.random() * 5);				
                int row = (int) (Math.random() * 7);	
                System.out.println((col+1) + "\n" + (row+1));
                for (int i = 0; i < size; i++) {
                    board.grid[row][col + i] = "S";

                }
            } else {	//else random > .5 -> Places ship on map vertically
            	System.out.println("Creating Ship:\nRandom # > .5");
                int col = (int) (Math.random() * 7);	
                int row = (int) (Math.random() * 5);	
                System.out.println((col+1) + "\n" + (row+1));
                for (int i = 0; i < size; i++) {
                    board.grid[row + i][col] = "S";

                }
            }
        }
    }

    
    /**
     * Counts the total number of shots fired that have hit a ship.
     * @param board The current board being checked for ship hits.
     * @return Total number of hits.
     */
    public int Counter(Board board) {
        hitCount = 0;
        for (int j = 0; j < board.getSize(); j++) {
            for (int k = 0; k < board.grid[j].length; k++) {
                if (board.grid[j][k].equals("S")) {
                    hitCount++;
                }
            }
        }
        return hitCount;
    }
    
    
    private int hitCount;
    private int shipCount = 3;
    
}
