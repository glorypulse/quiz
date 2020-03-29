import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

class Main {
    static boolean isStrongAnagram(String s) {
        int length = s.length();
        int mid = (length - 1) / 2;
        boolean isMidOdd = mid % 2 == 1;
        int mid1 = (mid - 1) / 2;
        if (!isMidOdd) mid1 ++;
        int start2 = (length + 1) / 2;
        int mid2 = start2 + mid1;
        Stack<Character> stackAll = new Stack<>();
        Stack<Character> stackSub = new Stack<>();
        char c, tmp;
        for (int i = 0; i < length; i ++) {
            c = s.charAt(i);
            if (i < mid) {
                stackAll.push(c);
                if (i < mid1) {
                    stackSub.push(c);
                } else if (!isMidOdd || i > mid1) {
                    tmp = stackSub.pop();
                    if (c != tmp) return false;
                }
            } else if (i == mid) {
                if (!stackSub.isEmpty()) return false;
            } else {
                tmp = stackAll.pop();
                if (c != tmp) return false;
                if (i >= start2) {
                    if (i < mid2) {
                        stackSub.push(c);
                    } else if (!isMidOdd || i > mid2) {
                        tmp = stackSub.pop();
                        if (c != tmp) return false;
                    }
                }
            }
        }
        if (!stackAll.isEmpty() || !stackSub.isEmpty()) return false;
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();

        if (isStrongAnagram(s)) {
            out.println("Yes");
        } else {
            out.println("No");
        }
        out.flush();
    }
}
