class Solution {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, ArrayList<int[]>> distanceMap = new TreeMap<>();

        for (int[] point: points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            ArrayList<int[]> distanceList = distanceMap.get(distance);
            if (distanceList == null) {
                distanceList = new ArrayList<>();
                distanceMap.put(distance, distanceList);
            }
            distanceList.add(point);
        }

        int count = 0;
        int[][] ans = new int[K][];
        for (ArrayList<int[]> distanceList: distanceMap.values()) {
            for (int[] point: distanceList) {
                ans[count] = point;
                count ++;
                if (count == K) return ans;
            }
        }
        return ans;
    }
}
