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
    val PartyNameLs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList.map(_.toString)

    def apply(cin: Scanner): OneCase = {
      val N = cin.nextInt
      val Ps = (for (i <- 1 to N) yield{
        cin.nextInt
      }).toList
      new OneCase(N, Ps)
    }

  }

  class OneCase(N: Int, Ps:List[Int]) {
    def solve: String = {
      evacuate(List(""), (Ps zip OneCase.PartyNameLs).sortWith((s1,s2) => s1._1 > s2._1))
    }

    def evacuate(evcLs:List[String], r_ps:List[(Int,String)]): String = {
      val cmax = r_ps(0)._1
      if (r_ps.filter(m => m._1 > 0).isEmpty) {
        evcLs.mkString(" ")
      } else if (cmax == 1 && r_ps.filter(m => m._1 > 0).size == 3) {
        evacuate(evcLs :+ r_ps(0)._2,
          ((cmax - 1, r_ps(0)._2) :: r_ps.tail).sortWith((s1,s2) => s1._1 > s2._1))
      } else if (r_ps(1)._1 == cmax){
        evacuate(evcLs :+ (r_ps(0)._2 + r_ps(1)._2),
          ((cmax - 1, r_ps(0)._2) :: (cmax - 1, r_ps(1)._2) :: r_ps.tail.tail).sortWith((s1,s2) => s1._1 > s2._1))
      } else {
        evacuate(evcLs :+ (r_ps(0)._2 + r_ps(0)._2),
          ((cmax - 2, r_ps(0)._2) :: r_ps.tail).sortWith((s1,s2) => s1._1 > s2._1))
      }
    }
  }


}
