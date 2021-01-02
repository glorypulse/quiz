class Solution {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);

        int[] indexes = new int[4];
        Arrays.fill(indexes, -1);
        int index_two = -1;
        boolean exists_under_three = false;
        boolean exists_under_five = false;

        boolean exists_under_one = false;
        boolean exists_under_five_not_one = false;

        for (int i = 0; i < 4; i ++) {
            if (index_two < 0 && A[i] == 2) {
                index_two = i;
            } else if (!exists_under_three && A[i] <= 3) {
                exists_under_three = true;
            } else if (!exists_under_five && A[i] <= 5) {
                exists_under_five = true;
            }

            if (!exists_under_one && A[i] <= 1) {
                exists_under_one = true;
            } else if (!exists_under_five_not_one && A[i] <= 5) {
                exists_under_five_not_one = true;
            }
        }

        if (index_two >= 0 && exists_under_three && exists_under_five) {
            indexes[0] = index_two;

            // indexes[1] ... index under three
            // indexes[2] ... index under five
            for (int i = 3; i >= 0; i --) {
                if (i == index_two) continue;
                if (A[i] <= 3 && indexes[1] < 0) {
                    indexes[1] = i;
                    continue;
                }
                if (A[i] <= 5 && indexes[2] < 0) {
                    indexes[2] = i;
                    continue;
                }
                indexes[3] = i;
            }
        } else if (exists_under_one && exists_under_five_not_one) {
            // indexes[0] ... index under one
            // indexes[2] ... index under five

            for (int i = 3; i >= 0; i --) {
                if (A[i] <= 1 && indexes[0] < 0) {
                    indexes[0] = i;
                    continue;
                }
                if (A[i] <= 5) {
                    if (indexes[1] < 0 && i >= 2) {
                        indexes[1] = i;
                        continue;
                    }
                    if (indexes[2] < 0) {
                        indexes[2] = i;
                        continue;
                    }
                }
                if (indexes[1] < 0) {
                    indexes[1] = i;
                } else {
                    indexes[3] = i;
                }
            }
        } else {
            return "";
        }

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < 5; i ++) {
            if (i == 2) {
                sb.append(':');
                continue;
            }
            int j = i < 2 ? i : i - 1;
            sb.append(A[indexes[j]]);
        }
        return sb.toString();
    }
}
