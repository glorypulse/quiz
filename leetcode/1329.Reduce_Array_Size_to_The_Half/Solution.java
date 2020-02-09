class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> OccurencesMap = new HashMap<>();
        for (int num: arr) {
            Integer count = OccurencesMap.get(num);
            if (count == null) {
                OccurencesMap.put(num, 1);
            } else {
                OccurencesMap.put(num, count + 1);
            }
        }
        List<Integer> occurences = new ArrayList<>(OccurencesMap.values());
        Collections.sort(occurences, Collections.reverseOrder());
        int halflength = arr.length - arr.length / 2;
        int count = 0;
        for (int occ: occurences) {
            count ++;
            halflength -= occ;
            if (halflength <= 0) break;
        }
        return count;
    }
}
