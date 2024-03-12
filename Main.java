import java.util.Scanner;

public class Main {
   public static void main(String [] args){

        Scanner scnr = new Scanner(System.in);
        BingoGame bg = new BingoGame();
        System.out.println(bg);
        int num = -1; //placeholder
        boolean winner = false;
        Char continuePlay;


        while (num != 0) {
            bg.roll();
            bg.checkBoards();
            System.out.println(bg);
            num = scnr.nextInt();
        }

        while (winner == false) {
            bg.roll();
            bg.checkBoards();
            System.out.println(bg);

            if (bg.checkBingoWinner == true) {
                System.out.println("Go for Bingo Blackout?");
                System.out.print("Enter Y to continue or N to quit: ");
                continuePlay = scnr.next().charAt(0);

                if (continuePlay == 'Y' || continuePlay == 'y') {
                    winner = false;
                }
                else if (continuePlay == 'N' || continuePlay == 'n') {
                    winner = true;
                }
            
            else if (bg.checkBlackoutWinner == true) {
                winner = true;
                }

            }


        }
    }
}
