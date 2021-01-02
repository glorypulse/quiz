class Solution {
    int[][] rects;
    int sum;
    Random random = new Random();
    TreeMap<Integer, Integer> rectMap;

    public Solution(int[][] rects) {
        this.rects = rects;

        this.rectMap = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < rects.length; i ++) {
            rectMap.put(sum, i);
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
    }

    public int[] pick() {
        int rand = random.nextInt(sum);
        int key = rectMap.floorKey(rand);
        int[] rect = rects[rectMap.get(key)];
        int x = (rand - key + 1) % (rect[2] - rect[0] + 1);
        int y = (rand - key + 1) / (rect[2] - rect[0] + 1);
        if (x == 0) {
            x = rect[2] - rect[0] + 1;
            y -= 1;
        }
        x += rect[0] - 1;
        y += rect[1];

        return new int[] { x, y };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
