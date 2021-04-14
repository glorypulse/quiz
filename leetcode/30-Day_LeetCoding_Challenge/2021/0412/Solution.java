class Solution {
    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        arr[0] = 1;
        int t = 1;
        int i = 1;
        int left = 2;
        int right = n;

        while (t + 2 <= k) {
            arr[i ++] = right --;
            arr[i ++] = left ++;
            t += 2;
        }
        if (t + 1 == k) {
            arr[i ++] = left + 1;
            arr[i ++] = left;
            left += 2;
            t ++;
        }
        while (left <= right) {
            arr[i ++]  = left ++;
        }
        return arr;
    }
}
