package study

import java.util.Scanner
import java.io.PrintWriter

import scala.collection.mutable.MutableList
import java.util.Arrays

object Layout {
  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val pw = new PrintWriter(System.out)

    val (n, ml, md) =  (sc.nextInt, sc.nextInt, sc.nextInt)


    var adjLs = new Array[MutableList[(Int, Int)]](n)
    for (i <- 0 until adjLs.size) {
      adjLs(i) = MutableList[(Int, Int)]()
    }

    for (i <- 1 to ml) {
      val (a, b, d) =  (sc.nextInt - 1, sc.nextInt - 1, sc.nextInt)
      adjLs(a) += ((b, d))
    }
    for (i <- 1 to md) {
      val (a, b, d) =  (sc.nextInt - 1, sc.nextInt - 1, sc.nextInt)
      adjLs(b) += ((a, -d))
    }

    val ans = solve(adjLs)
    pw.println(ans)
    pw.flush
    pw.close
    
  }

  // ベルマンフォード法で解く
  // d(i) + e >= d(j)
  //
  // d(i) + e < d(j) がtrueとなるようなi, jが存在 =>
  // 負の閉路がある=> 牛は並ぶことができない => -1
  //
  // d(n)がINF(初期値) => たどりつけない => -2
  def solve(adjLs : Array[MutableList[(Int, Int)]]) : Int = {
    var distances = new Array[Int](adjLs.size)
    import java.util.Arrays
    Arrays.fill(distances, (Int.MaxValue - 10e6).toInt)
    distances(0) = 0

    var i = 0
    var update = true
    while ( i <= adjLs.size && update) {
      update = false
      adjLs.zipWithIndex.foreach{ case (v, a) =>
        v.foreach { case (b, d) =>
          if (distances(a) + d < distances(b)) {
            update = true
            distances(b) = distances(a) + d
          }
        }
      }
      if (i == adjLs.size && update) { // 負の閉路があるとき
        distances(adjLs.size-1) = -1
      }
      i = i + 1      
    }

    distances.last match {
      case Int.MaxValue => -2
      case _ => distances.last
      }
  }

}
