//Ship Class


public class Ship {
  
  public void createShip(String[][] board, int size)
  {
    for (int j= 0; j< 5; j+++)
    {
      if(Math.random() < 0.5){
        int col = (int)(Math.random()*5);
        int row = (int)(Math.random()*7);
        for(int i =0; i<size; i++){
          board[row][col+i]="S";
        }
      }
      else{
        int col = (int)(Math.random() *7);
        int row = (int)(Math.random()*5);
        for(int i =0; i<size; i++){
          board[row][col+i]="S";
        }
      }
    }
  }
  
  
}
