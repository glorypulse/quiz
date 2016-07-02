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
      val S = cin.next
      new OneCase(S)
    }

  }

  class OneCase(S: String) {
    def solve: String = {
      mkStr(Nil, S.toList)
    }

    @tailrec
    final def mkStr(cls : List[Char], rls : List[Char]) : String= {
      rls match {
        case Nil => cls.mkString
        case x::xs => {
          cls match {
            case Nil => mkStr(List(x), rls.tail)
            case y::ys => if (y > x) mkStr (cls :+ x, xs) else mkStr(x :: cls, xs)
          }
        }
      }
    }
  }
}
