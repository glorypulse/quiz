class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int medIndex = (arr.length - 1) / 2;
        int med = arr[medIndex];

        int i = 0, left = 0, right = arr.length - 1;
        int absLeft, absRight;
        while (i < k) {
            absLeft = Math.abs(arr[left] - med);
            absRight = Math.abs(arr[right] - med);
            if (absLeft > absRight) {
                ans[i] = arr[left];
                left ++;
            } else if (absRight > absLeft) {
                ans[i] = arr[right];
                right --;
            } else {
                if (arr[left] > arr[right]) {
                    ans[i] = arr[left];
                    left ++;
                } else {
                    ans[i] = arr[right];
                    right --;
                }
            }
            i ++;
        }
        return ans;
    }
}
