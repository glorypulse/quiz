class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int prev = arr[0];
        int minAbsDif = Integer.MAX_VALUE;
        int dif;
        for (int i = 1; i < arr.length; i ++) {
            dif = arr[i] - prev;
            if (minAbsDif > dif) {
                minAbsDif = dif;
            }
            prev = arr[i];
        }

        prev = arr[0];
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 1; i < arr.length; i ++) {
            dif = arr[i] - prev;
            if (minAbsDif == dif) {
                tmp = new ArrayList<>();
                tmp.add(prev);
                tmp.add(arr[i]);
                ret.add(tmp);
            }
            prev = arr[i];
        }

        return ret;
    }
}
