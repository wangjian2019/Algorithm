package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ArrayAlgorithm {
	
	/**
	 * 剑指offer第8题：旋转数组，把一个数组最前面的若干元素搬到数组的末尾，这个叫做数组旋转。
	 * 输入一个递增排序的数组后，将它旋转，找到旋转后数组的最小元素。
	 * for example, 原数组[1,2,3,4,5]，旋转后[3,4,5,1,2]，旋转后数组最小元素是1
	 *
	 * 旋转后的数组，是两个递增排序的序列，前面的序列是递增，后面的序列也是递增的。
	 * 最小的元素是后面递增序列的第一个元素。前面递增序列的最小元素（数组第一个元素）应该大于后面递增序列的最大元素（数组最后一个元素）
	 * 二分查找，指针1指向数组第一个元素。指针2指向最后一个元素，中间元素如果比指针1元素大，说明中间元素在前面的递增序列中；
	 * 如果中间元素比指针1元素小，说明中间元素在后umiande递增序列中，以此类推的二分查找
	 * 
	 * 这里有一种特殊情况，如果数组中元素存在相同的情况，如果指针1元素==中间元素==指针2元素，那么必须顺序查找，没办法。
	 * 如果指针1或指针2元素与中间元素相同，那么可以继续二分查找，不影响，依然可以判断出来中间元素在哪个递增序列中
	 */
	public int testMinNumber(int[] nums){
		return 0;
	}
	
	/**
	 * 剑指offer第4题：替换空格，问题：两个排序的数组a, b。a数组末尾有足够多空间。
	 *       把b数组中元素插入到a中，并保证a的顺序
	 * 
	 * 思路：必须保证不能多次移动复制一个数字的情况。
	 *       所以从后往前的顺序！
	 *       先拿到数组b的长度。那么数组a的长度+数组b的的长度，就是a数组最后的的长度。
	 *       设定两个指针，一个指在a数组的尾部（a.length），一个指在a数组最后的尾部(a.length+b.length)
	 *	     从后向前比较a,b中的数组，把较大的数字复制到a的合适位置
	 *
	 * 关键： 合并两个数组或字符串，必须从后往前移动，减少移动次数，提高效率
	 */
	public void testA(int[] a, int[] b){
		
	}
	
	/**
	 * 剑指offer第3题：二维数组中的查找，在一个二维数组中，每行从左到右递增，每列从上到下递增，given a number, check whether there exists this number.
	 * 
	 * 思路：选取二维数组中右上角的数字，如果该数字大于要查找的数字，就剔除这个数字所在列；
	 *       如果该数字小于要查找的数字，就剔除这个数字所在的行。
	 */
	public boolean test(int[][] nums, int number){
		return false;
	}
	

	/**
	 * 一个包含整数和负数的有序数组，任意拿出一个数，判断是否有数组中两个数加和等于这个数,并返回这两个数和对应index
	 * 数组:[0,3,6,9,14,56]
	 * 
	 * 答案：定义两个指针，一个在第一个元素，一个在最后一个元素，两个指针对应元素相加只和如果等于这个数字，那么就返回，
	 * 如果小于，左指针前移；如果大于，右指针左移动。直到左指针和右指针相交或错开，那么就是没有。
	 */
	public boolean test0(int[] nums, int number) {
		return false;
	}
	
	/**
	 * 一个包含整数和负数的有序数组，任意拿出一个数，判断是否有数组中两个数加和等于这个数,并返回这两个数和对应index
	 * 数组:[-9,-2,0,3,6,9,14,56]
	 * 
	 * 题解：
	 * 方法 1：两层循环，遍历到每个数，再遍历找另外一个数字，复杂度 O(n^2)
	 * 方法 2： hash。用一个哈希表，存储每个数对应的下标，复杂度 O(n).
	 * 方法 3：先排序o(nlogn)，然后左右夹逼(左右各一个指针，当两数之和小于这个target，左指针++，如果大于这个target，右指针--)，排序 O(n log n)，左右夹逼 O(n)，最终O（N*log2N）。
	 */
	// 方法 2:开辟一个辅助的hash表，key是数组index，value是对应的值。已知数字减去某值，去看hash表里是否有另外的值
	public boolean test1(int[] nums, int number) {
		if (nums == null || nums.length == 0) {

		}
		// check whether number is a part of nums
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}
		for (int num : nums) {
			if (map.containsValue(number - num)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 一个包含整数和负数的有序数组，任意拿出一个数，判断是否有数组中两个数加和等于这个数,并返回这两个数和对应index
	 * 数组:[-9,-2,0,3,6,9,14,56]
	 * 
	 * 题解：
	 * 方法 1：两层循环，遍历到每个数，再遍历找另外一个数字，复杂度 O(n^2)
	 * 方法 2： hash。用一个哈希表，存储每个数对应的下标，复杂度 O(n).
	 * 方法 3：先排序o(nlogn)，然后左右夹逼(左右各一个指针，当两数之和小于这个target，左指针++，如果大于这个target，右指针--)，排序 O(n log n)，左右夹逼 O(n)，最终O（N*log2N）。
	 * 
	 */
	//方法 3:先排序，然后左右夹逼
	public int[] test11(int[] nums, int target){  
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

	/**
	 * 一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
	 * 
	 * @return
	 */
	// 创新辅助hash表，key是1~100，value是每个数字出现的次数。找到出现次数是0的数字即可
	public int test2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			map.put(num, 0);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				Integer count = map.get(nums[i]);
				count++;
				map.replace(nums[i], count);
			} else {
				map.put(nums[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
			if (mapEntry.getValue() == 0) {
				return mapEntry.getKey();
			}
		}
		return -1;
	}

	/**
	 * 一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
	 * 
	 * @return
	 */
	// 1~100的和减去这个数组所有元素的和就是缺少的那个数字
	public int test3(int[] nums) {
		int sums_100 = 0;
		int sums = 0;
		for (int i = 0; i < nums.length; i++) {
			sums_100 = sums + i;
		}
		for (int num : nums) {
			sums = sums + num;
		}
		return sums_100 - sums;
	}

	/**
	 * 一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
	 * 
	 * @return
	 */
	// 快速排序nums数组，再找出那个数字
	public int test4(int[] nums) {
		// 快速排序nums数组，再找出那个数字
		return 0;
	}

	/**
	 * 一个无序数组里有若干个正整数，范围从1到100，其中99个整数都出现了偶数次，只有一个整数出现了奇数次（比如1,1,2,2,3,3,4,5,5），
	 * 如何找到这个出现奇数次的整数？
	 * 
	 * @return
	 */
	// 遇到奇数次，偶数次这种题，一定用位运算，亦或。
	// 遍历整个数组，依次做异或运算。由于异或在位运算时相同为0，不同为1，因此所有出现偶数次的整数都会相互抵消变成0，只有唯一出现奇数次的整数会被留下。
	public int test5(int[] nums) {
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			temp = temp ^ nums[i];
		}
		return temp;
	}

	/**
	 * 一个无序数组里有若干个正整数，范围从1到100，其中98个整数都出现了偶数次，只有两个整数出现了奇数次（比如1,1,2,2,3,4,5,5），
	 * 如何找到这个出现奇数次的整数？
	 * 
	 * 思路：当有一个数字出现奇数次的时候，可以所有元素逐个亦或结果就是这个数字，因为相同数字亦或等于0.
	 *       当有两个数字出现奇数次的时候，如果把这两个数字分到两个数组中，那么就变成上面的问题了。
	 */
	// 遍历整个数组，依次做异或运算。由于数组存在两个出现奇数次的整数，所以最终异或的结果，等同于这两个整数的异或结果。这个结果中，至少会有一个二进制位是1（如果都是0，说明两个数相等，和题目不符）。
	// 举个例子，如果最终异或的结果是5，转换成二进制是00000101。此时我们可以选择任意一个是1的二进制位来分析，比如末位。把两个奇数次出现的整数命名为A和B，如果末位是1，说明A和B转为二进制的末位不同，必定其中一个整数的末位是1，另一个整数的末位是0。
	// 根据这个结论，我们可以把原数组按照二进制的末位不同，分成两部分，一部分的末位是1，一部分的末位是0。由于A和B的末位不同，所以A在其中一部分，B在其中一部分，绝不会出现A和B在同一部分，另一部分没有的情况。
	// 这样一来就简单了，我们的问题又回归到了上一题的情况，按照原先的异或解法，从每一部分中找出唯一的奇数次整数即可。
	public int test6(int[] nums) {
		return 0;
	}
	
	/**一个数组中n个数，只有一个数出现的次数超过了n/2，找出这个数：
	 * 1.o(n^2)，两个循环，记下每个数字出现的次数，取最大的那个。
	 * 2.o(n^2)，先排序，然后从第一个数开始，往后走看他有多少个从重复的，如果超过n/2，则找到；如果没有超过n/2，继续找下一个有多少个重复的，直到找到为止
	 * 3.o(n^2)，第一层循环，从第二个开始找，一直找到最后，看有几个和第一个数字是重复的，把第一个数字放进Set中。再从第二个开始，在Set里contains（）一下，看是否包含，如果包含说明已经重复算过了，可以往后再++。
	 * 4.o(nlogn)，快速排序，中间的那个值
	 * 5.o(n)，放进集合里面，每次拿出两个，如果是不一样的，就都删下去。如果一样就留着；多次循环，直到剩最后两个，就是这个数字
	 */
	public int test7(){
		return 0;
	}
	
	/**
	 * 问题： 在一个已排序数组中，给出一个数，返回这个数字出现的次数
	 *
	 * 一般思路：二分查找找到这个数字，分别往前和往后遍历，找到第一个出现的和最后一个出现的，统计总共有几次
	 * 完美思路：二分查找这个数字出现的第一次的位置和最后一次的位置，它们的数字下标之差+1就是次数。二分查找的时候如果找到这个数字了，判断前一个数字是不是也是这个数字，如果是，就说明不是第一次出现，继续二分查找，直到找到，这就是第一次的位置。最后一次的位置同理。
	 */
	public int test8(){
		return 0;
		
	}
	
	/**
	 * 问题：一个正整数数组，把里面所有数字拼接起来的整数最小，求这个最小整数
	 * 思路：把数组排序，由“小”到“大”，在数字比较的时候，把数字转成字符串比较即可
	 */
	public int test9(){
		return 0;
		
	}
	
	/**
	 * 问题：一个整型数组，里面有正数也有负数，数组中一个或多个整数组成的叫做子数组。求所有子数组的和的最大值。时间复杂度o(n)
	 * 
	 * 思路：只需要遍历一次数组。有一个变量记着当前从开始到当前数字的子数组之和是多少。如果遇到负数加和之后的子数组变小了。
	 *     全局记录累加的子数组只和，最大的子数组之和
	 * 
	 */
	public int test10(){
		return 0;
		
	}
	
	/**
	 * 问题： 数组中n个数，找出其中最小的k个数，最小TopK
	 * 
	 * 思路1： 基于数组中第k个数字调整，把比第k个数字小的数都放到左边，比它大的都放到右边
	 * @return
	 */
	public int test11(){
		return 0;
		
	}

}
