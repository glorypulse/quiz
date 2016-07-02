import java.util.Scanner
import java.io.PrintWriter
import scala.annotation.tailrec

object ProblemB {
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
      val stack = cin.next
      new OneCase(stack)
    }

  }

  class OneCase(stack: String) {
    def solve: String = {
      if (stack.contains("-"))
        checkSwitch(stack toList, (stack toList).tail :+ '+', 0) toString
      else
        0 toString
    }

    @tailrec
    final def checkSwitch(cs1: List[Char], cs2: List[Char], c:  Int) : Int = {
      (cs1, cs2) match {
        case (Nil, _) | (_, Nil) => c
        case (x::xs, y::ys) => checkSwitch (xs, ys, (if (x != y) 1 else 0) + c)
      }

    }
  }


}
