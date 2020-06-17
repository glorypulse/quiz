class Solution {
    final String neigher = "Neither";
    public String validIPAddress(String IP) {
        // IPv4
        if (IP.contains(".")) {
            String[] ip_split = IP.split("\\.");
            if (ip_split.length != 4) return neigher;
            ip_split = IP.split("\\.", 4);

            for (String ip_s: ip_split) {
                // number?
                if (!ip_s.matches("[1-2]?[0-9]?[0-9]")) return neigher;
                int ip_n = Integer.parseInt(ip_s);

                // leading zeros?
                if (String.valueOf(ip_n).length() != ip_s.length()) return neigher;

                // valid range?
                if (ip_n > 255) return neigher;
            }
            return "IPv4";
        } else {
            String[] ip_split = IP.split(":");
            if (ip_split.length != 8) return neigher;
            ip_split = IP.split(":", 8);
            for (String ip_s: ip_split) {
                if (ip_s.isEmpty()) return neigher;
                if (ip_s.equals("0")) continue;

                // hexadecimal digits?
                if (!ip_s.matches("[0-9a-fA-F]{1,4}")) return neigher;
            }
            return "IPv6";
        }
    }
}
