import java.util.HashSet;
import java.util.HashMap;
import java.util.Stack;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    enum Direction {
        Left, Down, Right, Up
    };

    public void cleanRoom(Robot robot) {
        cleanCell(robot, 0, 0, Direction.Left, new HashSet<String>());
    }

    String name(int i, int j) {
        return i + "," + j;
    }

    Direction left(Direction d) {
        switch(d) {
        case Left:
            return Direction.Down;
        case Down:
            return Direction.Right;
        case Right:
            return Direction.Up;
        }
        return Direction.Left;
    }

    int getNextI(int i, Direction d) {
        switch(d) {
        case Down:
            return i + 1;
        case Up:
            return i - 1;
        }
        return i;
    }

    int getNextJ(int j, Direction d) {
        switch(d) {
        case Left:
            return j - 1;
        case Right:
            return j + 1;
        }
        return j;
    }

    void cleanCell(Robot robot, int i, int j, Direction d, HashSet<String> visited) {
        robot.clean();
        visited.add(name(i, j));

        int next_i, next_j;
        for (int l = 0; l < 4; l ++) {
            next_i = getNextI(i, d);
            next_j = getNextJ(j, d);
            if (!visited.contains(name(next_i, next_j)) && robot.move()) {
                cleanCell(robot, next_i, next_j, d, visited);
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
            d = left(d);
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
    }
}
