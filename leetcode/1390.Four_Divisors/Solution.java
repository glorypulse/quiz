class Solution {
    List<Integer> divList;

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            if (isDivisorNumFour(num)) {
                sum += getDivisorsSum(num);
            }
        }

        return sum;
    }

    boolean isDivisorNumFour(int num) {
        int n = num;
        divList = new ArrayList<>();

        int[] c2 = getDivCount(n, 2);
        if (c2[0] > 4) return false;
        if (c2[0] > 0) divList.add(2);
        n = c2[1];
        int[] c3 = getDivCount(n, 3);
        if (c3[0] > 4 || (c2[0] + 1) * (c3[0] + 1) > 4) return false;
        if (c3[0] > 0) divList.add(3);
        n = c3[1];

        int divNum = (c2[0] + 1) * (c3[0] + 1);
        int div = 5;
        int[] c;
        while (n >= div * div) {
            c = getDivCount(num, div);
            if (c[0] > 0) {
                divNum *=  c[0] + 1;
                if (divNum > 4) return false;
                divList.add(div);
                n = c[1];
            }
            // エラストテネスの篩
            if (div % 6 == 5) {
                div += 2;
            } else {
                div += 4;
            }
        }
        if (n > 1) {
            divNum *= 2;
            divList.add(n);
        }
        if (divNum == 4) return true;
        return false;
    }

    int[] getDivCount(int num, int div) {
        int n = num;
        int count = 0;
        while (n % div == 0) {
            count += 1;
            if (count > 4) break;
            n /= div;
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = n;
        return ans;
    }

    int getDivisorsSum(int num) {
        int sum = 1;
        if (divList.size() == 1) { // このときはその因数の3乗
            int div = divList.get(0);
            sum += div + div * div + num;
        } else {
            for (int div: divList) {
                sum += div;
            }
            sum += num;
        }
        return sum;
    }
}
