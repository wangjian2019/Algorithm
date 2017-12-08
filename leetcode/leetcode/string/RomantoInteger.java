package leetcode.string;

/**
 * Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999
 * 
 * 
 */
public class RomantoInteger {
    public static int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'I'){
                if(res >= 5)//如果>=5, 说明之前肯定遍历过V了，所以这个I肯定在左边，减
                    res += -1;
                else
                    res += 1;
            }else if(c == 'V'){//遇见V,L,D,M,统统都加5，50，500，100
                res += 5;
            }else if(c == 'X'){
                if(res >= 50)//说明肯定之前有过L，这个X肯定在左边，减
                    res += -10;
                else 
                    res += 10;
            }else if(c == 'L'){
                res += 50;
            }else if(c == 'C'){//说明之前有D，这个C肯定在左边，减。能被减的只有I X C
                if(res >= 500)
                    res += -100;
                else
                    res += 100;
            }else if(c == 'D'){
                res += 500;
            }else if(c == 'M'){
                res += 1000;
            }
        }
        return res;
    }
}