class Solution {
    public int minTaps(int n, int[] ranges) {
        int length = ranges.length;
        int[][] rangeMaps = new int[length][2];
        int[] garden = new int[n + 1];
        Arrays.fill(garden, -1);

        for (int i = 0; i < length; i ++) {
            rangeMaps[i][0] = Math.max(i - ranges[i], 0);
            rangeMaps[i][1] = Math.min(i + ranges[i], n);
            if (rangeMaps[i][0] == rangeMaps[i][1]) continue;
            for (int j = rangeMaps[i][0]; j <= rangeMaps[i][1]; j ++) {
                garden[j] = i;
            }
        }
        System.out.println(Arrays.toString(garden));
        // 解がない
        for (int i = 0; i < n + 1; i ++) {
            if (garden[i] == -1) return -1;
        }

        Arrays.fill(garden, -1);
        return tapCount(0, 0, garden, rangeMaps, n);
    }

    int tapCount(int index, int count, int[] garden, int[][] rangeMaps, int n) {
        // ダメだった場合
        if (index >= rangeMaps.length) return Integer.MAX_VALUE;

        int notExecCount = tapCount(index + 1, count, garden, rangeMaps, n);

        // 1.実行する意味のないtap
        if (rangeMaps[index][0] == rangeMaps[index][1]) {
            return notExecCount;
        }

        boolean included = true;
        for (int i = rangeMaps[index][0]; i <= rangeMaps[index][1]; i ++) {
            if (garden[i] == -1) {
                included = false;
                break;
            }
        }
        if (included) {
            // 2.包含されている場合
            // このtapは実行しない
            return notExecCount;
        }

        // 包含されていない場合
        // このtapを実行する
        int[] newGarden = new int[n + 1];
        for (int i = 0; i <= n; i ++) {
            newGarden[i] = garden[i];
        }
        for (int i = rangeMaps[index][0]; i <= rangeMaps[index][1]; i ++) {
            newGarden[i] = index;
        }

        // 3.終わり
        boolean full = true;
        for (int i = 0; i < n + 1; i ++) {
            if (newGarden[i] == -1) {
                full = false;
                break;
            }
        }
        if (full) return Math.min(notExecCount, count + 1);

        // 4.終わらない場合は小さい方を返す
        return Math.min(notExecCount, tapCount(index + 1, count + 1, newGarden, rangeMaps, n));
    }
}
