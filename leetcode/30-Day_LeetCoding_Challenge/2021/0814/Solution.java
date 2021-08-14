class Solution {
    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        int[][][] points = new int[length][length][length];
        return calcPoints(0, length - 1, 0, boxes, points);
    }

    int calcPoints(int left, int right, int len, int[] boxes, int[][][] points) {
        if (left > right) return 0;
        while (right > left && boxes[right - 1] == boxes[right]) {
            right --;
            len ++;
        }
        if (points[left][right][len] > 0) {
            return points[left][right][len];
        }

        points[left][right][len] =
            calcPoints(left, right - 1, 0, boxes, points) + (len + 1) * (len + 1);
        for (int i = left; i < right; i ++) {
            if (boxes[i] == boxes[right]) {
                points[left][right][len] =
                    Math.max(points[left][right][len],
                             calcPoints(left, i, len + 1, boxes, points) +
                             calcPoints(i + 1, right - 1, 0, boxes, points));
            }
        }
        return points[left][right][len];
    }

}
