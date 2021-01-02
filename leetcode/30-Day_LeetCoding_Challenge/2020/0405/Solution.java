class Solution {
    public int maxProfit(int[] prices) {
        int have_max = Integer.MIN_VALUE;
        int not_have_max = 0;

        for (int price: prices) {
            have_max = Math.max(have_max, not_have_max - price);
            not_have_max = Math.max(not_have_max, have_max + price);
        }

        return Math.max(have_max, not_have_max);
    }
}
