package leetcode.array;

/**
 * Plus One
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * 題解：
 * 高精度加法。
 * 
 * 这道题就是实现题。
 * 先对原数组进行处理。从数组最后一位开始往前检查，如果当前数字是<9的，说明你加1无需进位，从循环跳出即可，如果当前数字等于9，说明加1涉及进位，且加1后当前数字应记为0，继续循环处理。
 * 当对原数组处理完后，还需要判断当前第0位是不是已经变为0了，如果已经变为0了说明是类似99+1这种，需要进位。其他则不需要。
 * 一般对数字进行操作的题都要考虑边界，尤其是溢出问题。
 * 
 * @author Alvin
 *
 */
public class PlusOne {
	
	
	public int[] test(int[] nums){
		 int length = nums.length;
		 //Array imitates plus one 
		  for(int i = length-1; i>=0; i--){
		      if(nums[i] < 9){
		          nums[i]++;
		          break;
		      }else{
		          nums[i]=0;
		      }
		  }
		  
		  int[] newdigits;
		  //以防數組是9999,when plus one, the array will be out of array limit,so justify whether thenums[0]==0
		  if(nums[0]==0){
		      newdigits = new int[nums.length+1];
		      newdigits[0]=1;
		      for(int i=1;i<newdigits.length;i++){
		          newdigits[i]=nums[i-1];
		      }
		  }else{
		      newdigits = new int[nums.length];
		      for(int i=0;i<nums.length;i++){
		          newdigits[i]=nums[i];
		      }
		  }
		   return newdigits;
	}
	 
}
