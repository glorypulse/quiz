class Solution {
    class Subsequence {
        int length;
        int sum;
        boolean[] included;

        Subsequence(int length, int sum, int nums_length) {
            this.length = length;
            this.sum = sum;
            this.included  = new boolean[nums_length];
        }

        void print() {
            System.out.println("length: " + length + ", sum: " + sum);
            System.out.println(Arrays.toString(included));
        }
    }
    void subsequence(int index, Subsequence ans, Subsequence test, Subsequence exNums, Integer[] nums) {

        if (index == nums.length) {
            if (test.length < ans.length) {
                ans.length = test.length;
                ans.sum = test.sum;
                ans.included = new boolean[nums.length];
                for (int i = 0; i < nums.length; i ++) {
                    ans.included[i] = test.included[i];
                }
            } else if (test.length == ans.length && test.sum > ans.sum) {
                ans.length = test.length;
                ans.sum = test.sum;
                ans.included = new boolean[nums.length];
                for (int i = 0; i < nums.length; i ++) {
                    ans.included[i] = test.included[i];
                }
            }
            return;
        }

        int val = nums[index];
        // val を含む
        test.included[index] = true;
        exNums.included[index] = false;
        subsequence(index + 1, ans, test, exNums, nums);

        // val を含まない
        if (test.sum - val > exNums.sum + val) {
            test.length -= 1;
            test.sum -= val;
            test.included[index] = false;
            exNums.length += 1;
            exNums.sum += val;
            exNums.included[index] = true;
            subsequence(index + 1, ans, test, exNums, nums);
            test.length += 1;
            test.sum += val;
            exNums.length -= 1;
            exNums.sum -= val;
        }
    }
    public List<Integer> minSubsequence(int[] nums) {
        int length = nums.length;
        Integer[] numsInt = new Integer[length];
        for (int i = 0; i < length; i ++) {
            numsInt[i] = nums[i];
        }
        Arrays.sort(numsInt, Comparator.reverseOrder());
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        Subsequence ans = new Subsequence(length, sum, length);
        Arrays.fill(ans.included, true);

        subsequence(0, ans, new Subsequence(length, sum, length), new Subsequence(0, 0, length), numsInt);

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < length; i ++) {
            if (ans.included[i]) {
                ansList.add(numsInt[i]);
            }
        }
        return ansList;
    }
}
