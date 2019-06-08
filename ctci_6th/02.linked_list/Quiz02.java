import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * 後ろからK番目を返す
 * 3
 * 3 1,2,1,4,3,1
 * 2 a,bb,aa,a,bb
 * 5 abc,cde,edf,cde,abd
 */
class Quiz02 {
    /*
     * Setへのadd => O(1)
     * Setのsize => O(1)?
     * これがn回 => O(n)
     */
    String getIndexKbyLast(List<String> list, int k) {
        int size = list.size();
        int indexK = size - k;
        return list.get(indexK);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz02 quiz = new Quiz02();
        for (int i = 0; i < num; i++) {
            int k = Integer.parseInt(sc.next());
            String str = sc.next();
            // System.out.println(String.valueOf(k) + "  -  " + str);
            out.println(quiz.getIndexKbyLast(new LinkedList<String>(Arrays.asList(str.split(","))), k));
        }
        out.flush();
    }
}
