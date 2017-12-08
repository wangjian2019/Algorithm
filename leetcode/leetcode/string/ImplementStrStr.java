package leetcode.string;


/**
 * Implement strStr()
 * 
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack.
 * 
 * 题解：
 *  字符串匹配问题，如果子串在主串中存在，则返回子串在主串中首次出现的第一个字符的位置，不存在则返回-1。
 *  朴素搜索算法（暴力算法）是o(m*n),更高效的是KMP算法，Boyer-Mooer算法和Rabin-Karp算法
 * 
 */
public class ImplementStrStr{

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return 0;
        }
        if(needle.length()==0){
            return 0;
        } 
        //o(m*n)逐个依次遍历
        for(int i = 0; i < haystack.length(); i++){
            //如果遍历的剩余字符串长度已经小于neeedle子串长度,那么说明已经无法匹配了
            if(i + needle.length() > haystack.length()){
                return -1;
            } 
            int m = i;
            for(int j = 0;j < needle.length(); j++){
                if(needle.charAt(j) == haystack.charAt(m)){
                    if(j == needle.length()-1){
                        return i;
                    }
                    m++;
                }else{
                    break; 
                } 
            }
        }
        return -1;
    }      
}