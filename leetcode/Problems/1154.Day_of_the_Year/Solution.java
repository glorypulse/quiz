class Solution {
    public int dayOfYear(String date) {
        int[] month_dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int date_num = Integer.parseInt(date.substring(8,10));

        int date_sum = 0;
        int[] month_dates_array;
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            month_dates[1] += 1;
        }

        for (int i = 0; i < month - 1; i ++) {
            date_sum += month_dates[i];
        }
        date_sum += date_num;

        return date_sum;
    }
}
