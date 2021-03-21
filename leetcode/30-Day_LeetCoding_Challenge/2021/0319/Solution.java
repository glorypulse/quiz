class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        Set<Integer> keySet = new HashSet<>();
        List<Integer>[] roomArray = rooms.toArray(new List[rooms.size()]);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int roomNum = queue.poll();
            if (keySet.contains(roomNum)) continue;
            keySet.add(roomNum);
            for (int key: roomArray[roomNum]) {
                queue.offer(key);
            }
        }
        if (keySet.size() == total) return true;
        return false;
    }
}
