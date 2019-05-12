import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * 順列チェック
 * sample:
 * TESTCASE
 * str_a1 str_b1
 * str_a2 str_b2
 * ...
 * str_aTESTCASE str_bTESTCASE
 */
class Quiz02 {
    /*
     * str_a と str_bを両方ソートして比較する
     * O(AlogA + BlogB)
     */
    boolean checkPermutation(String str_a, String str_b) {
        char[] sorted_a = str_a.toCharArray();
        Arrays.sort(sorted_a);
        char[] sorted_b = str_b.toCharArray();
        Arrays.sort(sorted_b);
        return Arrays.equals(sorted_a, sorted_b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz02 quiz = new Quiz02();
        for (int i = 0; i < num; i++) {
            String str_a = sc.next();
            String str_b = sc.next();
            out.println(quiz.checkPermutation(str_a, str_b));
        }
        out.flush();
    }
}
