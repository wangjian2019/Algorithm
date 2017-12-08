package leetcode.string;

/**
 * Integer to Roman
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * 
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String str = new String();
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int]  value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; num != 0; ++i) {
            while (num >= value[i]) {
                num = num - value[i];
                str = str + symbol[i];
            }
        }
        return str;
    }

    

}