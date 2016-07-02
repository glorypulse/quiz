import java.util.Scanner
import java.io.PrintWriter
import scala.annotation.tailrec

object ProblemD {
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
      val K,C,S = cin.nextInt
      new OneCase(K, C, S)
    }

  }

  class OneCase(K: Int, C: Int, S: Int) {
    def solve: String = {
      if ((C == 1 && S < K) || (C > 1 && S < K-1)) "IMPOSSIBLE"
      else if (K == 1) "1"
      else checkTile.mkString(" ")
    }

    def checkTile = {
      if (C == 1) {
        List.range(1, K + 1).map(_.toString)
      } else {
        List.tabulate(K-1)(i => 2 + i + K * i)
      }
    }
  }


}
