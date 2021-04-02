class Solution {
    class Count {
        int count;
        boolean end;

        Count(int count, boolean end) {
            this.count = count;
            this.end = end;
        }
    }

    class Trie {
        Trie[] nexts;
        boolean end;

        Trie() {
            nexts = new Trie[26];
            end = false;
        }

        void insertAllSubstrings(String str) {
            for (int i = 1; i < str.length(); i ++) {
                insert(str, i);
            }
        }

        void insert(String str, int index) {
            if (index == str.length()) {
                end = true;
                return;
            }
            int cIndex = str.charAt(index) - 'a';
            if (nexts[cIndex] == null) {
                nexts[cIndex] = new Trie();
            }
            nexts[cIndex].insert(str, index + 1);
        }

        Count search(String str, int index) {
            int cIndex = str.charAt(index) - 'a';
            if (nexts[cIndex] == null) return new Count(-1, false);
            return searchCount(str, index, 0);
        }

        Count searchCount(String str, int index, int count) {
            if (index == str.length()) {
                return new Count(count, end);
            }
            int cIndex = str.charAt(index) - 'a';
            if (nexts[cIndex] == null) {
                return new Count(count, end);
            }
            return nexts[cIndex].searchCount(str, index + 1, count + 1);
        }


    }
    public int[] movesToStamp(String stamp, String target) {
        int length = target.length();
        int index = 0;

        Trie trie = new Trie();
        trie.insert(stamp, 0);
        Trie trieSubstrings = new Trie();
        trieSubstrings.insertAllSubstrings(stamp);


        boolean completed = false;
        ArrayList<int[]> stamps = new ArrayList<>();
        int push = 0;
        while (index < length) {
            Count count = trie.search(target, index);
            if (!completed) {
                push ++;
                if (count.count < 0) return new int[0];
            } else {
                if (count.count < 0) {
                    push --;
                    count = trieSubstrings.search(target, index);
                    if (count.count < 0) return new int[0];
                }
            }
            stamps.add(new int[] { index, push });
            completed = count.end;
            index += count.count;
        }

        stamps.sort((a, b) -> a[1] - b[1]);
        int[] moves = new int[stamps.size()];
        for (int i = 0; i < stamps.size(); i ++) {
            moves[i] = stamps.get(i)[0];
        }
        return moves;
    }
}
