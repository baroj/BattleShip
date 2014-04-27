/**
 *Class responsible for generating ships and randomly placing them on the map.
 */
public class Ship{

    /**
     * Creates desired number of ships and randomly determines their size, orientation, and location on board.
     * @param board The game board where ships are being placed.
     * @param size The size of the game board being used.
     */
    public static void createShip(Board board, int size) {
    	shipSize = size;
        for (int j = 0; j < shipCount; j++) {
        	double orientation = Math.random();	//Random number determines whether ship is placed horizontally or vertically    	
            if (orientation < 0.5) {
            	System.out.println("Creating Ship:\nRandom # < .5 = Horizontal Ship");
            	int col = (int) (Math.random() * 5);				
                int row = (int) (Math.random() * 7);	
                System.out.println((row+1) + "," + (col+1));

                
                if(isValidShipPlacement(board, row, col, orientation)){
                	System.out.println("This is valid, placing on grid now...");
                	placeShip(board, row, col, orientation); 
}
                else{
                	System.out.println("This is not valid, getting new selection now...");
                	j--;	
                }
            } 
        
        	else {	//else random > .5 -> Places ship on map vertically
        		System.out.println("Creating Ship:\nRandom # > .5 = Vertical Ship");
                int col = (int) (Math.random() * 7);	
                int row = (int) (Math.random() * 5);	
                System.out.println((row+1) + "," + (col+1));
                
                if(isValidShipPlacement(board, row, col, orientation)){
                	System.out.println("This is valid, placing on grid now...");
                	placeShip(board, row, col, orientation);   
                }
                else{
                	System.out.println("This is not valid, getting new selection now...");
                	j--;	
                }         
            }
        }
    }

    /**
     * Checks to see if this a valid ship selection.
     * @param board Game board being checked.
     * @param row Beginning row.
     * @param col Beginning column.
     * @param orientation Random number that determines horizontal vs. vertical orientation
     * @return True if no ship exists at this location.
     */
    private static boolean isValidShipPlacement(Board board, int row, int col, double orientation){
    	if (orientation < 0.5){	//if orientation is horizontal
    		for(int i = 0; i < shipSize; i++){   		
    			if(board.grid[row][col + i] == 1){
    				return false;
    			}
    		}
    	return true;
    	}	
    	
    	else{	//else orientation is vertical
    		for(int i = 0; i < shipSize; i++){   		
    			if(board.grid[row + i][col] == 1){
    				return false;
    			}
    		}
		return true;    		
    	}
    }
    
    /**
     * Places the ship selection at this point on the map.
     * @param board Game board being changed.
     * @param row Beginning row for ship placement.
     * @param col Beginning column for ship placement.
     * @param orientation
     */
    private static void placeShip(Board board, int row, int col, double orientation){
    	if(orientation < 0.5){
    		for(int i = 0; i < shipSize; i++){
    			board.grid[row][col + i] = 1;
    		}   	
    	}
    	else{
    		for (int i = 0; i < shipSize; i++) {
    			board.grid[row + i][col] = 1;
            }
    	}    	
    }
    
    /**
     * 
     * @return Total number of hits required to win a game.
     */
    public static int hitsRequired(){
    	return shipSize * shipCount;
    }
    
    private static int shipSize;
    private static int shipCount = 4;
    
}
