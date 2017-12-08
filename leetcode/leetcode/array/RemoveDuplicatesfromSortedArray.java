package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. For example,
 * Given input array A = [1,1,2], Your function should return length = 2, and A
 * is now [1,2].
 * 题解：从后往前覆盖重复的元素即可
 * 
 * 
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most
 * twice? For example, Given sorted array A = [1,1,1,2,2,3], Your function
 * should return length = 5, and A is now [1,1,2,2,3]
 * 
 * What if the array is allowed duplicated twice Given a sorted array, remove
 * the duplicated element allowed at most twice For example, Given input array A
 * = [1,2,2,2,3,3,3,3], Your function should return length = 5, and A is now
 * [1,2,2,3,3].
 * 题解：由于是已经排序的数组，步长是2的判断，不断的从后往前覆盖元素即可。
 * 
 * 
 * What if the array is not sorted. Given an unsorted array, remove the
 * duplicated element allowed at most twice For example, Given input array A =
 * [1,2,3,2,3,3,2,3], Your function should return length = 5, and A is now
 * [1,2,2,3,3].只需返回长度，无需返回数组，因此不需要排序数组。
 * 题解：由于是未排序的数组，必须使用额外存储hashmap记录每个数字的出现次数。
 * 
 * @author Alvin
 *
 */
public class RemoveDuplicatesfromSortedArray {

	private static int sorted_nums1[] = new int[] { 1, 1, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5 };
	private static int sorted_nums2[] = new int[] { 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4 };
	private static int unsoerted_nums[] = new int[] { 1, 1, 4, 2, 2, 3, 2, 3, 2, 3, 1 };

	public static void main(String[] args) {
		print(sorted_nums1);
		System.out.println("result: " + testRemoveDuplicatedElementFromSortedArray(sorted_nums1));
		print(sorted_nums2);
		System.out.println("result: " + testRemoveDuplicatedElementTwiceFromSortedArray1(sorted_nums2));
		System.out.println("result: " + testRemoveDuplicatedElementTwiceFromSortedArray2(sorted_nums2));
		print(unsoerted_nums);
		System.out.println("result: " + testRemoveDuplicatedElementTwiceFromUnSortedArray(unsoerted_nums));
	}

	// 数组元素覆盖，后面的元素覆盖前面的元素
	// 时间复杂度 O(n)，空间复杂度 O(1)
	public static int testRemoveDuplicatedElementFromSortedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				index++;
				nums[index] = nums[i];
			}
		}
		print(nums);
		return index + 1;
	}

	// 数组元素覆盖，后面的元素覆盖前面的元素
	// 时间复杂度 O(n)，空间复杂度 O(1)
	// 用一个变量记录重复的次数
	public static int testRemoveDuplicatedElementTwiceFromSortedArray1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 2) {
			return 2;
		}
		int index = 0;
		int duplicatedTimes = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] == nums[i]) {
				duplicatedTimes++;
				continue;
			}
			if (nums[index] != nums[i]) {
				if (duplicatedTimes == 0 || duplicatedTimes == 1) {
					index = i;
					nums[index] = nums[i];
				} else {
					nums[index + 1] = nums[i - 1];
					index = index + 2;
					nums[index] = nums[i];
				}
			}
		}
		print(nums);
		return index + 1;
	}

	public static int testRemoveDuplicatedElementTwiceFromSortedArray2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length <= 2) {
			return nums.length;
		}
		int index = 2;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[index - 2]) {
				nums[index] = nums[i];
				index++;
			}
		}
		print(nums);
		return index;
	}
	
	// 数组元素覆盖，后面的元素覆盖前面的元素
		// 时间复杂度 O(n)，空间复杂度 O(1)
		//用一个hashmap记录每个数字的重复次数
		public static int testRemoveDuplicatedElementTwiceFromUnSortedArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}
			if (nums.length == 1) {
				return 1;
			}
			if (nums.length == 2) {
				return 2;
			}
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i : nums){
				if(map.containsKey(i)){
					int times = map.get(i);
					map.put(i, times+1);
				}else{
					map.put(i, 1);
				}
			}
			int index = 0;
			for(Map.Entry<Integer, Integer> entry : map.entrySet()){
				if(entry.getValue() <= 2){
					index = index + entry.getValue();
				}else{
					index = index + 2;
				} 
			}
			return index;
		}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + ",");
		}
		System.out.println('\n');
	}
}