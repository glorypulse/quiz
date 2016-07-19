package study

import scala.annotation.tailrec

/** Programming Contest Challenge Book p49
  POJ 3253 Fence Repair
  http://poj.org/problem?id=3253
  */

object FenceRepair {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    val N = sc.nextInt
    val Lls = for (i <- 0 until N) yield {
      sc.nextInt
    }

    val ans = solve(N, Lls)
    println(ans)
  }

  def solve(N: Int, Lls: Seq[Int]) : Int = {

    // もっとうまい初期化の仕方は？
    var pq = collection.mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    pq ++= Lls

    calcCost(0, pq)

  }


  @tailrec
  def calcCost(sum : Int, pq : collection.mutable.PriorityQueue[Int]) : Int = {
    pq.size match {
      case n if n <= 1 => sum
      case _ => {
        val (l1, l2) = (pq.dequeue, pq.dequeue)
        val cut = l1+l2
        calcCost(sum + cut, pq ++ List(cut))
      }
    }
  }
}
