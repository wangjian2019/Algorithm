package search;


public class SearchTest {
	int[] nums = new int[10];
		public boolean find(int key){  //普通查找
		if(nums.length == 0){
			return false;
		}
		for(int element : nums){
			if(key == element){
				return true;
			}
		}
		return false;
	}
	/**
	 * 二分查找的时间复杂度为log(n)
	 * @param key
	 * @return
	 */
	public boolean binarySearch(int key){  //二分法查找，最多查找【log(n)】+1
		int lower = 0;  //左指针
		int upper = nums.length;  //右指针
		if(nums.length == 0){
			return false;
		}
		for(;;){  //死循环，用过return跳出此方法顺便结束循环。
			int center = (lower + upper)/2;
			if(key == nums[center]){
				return true;
			}else if(key < nums[center]){
				upper = center - 1;
			}else if(key > nums[center]){
				lower = center + 1;
			}
			if(lower > upper){  //没找到，二分查找找不到的终止条件
				return false;
			}
		}
	}
	
	public boolean binarySearch(int key, int lower, int upper){  //二分法查找(递归实现)
		if(nums.length == 0){
			return false;
		}
		int center = (lower + upper)/2;
		if(key == nums[center]){
			return true;
		}else if(key < nums[center]){
			return binarySearch(key,lower,center - 1);
		}else if(key > nums[center]){
			return binarySearch(key,center + 1,upper);
		}
		if(lower > upper){  //没找到，二分查找找不到的终止条件
			return false;
		}
		return false;
	}
	
}