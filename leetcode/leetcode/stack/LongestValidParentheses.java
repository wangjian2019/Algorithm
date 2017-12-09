package leetcode.stack;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * 
 * Given a string containing just the characters ’(’ and ’)’, find the length of the longest valid (wellformed) parentheses substring.
 * For ”(()”, the longest valid parentheses substring is ”()”, which has length = 2.
 * Another example is ”)()())”, where the longest valid parentheses substring is ”()()”, which has
 * length = 4.
 * 
 * 
 * 题解：
 * 这道题是求最长的括号序列，比较容易想到用栈这个数据结构。基本思路就是维护一个栈，遇到左括号就进栈，遇到右括号则出栈，并且判断当前合法序列是否为最 长序列。不过这道题看似思路简单，但是有许多比较刁钻的测试集。具体来说，主要问题就是遇到右括号时如何判断当前的合法序列的长度。比较健壮的方式如下：
 * (1) 如果当前栈为空，则说明加上当前右括号没有合法序列（有也是之前判断过的）；
 * (2) 否则弹出栈顶元素，如果弹出后栈为空，则说明当前括号匹配，我们会维护一个合法开始的起点start，合法序列的长度即为当前元素的位置 -start+1；否则如果栈内仍有元素，则当前合法序列的长度为当前栈顶元素的位置下一位到当前元素的距离，因为栈顶元素后面的括号对肯定是合法的，而 且左括号出过栈了。
 * 因为只需要一遍扫描，算法的时间复杂度是O(n)，空间复杂度是栈的空间，最坏情况是都是左括号，所以是O(n)。
 * 
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //合法开始的起点
        int start = 0;
        //最长的合法字符串长度
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            //遇到左括号就进栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // record the position before first left parenthesis
                    start = i + 1;
                } else {
                    stack.pop();
                    // if stack is empty mean the positon before the valid left parenthesis is "last"
                    if (stack.isEmpty()) {
                        maxLen = Math.max(i - start + 1, maxLen);
                    } else {
                        // if stack is not empty, then for current i the longest valid parenthesis length is
                        // i-stack.peek()
                        maxLen = Math.max(i - stack.peek(), maxLen);
                    }
                }
            }
        }
        return maxLen;
    }
}