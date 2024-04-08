import java.util.Scanner;

public class Main {

    public static boolean FindingBingo(Scanner scnr, BingoGame bg) {
        String found;
        boolean playerFound = false;
        
        System.out.println("Got " + bg.getRollString() + "?");
        System.out.print("If found, type found. Else type no: ");
        found = scnr.next();

        if (found.equals("found") || found.equals("Found")) {
            playerFound = true;
        }

        else if (found.equals("no") || found.equals("No") || found.equals("NO")) {
            // skip
            playerFound = false;
        }

        return playerFound;
    }

   public static void main(String [] args) {

        Scanner scnr = new Scanner(System.in);
        BingoGame bg = new BingoGame();

        String playerName;
        String computerName;

        // Introduction
        System.out.println("Welcome to Bingo!");
        System.out.println();

        System.out.print("Enter in your name: ");
        bg.playersName(scnr.next());

        System.out.print("Enter in Opponents name: ");
        bg.computersName(scnr.next());

        System.out.println("Let's Begin.....");
        System.out.println();



        System.out.println(bg);
        int num = -1; //placeholder
        boolean winner = false;
        boolean onBlackOut = false;
        char continuePlay;


        while (winner == false) {
            bg.roll();
            bg.checkBoards(FindingBingo(scnr, bg));
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
            bg.checkBoards(FindingBingo(scnr, bg));
            System.out.println(bg);

            if ((bg.checkBlackoutWinner() == true) ) {
                onBlackOut = false;
            }
        }


    }
}

