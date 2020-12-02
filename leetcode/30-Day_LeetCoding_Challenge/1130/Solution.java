class Solution {
    class EndHigh {
        int end, high;
        EndHigh(int end, int high) {
            this.end = end;
            this.high = high;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int length = buildings.length;
        if (length == 0) return new ArrayList<>();

        Arrays.sort(buildings, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return b[2] - a[2];
            });
        List<List<Integer>> skyLines = new ArrayList<>();
        PriorityQueue<EndHigh> endQueue = new PriorityQueue<>( (a, b) -> {
                if (a.end != b.end) {
                    return a.end - b.end;
                }
                return b.high - a.high;
        });
        PriorityQueue<EndHigh> highQueue = new PriorityQueue<>( (a, b) -> {
                if (a.high != b.high) {
                    return b.high - a.high;
                }
                return a.end - b.end;
        });

        int i = 0;
        while (i < length || !endQueue.isEmpty()) {
            while (!endQueue.isEmpty() && endQueue.peek().end > highQueue.peek().end) {
                highQueue.poll();
            }

            if (endQueue.isEmpty() || i < length && buildings[i][0] <= endQueue.peek().end) {
                if (endQueue.isEmpty() || buildings[i][2] > highQueue.peek().high) {
                    List<Integer> skyLine = new ArrayList<>();
                    skyLine.add(buildings[i][0]);
                    skyLine.add(buildings[i][2]);
                    skyLines.add(skyLine);
                }
                EndHigh eh = new EndHigh(buildings[i][1], buildings[i][2]);
                endQueue.offer(eh);
                highQueue.offer(eh);
                i ++;
            } else {
                EndHigh end = endQueue.poll();
                while (!highQueue.isEmpty() && end.end >= highQueue.peek().end) {
                    highQueue.poll();
                }
                while (endQueue.size() > highQueue.size()) {
                    endQueue.poll();
                }
                if (endQueue.isEmpty()) {
                    skyLines.add(new ArrayList<>() {
                            {
                                add(end.end);
                                add(0);
                            }
                        });
                } else if (end.high > highQueue.peek().high) {
                    skyLines.add(new ArrayList<>() {
                            {
                                add(end.end);
                                add(highQueue.peek().high);
                            }
                        });
                }
            }
        }
        return skyLines;
    }
}
