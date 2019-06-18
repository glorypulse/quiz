class Quiz02 {
    static String doubleToBinary(double num) {
        if (num < 0 || num >= 1) {
            return "ERROR";
        }
        if (num == 0) {
            return "0";
        }

        StringBuilder ret = new StringBuilder();
        double check = num;
        while(check != 0 && ret.length() < 32) {
            check = check * 2;
            if (check >= 1) {
                ret.append("1");
                check --;
            } else {
                ret.append("0");
            }
        }
        return ret.toString();

    }
    public static void main(String[] args) {
        System.out.println(doubleToBinary(0.0625));
    }
}
