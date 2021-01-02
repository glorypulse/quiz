class RecentCounter {
    Queue<Integer> calledQueue;

    public RecentCounter() {
        calledQueue = new LinkedList<>();
    }

    public int ping(int t) {
        calledQueue.offer(t);
        while (calledQueue.peek() < t - 3000) {
            calledQueue.poll();
        }
        return calledQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
