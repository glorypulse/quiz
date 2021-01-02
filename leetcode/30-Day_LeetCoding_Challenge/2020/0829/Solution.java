class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int length = A.length;
        List<Integer> ansList = new ArrayList<>();

        for (int i = length - 1; i >= 0; i --) {
            if (A[i] == i + 1) continue; // the value is OK.

            int cur = 0;
            for (int j = 0; j < length; j ++) {
                if (A[j] == i + 1) {
                    cur = j;
                    break;
                }
            }

            int left, right;
            // replace
            if (cur > 0) {
                ansList.add(cur + 1);
                left = 0;
                right = cur;
                while (left < right) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                    left ++;
                    right --;
                }
            }

            // replace
            ansList.add(i + 1);
            left = 0;
            right = i;
            while (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left ++;
                right --;
            }
        }
        return ansList;
    }
}
