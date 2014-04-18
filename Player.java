
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
		fireAgain = false;
		shotsFired = 0;
	}
	
	/**
	 * Handles users move
	 * @param board Game board that the user is firing on.
	 * @param hits The total number of hits already accumulated.
	 * @return Integer value that represents hits.
	 */
    public void userFire(Board board){
         fireAgain = true;
         while(fireAgain){
        	 //Get User's Input Coordinates
        	 do {    		 
        		 getUserRow();	 
        	 }while(!(row > 0 && row < (Board.getSize()+1)));		   		 											
        	 row--;		//Subtract 1 from row value because array index starts at 0
        	 
        	 do {    		 
        		 getUserColumn();	 
        	 }while(!(col > 0 && col < (Board.getSize()+1)));		   		 											
        	 col--;		//Subtract 1 from column value because array index starts at 0 
        	 
        	 updateGrid(board);    //update the current grid with the user's move  	 
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
     * Update board with next move.
     */
    public void updateGrid(Board board){
    	//If there is a ship at the coordinate - handle a hit!
   	 	if(board.grid[row][col].equals("S")){			  
   	 		hits++;
   	 		shotsFired++;
   	 		System.out.println("~~~~~~~ HIT ~~~~~~~");
   	 		board.grid[row][col] = "!";
   	 		fireAgain = false;		//Some versions of battleship allow user to fire until they miss
   		 						//changing this to 'true' would in turn allow user to shoot til they miss
   	}
   	 
   	 	//Handles a shot selection that has already been previously selected
   	 	else if (board.grid[row][col].equals("M") || board.grid[row][col].equals("!")){
   	 		System.out.println("You Shot here already");
   	 	}
   	 
   	 	//Handles a shot selection that is a miss.
   	 	else{
   	 		shotsFired++;
   	 		System.out.println("~~~~~~~ MISS ~~~~~~~");
   	 		board.grid[row][col] = "M";
   	 		fireAgain = false;		//since the player missed, flag is set to false and thus exits main while() loop	
   	 	} 
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
    
    private int shotsFired;
    private int hits;
	private static Scanner input;
	private int row;
	private int col;
	private boolean fireAgain;
}

