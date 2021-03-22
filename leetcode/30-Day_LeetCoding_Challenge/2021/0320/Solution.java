class UndergroundSystem {
    class Average {
        int totalTime;
        int count;

        Average() {
            totalTime = 0;
            count = 0;
        }

        void inc(int time) {
            this.totalTime += time;
            count ++;
        }

        double getAverage() {
            return (totalTime * 1.0) / count;
        }
    }

    class CheckIn {
        String startStation;
        int time;

        CheckIn(String startStation, int time) {
            this.startStation = startStation;
            this.time = time;
        }
    }

    Map<String, Map<String, Average>> averageMap;
    Map<Integer, CheckIn> checkInMap;

    public UndergroundSystem() {
        averageMap = new HashMap<>();
        checkInMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        averageMap.putIfAbsent(checkIn.startStation, new HashMap<>());
        Map<String, Average> stationMap = averageMap.get(checkIn.startStation);
        stationMap.putIfAbsent(stationName, new Average());
        Average average = stationMap.get(stationName);
        average.inc(t - checkIn.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Average average = averageMap.get(startStation).get(endStation);
        return average.getAverage();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
