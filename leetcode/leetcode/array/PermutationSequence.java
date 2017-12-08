package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence：
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
 *"123"
 *"132"
 *"213"
 *"231"
 *"312"
 *"321"
 *Given n and k, return the kth permutation sequence.
 *Note: Given n will be between 1 and 9 inclusive.
 * 
 * 题解：
 * 一个n长度数据的全排列有n!种，取其中第k种。
 * 
 * 方法1：调用 k − 1 次Next_Permutation算法，得到第k次全排列
 * 方法2：利用康托编码的思路，
 * 这道题是让求出n个数字的第k个排列组合，由于其特殊性，我们不用将所有的排列组合的情况都求出来，然后返回其第k个，我们可以只求出第k个排列组合即可，那么难点就在于如何知道数字的排列顺序，可参见网友喜刷刷的博客，首先我们要知道当n = 3时，其排列组合共有3! = 6种，当n = 4时，其排列组合共有4! = 24种，我们就以n = 4, k = 17的情况来分析，所有排列组合情况如下：
 * 1234
 * 1243
 * 1324
 * 1342
 * 1423
 * 1432
 * 2134
 * 2143
 * 2314 
 * 2341
 * 2413
 * 2431
 * 3124
 * 3142
 * 3214
 * 3241
 * 3412	<--- k = 17
 * 3421
 * 4123
 * 4132
 * 4213
 * 4231
 * 4312
 * 4321
 * 我们可以发现，每一位上1,2,3,4分别都出现了6次，当第一位上的数字确定了，后面三位上每个数字都出现了2次，当第二位也确定了，后面的数字都只出现了1次，当第三位确定了，那么第四位上的数字也只能出现一次，
 * 
 * 那么下面我们来看k = 17这种情况的每位数字如何确定，由于k = 17是转化为数组下标为16：
 * 最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出
 * 第二位此时从1,2,4中取一个，k = 16是此时的k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，所以第二数字的下标为4 / 2 = 2，即4被取出
 * 第三位此时从1,2中去一个，k' = 4是此时的k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，所以第三个数字的下标为 0 / 1 = 0，即1被取出
 * 第四位是从2中取一个，k'' = 0是此时的k''' = 0 % (1!) = 0，而剩下的每个数字出现0！= 1次，所以第四个数字的下标为0 / 1= 0，即2被取出
 * 那么我们就可以找出规律了
 * a1 = k / (n - 1)!
 * k1 = k
 * a2 = k1 / (n - 2)!
 * k2 = k1 % (n - 2)!
 * ...
 * an-1 = kn-2 / 1!
 * kn-1 = kn-2 / 1!
 * an = kn-1 / 0!
 * kn = kn-1 % 0!
 * 
 * @author Alvin
 *
 */
public class PermutationSequence {
	
	public static void main(String[] args) {
//		int[] nums = { 1, 2, 7, 4, 3, 1 };
//		print(nums);
//		test1(nums, nums.length, 5);
//		print(nums);
		int[] nums = { 1, 2, 3, 4};
		print(nums);
		test2(nums, nums.length, 17);
		print(nums);
	}
	
	public static void test1(int[] nums, int n, int k) {
		for(int i = 0; i < k; i++){
			nextPermutation(nums);
		}
	}
	
	public static void nextPermutation(int[] nums) {
		int i, j, n = nums.length;
		for (i = n - 2; i >= 0; --i) {
			if (nums[i + 1] > nums[i]) {
				for (j = n - 1; j >= i; --j) {
					if (nums[j] > nums[i])
						break;
				}
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				reverse(nums, i + 1, nums.length - 1);
				return;
			}
		}
		reverse(nums, 0, nums.length - 1);
	}

	private static void reverse(int[] nums, int begin, int end) {
		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
	}
	
	public static void test2(int[] nums, int n, int k) {
		if (nums == null || n == 0 || n == 1) {
			return;
		}
		// 把nums数组完全拷贝到一个ArrayList中
		List<Integer> temp = new ArrayList<Integer>();
		for(int num : nums){
			temp.add(num);
		}
	    // 求n!,赋值pCount
        int pCount = 1;
        for(int i = 1 ; i <= n; i++) {  
            pCount = pCount * i;  
        }  
        //数组下标减1
        k--;  
        for(int i = 0 ; i < n; i++) {  
        	//求(n-i)!赋值pCount
            pCount = pCount/(n-i);  
            int selected = k / pCount;  
            nums[i] = temp.get(selected);
            //被选中的元素，后面的排列不可能再次被选中，所以从集合中删除
            temp.remove(selected);  
            k = k % pCount;  
        } 
    }
	
	//针对于字符串的情况
	public static String test3(int n, int k) {
		if (n <= 0) {
			return null;
		}
		if (n == 1) {
			return String.valueOf(n);
		}
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			temp.add(i);
		}
		int pCount = 1;
		for (int i = 1; i <= n; i++) {
			pCount = pCount * i;
		}
		if(k > pCount){
			return null;
		}
		k--;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			pCount = pCount / (n - i);
			int selected = k / pCount;
			result.append(temp.get(selected));
			temp.remove(selected);
			k = k % pCount;
		}
		return result.toString();
	}
	
	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + ",");
		}
		System.out.println('\n');
	}
}
