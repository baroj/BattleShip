import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Tester extends Player {

    public static void main(String[] arg) {
    	Scanner in = new Scanner(System.in);
        System.out.println("Please choose your skill level (0 for beginnger/1 for advanced)");
        int skill = in.nextInt();
        BattleShipGame battleGame = new BattleShipGame(skill);
        System.out.println("\n\n");
           
        battleGame.playGame();        
        
        System.out.println(battleGame.gameOver());
        in.close();
    }

}
