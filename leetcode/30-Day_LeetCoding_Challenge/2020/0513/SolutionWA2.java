class Solution {
    public String removeKdigits(String num, int k) {
        int prev = num.charAt(0) - '0';
        int prevIndex = 0;
        boolean topNum = true;
        Set<Integer> removeSet = new HashSet<>();

        for (int i = 1; k > 0 && i < num.length(); i ++) {
            if (removeSet.contains(i)) continue;
            int n = num.charAt(i) - '0';
            if (n == 0 && topNum) {
                removeSet.add(prevIndex);
                k --;
                while (i < num.length() && num.charAt(i) == '0') i ++;
                if (i < num.length()) {
                    prev = num.charAt(i) - '0';
                    prevIndex = i;
                }
            } else if (prev < n) {
                removeSet.add(i);
                k --;
            } else if (prev > n) {
                if (!removeSet.contains(prevIndex)) {
                    removeSet.add(prevIndex);
                    k --;
                }
                prevIndex ++;
                prev = num.charAt(prevIndex) - '0';
                i = prevIndex;
                topNum = true;
            } else {
                topNum = false;
            }
        }
        if (k > 0) {
            for (int i = 0; k > 0 && i < num.length(); i ++) {
                if (removeSet.contains(i)) continue;
                char cn = num.charAt(i);
                if (cn == '0') continue;
                removeSet.add(i);
                k --;
            }
        }

        StringBuilder sb = new StringBuilder();
        topNum = true;
        for (int i = 0; i < num.length(); i ++) {
            if (removeSet.contains(i)) continue;
            char cn = num.charAt(i);
            if (cn == '0' && topNum) continue;
            sb.append(num.charAt(i));
            topNum = false;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

}
