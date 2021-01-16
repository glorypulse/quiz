import java.util.ArrayList;

class Solution {
    public int maxSumDivThree(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList<Integer> restOne = new ArrayList<>();
        ArrayList<Integer> restTwo = new ArrayList<>();

        int sum = 0;
        for (int num: nums) {
            if (num % 3 == 0) {
                sum += num;
            } else if (num % 3 == 1) {
                restOne.add(num);
            } else {
                restTwo.add(num);
            }
        }

        int restOneSize = restOne.size();
        int restTwoSize = restTwo.size();

        if (Math.abs(restOneSize - restTwoSize) % 3 == 0) {
            for (int rest: restOne) {
                sum += rest;
            }
            for (int rest: restTwo) {
                sum += rest;
            }
            return sum;
        }

        Collections.sort(restOne, Comparator.reverseOrder());
        Collections.sort(restTwo, Comparator.reverseOrder());

        int i = 0, j = 0;
        while (restOneSize - i - restTwoSize > 3) {
            sum += restOne.get(i ++);
            sum += restOne.get(i ++);
            sum += restOne.get(i ++);
        }

        while (restTwoSize - j - restOneSize > 3) {
            sum += restTwo.get(j ++);
            sum += restTwo.get(j ++);
            sum += restTwo.get(j ++);
        }

        while (restOneSize - i > 3 || restTwoSize - j > 3) {
            sum += restOne.get(i ++);
            sum += restTwo.get(j ++);
        }

        int tmp3 = 0, tmp = 0;
        if (restOneSize - i > restTwoSize - j) {
            if (restOneSize - i >= 3) {
                tmp3 = restOne.get(i) + restOne.get(i + 1) + restOne.get(i + 2);
            }
            while (restTwoSize > j) {
                tmp += restOne.get(i ++);
                tmp += restTwo.get(j ++);
            }
        } else {
            if (restTwoSize - j >= 3) {
                tmp3 = restTwo.get(j) + restTwo.get(j + 1) + restTwo.get(j + 2);
            }
            while (restOneSize > i) {
                tmp += restOne.get(i ++);
                tmp += restTwo.get(j ++);
            }
        }
        sum += Math.max(tmp, tmp3);
        return sum;
    }
}
