package leetcode.array;

/**
 * Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers. If such arrangement is
 * not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order). 
 * The replacement must be in-place, do not allocate extra
 * memory. Here are some examples. 
 * 
 * Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 
 * 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3 
 * 1,1,5 → 1,5,1
 * 
 * 题解：翻译，翻译 实现“下一个排列”函数，将排列中的数字重新排列成字典序中的下一个更大的排列。 如果这样的重新排列是不可能的，它必须重新排列为可能的最低顺序（即升序排序）。 重排必须在原地，不分配额外的内存。
 * 
 * “1，2，3”的全排列：
 *  1 2 3
 *	1 3 2
 *	2 1 3
 *	2 3 1
 *	3 1 2
 *	3 2 1
 * 该题的意思是，从上面的某一行重排到期下一行，如果已经是最后一行了，则重排成第一行。
 * 如果给定数组是降序，则说明是全排列的最后一种情况，则下一个排列就是最初始情况。
 * 1 2 7 4 3 1
 * 下一个排列为：
 * 1 3 1 2 4 7
 * 那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，数字逐渐变大，到了2时才减小的，然后我们再从后往前找第一个比2大的数字，是3，
 * 那么我们交换2和3，再把此时3后面的所有数字转置一下即可，步骤如下：
 * 1 2 7 4 3 1
 * 1 2 7 4 3 1
 * 1 3 7 4 2 1
 * 1 3 1 2 4 7
 * 
 * 
 * @author Alvin
 *
 */
public class NextPermutation {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 4, 3, 1 };
		print(nums);
		test(nums);
		print(nums);
	}

	// 时间复杂度 O(n)，空间复杂度 O(1)
	public static void test(int[] nums) {
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
	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + ",");
		}
		System.out.println('\n');
	}
}
