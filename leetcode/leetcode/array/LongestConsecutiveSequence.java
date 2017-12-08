package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2], The
 * longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * 
 * 题解： 如果是o(nlogn)，可以先快速排序，再找出最长的连续序列 如果是o(n),
 * 就必须使用辅助的hashmap或hashset，存着每个元素是否被使用过。从某个元素开始，向左右开始遍历到最长序列
 * 
 * @author Alvin
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		print(nums);
		//System.out.println((longestConsecutive1(nums)));
		System.out.println((longestConsecutive2(nums)));
	}

	// 引入hashset或使用hashmap<Integer,boolean>,使用一个集合set存入所有的数字，然后遍历数组中的每个数字，如果其在集合中存在，那么将其移除，然后分别用两个变量pre和next算出其前一个数跟后一个数，然后在集合中循环查找，如果pre在集合中，那么将pre移除集合，然后pre再自减1，直至pre不在集合之中，对next采用同样的方法，那么next-pre-1就是当前数字的最长连续序列，更新res即可。
	public static int longestConsecutive1(int[] nums) {
		//最长的连续序列长度res
		int res = 0;
		Set<Integer> s = new HashSet<Integer>();
		// 把数组中所有元素放入set中
		for (int num : nums) {
			s.add(num);
		}

		for (int num : nums) {
			//这里一定要用remove判断有并移除掉，不能用contains去判断是否存在。因为是o(n)的时间复杂度，一个数字只能在一个连续序列中，不可能同时存在两个连续的序列中，所以计算某个数字的连续序列的时候拿到了这个值，直接移除即可，因为以后它不会再次被用到了
			if (s.remove(num)) {
				int pre = num - 1;
				int next = num + 1;
				while (s.remove(pre))
					--pre;
				while (s.remove(next))
					++next;
				res = Math.max(res, next - pre - 1);
			}
		}
		return res;
	}

	//引入hashmap,刚开始哈希表为空，然后遍历所有数字，如果该数字不在哈希表中，那么我们分别看其左右两个数字是否在哈希表中，如果在，则返回其哈希表中映射值，若不在，则返回0，然后我们将left+right+1作为当前数字的映射，并更新res结果，然后更新d-left和d-right的映射值
	public static int longestConsecutive2(int[] nums) {
		int res = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (m.containsKey(num))
				continue;
			int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
			int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
			int sum = left + right + 1;
			m.put(num, sum);
			res = Math.max(res, sum);
			m.put(num - left, sum);
			m.put(num + right, sum);
		}
		return res;
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + ",");
		}
		System.out.println('\n');
	}
}
