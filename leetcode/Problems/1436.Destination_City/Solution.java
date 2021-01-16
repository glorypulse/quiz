class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> citySet = new HashSet<>();
        HashSet<String> destSet = new HashSet<>();

        for (List<String> path: paths) {
            String a = path.get(0);
            String b = path.get(1);

            if (destSet.contains(a)) {
                destSet.remove(a);
            }

            if (!citySet.contains(b)) {
                destSet.add(b);
            }

            citySet.add(a);
            citySet.add(b);
        }

        String destCity = "";
        for (String dest: destSet) {
            destCity = dest;
        }
        return destCity;
    }
}
