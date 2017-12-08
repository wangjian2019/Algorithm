package string;

import java.lang.annotation.Native;

import org.junit.Test;

public class string {
	@Native
	public static final int MIN_VALUE = 0x80000000;
	@Native
	public static final int MAX_VALUE = 0x7fffffff;
	private boolean isNagetive = true;
	private int limit = 0;
	
	//String类型转Integer类型，模仿Integer.parseInt()
	@Test
	public int parseInt(String str){
		 //10表示十进制的整数
		 return parseInt(str,10);  
	}
	
    private int parseInt(String str, int radix) throws NumberFormatException{
    	 if (str == null) {  
             throw new NumberFormatException("null");  
         }  
    	//进制2~32之间
         if (radix < Character.MIN_RADIX) {  
             throw new NumberFormatException("radix " + radix +  
                                             " less than Character.MIN_RADIX");  
         }  
         if (radix > Character.MAX_RADIX) {  
             throw new NumberFormatException("radix " + radix +  
                                             " greater than Character.MAX_RADIX");  
         }  
         int result = 0;  
         boolean negative = false;  
         //游标，指向字符串当前的索引，遍历字符串中字符。
         int i = 0; 
         //Integer的最大值的负值。比整形的最小值－2147483648大1
         int limit = -Integer.MAX_VALUE;  
         int multmin; 
         //digit:保存字符经过转化后的Integer Value
         int digit;  
         if (str.length() > 0) {  
        	 //有可能是负数，第一位有可能是符号位，Possible leading "+" or "-"  
             char firstChar = str.charAt(0); 
             //char小于0说明第一位是符号位
             if (firstChar < '0') {
                 if (firstChar == '-') {  
                     negative = true;  
                     limit = Integer.MIN_VALUE;  
                 } else if (firstChar != '+') {
                     throw new NumberFormatException(str);  
                 } 
                 // 不能只有1位的符号没有数字，Cannot have alone "+" or "-"
                 if (str.length() == 1) {
                	 throw new NumberFormatException(str);   
                 } 
                 //游标+1，因为第一位是符号位，后面开始是数字位
                 i++;  
             } 
             // 因为下面要进入算result的循环，这里要计算一下能进行的最后一次循环的时候的最大result是多少，因为一旦再下一个循环乘以radix就会超出Integer最大值
             multmin = limit / radix;  
             while (i < str.length()) {  
                 // Accumulating negatively avoids surprises near MAX_VALUE  
                 // 这里返回值是2，可以先不管
            	 digit = Character.digit(str.charAt(i++),radix);  
                 if (digit < 0) {  
                     throw new NumberFormatException(str);  
                 } 
                 //以防后面的result*radix的结果超出最小负数的值，所以预先做validation
                 if (result < multmin) {  
                     throw new NumberFormatException(str);  
                 }  
                 //计算整型的值
                 result *= radix;  
                 if (result < limit + digit) {  
                     throw new NumberFormatException(str);  
                 }  
                 result -= digit;  
             }  
         } else {  
             throw new NumberFormatException(str);  
         }  
         return negative ? result : -result;  
	}
}
