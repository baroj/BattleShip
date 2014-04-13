
import java.util.Scanner;

/**
 *
 * @author Jonathan and Justin
 */
public class Player {
	
	//The way this is currently designed - torpedos is not being used. I don't think we need it either. Prob remove it.
	
	/*
	 * Constructor initializes values
	 */
	public Player(){
		input = new Scanner(System.in);
		hits = 0;
		fireAgain = false;
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
        	 
        	 //Request a row from the user.
        	 System.out.println("Select a row to fire in: ");
        	 row = input.nextInt();	      	 
        	 //Check for valid entry and request another entry if not valid
        	 while(!(row > 0 && row < 9)){
        		 System.out.println("Enter a valid row (1 -> 8)");
        		 row = input.nextInt();						   		 										
        	 }		
        	 row--;		//Subtract 1 from row value because array index starts at 0
        	 
        	 //Request a column from the user.
        	 System.out.println("Select a column to fire in: ");
        	 col = input.nextInt();
        	 //Check for valid entry and request another entry if not valid
        	 while(!(col > 0 && col < 9)){	 
        		 System.out.println("Enter a valid col (1 -> 8)");
        		 col = input.nextInt();		 	
        	 }	
        	 col--;		//Subtract 1 from column value because array index starts at 0
         
        	 //If there is a ship at the coordinate - handle a hit!
        	 if(board.grid[row][col].equals("S")){			  
        		 hits ++;
        		 System.out.println("~~~~~~~ HIT ~~~~~~~");
        		 board.grid[row][col] = "!";
        		 fireAgain = false;		//Some versions of battleship allow user to fire until they miss
        		 						//changing this to 'true' would in turn allow user to shoot til they miss
        	 }
        	 
        	 //Handles a shot selection that has already been previously selected
        	 else if (board.grid[row][col].equals("M") || board.grid[row][col].equals("!")){
        		 System.out.println("You Shot here already");
        		 	// k is already 0 - so we shouldn't need to change it at all. this is not necessary
        	 }
        	 
        	 //Handles a shot selection that is a miss.
        	 else{
        		 System.out.println("~~~~~~~ MISS ~~~~~~~");
        		 board.grid[row][col] = "M";
        		 fireAgain = false;		//since the player missed, flag is set to false and thus exits main while() loop	
        	 } 
         }
    }
 
    
    /**
     * Gets current hit count.
     * @return Total number of hits.
     */
    public int getHits(){
    	return hits;
    }
    
    private int hits;
	private static Scanner input;
	private int row;
	private int col;
	private boolean fireAgain;
}

