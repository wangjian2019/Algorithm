package leetcode.array;


/**
 * Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unkown to you beforehand.
 * for example: 0,1,2,3,4,5,6,7 might become 4,5,6,,0,1,2
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * Your may assume no duplicate exists in the array.
 * 
 * 题解：二分查找，一部分是递增，一部分不是，所以我们二分查找的边界可以通过是递增的那面去判断，else就是另一侧了
 * 
 * What if existing duplicated element?
 * 题解：同样是二分查找，只是二分查找的边界条件一定是>或<，不能是>=或<=了
 * 
 * @author Alvin
 *
 */
public class SearchInRotatedSortedArray {

	private int[] nums = {7,8,9,1,2,3,4,5,6};
	private int[] nums2 = {1,2,3,3,1,1,1,1,1,1};
	
	public static void main(String[] args) {
		
	}
	
	public static int testNoDuplicatedElement(int[] nums, int n){
		int left = 0;
		int right = nums.length;
		int middle = (left + right)/2;
		
		while(left <= right){
			if(nums[middle] == n){
				return middle;
			}
			//当没有重复元素时候，一定说明左面是递增的
			if(nums[middle] > nums[0]){
				if(nums[middle] > n && nums[left] <= n){
					right = middle;
				}else{
					left = middle + 1;
				}
			//当没有重复元素时候，一定说明右面是递增的	
			}else{
				if(nums[middle] < n && nums[right] >= n){
					left = middle + 1;
				}else{
					right = middle;
				}
			}
		}
		return -1;
	}
	
	public static int testExistingDuplicatedElement(int[] nums, int n){
		int left = 0;
		int right = nums.length;
		int middle = (left + right)/2;
		
		while(left <= right){
			if(nums[middle] == n){
				return middle;
			}
			//当有重复元素的时候，如果nums[left] < n，说明左面是递增的
			if(nums[middle] > nums[0]){
				if(nums[middle] > n && nums[left] < n){
					right = middle;
				}else{
					left = middle + 1;
				}
			//当有重复元素的时候，如果nums[right] > n，说明右面是递增的	
			}else{
				if(nums[middle] < n && nums[right] > n){
					left = middle + 1;
				}else{
					right = middle;
				}
			}
		}
		return -1;
	}
	
}
