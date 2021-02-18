class Solution {
    class Row {
        int numSoldiers;
        int index;

        Row(int[] row, int index) {
            numSoldiers = 0;
            for (int i = 0; i < row.length; i ++) {
                if (row[i] == 0) break;
                numSoldiers ++;
            }
            this.index = index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Row> pq = new PriorityQueue<>((a, b) -> {
                if (a.numSoldiers != b.numSoldiers) {
                    return b.numSoldiers - a.numSoldiers;
                }
                return b.index - a.index;
        });

        for (int i = 0; i < k; i ++) {
            pq.offer(new Row(mat[i], i));
        }

        for (int i = k; i < m; i ++) {
            pq.offer(new Row(mat[i], i));
            pq.poll();
        }

        int[] ansRows = new int[k];

        for (int i = k - 1; i >= 0; i --) {
            ansRows[i] = pq.poll().index;
        }

        return ansRows;
    }
}
