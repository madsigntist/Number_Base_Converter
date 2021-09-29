package converter;

import java.math.BigInteger;

class BaseConverter {
    public static String converter(String digit, int source, int target) {
        String[] nums = digit.split("\\.");
        return (nums.length == 1) ?
                intConverter(nums[0], source, target) :
                intConverter(nums[0], source, target) + "." + decimalConverter(nums[1], source, target);
    }

    public static String intConverter(String digit, int source, int target) {
        return new BigInteger(digit, source).toString(target);
    }

    public static String decimalConverter(String digit, int source, int target) {
        //Convert digit from source to decimal
        double decimal = 0.0;
        for (int i = 0; i < digit.length(); i++) {
            int val = Integer.parseInt(Character.toString(digit.charAt(i)), source);
            decimal += ((double) val) / Math.pow(source, i + 1);
        }

        //Convert decimal to decimal in target, max 5 digits
        StringBuilder sb = new StringBuilder();
        for (int digits = 0; digits < 5; digits++)
        {
            decimal = decimal * target;
            int intPart = (int) decimal;
            decimal -= intPart;
            sb.append(Integer.toString(intPart, target).charAt(0));
        }

        return sb.toString();
    }
}
