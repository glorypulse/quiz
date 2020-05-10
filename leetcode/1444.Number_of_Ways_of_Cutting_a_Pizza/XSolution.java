class Solution {
    public int ways(String[] pizza, int k) {
        int rowLength = pizza.length;
        if (rowLength == 0) return 0;
        int colLength = pizza[0].length();

        int[] rows = new int[rowLength];
        int[] cols = new int[colLength];
        boolean[][] pizzaMatrix = new boolean[rowLength][colLength];

        int i = 0, j = 0;
        for (String rowPizza: pizza) {
            for (char piece: rowPizza.toCharArray()) {
                if (piece == 'A') {
                    rows[i] += 1;
                    cols[j] += 1;
                    pizzaMatrix[i][j] = true;
                }
                j ++;
            }
            i ++;
            j = 0;
        }

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (i = 0; i < rowLength; i ++) {
            if (rows[i] > 0) rowSet.add(i);
        }

        for (j = 0; j < colLength; j ++) {
            if (rows[j] > 0) colSet.add(j);
        }

    }


    int countWays(Set<Integer> rowSet, int[] rows, Set<Integer> colSet, int[] cols, boolean[][] pizza, int k) {
        int count = 0;
        for (int row: rowSet) {
            int[] nextCols = cols.clone();
            Set<Integer> nextColsSet = new HashSet<>(colSet);
            for (int j = 0; j < cols.length; j ++ ) {
                if (pizza[row][j]) {
                    nextCols[j] -= 1;
                    if (nextCols[j] == 0) {
                        nextColsSet.remove(j);
                    }
                }
            }

            count += countWays(new HashSet<>(rowSet), rows.clone(), nextColsSet, nextCols, pizza, k - 1);
        }
    }
}
