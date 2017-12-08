package leetcode.array;

/**
 * 
 * You are given an n × n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 * 
 * 
 * 题解：
 * 首先沿着副对角线翻转一次，然后沿着水平中线翻转一次。
 * 或者，首先沿着水平中线翻转一次，然后沿着主对角线翻转一次
 * 
 * @author Alvin
 *
 */
public class RotateImage {

	// 时间复杂度 O(n^2)，空间复杂度 O(1)
	public void rotate(int[][] nums) {
		// 沿着副对角线反转
		for (int i = 0; i < nums.length; ++i){
			for (int j = 0; j < nums[i].length; ++j){
				int temp = nums[i][j];
				nums[i][j] = nums[nums.length - 1 - j][nums.length - 1 - i];
				nums[nums.length - 1 - j][nums.length - 1 - i] = temp;
			}
		} 
		// 沿着水平中线反转
		for (int i = 0; i < nums.length / 2; ++i) {
			for (int j = 0; j < nums.length; ++j){
				int temp = nums[i][j];
				nums[i][j] = nums[nums.length - 1 - i][j];
				nums[nums.length - 1 - i][j] = temp;
			}
		}
	}
}
