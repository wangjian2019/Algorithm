package leetcode.string;

/**
 * Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 *Return ”100”.
 * 
 * 
 * 題解：
 * 二进制加法都是从最低位（从右加到左）。
 * 所以对两个字符串要从最后一位开始加，如果遇见长度不一的情况，就把短的字符串高位补0.
 * 每轮计算要加上进位，最后跳出循环后要坚持进位是否为1，以便更新结果。
 * 
 */
public class AddBinary {

    //用0补齐最短字符串左侧，至两字符串等长，如 a = "1111", b = "1"，其基本实现就是实现 a = "1111"，b = "0001"，这样相加，只是代码更简洁
    public String addBinary(String a, String b) {
        //choose the longer one`s length
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        //从右边开始逐位取出字符串 a、b 的字符值 tempA 和 tempB，如果长度不足，则用0替代 
        for (int i = 0; i < maxLen; i++) {  
            //right->left
            int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            //在最左侧插入相加结果
            sb.insert(0, (tempA + tempB + carry) % 2); 
            //得到进位
            carry = tempA + tempB + carry > 1 ? 1 : 0; 
        }
        if (carry == 1)
            sb.insert(0, 1); //如果最高位有进位，则最高位还要加一位 1  
        return sb.toString();
    }
}