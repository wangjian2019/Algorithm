package leetcode.stack;

/**
 * Valid Parentheses
 * 
 * Given a string containing just the characters ’(’, ’)’, ’{’, ’}’, ’[’ and ’]’, determine if the
 * input string is valid.
 * The brackets must close in the correct order, ”()” and ”()[]” are all valid but ”(]” and ”([)]” are
 * not.
 * 
 * 题解：一个个检查给的characters，如果是左括号都入栈；如果是右括号，检查栈如果为空，证明不能匹配，如果栈不空，弹出top，与当前扫描的括号检查是否匹配。全部字符都检查完了以后，判断栈是否为空，空则正确都匹配，不空则证明有没匹配的。
 * 
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char top = stack.pop();
                if (s.charAt(i) == ')') {
                    if (top != '(') {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if (top != '{') {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if (top != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }

}