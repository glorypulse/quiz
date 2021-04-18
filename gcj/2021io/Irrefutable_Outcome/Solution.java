import java.util.*;
import java.io.*;
public class Solution {
    class Winner {
        boolean izabela;
        int points;
        Winner(boolean izabela, int points) {
            this.izabela = izabela;
            this.points = points;
        }

        boolean isIzabela() {
            return izabela;
        }

        char getWinner() {
            if (izabela) {
                return 'I';
            }
            return 'O';
        }

        int getPoints() {
            return points;
        }
    }
    HashMap<String, Winner> izabelaMap;
    HashMap<String, Winner> olgaMap;

    Solution() {
        izabelaMap = new HashMap<>();
        olgaMap = new HashMap<>();
    }

    Winner getWinner(String b, boolean izabela) {
        if (izabela) {
            if (izabelaMap.get(b) != null) {
                return izabelaMap.get(b);
            }
        } else {
            if (olgaMap.get(b) != null) {
                return olgaMap.get(b);
            }
        }

        int left = 0;
        int right = b.length() - 1;
        Winner winner = null;
        boolean init = izabela;
        while (left <= right) {
            char turn = izabela ? 'I' : 'O';
            boolean leftTurn = b.charAt(left) == turn;
            boolean rightTurn = b.charAt(right) == turn;
            if (leftTurn && rightTurn) {
                if (left == right || b.charAt(left + 1) == turn || b.charAt(right - 1) == turn) {
                    winner = new Winner(izabela, right - left + 1);
                } else {
                    Winner leftWinner = getWinner(b.substring(left + 1, right + 1), !izabela);
                    Winner rightWinner = getWinner(b.substring(left, right), !izabela);
                    if (leftWinner.isIzabela() == rightWinner.isIzabela()) {
                        if (leftWinner.isIzabela() == izabela) {
                            if (leftWinner.getPoints() > rightWinner.getPoints()) {
                                winner = leftWinner;
                            } else {
                                winner = rightWinner;
                            }
                        } else {
                            if (leftWinner.getPoints() > rightWinner.getPoints()) {
                                winner = rightWinner;
                            } else {
                                winner = leftWinner;
                            }
                        }
                    } else {
                        if (leftWinner.isIzabela() == izabela) {
                            winner = leftWinner;
                        } else {
                            winner = rightWinner;
                        }
                    }
                }
                break;
            } else if (leftTurn) {
                left ++;
            } else if (rightTurn) {
                right --;
            } else {
                winner = new Winner(!izabela, right - left + 2);
                break;
            }
            izabela = !izabela;
        }
        if (winner == null) {
            winner = new Winner(!izabela, 1);
        }

        if (init) {
            izabelaMap.put(b, winner);
        } else {
            olgaMap.put(b, winner);
        }
        return winner;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int t = 1; t <= test_case; t++) {
            String b = in.next();
            Winner winner = sol.getWinner(b, true);
            System.out.println("Case #" + t + ": " + winner.getWinner() + " " + winner.getPoints());
        }
    }
}
