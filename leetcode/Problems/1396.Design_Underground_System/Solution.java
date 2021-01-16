class UndergroundSystem {
    class StationTime {
        long timeSum = 0;
        int num = 0;

        void addPassenger(int startTime, int endTime) {
            timeSum += endTime - startTime;
            num ++;
        }

        double getAverage() {
            return timeSum / (num * 1.0);
        }
    }
    class PassengerLog {
        String startStationName;
        int startTime;

        PassengerLog(String stationName, int time) {
            this.startStationName = stationName;
            this.startTime = time;
        }
    }
    Map<String, StationTime> stationMap;
    Map<Integer, PassengerLog> passengerMap;

    public UndergroundSystem() {
        stationMap = new HashMap<>();
        passengerMap = new HashMap<>();

    }

    public void checkIn(int id, String stationName, int t) {
        passengerMap.put(id, new PassengerLog(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        PassengerLog pLog = passengerMap.get(id);
        String stationWay = pLog.startStationName + ":" + stationName;
        StationTime station = stationMap.get(stationWay);
        if (station == null) {
            station = new StationTime();
            stationMap.put(stationWay, station);
        }
        station.addPassenger(pLog.startTime, t);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationWay = startStation + ":" + endStation;
        StationTime station = stationMap.get(stationWay);
        if (station == null) return 0.0;
        return station.getAverage();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
