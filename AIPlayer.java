import java.util.Random;

/**
 * Constructs the computer user and handles computer moves.
 * @author Jonathan and Justin
 *
 */
public class AIPlayer {

	/**
	 * Constructor creates computer player and initializes values.
	 * @param s The skill level being applied to computer player.
	 */
	public AIPlayer(int s){
		skillLevel = s;
		hits = 0;
		shotsFired = 0;
		nextMove = new Move(0,0);
		//prevMove = new Move(0,0);
		//prevPrevMove = new Move(0,0);
		generator = new Random();
		System.out.println("Computer player constructed.");
		System.out.print("Skill level chosen: ");
		if(skillLevel==0){
			System.out.println("Beginner");
		}
	}
	
	
	/**
	 * Calculates the next computer move
	 */
	public void compFire(Board board){
		//
		if(skillLevel==0){	//skill level is beginner - computer moves are random
			nextMove = getRandomShot();
		}		
		else{	//else skill level is advanced - computer utilizes battleship strategies
			if(shotsFired == 0){	//If first shot of game, select 1 at random
				nextMove = getRandomShot();
			}
			
			
			
			
		}
		
		
		placeShot(nextMove, board);

	}
	
	
	/**
	 * Places a shot on the game board at specified coordinates.
	 * @param n The Move coordinates being used to place shot.
	 * @param board The Board that the shot is being placed onto.
	 */
	public void placeShot(Move n, Board board){
		int row = n.getY();
		int col = n.getX();
		
		//Handles shot selection that is a hit
		if(board.grid[row][col].equals("S")){			  
    		hits++;
    		shotsFired++;
    		System.out.println("~~~~~~~ HIT ~~~~~~~");
    		board.grid[row][col] = "!";
    	 }
    	 
    	 //Handles a shot selection that has already been previously selected
    	 else if (board.grid[row][col].equals("M") || board.grid[row][col].equals("!")){
    		 System.out.println("Computer already shot here");
    		 compFire(board);	//If this shot has already been made - whoops, get another move!
    	 }
    	 
    	 //Handles a shot selection that is a miss.
    	 else{
    		 shotsFired++;
    		 System.out.println("~~~~~~~ MISS ~~~~~~~");
    		 board.grid[row][col] = "M";
    	 } 
		
	}
	
	  /**
     * Gets current hit count.
     * @return Total number of hits.
     */
    public int getHits(){
    	return hits;
    }
    
    /**
     * 
     * @return Total number of shots fired.
     */
    public int getShotsFired(){
    	return shotsFired;
    }
	
    /**
     * Generates a random Move object.
     * @return
     */
    public Move getRandomShot(){
    	Move randMove = new Move(generator.nextInt(Board.getSize()), 
    			generator.nextInt(Board.getSize()));
    	return randMove;
    }
    
    
    
	private int shotsFired;
	private int hits;
	//private Move prevMove;	Will need this when utilizing advanced AI
	private Move nextMove;
	//private Move prevMove;
	//private Move prevPrevMove;
	private Random generator;
	private int skillLevel;
}
