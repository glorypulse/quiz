import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static int countChangingToAnaglam(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] sChar = s.toCharArray();
        int count = 0;
        while (left < right) {
            if (sChar[left] != sChar[right]) count ++;
            left ++;
            right --;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();

        out.println(countChangingToAnaglam(s));
        out.flush();
    }
}
