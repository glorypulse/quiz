import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        if (books.length == 0) return 0;
        // same_row, another_row
        //  width, height, row, row_height
        Deque<int[]> memo = new ArrayDeque<int[]>();
        Deque<int[]> memoNext = new ArrayDeque<int[]>();


        // initialize
        int[] tmp = new int[4];;
        tmp[0] = shelf_width - books[0][0]; // width
        tmp[1] = books[0][1]; // height
        tmp[2] = books[0][1]; // row_height
        memo.add(tmp);

        int width = 0, height = 0;
        int i = 0;
        int[] next;
        for (i = 0; i < books.length; i++) {
            width = books[i][0];
            height = books[i][1];

            while (!memo.empty?) {
                tmp = memo.poll();
                // same_row
                if (width =< tmp[0]) {
                    next = new int[4];
                    next[0] = tmp[0] - width;
                    next[1] = tmp[1];
                    if (height > tmp[2]) {
                        next[1] += height - tmp[2];
                        next[2] = height;
                    } else {
                        next[2] = tmp[2];
                    }
                    memoNext.add(next);
                }

                // next_row
                // TODO
            }
        }
    }
}
