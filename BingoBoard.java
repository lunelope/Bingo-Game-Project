import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BingoBoard {
    private String name;
    private int[][] bingoBoard = new int[5][5];
    private static final int B_COLUMN = 0, I_COLUMN = 1, N_COLUMN = 2, G_COLUMN = 3, O_COLUMN = 4;

        /* 
        * Bingo Board Columns can only contain certain numbers
        * B: 1-15
        * I: 16-30
        * N: 31-45
        * G: 46-60
        * O: 61-75
        */

        // Constructor method to generate a bingo board
    public BingoBoard(String name, Random rand) {
        this.name = name;
        Set<Integer> boardSet = new HashSet<>();
        for (int i = 0; i < bingoBoard.length; ++i) {
            int boardNum = 0;
            for (int j = 0; j < bingoBoard[i].length; ++j) {
                int randomNum = rand.nextInt(15) + 1 + boardNum;

                // Range of random numbers generated throughout the board
                // With range starting at (1-15) and increasing both bounds by 15
                while (!boardSet.add(randomNum)) {
                    randomNum = rand.nextInt(15) + 1 + boardNum;
                }
                bingoBoard[i][j] = randomNum;
                boardNum += 15;
            }
        }
        bingoBoard[2][2] = 0;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append(name + "'s Board:\n");
        boardString.append("  B   I   N   G   O\n");
        for (int i = 0; i < 5; ++i) {
            boardString.append(String.format("%3d %3d %3d %3d %3d%n", 
                      bingoBoard[i][B_COLUMN], bingoBoard[i][I_COLUMN], 
                      bingoBoard[i][N_COLUMN], bingoBoard[i][G_COLUMN], 
                      bingoBoard[i][O_COLUMN]));
        }
        return boardString.toString();
    }

    public boolean checkBoard(int roll, int rollIndex, String rollString) {
        
        for (int i = 0; i < 5; ++i) {
            // if number found within board outputs "# found"
            if (bingoBoard[i][rollIndex] == roll) {
                bingoBoard[i][rollIndex] = 0; // Mark as found
                System.out.println(rollString + " found for " + name);
                return true;
            }
        }
        // Else if number not found within board; Outputs "not found"
        System.out.println(rollString + " not found for " + name);
        return false;
    }

    public boolean checkRowBingo() {
        for (int i = 0; i < 5; ++i) {
            if (bingoBoard[i][0] == bingoBoard[i][1] && bingoBoard[i][1] == bingoBoard[i][2] && bingoBoard[i][2] == bingoBoard[i][3] && bingoBoard[i][3] == bingoBoard[i][4]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnBingo() {
        for (int i = 0; i < 5; ++i) {
            if (bingoBoard[0][i] == bingoBoard[1][i] && bingoBoard[1][i] == bingoBoard[2][i] && bingoBoard[2][i] == bingoBoard[3][i] && bingoBoard[3][i] == bingoBoard[4][i]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalBingo() {
        if (bingoBoard[0][0] == bingoBoard[1][1] && bingoBoard[1][1] == bingoBoard[2][2] && bingoBoard[2][2] == bingoBoard[3][3] && bingoBoard[3][3] == bingoBoard[4][4]) {
            return true;
        }
        if (bingoBoard[0][4] == bingoBoard[1][3] && bingoBoard[1][3] == bingoBoard[2][2] && bingoBoard[2][2] == bingoBoard[3][1] && bingoBoard[3][1] == bingoBoard[4][0]) {
            return true;
        }
        return false;
    }

    public boolean checkBingo() {
        return checkRowBingo() || checkColumnBingo() || checkDiagonalBingo();
    }

    public boolean checkBlackOut() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (bingoBoard[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}