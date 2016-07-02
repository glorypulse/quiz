import java.util.Scanner
import java.io.PrintWriter
import scala.annotation.tailrec

import scala.math.pow

object ProblemC {
    def main(args: Array[String]) = {
      val cin: Scanner = new Scanner(System.in);
      val cout: PrintWriter = new PrintWriter(System.out);

      for (i <- 1 to cin.nextInt) {
        cout.println(f"Case #$i%d:")
        cout.flush
        val ans = OneCase(cin).solve
      }
      cout.flush
      cout.close
    }

  object OneCase {
    def apply(cin: Scanner): OneCase = {
      val N, J = cin.nextInt
      new OneCase(N, J)
    }

  }

  class OneCase(N: Int, J: Int) {
    def solve: Unit = {
      val dls = getDivisors(1, Nil)
      val n = getExpOverJ(1)
      val d_index = getDIndex(0, n, dls)
      //makeDigits("0" * dls(d_index)._1, d_index, dls)
      makeDigits("0" * (dls(d_index)._1 - 2), dls(d_index)._2, 1)
    }

    @tailrec
    final def getDivisors(i: Int, dls: List[(Int,Int)]) : List[(Int,Int)]= {
      if (i < N / 2) {
        if ((N % i) == 0 ) getDivisors(i + 1, (N / i, i) :: dls)
        else getDivisors(i + 1, dls)
      }
      else {
        dls
      }
    }

    @tailrec
    final def getExpOverJ(i: Int): Int= {
      val check = pow(2,i)
      if (check >= J) i
      else getExpOverJ(i + 1)
    }

    @tailrec
    final def getDIndex(i: Int, n: Int, cdls: List[(Int, Int)]): Int= {
      if (cdls.isEmpty) -1 // don't have d_index
      else {
        val (x, y) = cdls.head
        if (x >= n + 2) i
        else getDIndex(i + 1, n, cdls.tail)
      }
    }


    //    def makeDigits(c_digits: String, index: Int, dls: List[(Int, Int)]) = {
    @tailrec
    final def makeDigits(c_digits: String, pair_num: Int, i: Int) :Unit= {
      //certainly exists d_index & satisfies pow(2,dls(d_index)._1) > J
      val digits = "1" + c_digits + "1"
      print(digits * pair_num + " ")
      for (i <- 2 to 10) {
        print(java.lang.Long.parseLong(digits, i).toString)
        if (i != 10) print(" ")
        else println
      }

      val nextNum = (java.lang.Long.parseLong(c_digits, 2) + 1).toBinaryString
      val sh_d = c_digits.length - nextNum.length

      if (sh_d >= 0 && i < J) makeDigits("0" * sh_d + nextNum, pair_num, i + 1)

    }
  }


}
