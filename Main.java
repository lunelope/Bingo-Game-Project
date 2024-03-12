import java.util.Scanner;

public class Main {
   public static void main(String [] args){

        Scanner scnr = new Scanner(System.in);
        BingoGame bg = new BingoGame();
        System.out.println(bg);
        int num = -1; //placeholder
        boolean winner = false;
        Char continuePlay;

        while (winner == false) {
            bg.roll();
            bg.checkBoards();
            System.out.println(bg);

            if (bg.checkBingoWinner() == true) {
                System.out.println("Go for Bingo Blackout?");
                System.out.print("Enter Y to continue or N to quit: ");
                continuePlay = scnr.next().charAt(0);

                if ((continuePlay == 'Y' || continuePlay == 'y')) {
                    onBlackOut = true;
                    break;

                }
                else if (continuePlay == 'N' || continuePlay == 'n') {
                    winner = true;
                }

            }
        }


        while (onBlackOut == true) {
            bg.roll();
            bg.checkBoards();
            System.out.println(bg);

            if ((bg.checkBlackoutWinner() == true) ) {
                onBlackOut = false;
            }
        }

    }
}

