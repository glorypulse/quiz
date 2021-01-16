class Solution {
    public int maxStudents(char[][] seats) {
        int oddCol = 0, evenCol = 0;
        char seat;
        for (int i = 0; i < seats.length; i ++) {
            for (int j = 0; j < seats[i].length; j ++) {
                seat = seats[i][j];
                if (seat == '.') {
                    if (j % 2 == 0) {
                        evenCol ++;
                    } else {
                        oddCol ++;
                    }
                }
            }
        }

        int count = 0;
        int check = 0;
        if (evenCol > oddCol) {
            count = evenCol;
        } else {
            count = oddCol;
            check = 1;
        }

        for (int i = 0; i < seats.length; i ++) {
            for (int j = 0; j < seats[i].length; j ++) {
                seat = seats[i][j];
                if (seat == '.') {
                    if (j % 2 == check) {
                        seats[i][j] = '#';
                        if (j - 1 >= 0) {
                            seats[i][j - 1] = '#';
                            if (i - 1 >= 0) seats[i - 1][j - 1] = '#';
                            if (i + 1 < seats.length) seats[i + 1][j - 1] = '#';
                        }
                        if (j + 1 < seats[i].length) {
                            seats[i][j + 1] = '#';
                            if (i - 1 >= 0) seats[i - 1][j + 1] = '#';
                            if (i + 1 < seats.length) seats[i + 1][j + 1] = '#';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < seats.length; i ++) {
            for (int j = 0; j < seats[i].length; j ++) {
                seat = seats[i][j];
                if (seat == '.') count ++;
            }
        }

        return count;
    }
}
