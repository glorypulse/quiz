class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroIndex = -1;
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int num = nums[i];
            if (num == 0 && zeroIndex < 0) {
                zeroIndex = index;
            } else {
                product *= num;
            }
        }
        int[] productAns = new int[length];
        if (product != 0) {
            if (zeroIndex < 0) {
                for (int i = 0; i < length; i ++) {
                    productAns[i] = product / nums[i];
                }
            } else {
                productAns[zeroIndex] = product;
            }
        }
        return productAns;
    }
}
