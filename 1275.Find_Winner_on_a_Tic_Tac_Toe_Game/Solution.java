class Solution {
    char A = 'X';
    char B = 'O';

    public String tictactoe(int[][] moves) {
        boolean turnA = true;
        char[][] squares = new char[3][3];
        for (int[] move: moves) {
            squares[move[0]][move[1]] = playerChar(turnA);
            if (checkWin(squares, turnA, move)) {
                if (turnA) return "A";
                return "B";
            }
            turnA = !turnA;
        }

        if (moves.length == 9) return "Draw";
        return "Pending";

    }

    char playerChar(boolean turnA) {
        if (turnA) return A;
        return B;
    }

    boolean checkWin(char[][] squares, boolean turnA, int[] move) {
        char checkChar = playerChar(turnA);
        // row
        boolean result = true;
        for (int i = 0; i < 3; i ++) {
            if(!(squares[i][move[1]] == checkChar)) {
                result = false;
                break;
            }
        }
        if (result) return true;

        // col
        result = true;
        for (int i = 0; i < 3; i ++) {
            if(!(squares[move[0]][i] == checkChar)) {
                result = false;
                break;
            }
        }
        if (result) return true;

        // diagonal
        if (move[0] == move[1]) {
            result = true;
            for (int i = 0; i < 3; i ++) {
                if(!(squares[i][i] == checkChar)) {
                    result = false;
                    break;
                }
            }
            if (result) return true;
        }
        if (2 - move[0] == move[1]) {
            result = true;
            for (int i = 0; i < 3; i ++) {
                if(!(squares[2 - i][i] == checkChar)) {
                    result = false;
                    break;
                }
            }
            if (result) return true;
        }
        return false;
    }
}
