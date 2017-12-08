package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. You may assume that each input would have exactly one
 * solution. 
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 * 
 * 题解：
 * 方法 1：两层循环，遍历到每个数，再遍历找另外一个数字，复杂度 O(n^2)
 * 方法 2： hash。用一个哈希表，存储每个数对应的下标，复杂度 O(n).
 * 方法 3：先排序o(nlogn)，然后左右夹逼(左右各一个指针，当两数之和小于这个target，左指针++，如果大于这个target，右指针--)，排序 O(n log n)，左右夹逼 O(n)，最终O（N*log2N）。
 * 
 * 
 * @author Alvin
 *
 */
public class TwoSum {
	
	//方法 3：先排序，然后左右夹逼
	public int[] test1(int[] nums, int target){  
		Arrays.sort(nums);
	    int i = 0;
	    int j = nums.length - 1; 
	    while(i < j){  
	        if(nums[i] + nums[j] == target){
	        	int[] result = new int[] { i, j };
				return result; 
	        }else if(nums[i] + nums[j] < target)  
	            i++;  
	        else  
	            j--;  
	    }  
	    return null;  
	}  
	
	//方法二：引入hashmap
	public int[] test2(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		// check whether number is a part of nums
		//key: 数字 ，value：对应数组下标
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsValue(target - nums[i])) {
				int[] result = new int[] {i, map.get(target - nums[i])};
				return result;
			}
		}
		return null;
	}
}
