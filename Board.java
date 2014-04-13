//Board Class


public class Board { 

  public Board(String [][] board) {
    for (int r =0; r<board.length; r++){
      for(int c =0; c <board[0].length; c++){
        board[r][c]= "~";
      }
    }
  }

    
  
  
  
}
