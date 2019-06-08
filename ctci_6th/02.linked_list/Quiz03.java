import java.util.Scanner;
import java.io.PrintWriter;

/**
 * 間の要素を削除
 * 3
 * a,b,c,d,e,f e
 * ab,dd,ee,ff,gg ee
 * 3,4,5,6,7 6
 */
class Quiz02 {
    boolean removeItem(OrgLinkedList list, OrgLinkedList k) {
        if (k == null || k.next == null) {
            return false;
        }

        k.data = k.next.data;
        k.next = k.next.next;
        System.out.println(list.all);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Quiz02 quiz = new Quiz02();
        for (int i = 0; i < num; i++) {
            String str = sc.next();
            String k = sc.next();
            System.out.println(String.valueOf(k) + "  -  " + str);
            // OrgLinkedListに変換
            // out.println(quiz.getIndexKbyLast(str, k);
        }
        out.flush();
    }
}
