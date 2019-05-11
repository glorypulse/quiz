package study

import java.util.Scanner;
import java.io.PrintWriter;

import scala.collection.mutable.{MutableList, PriorityQueue}

/** Programming Contest Challenge Book p103
  POJ No.3723
  http://poj.org/problem?id=3723
  */

object Conscription {

  def main(args : Array[String]) {
    val sc = new Scanner(System.in);
    val pw = new PrintWriter(System.out);

    val t = sc.nextInt;

    for (i <- 1 to t) {
      val (n, m, r) = (sc.nextInt, sc.nextInt, sc.nextInt)

      // girls => 0 .. n-1, boys => n .. n+m-1
      val soldiers = n + m

      var relations = new Array[Array[Int]](soldiers)
      for (rn <- 0 until relations.size) {
        relations(rn) = new Array[Int](soldiers)
        for(rd <- 0 until relations(rn).size) {
          relations(rn)(rd) = 0 // 存在しない辺は削減コスト０
        }
      }

      for (j <- 1 to r) {
        val (x, y, d) = (sc.nextInt, sc.nextInt + n, sc.nextInt)
        relations(x)(y) = Math.min(relations(x)(y), -d)
        relations(y)(x) = Math.min(relations(x)(y), -d)
      }

      val ans = solve(soldiers, relations)
      pw.println(ans)
    }

    pw.flush
    pw.close

  }

  def solve(soldiers : Int, relations : Array[Array[Int]]) : Int = {

    val mincost_order = new Ordering[(Int, Int)]{ def compare(x : (Int, Int), y: (Int, Int)) = {
      if (x._1 < y._1) 1 else -1
    }}
    var mincost = PriorityQueue[(Int, Int)]()(mincost_order) // (cost, label)

    import scala.collection.mutable.Set
    var unused = Set(1 until soldiers).flatten

    def update_mincost(s : Int) = {
      var new_mincost = PriorityQueue[(Int, Int)]()(mincost_order)
      for (check_s <- mincost) {
        if (unused(check_s._2)) {
          val new_min = Math.min(check_s._1, relations(s)(check_s._2))
          new_mincost.enqueue((new_min, check_s._2))
        }
      }
      mincost = new_mincost
    }


    // initialize
    for (un_s <- unused) {
      mincost.enqueue((relations(0)(un_s), un_s))
    }

    val InitCost = 10000
    var cost = InitCost

    while (!unused.isEmpty) {
      // define s
      val (d, s) = mincost.dequeue

      // calc about s
      unused -= s
      cost += InitCost + d

      // update mincost
      update_mincost(s)
    }

    cost
  }

}
