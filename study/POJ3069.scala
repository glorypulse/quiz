package study

import scala.annotation.tailrec

/** Programming Contest Challenge Book p47
  POJ 3069 Sruman's Army
  http://poj.org/problem?id=3069 
  */

object SrumansArmy {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    import scala.util.control.Breaks
    val inputLoop = new Breaks
    inputLoop.breakable { while(true) {

      val (inputR, inputN) = (sc.nextInt, sc.nextInt)
      if (inputR == -1) inputLoop.break;
      val inputX = for (i <- 0 until inputN) yield {
        sc.nextInt
      }
      val ans = solve(inputR, inputN, inputX.sorted)
      pw.println(ans)
    }}

    pw.flush
    pw.close

  }

  def solve(r: Int, n: Int, xLs: Seq[Int]):Int = {

    @tailrec
    def putPalantirs(cpoint: Int, npoint: Int, count: Int, preX: Int, rxLs: Seq[Int]) : Int = {
      rxLs.size match {
        case 0 => npoint match {
          case 0 => count
          case _ => count + 1 // npointが0でないときは、Palantirの効力が届かないtroopが存在のため、最後のtroopにPalantirを持たせる
        }
        case _ => (cpoint, npoint) match {
          // npointが0でないとき =
          //   Palantirの効力が届かないtroopがいるので、npointよりも手前にPalantirが必要
          case (0, _) => rxLs.head match {
            case p if p < npoint => putPalantirs(0, npoint, count, p, rxLs.tail)
            case p if p == npoint => putPalantirs(p + r, 0, count + 1, p, rxLs.tail)
            case p if p > npoint => putPalantirs(preX + r, 0, count + 1, preX, rxLs)
          }

          // cpointが0でないとき =
          //  Palantirの効力はチェックしたtroopには行き届いているので、届かなくなるtroopがないか列を確認
          case (_, 0) => rxLs.head match {
            case p if p > cpoint => putPalantirs(0, p + r, count, p, rxLs.tail)
            case p if p <= cpoint => putPalantirs(cpoint, 0, count, p, rxLs.tail)
          }
        }
      }
    }

    putPalantirs(0, xLs.head + r, 0, 0, xLs)
  }

}
