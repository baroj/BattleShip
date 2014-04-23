/**
 * Abstract Player class containing common member methods and fields.
 * @author Jonathan and Justin
 */
public abstract class Player{
	
	public Player(){
		System.out.println("In Abstract Player() Constructor");
		shotsFired = 0;
		hits = 0;
		fireAgain = false;
		prevMove = new Move(0, 0);	
		prevMove2 = new Move(0, 0);
		nextMove = new Move(0, 0);
	}
	
	
	/**
	 * Get next move from player, check validity of next move, and handle move appropriately.
	 * @param board Game board that the user is firing at.
	 */
    public abstract void playerFire(Board board);
    
    
    /**
     * Sends update to board's grid and increments player's hit counter and shotsFired counter accordingly.
     * @param board Game board shot is being placed on.
     * @param nextMove Coordinates of move being placed on grid.
     */
    public void placeShot(Board board, Move nextMove){
		 board.updateGrid(nextMove);
		 prevMove2 = prevMove;
		 prevMove = nextMove;
		 if(prevMove.isHit(board)){		//if grid update resulted in a hit - increment hits count
			 hits++;					
		 }
		 shotsFired++;
		 fireAgain = false;
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
    
    
    public Move prevMove;
    public Move prevMove2;
    public Move nextMove;
	public boolean fireAgain;		
    private int shotsFired;
    public int hits;

}

