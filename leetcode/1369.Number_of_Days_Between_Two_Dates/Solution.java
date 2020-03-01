class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] date1Str = date1.split("-");
        String[] date2Str = date2.split("-");
        int[] date1Array = new int[3];
        int[] date2Array = new int[3];
        for (int i = 0; i < 3; i ++) {
            date1Array[i] = Integer.parseInt(date1Str[i]);
            date2Array[i] = Integer.parseInt(date2Str[i]);
        }

        int[] bigDateArray;
        int[] smallDateArray;

        if (date1Array[0] == date2Array[0] && date1Array[1] == date2Array[1] && date1Array[2] == date2Array[2]) {
            return 0;
        } else if (date1Array[0] > date2Array[0] ||
            (date1Array[0] == date2Array[0] && date1Array[1] > date2Array[1]) ||
            (date1Array[0] == date2Array[0] && date1Array[1] == date2Array[1] && date1Array[2] > date2Array[2])) {
            bigDateArray = date1Array;
            smallDateArray = date2Array;
        } else {
            bigDateArray = date2Array;
            smallDateArray = date1Array;
        }

        int bigDate = 0;
        int smallDate = 0;

        // month
        if (!(bigDateArray[1] == smallDateArray[1] && bigDateArray[0] == smallDateArray[0])) {
            int bigMonth = bigDateArray[1];
            int bigYear = bigDateArray[0];
            do {
                bigMonth --;
                if (bigMonth == 0) {
                    bigMonth = 12;
                    bigYear --;
                }
                bigDate += monthDate(bigMonth, bigYear);
            } while (!(bigMonth == smallDateArray[1] && bigYear == smallDateArray[0]));
        }

        // date
        bigDate += bigDateArray[2];
        smallDate += smallDateArray[2];

        return bigDate - smallDate;
    }


    boolean leapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    int monthDate(int month, int year) {
        switch(month) {
        case 4,6,9,11:
            return 30;
        case 2:
            if (leapYear(year)) {
                return 29;
            }
            return 28;
        default:
            return 31;
        }
    }


}
