import java.util.Random;
import java.util.LinkedHashSet;
import java.util.Set;

public class BingoGame {
    private static Random rand = new Random();
    protected String player;
    protected String CPU;
    private BingoBoard playerBoard;
    private BingoBoard computerBoard;
    private Set<Integer> rollSet = new LinkedHashSet<Integer>();
    private int roll;

    public void playersName(String player) {
        playerBoard = new BingoBoard(player, rand);
    }

    public void computersName(String CPU) {
       computerBoard = new BingoBoard(CPU, rand);
    }

    public void roll() {
        roll = rand.nextInt(75) + 1;
        while (!rollSet.add(roll)) {
            roll = rand.nextInt(75) + 1;
        }
    }

    public String toString() {
        //Print out boards, and roll history
        StringBuilder bingoString = new StringBuilder();
        bingoString.append(playerBoard.toString());
        bingoString.append(computerBoard.toString());
        return bingoString.toString();
    }

    public int getRollIndex() {
        return (roll - 1) / 15;
    }

    
    public String getRollString() {
        if (roll >= 1 && roll <= 15) {
            return "B" + roll;
        }
        else if (roll >= 16 && roll <= 30) {
            return "I" + roll;
        }
        else if (roll >= 31 && roll <= 45) {
            return "N" + roll;
        }
        else if (roll >= 46 && roll <= 60) {
            return "G" + roll;
        }
        else if (roll >= 61 && roll <= 75) {
            return "O" + roll;
        }
        else {
            return " ";
        }
    }

    public void checkBoards(boolean found) {
        int rollIndex = getRollIndex();
        String rollString = getRollString();

        // Display the number that is being called for 
        System.out.println("Calling " + rollString);
        
        computerBoard.checkBoard(roll, rollIndex, rollString);

        if (found == true) {
            playerBoard.checkBoard(roll, rollIndex, rollString); 
        }
        
    }

    // Add print statement for winners within method
    public boolean checkBingoWinner() {
        boolean playerBingo = playerBoard.checkBingo();
        boolean computerBingo = computerBoard.checkBingo();

        if (playerBingo && computerBingo) {
            // Both achieved bingo at the same time
            System.out.println("Player & Computer has won Bingo!");
            return true;
        }
        else if (playerBingo) {
            System.out.println("Player has won Bingo!");
            return true;
            // Player achieved bingo
        }
        else if (computerBingo) {
            System.out.println("Computer has won Bingo!");
            return true;
            // Computer achieved bingo
        }
        else {
            return false;
            // No winner yet
        }
    }

    // Add print statement for winners within method
    public boolean checkBlackoutWinner() {
        boolean playerBlackout = playerBoard.checkBlackOut();
        boolean computerBlackout = computerBoard.checkBlackOut();

        if (playerBlackout && computerBlackout) {
            // Both achieved blackout at the same time
            System.out.println("Player & Computer has won Blackout!");
            return true;
        }
        else if (playerBlackout) {
            System.out.println("Player has won Blackout!");
            return true;
            // Player achieved blackout
        }
        else if (computerBlackout) {
            System.out.println("Computer has won Blackout!");
            return true;
            // Computer achieved blackout
        }
        else {
            return false;
            // No winner yet
        }
    }

}
