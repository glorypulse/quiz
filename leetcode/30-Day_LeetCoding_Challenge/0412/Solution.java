class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            pq.offer(stone);
        }

        int bigS = pq.poll();
        int smallS, tmp;
        while (!pq.isEmpty()) {
            smallS = pq.poll();
            tmp = bigS - smallS;
            if (tmp != 0) {
                pq.offer(tmp);
            }
            if (pq.isEmpty()) {
                return 0;
            } else {
                bigS = pq.poll();
            }
        }

        return bigS;
    }
}
