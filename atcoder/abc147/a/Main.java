import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static String blackjack(int a1, int a2, int a3) {
        if (a1 + a2 + a3 <= 21) {
            return "win";
        }
        return "bust";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a1 = Integer.parseInt(sc.next());
        int a2 = Integer.parseInt(sc.next());
        int a3 = Integer.parseInt(sc.next());

        out.println(blackjack(a1, a2, a3));
        out.flush();
    }
}
