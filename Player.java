
import java.util.Scanner;

/**
 *
 * @author Jonathan and Justin
 */
public class Player {
		
	/**
	 * Construct new player object and initialize values.
	 */
	public Player(){
		input = new Scanner(System.in);
		hits = 0;
		shotsFired = 0;
		fireAgain = false;
		nextMove = new Move(-1, -1);
		
	}
	
	/**
	 * Get next move from user, check validity of next move, and update grid.
	 * @param board Game board that the user is firing at.
	 */
    public void userFire(Board board){
         fireAgain = true;
         while(fireAgain){
        	 
        	 //Get User's Input Coordinates
        	 do {    		 
        		 getUserRow();	 
        	 }while(!(row > 0 && row < (Board.getSize()+1)));		   		 											
        	 row--;		//Subtract 1 from row value because array index starts at 0
        	 nextMove.setRow(row);
        	 do {    		 
        		 getUserColumn();
        	 }while(!(col > 0 && col < (Board.getSize()+1)));		   		 											
        	 col--;		//Subtract 1 from column value because array index starts at 0 
        	 nextMove.setCol(col);
        	 
        	 //if user's next move is a valid move - update the grid and exit loop
        	 if(nextMove.isValidMove(board)){
        		 fireAgain = false;
        		 placeShot(board, nextMove);
        	 } 	 
         }
    }
 
    /**
     * Requests and stores a valid row from user input.
     */
    public void getUserRow(){
   	 	System.out.println("Select a row to fire in (1 -> " + Board.getSize() + ") : ");
   	 	row = input.nextInt(); 	 	
    }
    
    
    /**
     * Requests and stores a valid column from user input.
     */
    public void getUserColumn(){
    	 System.out.println("Select a column to fire in ((1 -> " + Board.getSize() + ") : ");
    	 col = input.nextInt();
    }
   

    /**
     * Handles shot and increments player's hit counter and shotsFired counter accordingly.
     * @param board Game board shot is being placed on.
     * @param nextMove Coordinates of move being placed on grid.
     */
    public void placeShot(Board board, Move nextMove){
		 board.updateGrid(nextMove);
		 if(nextMove.isHit(board)){		//if grid update resulted in a hit - increment hits count
			 hits++;					
		 }
		 shotsFired++;

    }
    
    
    /**
     * Gets current hit count.
     * @return Total number of hits.
     */
    public int getHitCount(){
    	return hits;
    }
    
    
    /**
     * 
     * @return Total number of shots fired by player.
     */
    public int getShotsFired(){
    	return shotsFired;
    }
    
    
	private static Scanner input;
    private Move nextMove;
	private boolean fireAgain;
    private int shotsFired;
    private int hits;
	private int row;
	private int col;
}

