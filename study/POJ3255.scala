package study

import scala.annotation.tailrec

/** Programming Contest Challenge Book p102
  POJ No.3255 Roadblocks
  http://poj.org/problem?id=3255
  */

object Roadblocks {
  def main(args : Array[String]) {

    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    val (n, r) = (sc.nextInt, sc.nextInt)

    // adjacency list
    var intersections = new Array[List[(Int, Int)]](n)

    for (i <- 1 to r) {
      val (a, b, d) = (sc.nextInt, sc.nextInt, sc.nextInt)
      val from = a-1
      val to = b-1

      intersections(from) = if (intersections(from) == null) {
        List((to, d))
      } else {
        intersections(from) :+ (to, d)
      }

      intersections(to) = if (intersections(to) == null) {
        List((from, d))
      } else {
        intersections(to) :+ (from, d)
      }
      }

    // for debug
    // pw.println(s"${n}, ${r}")
    // intersections.zipWithIndex.foreach{ case (is, i) => pw.print(s"${i}..")
    //   if (is == null) pw.println("null")
    //   else is.map(ad => pw.println(ad._1, ad._2))
    // }

    val ans = solve(n, r, intersections)
    pw.println(ans)
    pw.flush
    pw.close

  }

  def solve(n : Int, r : Int, intersections : Array[List[(Int, Int)]]) : Int = {
    // for dijkstra matrix (shortest, second shortest)
    var d_matrix = new Array[(Int, Int)](n)
    var unchecked = ((0 to (n-1)).toList.map((_,0)) ++ (0 to (n-1)).toList.map((_,1)))

    def checkShortestPath(from : Int, now_d : Int) {

      // the order of n
      def insertedUnchecked (distance: Int, to: Int, sp: Int) : List[(Int, Int)] = {

        def getInsertion(sub_unchecked: List[(Int, Int)]) : List[(Int, Int)] = {
          if (sub_unchecked.isEmpty) {
            List()
          } else {
            val is_n = sub_unchecked.head
            val cis_n = is_n._1
            val c_distance = is_n._2 match {
              case 0 => d_matrix(cis_n)._1
              case 1 => d_matrix(cis_n)._2
            }

            if (c_distance >= distance) {
              (to, sp) :: sub_unchecked
            } else {
              sub_unchecked.head :: getInsertion(sub_unchecked.tail)
            }
          }
        }

        val c_unchecked = unchecked.filterNot{case (is_n, s) => (is_n == to) && (s == sp)}
        getInsertion(c_unchecked)
      }

      intersections(from).foreach{ is =>
        val to = is._1
        val distance = now_d + is._2
        var sp = Int.MaxValue

        if (d_matrix(to)._1 > distance) { // shortest?
          d_matrix(to) = (distance, d_matrix(to)._1)
          sp = 0
        } else if (d_matrix(to)._2 > distance) {
          d_matrix(to) = (d_matrix(to)._1, distance)
          sp = 1
        }

        if (sp != Int.MaxValue) {
          // update unchecked list
          unchecked = insertedUnchecked(distance, to, sp)
        }
      }
    }

    def get_second_dijkstra() {

      val b = new scala.util.control.Breaks
      b.breakable {
        while(!unchecked.isEmpty) {
          val (from, sp) = unchecked.head
          unchecked = unchecked.tail
          if (from == n-1 && sp == 1)  {
            b.break
          } else {
            val now_d = sp match {
              case 0 => d_matrix(from)._1
              case 1 => d_matrix(from)._2
            }
            checkShortestPath(from, now_d)
          }
        }
      }

    }



    // initialize d_matrix
    d_matrix(0) = (0, Int.MaxValue)
    for (i <- (1 to n-1)) {
      d_matrix(i) = (Int.MaxValue, Int.MaxValue)
    }

    get_second_dijkstra()
    d_matrix(n-1)._2
  }



}
