import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * URLify
 * sample:
 * TESTCASE
 * "str1", str1_length
 * "str2", str2_length
 * ...
 * "strTESTCASE", strTESTCASE_length
 */
class Quiz03 {
    /*
     * strを読み込んでspaceを%20に変える
     * O(n)
     */
    String changeSpaceto20(String str) {
        char[] char_array_org = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(char_array_org[i] == ' ') count++;
        }

        char[] char_array = new char[str.length() + count * 2];
        int index = 0;
        for (char org : char_array_org) {
            if (org == ' ') {
                char_array[index] = '%';
                char_array[index + 1] = '2';
                char_array[index + 2] = '0';
                index = index + 3;
            }
            else {
                char_array[index] = org;
                index++;
            }
        }
        return new String(char_array);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz03 quiz = new Quiz03();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] items = line.split("\"");
            out.println(quiz.changeSpaceto20(items[1]));
        }
        out.flush();
    }
}
