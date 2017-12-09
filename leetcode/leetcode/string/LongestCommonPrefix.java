package leetcode.string;

/**
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * 
 * 题解：
 * 求一系列字符串的共同前缀
 * 解题思路是，先对整个String数组预处理一下，求一个最小长度（最长前缀肯定不能大于最小长度）。
 * 然后以第0个字符串作为参照，从第1个字符串到最后一个字符串，对同一位置做判断，有不同字符串返回当前记录的字符串就行。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder res = new StringBuilder();
        int index = 0;
        int len = minlen(strs);
        while (index < len) {
            //String[]数组中每个String元素的第index位置的字符
            for (int i = 1; i < strs.length; i++) {
                //String[]数组中每个String元素的第index位置上，只要有一个元素的这个index位置的字符与大家不一样，那么就说明前缀一定是前面一位了。如果第一个位置就不一样，就说明没有前缀，直接返回空字符串即可
                if (strs[i].charAt(index) != strs[0].charAt(index))
                    return res.toString();
            }
            res.append(strs[0].charAt(index));
            index++;
        }
        return res.toString();
    }

    //返回字符串数组中每个String元素的长度的最小值
    private int minlen(String[] strs) {
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++)
            min = Math.min(min,  strs[i].length());
        return min;
    }

}
