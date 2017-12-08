package leetcode.string;

/**
 * Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * 题解：
 * 双指针法：时间 O(N) 空间 O(1)
 * 假设我们用两个指针分别指向s和p字符串中要匹配的位置，首先分析下通配符匹配过程中会有哪些情况是成功：
 * 1. s的字符和p的字符相等
 * 2. p中的字符是?，这时无论s的字符是什么都可以匹配一个
 * 3. p中遇到了一个*，这时无论s的字符是什么都没关系
 * 4. 之前的都不符合，但是p在之前的位置有一个*，我们可以从上一个*后面开始匹配
 * 5. s已经匹配完，但是p后面还有很多连续的`*
 * 这里1和2的情况比较好处理，关键在于如何处理3和4的情况。当我们遇到一个*时，因为之后可能要退回至该位置重新匹配，我们要将它的下标记录下来，比如idxstar。但是，当我们连续遇到两次4的情况，如何保证我还是能继续匹配s，而不是每次都退回idxstar+1导致循环呢？所以我们还要记录一个idxmatch，用来记录用上一个*连续匹配到的s中的下标。最后，对于情况5，我们用一个循环跳过末尾的*跳过就行了。
 * 
 * 
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int idxs = 0, idxp = 0, idxstar = -1, idxmatch = 0;
       while(idxs < s.length()){
           // 当两个指针指向完全相同的字符时，或者p中遇到的是?时
           if(idxp < p.length() && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '?')){
               idxp++;
               idxs++;
           // 如果字符不同也没有?，但在p中遇到是*时，我们记录下*的位置，但不改变s的指针
           } else if(idxp < p.length() && p.charAt(idxp)=='*'){
               idxstar = idxp;
               idxp++;
               //遇到*后，我们用idxmatch来记录*匹配到的s字符串的位置，和不用*匹配到的s字符串位置相区分
               idxmatch = idxs;
           // 如果字符不同也没有?，p指向的也不是*，但之前已经遇到*的话，我们可以从idxmatch继续匹配任意字符
           } else if(idxstar != -1){
               // 用上一个*来匹配，那我们p的指针也应该退回至上一个*的后面
               idxp = idxstar + 1;
               // 用*匹配到的位置递增
               idxmatch++;
               // s的指针退回至用*匹配到位置
               idxs = idxmatch;
           } else {
               return false;
           }
       }
       // 因为1个*能匹配无限序列，如果p末尾有多个*，我们都要跳过
       while(idxp < p.length() && p.charAt(idxp) == '*'){
           idxp++;
       }
       // 如果p匹配完了，说明匹配成功
       return idxp == p.length();
   }
}