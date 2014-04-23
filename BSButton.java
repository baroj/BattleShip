
//Justin Johnson
//Z23136514

import javax.swing.JButton;

/**
 * A class for creating a TicTacToeButton - extends JButton.
 * @author Justin
 *
 */
public class BSButton extends JButton {
	

	/**
	 * Constructs a TicTacToeButton object.
	 * Sets buttonStatus to 0.
	 */
	public BSButton(){
		b = new JButton();	
		buttonStatus = 0;	
	}
	
	
	/**
	 * Obtain button's current status.
	 * @return buttonStatus - integer value used to determine who has selected current button.
	 */
	public int getStatus(){
		return this.buttonStatus;
	}
	
	/**
	 * Set button status.
	 * @param s - integer value used to set current button's status.
	 * Distinguishes who has selected the current button.
	 */
	public void setStatus(int s){
		buttonStatus = s;
	}
	
	
	/**
	 * Tests button object to see if it is a valid move.
	 * @return True if button has not yet been selected by user or computer.
	 */
	public Boolean isValidMove(){
		if(getStatus() == 0 || getStatus() == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	private static final long serialVersionUID = 1L;
	private JButton b;			
	private int buttonStatus;	//0 = no shot, no ship; 1 = no shot, ship; 2 = shot, no ship (MISS); 3 = shot, ship (HIT);
	
}
