package leetcode.string;



/**
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length
 * of S is 1000, and there exists one unique longest palindromic substring.
 *
 * 題解：
 * the longest回文字符串
 * 
 * 方法一：暴力枚舉，以每個元素為中間元素，同時從左右出發，時間複雜度o(n^2)
 * 方法二：記憶化搜索，時間複雜度o(n^2)，設 f[i][j]表示[i,j]之間的最長回文字符串，公式如下：
 *      f[i][j] = if(i ==j) S[i]
 *                if(S[i]) == S[j] && f[i+1][j-1] == S[i+1][j-1]) S[i][j]
 *                else max(f[i+1][j-1], f[i][j-1], f[i+1][j])
 * 方法三：动态规划，时间复杂度o(n^2)
 * 
 * / 

public class LongestPalindromicSubstring{
    
    //方法一：是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，
    //例如aba是回文，abba也是回文，这两种情况要分情况考虑）往两边同时进行扫描，直到不是回文串为止。
    //假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂度为O(n),
    //所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)。
    public String longestPalindrome(String s) {
        if (s.isEmpty()||s==null||s.length() == 1)
            return s;
    
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // 当是有中心节点的对称：abcdcba
            String tmp = helper(s, i, i);
            
            if (tmp.length() > longest.length())
                longest = tmp;
    
            // 当是有中心节点的对称：abccba
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length())
                longest = tmp;
        }
 
        return longest;
    }
 
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}