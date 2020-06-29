class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> departs = new HashMap<>();
        for (List<String> ticket: tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            LinkedList<String> arrivals = departs.get(departure);
            if (arrivals == null) {
                arrivals = new LinkedList<>();
                departs.put(departure, arrivals);
            }
            arrivals.offer(arrival);
        }

        for (LinkedList<String> arrivals: departs.values()) {
            Collections.sort(arrivals);
        }

        List<String> itinerary = new ArrayList<>();
        String departure = "JFK";

        setItinerary(itinerary, departure, departs);
        Collections.reverse(itinerary);
        return itinerary;
    }

    void setItinerary(List<String> itinerary, String departure, HashMap<String, LinkedList<String>> departs) {
        LinkedList<String> arrivals = departs.get(departure);

        while (arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.remove();
            setItinerary(itinerary, arrival, departs);
        }

        itinerary.add(departure);
    }
}
