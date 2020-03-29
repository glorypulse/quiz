import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static String maxVolume(int l) {
        double vol = l * l * l / 27.0;

        return String.format("%.12f", vol);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int l = Integer.parseInt(sc.next());

        out.println(maxVolume(l));
        out.flush();
    }
}
