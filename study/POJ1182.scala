package study

import java.util.Scanner
import java.io.PrintWriter

/** Programming Contest Challenge Book p 85
  POJ 1182
  http://poj.org/problem?id=1182
  */

object FoodChain {

  def main(args : Array[String]) {
    val sc = new Scanner(System.in)
    val pw = new PrintWriter(System.out)
    val (n, k) = (sc.nextInt, sc.nextInt)

    val informations = (for (i <- 1 to k) yield {
      (sc.nextInt, sc.nextInt, sc.nextInt)
    }).toList

    val ans = solve(n, informations)
    pw.println(ans)
    pw.flush
    pw.close
    exit 
  }

  def solve(N : Int, informations: List[(Int, Int, Int)]) : Int = {
    var count = 0
    var checked = scala.collection.mutable.Set[Int]()
    var gset = new GroupSet(N)
    
    informations.foreach{ info =>
      val (d, x, y) = info
        (x, y) match {
        case (n, m) if ((n > N) || (m > N) || (n < 1) || (m < 1)) => {
          count += 1
        }
        case _ => {
          if (x != y) {
            (checked(x), checked(y)) match {
              case (false, false) => {
                checked += (x, y)
                d match {
                  case 1 => gset.union(x-1, y-1)
                  case 2 => gset.eat_union(x-1, y-1)
                }
              }
              case (false, true) => {
                checked += x
                d match {
                  case 1 => gset.union(y-1, x-1)
                  case 2 => gset.eat_union(x-1, y-1)
                }
              }
              case (true, false) => {
                checked += y
                d match {
                  case 1 => gset.union(x-1, y-1)
                  case 2 => gset.eat_union(x-1, y-1)
                }
              }
              case (true, true) => {
                d match {
                  case 1 => {
                    if (gset.differ(x-1, y-1)) {
                      count += 1
                    } else if (!gset.same(x-1, y-1)) {
                      gset.union(x-1, y-1)
                    }
                  }
                  case 2 => {
                    if (gset.cannot_eat(x-1, y-1)) {
                      count += 1
                    } else if (!gset.eat(x-1, y-1)) {
                      gset.eat_union(x-1, y-1)
                    }
                  }
                }
              }
            }
          } else { // x == y
            d match {
              case 1 =>
              case 2 => count += 1
            }
          }
        }
      }
    }
    count
  }

  class Group {
    var parent: Int = -1
    var food : Int = -1
    var eater : Int = -1
  }

  class GroupSet(N : Int) {
    var group = new Array[Group](N)
    for (i <- 0 until N) {
      group(i) = new Group()
    }

    def find(x : Int) : Int = {
      group(x).parent match {
        case -1 => x
        case n if n == x => println(s"error!"); x
        case p => {
          val g = find(p)
          if (g != p) { group(x).parent = g }
          g
        }
      }
    }

    def same(x: Int, y : Int): Boolean = {
      val xg = find(x)
      val yg = find(y)
      xg == yg
    }

    def differ(x: Int, y:Int) : Boolean = {
      val xg = find(x)
      val yg = find(y)
        (group(xg).food == yg) || (group(yg).food == xg)
    }

    def cannot_eat(x: Int, y: Int) : Boolean = {
      val xg = find(x)
      val yg = find(y)

      same(xg, yg) || (group(yg).food == xg)
    }

    def eat(x: Int, y:Int) : Boolean = {
      val xg = find(x)
      val yg = find(y)
      group(xg).food == yg
    }

    // 統合したグループの親を返す
    def union(x : Int, y : Int) : Int = {
      val xg = find(x)
      val yg = find(y)

      same(xg, yg) match {
        case true => xg
        case false => {
          group(yg).parent = xg
          group(yg).food match {
            case -1 =>
            case yf => eat_union(xg, yf)
          }
          find(xg)
        }
      }
    }

    def eat_union(x : Int, y : Int) {
      val xg = find(x)
      var yg = find(y)

      yg = group(xg).food match {
        case -1 => group(xg).food = yg; group(yg).eater = xg; yg
        case xf =>  if (find(xf) != yg) union(find(xf), yg) else yg
      }

      group(xg).eater match {
        case -1 =>
        case xe => if (group(yg).food != find(xe)) eat_union(yg, find(xe))
      }

      find(xg)
    }
  }

}
