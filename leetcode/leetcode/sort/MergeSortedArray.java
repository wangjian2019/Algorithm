package leetcode.sort;

/**
 * Merge Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space to hold additional elements from B. The number of
 * elements initialized in A and B are m and n respectively.
 * 
 * 
 * 题解：把B数组合并到A数组中，所以A数组的长度一定是A+B，合并后A数组最后一个元素的位置一定是 m + n - 1，A，B数组从后往前开始遍历放元素
 * 
 * 
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pa = m - 1;
        int pb = n - 1;
        int index = m + n - 1;

        while (pa >= 0 && pb >= 0) {
            if (nums1[pa] >= nums2[pb]) {
                nums1[index--] = nums1[pa--];
            } else {
                nums1[index--] = nums2[pb--];
            }
        }
        //因为是把B merge到A上，因此A上有剩余元素没事，B上有剩余呀un苏直接merge过来即可
        while (pb >= 0) { // 说明pa一定为0
            nums1[index--] = nums2[pb--];
        }
        
    }

}