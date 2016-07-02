import java.util.Scanner;
import java.io.PrintWriter;
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
      if (N == 0)  "INSOMNIA"
      else checkDigit(N, 1, "0123456789" toList) toString
    }

    @tailrec
    final def checkDigit (b: Int, i: Int, cl: List[Char]): Int= {
      val b_ls = b.toString toList
      val cl_next = cl.filterNot(b_ls contains)
      if (cl_next.isEmpty) b
      else checkDigit(N * (i+1), i+1, cl_next)
    }
  }


}
