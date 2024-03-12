import java.util.Random;
import java.util.LinkedHashSet;
import java.util.Set;

public class BingoGame {
    private static Random rand = new Random();
    private BingoBoard playerBoard = new BingoBoard("Player", rand);
    private BingoBoard computerBoard = new BingoBoard("Computer", rand);
    private Set<Integer> rollSet = new LinkedHashSet<Integer>();
    private int roll;

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
        bingoString.append("Roll History: ");
        bingoString.append(rollSet);
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

    public void checkBoards() {
        int rollIndex = getRollIndex();
        String rollString = getRollString();

        // Display the number that is being called for 
        System.out.println("Calling " + rollString);

        playerBoard.checkBoard(roll, rollIndex, rollString);
        computerBoard.checkBoard(roll, rollIndex, rollString);
    }

    public boolean checkBingoWinner() {
        boolean playerBingo = playerBoard.checkBingo();
        boolean computerBingo = computerBoard.checkBingo();

        if (playerBingo && computerBingo) {
            // Both achieved bingo at the same time
            return true;
        }
        else if (playerBingo) {
            return true;
            // Player achieved bingo
        }
        else if (computerBingo) {
            return true;
            // Computer achieved bingo
        }
        else {
            return false;
            // No winner yet
        }
    }

    public boolean checkBlackoutWinner() {
        boolean playerBlackout = playerBoard.checkBlackOut();
        boolean computerBlackout = computerBoard.checkBlackOut();

        if (playerBlackout && computerBlackout) {
            // Both achieved blackout at the same time
            return true;
        }
        else if (playerBlackout) {
            return true;
            // Player achieved blackout
        }
        else if (computerBlackout) {
            return true;
            // Computer achieved blackout
        }
        else {
            return false;
            // No winner yet
        }
    }

}