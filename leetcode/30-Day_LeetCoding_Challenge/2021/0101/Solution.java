class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int length = arr.length;
        if (length == 0) return false;
        Arrays.sort(pieces, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> piecesList = new ArrayList<>() {
                {
                    for (int[] piece: pieces) {
                        add(piece);
                    }
                }
            };

        return canForm(arr, 0, piecesList);
    }

    boolean canForm(int[] arr, int index, ArrayList<int[]> pieces) {
        int left = 0;
        int right = pieces.size() - 1;
        int j = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            int[] piece = pieces.get(middle);
            if (piece[0] == arr[index]) {
                j = middle;
                break;
            } else if (piece[0] < arr[index]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (left > right) {
            return false;
        }
        int[] piece = pieces.get(j);
        int endIndex = checkSame(arr, index, piece);
        if (endIndex == arr.length) {
            return true;
        } else if (endIndex > 0) {
            pieces.remove(j);
            if (canForm(arr, endIndex, pieces)) {
                return true;
            }
        }
        return false;
    }

    int checkSame(int[] arr, int index, int[] piece) {
        int i = index;
        int j = 0;
        while (i < arr.length && j < piece.length && arr[i] == piece[j]) {
            i ++;
            j ++;
        }
        if (j == piece.length) return i;
        return -1;
    }


}
