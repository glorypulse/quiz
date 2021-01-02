class Solution {
    class Trie {
        Trie[] children;
        boolean end;

        Trie() {
            children = new Trie[26];
            end = false;
        }

        void insert(String str) {
            insert(str, 0);
        }
        void insert(String str, int index) {
            if (index == str.length()) {
                end = true;
                return;
            }

            int c = str.charAt(index) - 'a';
            if (children[c] == null) {
                children[c] = new Trie();
            }
            children[c].insert(str, index + 1);
        }

        boolean search(char c) {
            int ci = c - 'a';
            if (children[ci] == null) return false;
            return children[ci].end;
        }

        Trie with(char c) {
            int ci = c - 'a';
            return children[ci];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        if (n == 0) return new ArrayList<String>();
        int m = board[0].length;

        boolean[] start = new boolean[26];
        Trie check = new Trie();
        for (String word: words) {
            check.insert(word);
            start[word.charAt(0) - 'a'] = true;
        }

        boolean[][] visited = new boolean[n][m];
        Set<String> found = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (start[board[i][j] - 'a']) {
                    searchBoard(board, check, i, j, visited, found, "");
                }
            }
        }
        return new ArrayList<String>(found);
    }

    void searchBoard(char[][] board, Trie check, int i, int j, boolean[][] visited, Set<String> found, String parent) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return;
        visited[i][j] = true;
        char c = board[i][j];

        Trie next = check.with(c);
        if (next != null) {
            String nextStr = parent + c;
            if (next.end) {
                found.add(nextStr);
            }
            searchBoard(board, next, i + 1, j, visited, found, nextStr);
            searchBoard(board, next, i - 1, j, visited, found, nextStr);
            searchBoard(board, next, i, j + 1, visited, found, nextStr);
            searchBoard(board, next, i, j - 1, visited, found, nextStr);
        }
        visited[i][j] = false;
    }
}
