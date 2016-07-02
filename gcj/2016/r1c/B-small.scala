import java.util.Scanner
import java.io.PrintWriter
import scala.annotation.tailrec

object ProblemC {
    def main(args: Array[String]) = {
      val cin: Scanner = new Scanner(System.in);
      val cout: PrintWriter = new PrintWriter(System.out);

      for (i <- 1 to cin.nextInt) {
        cout.print(f"Case #$i%d: ")
        cout.flush
        val ans = OneCase(cin).solve
      }
      cout.flush
      cout.close
    }

  object OneCase {

    def apply(cin: Scanner): OneCase = {
      val J, P, S, K = cin.nextInt
      new OneCase(J, P, S, K)
    }

  }

  class OneCase(J: Int, P: Int, S: Int, K:Int) {
    def solve: Unit = {
      calcPairs()
    }


    def calcPairs():Unit = {
      val checkLs = List(J * P * K, J * S * K, P * S * K , J * P * S)
      val min_ans = checkLs.min
      val min_i = checkLs.indexOf(min_ans)

      println(min_ans)

      if (min_i == 3) { // JPS
        for (j <- 1 to J; p <- 1 to P; s <- 1 to S) {
          println(j.toString + " " + p.toString + " " + s.toString)
        }
      } else if (min_i == 0){
        val sLs = List.range(1, S+1)
        for (j <- 1 to J; p <- 1 to P; k <- 0 to K-1) {
          println(j.toString + " " + p.toString + " " + sLs(k).toString)
        }
      } else if (min_i == 1) {
        val pLs = List.range(1, P+1)
        for (j <- 1 to J; s <- 1 to S; k <- 0 to K-1) {
          println(j.toString + " " + pLs(k).toString + " " + s.toString)
        }
      } else {
        val jLs = List.range(1, J+1)
        for (p <- 1 to P; s <- 1 to S; k <- 0 to K-1) {
          println(jLs(k).toString + " " + p.toString + " " + s.toString)
        }
      }
    }

  }
}
