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
      val N = cin.nextInt
      val fLs = (for (i <- 1 to N-1) yield {
        (for (i <- 1 to N) yield cin.nextInt).toList
      }).toList
      val n_Ls = (for (i <- 1 to N) yield cin.nextInt).toList
      val sLs = (for (i <- 1 to N-1) yield {
        (for (i <- 1 to N) yield cin.nextInt).toList
      }).toList
      new OneCase(N, fLs, n_Ls, sLs.reverse)
    }
  }

  class OneCase(N: Int, fLs: List[List[Int]], n_Ls: List[Int], sLs: List[List[Int]]) {
    def solve: String = {
      val (rf2, rs2) = checkList(fLs.flatten, sLs.flatten, Nil, Nil)
      //println(rf2.filter(rs2.contains))
      whichNls(rf2.filterNot(rs2.contains), rs2.filterNot(rf2.contains)).sorted.mkString(" ")
    }

    @tailrec
    final def checkList (r_fLs: List[Int], r_sLs: List[Int], r_fLs2: List[Int], r_sLs2: List[Int]) : (List[Int], List[Int])= {
      (r_fLs, r_sLs) match {
        case (Nil, Nil) => (r_fLs2, r_sLs2)
        case (Nil, _) => (r_fLs2, r_sLs2 ++ r_sLs)
        case (_, Nil) => (r_fLs2 ++ r_fLs, r_sLs2)
        case (x::xs, y::ys) => if (x == y) {
          checkList(xs, ys, r_fLs2, r_sLs2)
        } else if (x > y) {
          checkList(r_fLs, ys, r_fLs2, r_sLs2 :+ y)
        } else {
          checkList(xs, r_sLs, r_fLs2 :+ x, r_sLs2)
        }
      }
    }

    def whichNls(rf2: List[Int], rs2: List[Int]) = {
      if (rf2.filterNot(n_Ls.contains).isEmpty)
        n_Ls.filterNot(rf2.contains) ++ rs2
      else
        n_Ls.filterNot(rs2.contains) ++ rf2
    }
  }


}
