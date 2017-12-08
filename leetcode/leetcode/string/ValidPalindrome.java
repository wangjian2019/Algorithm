package leetcode.string;

/**
 * Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * ”A man, a plan, a canal: Panama” is a palindrome.
 * ”race a car” is not a palindrome.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * 题解：
 * 回文，就是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。alphanumeric表示字母或数字
 * 但是这里，加入了空格和非字母数字的字符，增加了些难度。
 * 但其实原理还是很简单：只需要建立两个指针，left和right, 分别从字符的开头和结尾处开始遍历整个字符串，
 * 如果遇到非字母数字的字符就跳过，继续往下找，直到找到下一个字母数字或者结束遍历，如果遇到大写字母，就将其转为小写。
 * 等左右指针都找到字母数字时，比较这两个字符，若相等，则继续比较下面两个分别找到的字母数字，若不相等，直接返回false. 
 * 时间复杂度为O(n), 
 * 
 * 
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        //由于该问题不考虑大小写，因此全部转换为大写，再往后分析
        s = s.toUpperCase();
        int low1 = 'A', high1 = 'Z';
        int low2 = '0', high2 = '9';

        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if ((s.charAt(low) < low1 || s.charAt(low) > high1) && (s.charAt(low) < low2 || s.charAt(low) > high2)) {
                low++;
                continue;
            }

            if ((s.charAt(high) < low1 || s.charAt(high) > high1)
                    && (s.charAt(high) < low2 || s.charAt(high) > high2)) {
                high--;
                continue;
            }
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.print(isPalindrome("A man, a plan, a canal: Panama"));
    }
}