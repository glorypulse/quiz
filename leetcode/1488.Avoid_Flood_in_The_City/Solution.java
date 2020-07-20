class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> fulled = new HashMap<>();
        LinkedList<Integer> dryDays = new LinkedList<>();

        for (int i = 0; i < rains.length; i ++) {
            int rain = rains[i];
            if (rain == 0) {
                dryDays.add(i);
            } else {
                rains[i] = -1;
                Integer rainDay = fulled.get(rain);
                if (rainDay == null) {
                    fulled.put(rain, i);
                } else {
                    if (dryDays.isEmpty()) {
                        return new int[] {};
                    } else {
                        Iterator<Integer> dryIterator = dryDays.iterator();
                        boolean dried = false;
                        while (dryIterator.hasNext()) {
                            int dryDay = dryIterator.next();
                            if (dryDay > rainDay) {
                                dryIterator.remove();
                                rains[dryDay] = rain;
                                fulled.put(rain, i);
                                dried = true;
                                break;
                            }
                        }
                        if (!dried) {
                            return new int[] {};
                        }
                    }
                }
            }
        }

        if (!dryDays.isEmpty()) {
            for (int dryDay: dryDays) {
                rains[dryDay] = 1;
            }
        }
        return rains;
    }
}
