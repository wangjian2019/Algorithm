package leetcode.sort;


/**
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * or example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * 题解：
 * 题目给了一个unsorted integer array，如果先排序，再处理，快排和归并排和堆排都是o(nlogn)无法保证O(n)的要求。
 * 
 * 
 * 注意：题目要求是find the first missing positive integer 。也就是说，即便你给的数组是4 5 6 7，看似都一一排好序，但是返回值一定是1，也就是如果给的数组是4 5 7 8 ，答案不是6，是1。
 * 因此，有了这个性质，我们就能i和A[i]是否相等来做判断了。“实现中还需要注意一个细节，就是如果当前的数字所对应的下标已经是对应数字了，那么我们也需要跳过，因为那个位置的数字已经满足要求了，否则会出现一直来回交换的死循环。
 * 
 * 解法的思想是：把数组中数值等于i的数字，放到数组的index是i的位置上，通过不停地交换，来做到这个原则。然后从头遍历一下，第一个不符合这个原则的就是结果了。
 * 
 * 例子：
 * 100，200,300,,400,1,2
 * 前四个元素都大于数据长度不参与调换直接跳过，然后对1，2开始调换
 * 100，1，300，400，200，2
 * 100，1，2，400，200，100
 * 结果就是3
 * 
 * 3，4，-1，1
 * 1，4，-1，3
 * 4,1,-1,3
 * 
 * 
 * return 2
 * 
 */
public class FirstMissingPositive{

    public int firstMissingPositive(int[] nums) {
        //find the first missing positive integer，如果数组是空，那么返回第一个正整数，也就是1
        if(nums.length==0||nums==null)
             return 1;
             
         for (int i = 0; i < nums.length; i++){
             if (i != nums[i]){
                 if (nums[i] <= 0 || nums[i] > nums.length-1 || nums[i] == nums[nums[i]])
                     continue;
                 else{
                     swap(nums, i, nums[i]);
                     i--;
                 }
             }
         }
         int k = 1;  
         while (k < nums.length && nums[k] == k) 
             k++;  
             
         if(nums[0]==k)
             return k+1;
         else
             return k;
    }
    
    private void swap(int[] nums, int i, int j){
        
        if(nums[i] != nums[j]){
            int temp = 0;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
