import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 0) return new ArrayList<Integer>();

        // 深さを求める
        int depth = 0;
        int check = 1;
        for (depth = 0; depth < 20; depth++) {
            check *= 2;
            if (label < check) break;
        }
        int max = check - 1;
        int min = check - (check / 2);

        Integer[] ans = new Integer[depth + 1];
        ans[depth] = label;

        int index = 0;
        if (depth % 2 == 0) {
            index = max - label;
        } else {
            index = label - min; // 6
        }
        depth--;
        while (depth > 0) {
            index /= 2;
            max = min - 1;
            min /= 2;
            if (depth % 2 == 0) {
                ans[depth] = max - index;
            } else {
                ans[depth] = min + index;
            }
            depth--;
        }
        ans[0] = 1;
        // return List.of(ans)
        return Arrays.asList(ans);
    }
}
