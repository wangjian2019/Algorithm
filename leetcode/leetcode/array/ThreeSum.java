package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a; b; c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: Elements in a triplet (a; b; c) must be in non-descending order. (ie,
 * a ≤ b ≤ c) • The solution set must not contain duplicate triplets. 
 * For example, given array S = {-1 0 1 2 -1 -4}. 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * 题解：
 * 1. 3层循环，选中一个数，再选中一个数，遍历找另外一个数，o(n^3)，FUCK!!
 * 2. 先排序o(nlogn),然后从数组的i=0到n-1每个数字进行遍历，遍历arr[i]时，在调用2Sum问题中的函数getSumNum(arr , Sum-arr[i])，也就是问题转化为求2Sum
 * 
 * 
 * 如果有多种组合那就返回List<List<Integer>>，如果只返回第一种组合int[]即可
 * 
 * @author Alvin
 *
 */
public class ThreeSum {
	static HashSet<String> repeat = new HashSet<String>(); // 查重
	//答案可能有多组数据，所以集合套集合
	static List<List<Integer>> result = new LinkedList<List<Integer>>();

    public static void main(String[] args) {
        int a[] = {-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
        System.out.println(test1(a, 0));
        //System.out.println(test2(a).size());
    }
    
    public static int[] test1(int[] nums, int target) {
    	 if (nums.length < 3) {
             return null;
         }
         if (nums.length == 3) {
             if (nums[0] + nums[1] + nums[2] == 0) {
                 return new int[]{nums[0], nums[1], nums[2]};
             } else {
                 return null;
             }
         }
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			int[] result = get2Sum(nums, target - nums[i]);
			if(result != null){
				int[] finalResult = new int[] { i, result[0], result[1]};
				return finalResult;
			}
		}
		return null;
    }
    
    private static int[] get2Sum(int[] nums, int target){  
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
    
}

