class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int max = 0;
        int current = 0;
        int[] frogs = new int[4];
        for (char voice: croakOfFrogs.toCharArray()) {
            switch(voice) {
            case 'c':
                current ++;
                max = Math.max(max, current);
                frogs[0] ++;
                break;
            case 'r':
                frogs[0] --;
                if (frogs[0] < 0) return -1;
                frogs[1] ++;
                break;
            case 'o':
                frogs[1] --;
                if (frogs[1] < 0) return -1;
                frogs[2] ++;
                break;
            case 'a':
                frogs[2] --;
                if (frogs[2] < 0) return -1;
                frogs[3] ++;
                break;
            case 'k':
                frogs[3] --;
                if (frogs[3] < 0) return -1;
                current --;
                break;
            }
        }
        if (current > 0) return -1;
        return max;
    }
}
