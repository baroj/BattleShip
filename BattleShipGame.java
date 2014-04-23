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
		//Initialize two boards and apply to GUI
		compBoard = new Board(boardSize);
		userBoard = new Board(boardSize);
        gui = new BattleShipGUI(userBoard, compBoard);
        
        //Create ships and display ship locations to console
		System.out.println("Placing user ships on user's board:");
		Ship.createShip(userBoard, 4);
		userBoard.displayShips();			
		System.out.println("Placing computer ships on computer's board");
		Ship.createShip(compBoard, 4);
		compBoard.displayShips();
		
		//Update GUI with ships
		gui.updateUserGUI();
		gui.updateCompGUI();
		//Construct Player Objects
		user = new UserPlayer();				
        comp = new AIPlayer(skill);		       
	}


	/**
	 * Take turns firing until there is a winner.
	 */
	public void playGame(){    
		gui.displayGUI();
		while ((user.getHitCount() < Ship.hitsRequired()) &&	//while there is no winner!
        		(comp.getHitCount() < Ship.hitsRequired())){	//PLAY BATTLESHIP!
        	if(takeTurns){
        		System.out.println("USER'S TURN\nUSER'S GAMEBOARD:");		//display board
            	userBoard.displayBoard();
            	System.out.println();
            	user.playerFire(userBoard);				//user selects shot
            	
            	System.out.println("USER HAS FIRED!");
            	userBoard.displayBoard();
            	System.out.println("\n\n\n");
            	gui.updateUserGUI();
            }
            else{
            	System.out.println("COMPUTER'S TURN\nCOMPUTER'S GAMEBOARD:");	//display board
            	compBoard.displayBoard();				
            	System.out.println();;				
            	comp.playerFire(compBoard);				//computer selects shot
            	
            	System.out.println("COMPUTER HAS FIRED!");
            	compBoard.displayBoard();
            	System.out.println("\n\n\n");
            	gui.updateCompGUI();
            }
            //Once a player has gone, switch whose turn it is
            takeTurns = !takeTurns;
        }


	}


	/**
	 * Display end of game results.
	 */
	public String gameOver(){
		if(user.getHitCount() < comp.getHitCount()){
			return "Sorry, but you've lost!.\nComputer fired " + comp.getShotsFired();
		}
		else{
			return "Congratulations, You've Won!!\nYou fired " + user.getShotsFired();
			
		}
	}



	
	public Board compBoard;
	public Board userBoard;
	private BattleShipGUI gui;
	private Boolean takeTurns;
	private UserPlayer user;
	private AIPlayer comp;
	private final int boardSize = 8;
}
