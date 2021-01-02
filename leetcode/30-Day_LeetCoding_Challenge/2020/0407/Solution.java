class Solution {
    public int countElements(int[] arr) {
        Set<Integer> existedNum = new HashSet<>();
        for (int num: arr) {
            existedNum.add(num);
        }
        int count = 0;
        for (int num: arr) {
            if (existedNum.contains(num + 1)) {
                count ++;
            }
        }
        return count;
    }
}
