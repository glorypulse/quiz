package study;

import java.util.Scanner;
import java.io.PrintWriter;

/** Programming Contest Challenge Book p56
    LCS Problem
 */
public class LCSProblem {
    /* Input sample
4 4
abcd becd
    */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        String t = sc.next();

        LCSProblem lcsp = new LCSProblem();
        int ans = lcsp.solve(s, t);

        pw.println(String.valueOf(ans));
        pw.flush();
        pw.close();
            
    }

    int solve(String s, String t) {
        int[][] lcs = new int[s.length()+1][t.length()+1];
        // initialize
        for (int i = 0; i < s.length()+1; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 1; j < t.length()+1; j++) {
            lcs[0][j] = 0;
        }

        // dynamic programming
        for (int i = 1; i < s.length()+1; i++) {
            for (int j=1; j < t.length()+1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) { // 文字列のi,jとlcs関数のi,jの関係に注意
                    lcs[i][j] = Math.max(lcs[i-1][j-1]+1, Math.max(lcs[i-1][j], lcs[i][j-1]));
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return lcs[s.length()][t.length()];
    }
    
}
    
