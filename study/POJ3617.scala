package study

import scala.annotation.tailrec

/** Programming Contest Challenge Book p45,
  POJ 3617 Best Cow Line
  http://poj.org/problem?id=3617
**/

object BestCowLine {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    val N = sc.nextInt
    val S = (for (i <- 0 until N) yield {
      sc.next
    }).mkString

    val ans = solve(N, S)

    pw.println(ans)
    pw.flush
    pw.close
  }

  import scala.collection.mutable.LinearSeq // 末尾に追加するため、MutableListを利用

  def solve(N: Int, S: String) : String = {
    val S_normal = S.toList
    val S_reverse = S.reverse.toList

    greedy_check(N, S_normal, S_reverse, LinearSeq())
  }


  @tailrec
  def greedy_check(count: Int, nStr: Seq[Char], rStr: Seq[Char], res: LinearSeq[Char]) : String = {
    count match {
      case 0 => res.mkString
      case _ => {

        // 80文字ずつ改行
        val resLn = if (res.filterNot(_ == '\n').size % 80 == 0) res :+ '\n' else res

        // １つめの文字列を選択するときはtrue, 2つ目の場合はfalse
        @tailrec
        def chooseChar(a: Char, b:Char, aNext: Seq[Char], bNext: Seq[Char], sub_c: Int): Boolean = {
          if (a < b) true
          else if (a > b) false
          else {
            if (aNext.isEmpty || bNext.isEmpty) true // どちらでもよい
            else  chooseChar(aNext.head, bNext.head, aNext.tail, bNext.tail, sub_c - 1) // 次の文字に託す
          }
        }

        val nc = nStr.head
        val rc = rStr.head
        chooseChar(nc, rc, nStr.tail, rStr.tail, (count + 1) / 2) match {
          case true => greedy_check(count - 1, nStr.tail, rStr, resLn :+ nc)
          case false => greedy_check(count - 1, nStr, rStr.tail, resLn :+ rc)
        }
      }
    }

  }
}
