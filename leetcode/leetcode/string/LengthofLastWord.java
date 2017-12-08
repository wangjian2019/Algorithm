package leetcode.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * 
 * 题解：注意考虑两种特殊情况，当s=""和s="            " ;这两种情况需要特别考虑，这就是我if语句里面判断的这两种情况。  
 * 
 */
public class LengthofLastWord{
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        if(a == null || a.length == 0)
            return 0;

       return a[a.length-1].length();
   }
}