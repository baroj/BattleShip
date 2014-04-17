//Justin Johnson
//April 12, 2014

/**
 * Class for handling moves 
 * @author Jonathan and Justin
 *
 */
public class Move {

	/**
	 * Construct move and assign coordinates.
	 * @param x
	 * @param y
	 */
	public Move(int x, int y){
		xCord = x;
		yCord = y;
	}

	/**
	 * Get value of x-coordinate.
	 * @return Value of x-coordinate.
	 */
	public int getX(){
		return xCord;
	}

	/**
	 * Get value of y-coordinate.
	 * @return Value of y-coordinate.
	 */
	public int getY(){
		return yCord;
	}

	/**
	 * Set value of x-coordinate.
	 * @param x New value for x-coordinate.
	 */
	public void setX(int x){
		xCord = x;
	}

	/**
	 * Set value of y-coordinate.
	 * @param y New value for y-coordinate.
	 */
	public void setY(int y){
		yCord = y;
	}

	/**
	 * Convert x and y coordinates to a string with structure : "x, y"
	 */
	public String toString(){
		return xCord + ", " + yCord;
	}

	/**
	 * Check to see if this move's coordinates is directly above Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly above Move 'other'.
	 */
	public Boolean isNorth(Move other){
		if((this.getX() == other.getX()) && (this.getY() == (other.getY()-1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly below Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly below Move 'other'.
	 */
	public Boolean isSouth(Move other){
		if((this.getX() == other.getX()) && (this.getY() == (other.getY()+1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly to right of Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly to right of Move 'other'.
	 */
	public Boolean isEast(Move other){
		if((this.getY() == other.getY()) && (this.getX() == (other.getX()+1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly to left of Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly to left of Move 'other'.
	 */
	public Boolean isWest(Move other){
		if((this.getY() == other.getY()) && (this.getX() == (other.getX()-1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this coordinate is a ship hit.
	 * @param move The move coordinates that are being checked.
	 * @param board The game board being checked for a ship hit.
	 * @return True if move coordinate is a hit.
	 */
	public Boolean isHit(Board board){
		if(board.grid[this.getY()][this.getX()] == "!"){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Check to see if this coordinate is a a miss shot.
	 * @param move The move coordinates that are being checked.
	 * @param board The game board being checked for a missed shot..
	 * @return True if move coordinate is a missed shot.
	 */
	public Boolean isMiss(Board board){
		if(board.grid[this.getY()][this.getX()] == "M"){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this Move is a valid move.
	 * @param move Coordinates being checked for validity.
	 * @param board Board being checked for validity.
	 * @return True if current coordinate is not already fired upon and is valid coordinate on grid.
	 */
	public Boolean isValidMove(Board board){
		int col = this.getX();
		int row = this.getY();
		//if move is outside of the grid size - is not valid
		if((col < 1) || (col > Board.getSize()) || (row < 1) || (row > Board.getSize())){	
			System.out.println("Invalid Move Detected");
			return false;															
		}
		//else if coordinate contains anything other than "~" - is has already been shot at, thus not valid
		else if(board.grid[row][col] != "~"){
			System.out.println("Invalid Move Detected");
			return false;
		}
		//else coordinate is a valid move
		else{
			System.out.println("Valid Move Detected");
			return true;
		}
		
	}
	

	

	private int xCord;
	private int yCord;
}
