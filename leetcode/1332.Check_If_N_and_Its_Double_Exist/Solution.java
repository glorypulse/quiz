class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> existedSet = new HashSet<>();
        Set<Integer> wantedSet = new HashSet<>();

        for (int num: arr) {
            if (wantedSet.contains(num)) {
                return true;
            }
            if (existedSet.contains(num * 2)) {
                return true;
            }
            if (num % 2 == 0) {
                if (existedSet.contains(num / 2)) {
                    return true;
                } else {
                    wantedSet.add(num / 2);
                }
            }
            existedSet.add(num);
            wantedSet.add(num * 2);
        }
        return false;
    }
}
