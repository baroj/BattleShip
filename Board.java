/**
 * 
 * @author Jonathan and Justin
 */
public class Board extends Ship {
	public static final boolean DEBUG = false; // what is this for? When I comment the code out nothing changes. Hm?

	/**
	 * Constructs an empty game board.
	 * @param size Size of game board.
	 */
	public Board(int size) {
		boardSize = size;
		grid = new String[boardSize][boardSize];		
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				grid[r][c] = "~";
			}
		}
	}

	
	/**
	 * Display board to console
	 * @param board Array used to represent game board
	 */
	public void displayBoard() {
		for (int r = 0; r < boardSize; r++) {
			/*if (DEBUG == true) {
				for (int c = 0; c < board[0].length; c++) {
					System.out.print(" " + board[r][c]);		Do we need this? What is it doing?
				}
				System.out.println("");
			} else {*/
			
			for (int c = 0; c < boardSize; c++) {
				if (grid[r][c].equals("S")) {
					System.out.print(" " + "~");
				} else {
					System.out.print(" " + grid[r][c]);
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
				System.out.print(" " + grid[r][c]);
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
	
	
	
	public String[][] grid;
	private static int boardSize;	//by setting this value in the constructor - we only need to call .length() once
							//It's more efficient to do it this way
}
