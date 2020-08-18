class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int per_candies = num_people * (num_people + 1) / 2;
        int tmp_candies = candies;
        int turn = 0;
        while (tmp_candies > 0) {
            tmp_candies -= per_candies + turn * num_people * num_people;
            turn ++;
        }
        turn --;
        tmp_candies += per_candies + turn * num_people * num_people;

        int[] people_candies = new int[num_people];
        for (int i = 0; i < num_people; i ++) {
            people_candies[i] = (turn * (turn - 1) / 2) * num_people + turn * (i + 1);
            if (tmp_candies > 0) {
                int candies_once = turn * num_people + i + 1;
                people_candies[i] += Math.min(candies_once, tmp_candies);
                tmp_candies -= candies_once;
            }
        }
        return people_candies;
    }
}
