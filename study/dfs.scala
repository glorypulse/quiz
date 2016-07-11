package study

import scala.annotation.tailrec

/** Programming Contest Challenge Book p34 */
object PartialSum {
  /* Input Pattern *********
   * n
   * a(list of number)
   * k
   * 
   * example...
4
1,2,4,7
13
   */
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val a = sc.next.split(",").toList.map(_.toInt)
    val k = sc.nextInt
    
    val ans = solve(n, a, k)
    println(
      ans match {
        case true => "Yes"
        case false => "No"
      }
    )
  }

  def solve(n: Int, a: List[Int], k: Int): Boolean = {
    dfs(0, a, k)
  }

  def dfs(init: Int, searchLs: List[Int], k:Int) : Boolean = {
    searchLs.isEmpty match {
      case true => {
        false
      }
      case false => {
        (init + searchLs.head) match {
          case n if n == k => true
          case _ => dfs(init + searchLs.head, searchLs.tail, k) ||
            dfs(init, searchLs.tail, k)
        }
        
      }
    }
  }
}
