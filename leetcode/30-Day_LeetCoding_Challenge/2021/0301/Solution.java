class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candies = new HashSet<>();
        for (int candy: candyType) {
            candies.add(candy);
        }
        return Math.min(candies.size(), candyType.length / 2);
    }
}
