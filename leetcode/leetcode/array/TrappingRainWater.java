package leetcode.array;

import org.junit.Test;

/**
 * Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6
 * 
 * 题解： 
 * 方法一：对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是 min(max_left, max_right) - height。所以，
 *  1.从左往右扫描一遍，对于每个柱子，求取左边最大值；
 *  2.从右往左扫描一遍，对于每个柱子，求最大右值； 
 *  3.再扫描一遍，把每个柱子的面积并累加。 
 *  
 *  每个位置的储水量=它的左右柱子的取最小值-当前柱子的高度
 *  
 *  
 * @author Alvin
 *
 */
public class TrappingRainWater {
	
	//根据方法一，解题如下
	public int trap(int[] nums) {
		if (nums == null || nums.length == 0){
			return 0;
		}

		int i = 0;
		int max = 0;
		int total = 0;
		int left[] = new int[nums.length];
		int right[] = new int[nums.length];

		// from left to right
		left[0] = nums[0];
		max = nums[0];
		for (i = 1; i < nums.length; i++) {
			left[i] = Math.max(max, nums[i]);
			max = Math.max(max, nums[i]);
		}

		// from right to left
		right[nums.length - 1] = nums[nums.length - 1];
		max = nums[nums.length - 1];
		for (i = nums.length - 2; i >= 0; i--) {
			right[i] = Math.max(max, nums[i]);
			max = Math.max(max, nums[i]);
		}

		// trapped water (when i==0, it cannot trapped any water)
		for (i = 1; i < nums.length - 1; i++) {
			int bit = Math.min(left[i], right[i]) - nums[i];
			if (bit > 0)
				total = total + bit;
		}

		return total;
	}
	
	@Test
	public void main(){
		int[] nums = new int[]{2,4,6,5,3,7};
		int trap = this.trap(nums);
		System.out.println(trap);
	}
}
