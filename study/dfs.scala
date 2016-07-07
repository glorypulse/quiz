package study

object SubAdd {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val a = sc.nextLine.split(" ").toList.map(_.toInt)
    val k = sc.nextInt
    
    val ans = solve(n, a, k)
  }

def solve(n: Int, a: List[Int], k: Int): Boolean = {
    dfs(0, a, k)    
  }

  def dfs(init: Int, searchLs: List[Int], k:Int) : Boolean = {
    (init + searchLs.head) match {
      case n if n == k => true
      case _ => dfs(init + searchLs.head, searchLs.tail, k) ||
      	          dfs(init, searchLs.tail, k)
    }
  }
}