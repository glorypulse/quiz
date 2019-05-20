import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * 重複要素の削除
 * 3
 * 1,2,1,4,3,1
 * a,bb,aa,a,bb
 * abc,cde,edf,cde,abd
 */
class Quiz01 {
    /*
     * Setへのadd => O(1)
     * Setのsize => O(1)?
     * これがn回 => O(n)
     */
    LinkedList<String> removeDuplicatedOnList(String[] array) {
        // List<String> dupList = List.of(array);
        LinkedList<String> dupList = new LinkedList<String>(Arrays.asList(array)); // 削除のパフォーマンス
        HashSet<String> itemSet = new HashSet<String>();
        int oldLength = 0;
        int newLength = 0;
        boolean status = true;
        Iterator<String> l = dupList.iterator();

        while(l.hasNext()) {
            String item = l.next();
            oldLength = newLength;
            itemSet.add(item);
            newLength = itemSet.size();
            if (oldLength == newLength) {
                l.remove();
            }
        }
        return dupList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz01 quiz = new Quiz01();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            out.println(quiz.removeDuplicatedOnList(str.split(",")));
        }
        out.flush();
    }
}
