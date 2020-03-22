import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static int snowDepth(int h1, int h2) {
        return h1 - h2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int h1 = Integer.parseInt(sc.next());
        int h2 = Integer.parseInt(sc.next());

        out.println(snowDepth(h1, h2));
        out.flush();
    }
}
