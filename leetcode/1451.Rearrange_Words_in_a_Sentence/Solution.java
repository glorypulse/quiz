class Solution {
    public String arrangeWords(String text) {
        String[] textSplit = text.split(" ");
        textSplit[0] = textSplit[0].toLowerCase();

        TreeMap<Integer, List<String>> lengthMap = new TreeMap<>();
        for (String ts: textSplit) {
            int length = ts.length();
            List<String> lengthList = lengthMap.get(length);
            if (lengthList == null) {
                lengthList = new LinkedList<>();
                lengthMap.put(length, lengthList);
            }
            lengthList.add(ts);
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> lengthList: lengthMap.values()) {
            for (String tl: lengthList) {
                sb.append(tl);
                sb.append(" ");
            }
        }

        String arrangedText = sb.toString().substring(0, sb.length() - 1);
        return arrangedText.substring(0, 1).toUpperCase() + arrangedText.substring(1);
    }
}
