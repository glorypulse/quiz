public class Codec {
    private static int MAX;
    private Map<String, String> urlMap;
    private char[] codeChars;

    Codec() {
        MAX = (int)Math.pow(62, 5);
        urlMap = new HashMap<>();
        codeChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    }


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode() % MAX;
        String hash = getHash(hashCode);
        urlMap.put(hash, longUrl);
        return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String hash = shortUrl.substring(19);
        return urlMap.get(hash);
    }

    private String getHash(int hashCode) {
        StringBuilder sb = new StringBuilder();
        while (hashCode > 0) {
            int remain = hashCode % 62;
            sb.append(codeChars[remain]);
            hashCode /= 62;
        }
        while (sb.length() < 6) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
