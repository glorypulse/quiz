class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] location_start = new int[1001];
        int[] location_end = new int[1001];
        for(int[] trip: trips) {
            int num_passengers = trip[0];
            int start_location = trip[1];
            int end_location = trip[2];
            for (int i = start_location + 1; i < end_location; i++ ) {
                location_start[i] += num_passengers;
                location_end[i] += num_passengers;
            }
            location_start[start_location] += num_passengers;
            location_end[end_location] += num_passengers;
        }

        int max_passengers = 0;
        for(int location_passengers: location_start) {
            if (max_passengers < location_passengers) { max_passengers = location_passengers; }
        }
        for(int location_passengers: location_end) {
            if (max_passengers < location_passengers) { max_passengers = location_passengers; }
        }


        return capacity >= max_passengers;
    }
}
