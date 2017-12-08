package leetcode.array;

/**
 * Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 
 * 题解：
 *   异或，不仅能处理两次的情况，只要出现偶数次，都可以清零。
 *   异或是相同为0，不同为1。所以对所有数进行异或，得出的那个数就是single number。
 *   
 *   这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x
 * 
 * 
 * Single Number II
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 
 * 
 * 题解：
 * 
 * 用 one 记录到当前处理的元素为止，二进制 1 出现“1 次”（mod 3 之后的 1）的有哪
 * 些二进制位；用 two 记录到当前计算的变量为止，二进制 1 出现“2 次”（mod 3 之后的 2）的有哪
 * 些二进制位。当 one 和 two 中的某一位同时为 1 时表示该二进制位上 1 出现了 3 次，此时需要清
 * 零。即用二进制模拟三进制运算。最终 one 记录的是最终结果
 * 
 */
public class SingleNumber {

    //初始时先让一个数与0异或，然后再对剩下读数挨个进行异或，x^0=x，相当于什么都没变。
    public int singleNumber1(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }

    //从第2个数开始，逐个和前一个数字进行性亦或操作
    public static int singleNumber2(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] ^= A[i - 1];
        }
        return A[A.length - 1];
    }

    //时间复杂度 O(n)，空间复杂度 O(1)
    public int singleNumberII(int[] nums) {
        int one = 0;
        int two = 0; 
        int three = 0;
        for (int i = 0; i < nums.length; ++i) {
            two = two | (one & nums[i]);
            one = one ^ nums[i];
            three = ~(one & two);
            one = one & three;
            two = two & three;
        }
        return one;
    }
}