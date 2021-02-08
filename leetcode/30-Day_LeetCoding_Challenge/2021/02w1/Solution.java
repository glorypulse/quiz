/**
 * Squirrel Simulation
 */
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int min = Integer.MAX_VALUE;
        int totalDistance = 0;
        for (int i = 0; i < nuts.length; i ++) {
            int[] nut = nuts[i];
            int distanceToSquirrel = Math.abs(squirrel[0] - nut[0]) + Math.abs(squirrel[1] - nut[1]);
            int distanceToTree = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            min = Math.min(min, distanceToSquirrel - distanceToTree);
            totalDistance += distanceToTree * 2;
        }
        totalDistance += min;
        return totalDistance;
    }
}
