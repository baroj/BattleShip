/**
 * 
 * @author Jonathan and Justin
 */
public class Board{

	/**
	 * Constructs an empty game board.
	 * @param size Size of game board.
	 */
	public Board(int size) {
		boardSize = size;
		grid = new int[boardSize][boardSize];		
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				grid[r][c] = 0;
			}
		}
	}


	/**
	 * Display board to console
	 * @param board Array used to represent game board
	 */
	public void displayBoard() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				if(grid[r][c] == 3){
					System.out.print(" !");
				}
				else if(grid[r][c] == 2){
					System.out.print(" M");
				}
				else{
					System.out.print(" ~");
				}
			}
			System.out.println("");
		}
	}


	/**
	 * Prints game board to console with ship locations revealed, for debugging purposes.
	 * @param board Game board currently being used.
	 */
	public void displayShips() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				if(grid[r][c] == 1){
					System.out.print(" S");
				}
				else{
					System.out.print(" ~");
				}
			}
			System.out.println("");
		}
	}

	/**
	 * Gets value of current board size.
	 * @return The size of current board.
	 */
	public static int getSize(){
		return boardSize;
	}
	
	
	/**
	 * Updates grid with a new move.
	 * @param gui 
	 * @param move Move coordinates used to update grid.
	 */
	public void updateGrid(Move move){
		if(move.isValidMove(this)){
			if(grid[move.getRow()][move.getCol()] == 1){
				grid[move.getRow()][move.getCol()] = 3;
	   	 		System.out.println("~~~~~~~ HIT ~~~~~~~");
			}
			else{
				grid[move.getRow()][move.getCol()] = 2;
	   	 		System.out.println("~~~~~~~ MISS ~~~~~~~");

			}
		}
	}



	public int[][] grid;
	private static int boardSize;	//by setting this value in the constructor - we only need to call .length() once
									//It's more efficient to do it this way
}
