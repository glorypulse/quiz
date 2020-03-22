import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static String synop_vv(int m) {
        String vv = "89";
        if (m < 100) {
            vv = "00";
        } else if (m < 1000) {
            vv = "0" + String.valueOf(m / 100);
        } else if (m <= 5000) {
            vv = String.valueOf(m / 100);
        } else if (m <= 30000) {
            vv = String.valueOf(m / 1000 + 50);
        } else if (m <= 70000) {
            vv = String.valueOf((m / 1000 - 30) / 5 + 80);
        }
        return vv;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int m = Integer.parseInt(sc.next());

        out.println(synop_vv(m));
        out.flush();
    }
}
