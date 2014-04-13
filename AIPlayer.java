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
		nextMove = new Move(0,0);
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
			nextMove.setX(generator.nextInt(8));
			nextMove.setY(generator.nextInt(8));
		}
		
		else{	//else skill level is advanced - computer utilizes battleship strategy
		System.out.println("computer using strategy");
		//********************
		//Insert Game Log Here
		//********************
		}
		
		
		placeShot(nextMove, board);

	}
	
	
	public void placeShot(Move n, Board board){
		int row = n.getX();
		int col = n.getY();
		
		//Handles shot selection that is a hit
		if(board.grid[row][col].equals("S")){			  
    		hits++;
    		System.out.println("~~~~~~~ HIT ~~~~~~~");
    		board.grid[row][col] = "!";
    	 }
    	 
    	 //Handles a shot selection that has already been previously selected
    	 else if (board.grid[row][col].equals("M") || board.grid[row][col].equals("!")){
    		 System.out.println("Computer already shot here");
    		 compFire(board);	//If this shot has already been made - get another move!
    	 }
    	 
    	 //Handles a shot selection that is a miss.
    	 else{
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
	
	
	private int hits;
	//private Move prevMove;	Will need this when utilizing advanced AI
	private Move nextMove;
	private Random generator;
	private int skillLevel;
}
