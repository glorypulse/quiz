package study

/** Programming Contest Challeng Book p37 **/
object Maze {
  /* Input Pattern
   * n m
   * maze_map
   * 
   *  Sample...
10 10
#S######.#
......#..#
.#.##.##.#
.#........
##.##.####
....#....#
.#######.#
....#.....
.####.###.
....#...G#
   */

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val pw = new java.io.PrintWriter(System.out)

    val n = sc.nextInt
    val m = sc.nextInt
    val maze_map = for (i <- 0 until n) yield {
      sc.next.split("").toVector
    }

    val ans = solve(n, m, maze_map)
    println(
      ans match {
        case n if n < 0 => "There are no routes to the goal!"
        case length => s"Answer:${length}"
      }
    )

  }


  def solve(n: Int, m: Int, mmap: Seq[Seq[String]]) : Int = {
    val maze = createMaze(mmap)
    calcShortestPath(n, m, maze)
  }

  def createMaze(mmap: Seq[Seq[String]]) : Maze = {
    var start = (-1, -1)
    var goal = (-1, -1)
    def checkSet(target: (Int, Int)) :Boolean = {
      if (target._1 == -1) { false } else { true }
    }
    mmap.zipWithIndex.foreach{ case(row: Seq[String], i: Int) =>
      row.zipWithIndex.foreach { case(item: String, j: Int) => {
        item match {
          case "S" => start = (i, j)
          case "G" => goal = (i, j)
          case _ =>
        }
        if (checkSet(start) && checkSet(goal)) {
          return Maze(start, goal, mmap)
        }
      }}
    }
    Maze(start, goal, mmap)
  }



  def calcShortestPath(n: Int, m:Int , maze : Maze) :Int = {
    var checkTargets = List(maze.start)
    var nextTargets = List(maze.start)
    var memoMap = maze.mmap.map { _.toBuffer}.toBuffer
    memoMap(maze.start._1)(maze.start._2) = "0"

    def checkMap(i: Int, j: Int) : Boolean = {
      val nump = """(\d+)""".r
      memoMap(i)(j) match {
        case "#" => false
        case nump(n) => false
        case _ => true
      }
    }

    def checkGoal() : String = {
      memoMap(maze.goal._1)(maze.goal._2)
    }


    while(!nextTargets.isEmpty  && checkGoal=="G") {
      // Initial
      checkTargets = nextTargets
      nextTargets = List()

      // Check right,down,left,up
      checkTargets.foreach { case (i, j) =>
        val distance = memoMap(i)(j).toInt

        // right
        val right = j + 1
        if (right < m) {
          if (checkMap(i, right)) {
            memoMap(i)(right) = (distance + 1).toString
            nextTargets = nextTargets :+ (i, right)
          }
        }

        // down
        val down = i + 1
        if (down < n) {
          if (checkMap(down, j)) {
            memoMap(down)(j) = (distance + 1).toString
            nextTargets = nextTargets :+ (down, j)
          }
        }

        // left
        val left = j - 1
        if (left >= 0) {
          if (checkMap(i, left)) {
            memoMap(i)(left) = (distance + 1).toString
            nextTargets = nextTargets :+ (i, left)
          }
        }

        // up
        val up = i - 1
        if (up >= 0) {
          if (checkMap(up, j)) {
            memoMap(up)(j) = (distance + 1).toString
            nextTargets = nextTargets :+ (up, j)
          }
        }
      }
    }

    // Achieved the Goal or Exists No path
    checkGoal match {
      case "G" => -1
      case n => n.toInt
    }

  }
}

case class Maze(start: (Int, Int), goal: (Int, Int), mmap: Seq[Seq[String]])
