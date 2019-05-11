import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * 重複のない文字列
 */
class Quiz01 {
    /*
     * Setを使ったバターン
     * Setへのadd => O(1)
     * Setのsize => O(1)?
     * これがn回 => O(n)
     */
    boolean isUniqueStringwithSet(String str) {
        HashSet<Character> appearedLetterSet = new HashSet<Character>();
        int old_length = 0;
        int new_length = 0;
        boolean status = true;
        for (char c : str.toCharArray()) {
            old_length = new_length;
            appearedLetterSet.add(c);
            new_length = appearedLetterSet.size();
            if (old_length == new_length) {
                status = false;
                break;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz01 quiz = new Quiz01();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            out.println(quiz.isUniqueStringwithSet(str));
        }
        out.flush();
    }
}
