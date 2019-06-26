import java.util.HashSet;

class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> touched = new HashSet<String>(); // booleanの配列で代替できる
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (touched.contains(key(i, j))) continue;
                if (grid[i][j] == '1') {
                    // found an island!
                    count++;
                    foundIsland(grid, touched, i, j);
                } else {
                    touched.add(key(i, j));
                }
            }
        }
        return count;
    }

    private void foundIsland(char[][] grid, HashSet<String> touched, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || touched.contains(key(i, j))) return;
        touched.add(key(i, j));
        if (grid[i][j] == '0') return;
        if (grid[i][j] == '1') {
            // right
            foundIsland(grid, touched, i, j + 1);
            // down
            foundIsland(grid, touched, i + 1, j);
            // left
            foundIsland(grid, touched, i, j - 1);
            // up
            foundIsland(grid, touched, i - 1, j);
        }
        return;
    }

    private String key(int i, int j) {
        return i + "," + j;
    }
}
