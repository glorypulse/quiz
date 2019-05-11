package study

import java.util.Scanner
import java.io.PrintWriter

object Expedition {
  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val pw = new PrintWriter(System.out)

    val n = sc.nextInt
    var (a, b) = (new Array[Int](n), new Array[Int](n))
    for (i <- 0 until n) {
      a(i) = sc.nextInt
      b(i) = sc.nextInt
    }
    val (l, p) = (sc.nextInt, sc.nextInt)

    val ans = solve(n, l, p, a, b)
    pw.println(ans)
    pw.flush
    pw.close

  }

  def solve(n : Int, l : Int, p : Int, a : Array[Int], b : Array[Int]) : Int = {
    val al = 0 +: a.reverse.map(l - _) :+ l // スタートからの距離の配列に変換
    val bb = b.reverse
    import scala.collection.mutable.PriorityQueue
    var posGas = new PriorityQueue[Int]
    var now = 0
    var rp = p
    var i = 0
    var count = 0


    while (i <= n && count >= 0) {
      now = al(i + 1)
      rp -= al(i+1) - al(i)

      while (rp < 0 && posGas.size > 0) { // 補給
        rp += posGas.dequeue
        count += 1
      }
      if (rp < 0 && posGas.isEmpty) { // 到達できなかった
        count = -1
      }

      if (i != n) {
        posGas.enqueue(bb(i))
      }
      i += 1

    }

    count
  }

}
