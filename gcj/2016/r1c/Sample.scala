import java.util.Scanner
import java.io.PrintWriter
import scala.annotation.tailrec

object ProblemA {
    def main(args: Array[String]) = {
      val cin: Scanner = new Scanner(System.in);
      val cout: PrintWriter = new PrintWriter(System.out);

      for (i <- 1 to cin.nextInt) {
        val ans = OneCase(cin).solve
        cout.println(f"Case #$i%d: $ans")
      }
      cout.flush
      cout.close
    }

  object OneCase {
    def apply(cin: Scanner): OneCase = {
      val N = cin.nextInt
      new OneCase(N)
    }

  }

  class OneCase(N: Int) {
    def solve: String = {
      1.toString
    }
  }


}
