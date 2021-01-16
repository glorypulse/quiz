class TweetCounts {
    Map<String, TreeSet<Integer>> records;

    public TweetCounts() {
        this.records = new HashMap<String, TreeSet<Integer>>();

    }

    public void recordTweet(String tweetName, int time) {
        TreeSet<Integer> userRecords = records.get(tweetName);
        if (userRecords == null) {
            userRecords = new TreeSet<>();
            records.put(tweetName, userRecords);
        }
        userRecords.add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        TreeSet<Integer> userRecords = records.get(tweetName);
        int freqSeconds = getSecondsFromFrequency(freq);
        List<Integer> tweetList = new ArrayList<>();
        int length;
        if (userRecords == null) {
            length = (endTime - startTime) / freqSeconds + 1;
            for (int i = 0; i < length; i ++) {
                tweetList.add(0);
            }
            return tweetList;
        }

        int time = startTime;
        while (time <= endTime) {
            Set<Integer> currentSet = userRecords.subSet(time, Math.min(time + freqSeconds, endTime + 1));
            tweetList.add(currentSet.size());
            time += freqSeconds;
        }
        return tweetList;
    }

    int getSecondsFromFrequency(String freq) {
        switch(freq) {
        case "minute":
            return 60;
        case "hour":
            return 3600;
        case "day":
            return 86400;
        }
        return 1;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
