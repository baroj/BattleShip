//Justin Johnson
//April 12, 2014

/**
 * Class for handling moves 
 * @author Pustikins
 *
 */
public class Move {
	
	
	public Move(int x, int y){
		xCord = x;
		yCord = y;
	}
	
	//return xCord
	public int getX(){
		return xCord;
	}
	
	//return yCord
	public int getY(){
		return yCord;
	}
	
	//set value of xCord
	public void setX(int x){
		xCord = x;
	}
	
	//set value of yCord
	public void setY(int y){
		yCord = y;
	}
	
	
	
	//Create a string out of Coordinates
	//Format is: "xCord, yCord"
	public String toString(){
		return xCord + ", " + yCord;
	}
	
	
	private int xCord;
	private int yCord;
}
