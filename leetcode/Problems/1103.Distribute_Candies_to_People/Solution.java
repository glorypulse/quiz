class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int base_sum = num_people * (num_people + 1) / 2;

        int num_row = 0;
        int tmp_candies = candies;
        int twice_people = num_people * num_people;
        while (tmp_candies >= 0) {
            tmp_candies -= base_sum + num_row * twice_people;
            num_row ++;
        }
        num_row --;
        tmp_candies += base_sum + num_row * twice_people;
        int num_remains = tmp_candies;

        int[] ans = new int[num_people];
        int i = 0;
        for (i = 0; i < num_people; i++) {
            ans[i] = num_row * (num_row - 1) * num_people / 2 + (i + 1) * num_row;
        }

        i = 0;
        while (num_remains > 0) {
            int remains = Math.min(num_row * num_people + i + 1, num_remains);
            num_remains -= remains;
            ans[i] += remains;
            i++;
        }

        return ans;
    }
}
