class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        LinkedList<Integer>[] diagonalLists = new LinkedList[n + m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int index = i - j + m;
                if (diagonalLists[index] == null) {
                    diagonalLists[index] = new LinkedList<>();
                }
                diagonalLists[index].add(mat[i][j]);
            }
        }

        for (LinkedList<Integer> list: diagonalLists) {
            if (list != null) {
                Collections.sort(list);
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int index = i - j + m;
                mat[i][j] = diagonalLists[index].removeFirst();
            }
        }
        return mat;
    }
}
