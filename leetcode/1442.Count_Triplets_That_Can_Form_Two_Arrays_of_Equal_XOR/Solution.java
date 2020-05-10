class Solution {
    public int countTriplets(int[] arr) {
        int a = 0, b = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i ++) {
            a = 0;
            for (int j = i + 1; j < arr.length; j ++) {
                a ^= arr[j - 1];
                b = 0;
                for (int k = j; k < arr.length; k ++) {
                    b ^= arr[k];
                    if (a == b) {
                        // System.out.println("i: " + i + ", j:" + j + ", k:" + k);
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}
