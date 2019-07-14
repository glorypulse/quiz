import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    // arr2のitemがkeyであるhashをつくる
    // arr1を走査して、hashのkeyが存在すれば1を足す
    //               存在しなければ残り物arrayへ
    // 残り物arrayをascにorderする
    // arr2を見てhashに蓄積したkeyの値の通りに結果arrayを構築する
    // 結果arrayに残り物arrayをくっつける
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> arr2Map = new HashMap<Integer, Integer>();
        for (int i: arr2) {
            arr2Map.put(i, 0);
        }

        ArrayList<Integer> remains = new ArrayList<Integer>();
        int count = 0;
        for (int i: arr1) {
            if (arr2Map.containsKey(i)) {
                count = arr2Map.get(i);
                arr2Map.put(i, count + 1);
            } else {
                remains.add(i);
            }
        }

        Integer[] remainsArray = new Integer[remains.size()];
        remains.toArray(remainsArray);
        mergeSort(remainsArray, 0, remainsArray.length - 1);

        int[] resultArray = new int[arr1.length];

        int i = 0;
        int l;
        for (int j: arr2) {
            count = arr2Map.get(j);
            for (l = 0; l < count; l++) {
                resultArray[i] = j;
                i ++;
            }
        }

        for (l = 0; l < remainsArray.length; l++) {
            resultArray[i] = remainsArray[l].intValue();
            i ++;
        }

        return resultArray;
    }

    void mergeSort(Integer[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        int l = left;
        int r = mid + 1;
        int[] tmp = new int[right - left + 1];
        int i = 0;
        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                tmp[i] = array[l];
                l ++;
            } else {
                tmp[i] = array[r];
                r ++;
            }
            i ++;
        }
        if (l <= mid) {
            while (i < tmp.length) {
                tmp[i] = array[l];
                l ++;
                i ++;
            }
        } else if (r <= right) {
            while (i < tmp.length) {
                tmp[i] = array[r];
                r ++;
                i ++;
            }
        }
        for (i = 0; i < tmp.length; i ++) {
            array[left + i] = tmp[i];
        }
        return;
    }

}
