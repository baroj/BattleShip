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
		prevMove = new Move(0,0);
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
			nextMove = getRandomMove();
			while(!nextMove.isValidMove(board)){
				nextMove = getRandomMove();
			}
			placeShot(nextMove, board);
		}		
		
		
		else{	//else skill level is advanced - computer utilizes battleship strategies
			if(shotsFired == 0){	//If first shot of game, select 1 at random
				System.out.println("First shot of game.");
				nextMove = getRandomMove();
				prevMove = nextMove;
				placeShot(nextMove, board);
			}
			
			
			else{
				//if previous move is a hit - get a local move
				if(prevMove.isHit(board)){	
					System.out.println("prevMove.isHit: " + prevMove.toString());
					nextMove = getLocalMove(prevMove, board);
					//if local move is a valid move - place it on the grid
					if(nextMove.isValidMove(board)){
						System.out.println("nextMove.isValid: " + nextMove.toString());
						prevMove = nextMove;
						System.out.println("Placing next local move: " + nextMove.toString());
						placeShot(nextMove, board);
					}
					//else - no local moves are available - resort to getting random moves
					else{
						System.out.println("Local move not valid, return to random move.");
						while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
							nextMove = getRandomMove();
						}
						System.out.println("Placing random shot: " + nextMove.toString());
						prevMove = nextMove;		//place valid move on board
						placeShot(nextMove, board);				
					}
					
				}
				//else previous move is not a hit - so resort to random move and place on board
				else{
					System.out.println("prevMove is not a hit - get random move.");
					nextMove = getRandomMove();
					prevMove = nextMove;
					placeShot(nextMove, board);
				}
			}


		}

	

	}


	/**
	 * Places a shot on the game board at specified coordinates.
	 * @param n The Move coordinates being used to place shot.
	 * @param board The Board that the shot is being placed onto.
	 */
	public void placeShot(Move n, Board board){
		int row = n.getRow();
		int col = n.getCol();
		System.out.println("Placing shot");
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
    
    
    
    
    
	private int shotsFired;
	private int hits;
	//private Move prevMove;	Will need this when utilizing advanced AI
	private Move nextMove;
	private Move prevMove;
	//private Move prevPrevMove;
	private Random generator;
	private int skillLevel;
}
