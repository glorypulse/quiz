package study

import java.util.Scanner
import java.io.PrintWriter

class Layout {
  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val pw = new PrintWriter(System.out)

    val (n, ml, md) =  (sc.nextInt, sc.nextInt, sc.nextInt)

    import scala.collection.mutalbe.MutableList
    var adjLs = new Array[MutableList[(Int, Int)]](n)
    for (i in 1 to ml) {
      val (a, b, d) =  (sc.nextInt - 1, sc.nextInt - 1, sc.nextInt)
      adjLs(a) += (b, d)
    }
    for (i in 1 to md) {
      val (a, b, d) =  (sc.nextInt - 1, sc.nextInt - 1, sc.nextInt)
      adjLs(b) += (a, -d)
    }
  }

  // ベルマンフォード法で解く
  // d(i) + e >= d(j)
  //
  // d(i) + e < d(j) がtrueとなるようなi, jが存在 =>
  // 負の閉路がある=> 牛は並ぶことができない => -1
  //
  // d(n)がINF(初期値) => たどりつけない => -2
}
