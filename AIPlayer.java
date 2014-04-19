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
		generator = new Random();
		skillLevel = s;
		hits = 0;
		shotsFired = 0;
		nextMove = new Move(0,0);
		prevMove = new Move(0,0);
		//prevPrevMove = new Move(0,0);
		System.out.println("Computer player constructed.");
		System.out.print("Skill level chosen: ");
		if(skillLevel==0){
			System.out.println("Beginner");
		}
		else{
			System.out.println("Adanced");
		}
	}


	/**
	 * Calculates the next computer move
	 */
	public void compFire(Board board){
		
		//SKILL LEVEL BEGINNER - shot selections are random
		if(skillLevel==0){	
			nextMove = getRandomMove();
			while(!nextMove.isValidMove(board)){
				nextMove = getRandomMove();
			}
			placeShot(board, nextMove);
		}
		
		//SKILL LEVEL ADVANCED - computer utilizes battleship strategies
		else{			
			if(shotsFired == 0){	//If first shot of game, select shot at random
				System.out.println("First shot of game.");
				nextMove = getRandomMove();
				while(!nextMove.isValidMove(board)){
					nextMove = getRandomMove();
				}
				placeShot(board, nextMove);
			}
			
			
			
			else{	//If not first shot of game - utilize battleship strategy
				
				//if previous move is a hit - get a local move
				if(prevMove.isHit(board)){	
					System.out.println("prevMove.isHit: " + prevMove.toString());
					nextMove = getLocalMove(prevMove, board);
					//if local move is a valid move - place it on the grid
					if(nextMove.isValidMove(board)){
						System.out.println("nextMove.isValid: " + nextMove.toString());
						System.out.println("Placing next local move: " + nextMove.toString());
						placeShot(board, nextMove);
						
					}
					//else - no local moves are available - resort to getting random moves
					else{
						System.out.println("Local move not valid, return to random move.");
						while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
							nextMove = getRandomMove();
						}
						System.out.println("Placing random shot: " + nextMove.toString());
						placeShot(board, nextMove);				
					}
					
				}
				
				//else previous move is not a hit - so resort to random move and place on board
				else{
					System.out.println("prevMove is not a hit - get random move.");
					nextMove = getRandomMove();
					while(!nextMove.isValidMove(board)){
						nextMove = getRandomMove();
					}
					placeShot(board, nextMove);
				}
			}
		}	
	}

	
	/**
     * Handles shot and increments player's hit counter and shotsFired counter accordingly.
     * @param board Game board shot is being placed on.
     * @param nextMove Coordinates of move being placed on grid.
     */
    public void placeShot(Board board, Move nextMove){
		 board.updateGrid(nextMove);
		 prevMove = nextMove;
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
     * @return Total number of shots fired.
     */
    public int getShotsFired(){
    	return shotsFired;
    }

    /**
     * Generates a random Move object.
     * @return
     */
    public Move getRandomMove(){
    	Move randMove = new Move(generator.nextInt(Board.getSize()), 
    			generator.nextInt(Board.getSize()));
    	return randMove;
    }
    
    
    /**
	 * Select a move that neighbors current move, return invalid Move if none are available.
	 * @param move Coordinates being evaluated.
	 * @return Returns a move that is directly North, South, East, or West of current Move.
	 * @return Move(-1, -1) if there are no moves available North, South, East or West of current Move.
	 */
    public Move getLocalMove(Move move, Board board){
    	int row = move.getRow();
    	int col = move.getCol();
    	Move localMove = new Move(row, col-1);	
    	System.out.println("Trying localMove " + localMove.toString());
    	if(localMove.isValidMove(board)){			//if West coordinate is valid - return
    		System.out.println("returning local W: " + localMove.toString());
    		return localMove;
    	}
    	else{
    		localMove = new Move(row, col +1);
        	System.out.println("Trying localMove " + localMove.toString());
    		if(localMove.isValidMove(board)){		//else if East coordinate is valid - return
    			System.out.println("Returning local E: " + localMove.toString());
    			return localMove;
    		}
    		else{
    			localMove = new Move (row-1, col);
    	    	System.out.println("Trying localMove " + localMove.toString());
    			if(localMove.isValidMove(board)){	//else if South coordinate is valid - return
    				System.out.println("Returning local S: " + localMove.toString());
    				return localMove;
    			}
    			else{
    				localMove = new Move(row+1, col);
    		    	System.out.println("Trying localMove " + localMove.toString());
    				if(localMove.isValidMove(board)){//else if North coordinate is valid - return
    					System.out.println("Returning local N: " + localMove.toString());
    					return localMove;
    				}
    				else{
    					localMove = new Move(-1, -1);//if no localMoves are valid - return an invalid move
    					System.out.println("Returning Invalid Local Move: " + localMove.toString());
    					return localMove;			//if invalid move is returned - there are no valid moves
    				}								//available
    			}
    		}
    	}  	
    }
    
    
    
   // private int localMoveCounter;	--> need way to check for another localMove if the first localMove is a miss
   //we want the computer to exhaust all 4 corners of the last hit before moving onto random shot selection
	private Random generator;
	private Move nextMove;
	private Move prevMove;
	private int skillLevel;
	private int shotsFired;
	private int hits;


}
