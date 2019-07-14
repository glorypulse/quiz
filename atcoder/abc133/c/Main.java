import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static int minMod(int l, int r) {
        if (r - l >= 2019) {
            return 0;
        }

        int lMod = l % 2019;
        int rMod = r % 2019;
        if (lMod > rMod) return 0;
        if (r - l > 3) {
            if (lMod <= 673 && rMod >= 673) return 0;
            if (lMod <= 1346 && rMod >= 1346) return 0;
            if (lMod % 3 == 0 || lMod % 3 == 2) return (lMod * (lMod + 1)) % 2019;
            if (lMod % 3 == 1) return (lMod * (lMod + 2)) % 2019;
        }
        return (lMod * (lMod + 1)) % 2019;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int l = Integer.parseInt(sc.next());
        int r = Integer.parseInt(sc.next());

        out.println(minMod(l, r));
        out.flush();
    }
}
