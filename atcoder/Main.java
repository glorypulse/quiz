import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static int cheaper(int n, int a, int b) {
        int train = n * a;
        if ( train < b ) {
            return train;
        }
        return b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(sc.next());
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());

        out.println(cheaper(n, a, b));
        out.flush();
    }
}
