import java.util.HashSet;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> actuals = new HashSet<String>();
        int count = 0;
        for (String email: emails) {
            char[] emailChar = new char[email.length()];
            int index = 0;
            boolean domain = false;
            boolean plus = false;
            for (char c: email.toCharArray()) {
                if (domain) {
                    emailChar[index] = c;
                    index++;
                    continue;
                }
                if (c == '@') {
                    emailChar[index] = '@';
                    index++;
                    domain = true;
                    continue;
                }
                if (plus) continue;
                if (c == '+') {
                    plus = true;
                    continue;
                }
                if (c == '.') continue;
                emailChar[index] = c;
                index++;
            }
            String actualEmail = new String(emailChar).replace("\000", "");
            if (!actuals.contains(actualEmail)) {
                count ++;
                actuals.add(actualEmail);
            }
        }
        return count;
    }
}
