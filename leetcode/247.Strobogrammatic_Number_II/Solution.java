import java.util.List;
import java.util.ArrayList;


class Solution {
    char upsideDown(char c) {
        switch(c) {
        case '9':
            return '6';
        case '6':
            return '9';
        }
        return c;
    }
    char[] allStorobo = {'0', '1', '6', '8', '9'};

    void makeStorobo(int index, int n, char[] storobo, List<String> storoboList) {
        if (index == n / 2 && n % 2 == 0 || index == n / 2 + 1 && n % 2 == 1) {
            storoboList.add(new String(storobo));
            return;
        }
        for (char c: allStorobo) {
            if (index == 0 && c == '0' && n != 1) continue;
            if (index == n / 2 && n % 2 == 1 && ( c == '6' || c == '9')) continue;
            storobo[index] = c;
            storobo[n - 1 - index] = upsideDown(c);
            makeStorobo(index + 1, n, storobo, storoboList);
        }
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> storoboList = new ArrayList<>();
        char[] storobo = new char[n];
        makeStorobo(0, n, storobo, storoboList);
        return storoboList;
    }
}
