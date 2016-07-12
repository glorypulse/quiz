package study

/** Programming Contest Challenge Book p42 **/
object FewCoins {
  /* Input pattern
   c1 c5 c10 c50 c100 c500
   a

   Sample case
3 2 1 3 0 2
620


   */

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    val c1 = (1, sc.nextInt)
    val c5 = (5, sc.nextInt)
    val c10 = (10, sc.nextInt)
    val c50 = (50, sc.nextInt)
    val c100 = (100, sc.nextInt)
    val c500 = (500, sc.nextInt)
    val a = sc.nextInt

    val coins = List(c500, c100, c50, c10, c5, c1)

    val ans = solve(a, coins)
    println(s"USE ${ans} coins")


  }

  def solve(a : Int, coins: Seq[(Int, Int)]) : Int = {
    val usedCoins = useCoins(a, List(), coins)
    usedCoins.foreach {case (value, c) =>
      println(s"${value}YEN, COINS: ${c}")
    }
    usedCoins.map(_._2).sum


  }

  def useCoins(a: Int, ucoins: Seq[(Int, Int)], hcoins: Seq[(Int, Int)]) : Seq[(Int, Int)] = {
    if (a == 0 || hcoins.isEmpty) {
      return ucoins
    }

    val (value, coin) = hcoins.head
    var count = coin
    while (a < value * count) {
      count -= 1
    }
    useCoins(a - value * count, ucoins :+ (value, count), hcoins.tail)
  }
}

