/**
 * Class for constructing new BattleShip games, playing games, and displaying end of game results.
 * @author Jonathan and Justin
 *
 */
public class BattleShipGame {
	
	/**
	 * Construct game boards and players accordingly.
	 * @param skill The skill level to be applied to Computer Player AI
	 */
	public BattleShipGame(int skill){
		takeTurns = false;
		userBoard = new Board(boardSize);	//Construct user game board and place ships
		System.out.println("Placing user ships on user's board:");
		userBoard.createShip(userBoard, 4);
		userBoard.displayShips();
		compBoard = new Board(boardSize);	//Construct computer game board and place ships
		System.out.println("Placing computer ships on computer's board");
		compBoard.createShip(compBoard, 4);
		compBoard.displayShips();
		user = new Player();				//Construct user player object
        comp = new AIPlayer(skill);			//Construct computer player object
	}
	
	
	/**
	 * Take turns firing until there is a winner.
	 */
	public void playGame(){        										
		while ((user.getHits() < userBoard.hitsRequired()) &&	//while there is no winner!
        		(comp.getHits() < compBoard.hitsRequired())){	//PLAY BATTLESHIP!
        	if(takeTurns){
        		System.out.println("USER'S TURN\nUSER'S GAMEBOARD:");		//display board
            	userBoard.displayBoard();
            	System.out.println();
            	user.userFire(userBoard);				//user selects shot
            	System.out.println("USER HAS FIRED!");
            	userBoard.displayBoard();
            	System.out.println("\n\n\n");
            }
            else{
            	System.out.println("COMPUTER'S TURN\nCOMPUTER'S GAMEBOARD:");	//display board
            	compBoard.displayBoard();				
            	System.out.println();;				
            	comp.compFire(compBoard);				//computer selects shot
            	System.out.println("COMPUTER HAS FIRED!");
            	compBoard.displayBoard();
            	System.out.println("\n\n\n");
            }
            //Once a player has gone, switch whose turn it is
            takeTurns = !takeTurns;
        }
		
		
	}
	
	
	/**
	 * Display end of game results.
	 */
	public String gameOver(){
		if(user.getHits() < comp.getHits()){
			return "Sorry, but you've lost!.";
		}
		else{
			return "Congratulations, You've Won!!";
		}
	}
	
	
	
	
	public Board compBoard;
	public Board userBoard;
	private Boolean takeTurns;
	private Player user;
	private AIPlayer comp;
	private final int boardSize = 8;
}
