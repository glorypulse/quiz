import java.util.Scanner;
import java.io.PrintWriter;

// A - Dividing a String
class Main {
    static int divideStr(String str) {
        int count = 0;
        int pre = '\0';
        char cur;
        for (int i = 0; i < str.length(); i ++) {
            cur = str.charAt(i);
            if (pre == cur && i != str.length() - 1) {
                count ++;
                i ++;
                pre = '\0';
            } else if (pre != cur) {
                count ++;
                pre = cur;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String str = sc.nextLine();

        out.println(divideStr(str));
        out.flush();
    }
}
