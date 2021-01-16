class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> targetList = new ArrayList<>();
        int length = nums.length;

        for (int i = 0; i < length; i ++) {
            if (targetList.size() == index[i]) {
                targetList.add(nums[i]);
            } else {
                targetList.add(index[i], nums[i]);
            }
        }

        int[] target = new int[length];
        for (int i = 0; i < length; i ++) {
            target[i] = targetList.get(i);
        }

        return target;
    }
}
